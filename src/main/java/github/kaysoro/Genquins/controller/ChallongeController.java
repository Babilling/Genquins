package github.kaysoro.Genquins.controller;

import github.kaysoro.Genquins.payload.Match;
import github.kaysoro.Genquins.payload.Participant;
import github.kaysoro.Genquins.service.ChallongeClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/api")
public class ChallongeController {

    private ChallongeClient challongeClient;

    private static final Logger LOGGER = LoggerFactory.getLogger(ChallongeController.class);

    public ChallongeController(ChallongeClient challongeClient){
        this.challongeClient = challongeClient;
    }

    @GetMapping("/matches")
    public Flux<Match> getMatchesFromCurrentRound(String tournamentId) {
       return challongeClient.getAllMatchesForTournament(tournamentId);
    }

    @GetMapping("/participants")
    public Flux<Participant> getParticipants(String tournamentId) {
        return challongeClient.getAllParticipantsForTournament(tournamentId);
    }

    @ExceptionHandler(WebClientResponseException.class)
    public ResponseEntity<String> handleWebClientResponseException(WebClientResponseException ex) {
        LOGGER.error("Error from WebClient - Status {}, Body {}", ex.getRawStatusCode(),
                ex.getResponseBodyAsString(), ex);
        return ResponseEntity.status(ex.getRawStatusCode()).body(ex.getResponseBodyAsString());
    }
}
