package github.kaysoro.Genquins.service;

import github.kaysoro.Genquins.mapper.MatchMapper;
import github.kaysoro.Genquins.payload.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.ExchangeFilterFunction;
import org.springframework.web.reactive.function.client.ExchangeFilterFunctions;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ChallongeClient {

    private static final String CHALLONGE_API_BASE_URL = "https://api.challonge.com/v1";
    private static final String USER_AGENT = "Spring 5 WebClient";
    private static final Logger LOGGER = LoggerFactory.getLogger(ChallongeClient.class);

    private final WebClient webClient;

    @Value("${challonge.tournament}")
    private String tournamentId;

    public ChallongeClient(@Value("${challonge.username}") String username,
                           @Value("${challonge.token}") String token) {
        this.webClient = WebClient.builder()
                .baseUrl(CHALLONGE_API_BASE_URL)
                .defaultHeader(HttpHeaders.USER_AGENT, USER_AGENT)
                .filter(ExchangeFilterFunctions
                        .basicAuthentication(username, token))
                .filter(logRequest())
                .build();
    }

    public Mono<Match> submitScores(github.kaysoro.Genquins.model.Match match){
        return webClient.put()
                .uri("/tournaments/{tournamentId}/matches/{matchId}.json", tournamentId, match.getId())
                .accept(MediaType.APPLICATION_JSON )
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromObject(MatchMapper.map(match)))
                .retrieve()
                .bodyToMono(MatchWrapper.class)
                .map(MatchWrapper::getMatch);
    }

    public Flux<Match> getAllMatchesForTournament() {
        return webClient.get()
                .uri("/tournaments/{tournamentId}/matches.json", tournamentId)
                .retrieve()
                .bodyToFlux(MatchWrapper.class)
                .filter(m -> m.getMatch().getState().equals(Match.STATE_OPEN) || m.getMatch().getState().equals(Match.STATE_COMPLETE))
                .map(MatchWrapper::getMatch);
    }

    public Flux<Participant> getAllParticipantsForTournament() {
        return webClient.get()
                .uri("/tournaments/{tournamentId}/participants.json", tournamentId)
                .retrieve()
                .bodyToFlux(ParticipantWrapper.class)
                .map(ParticipantWrapper::getParticipant);
    }

    private ExchangeFilterFunction logRequest() {
        return (clientRequest, next) -> {
            LOGGER.info("Request: {} {}", clientRequest.method(), clientRequest.url());
            clientRequest.headers()
                    .forEach((name, values) -> values.forEach(value -> LOGGER.info("{}={}", name, value)));
            return next.exchange(clientRequest);
        };
    }

    public Mono<Tournament> getTournament() {
        return webClient.get()
                .uri("/tournaments/{tournamentId}.json", tournamentId)
                .retrieve()
                .bodyToMono(TournamentWrapper.class)
                .map(TournamentWrapper::getTournament);
    }
}
