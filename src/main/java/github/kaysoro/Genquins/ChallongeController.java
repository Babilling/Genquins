package github.kaysoro.Genquins;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api")
public class ChallongeController {

    @Autowired
    private ChallongeClient challongeClient;

    private static final Logger logger = LoggerFactory.getLogger(ChallongeController.class);

    @GetMapping("/{tournament}/round")
    public Mono<String> getMatchesFromCurrentRound(@PathVariable String tournament) {
       return challongeClient.getMatchesFromCurrentRound(tournament);
    }

    @GetMapping("/{tournament}/ladder")
    public Mono<String> getChallongeLadder(@PathVariable String tournament) {
        return challongeClient.getChallongeLadder(tournament);
    }

    @ExceptionHandler(WebClientResponseException.class)
    public ResponseEntity<String> handleWebClientResponseException(WebClientResponseException ex) {
        logger.error("Error from WebClient - Status {}, Body {}", ex.getRawStatusCode(),
                ex.getResponseBodyAsString(), ex);
        return ResponseEntity.status(ex.getRawStatusCode()).body(ex.getResponseBodyAsString());
    }
}
