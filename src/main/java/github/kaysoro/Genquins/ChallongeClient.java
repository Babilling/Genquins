package github.kaysoro.Genquins;

import github.kaysoro.Genquins.config.AppProperties;
import github.kaysoro.Genquins.generator.HTMLGenerator;
import github.kaysoro.Genquins.payload.ResponseNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.ExchangeFilterFunction;
import org.springframework.web.reactive.function.client.ExchangeFilterFunctions;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class ChallongeClient {
    private static final String CHALLONGE_API_BASE_URL = "https://api.challonge.com/v1";
    private static final String USER_AGENT = "Spring 5 WebClient";
    private static final Logger logger = LoggerFactory.getLogger(ChallongeClient.class);

    private final WebClient webClient;

    @Autowired
    public ChallongeClient(AppProperties appProperties) {
        this.webClient = WebClient.builder()
                .baseUrl(CHALLONGE_API_BASE_URL)
                .defaultHeader(HttpHeaders.USER_AGENT, USER_AGENT)
                .filter(ExchangeFilterFunctions
                        .basicAuthentication(appProperties.getChallonge().getUsername(),
                                appProperties.getChallonge().getToken()))
                .filter(logRequest())
                .build();
    }


    public Mono<String> getMatchesFromCurrentRound(String tournamentId) {
         return webClient.get()
                 .uri("/tournaments/{tournamentId}.json?include_participants=1&include_matches=1", tournamentId)
                 .retrieve()
                 .bodyToMono(ResponseNode.class)
                 .map(HTMLGenerator::generateTree);
    }

    public Mono<String> getChallongeLadder(String tournamentId) {
        return webClient.get()
                .uri("/tournaments/{tournamentId}.json?include_participants=1&include_matches=1", tournamentId)
                .retrieve()
                .bodyToMono(ResponseNode.class)
                .map(HTMLGenerator::generateLadder);
    }

    private ExchangeFilterFunction logRequest() {
        return (clientRequest, next) -> {
            logger.info("Request: {} {}", clientRequest.method(), clientRequest.url());
            clientRequest.headers()
                    .forEach((name, values) -> values.forEach(value -> logger.info("{}={}", name, value)));
            return next.exchange(clientRequest);
        };
    }
}
