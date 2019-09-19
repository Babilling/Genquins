package github.kaysoro.Genquins.controller;

import github.kaysoro.Genquins.payload.Match;
import github.kaysoro.Genquins.payload.MatchWrapper;
import github.kaysoro.Genquins.service.ChallongeClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ChallongeController {

    private ChallongeClient challongeClient;

    private static final Logger LOGGER = LoggerFactory.getLogger(ChallongeController.class);

    public ChallongeController(ChallongeClient challongeClient){
        this.challongeClient = challongeClient;
    }

    @GetMapping("/matches")
    public Mono<List<Match>> getMatchesFromCurrentRound() {
       return challongeClient.getAllMatchesForTournament();
    }

    @ExceptionHandler(WebClientResponseException.class)
    public ResponseEntity<String> handleWebClientResponseException(WebClientResponseException ex) {
        LOGGER.error("Error from WebClient - Status {}, Body {}", ex.getRawStatusCode(),
                ex.getResponseBodyAsString(), ex);
        return ResponseEntity.status(ex.getRawStatusCode()).body(ex.getResponseBodyAsString());
    }
}
