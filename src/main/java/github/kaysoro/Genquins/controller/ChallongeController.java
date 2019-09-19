package github.kaysoro.Genquins.controller;

import github.kaysoro.Genquins.payload.Match;
import github.kaysoro.Genquins.service.ChallongeClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/api")
public class ChallongeController {

    private ChallongeClient challongeClient;

    private static final Logger logger = LoggerFactory.getLogger(ChallongeController.class);

    public ChallongeController(ChallongeClient challongeClient){
        this.challongeClient = challongeClient;
    }

    @GetMapping("/matches")
    public Flux<Match> getMatchesFromCurrentRound() {
       return challongeClient.getAllMatchesForTournament();
    }

    @GetMapping({ "/", "/index" })
    public String index(Model model) {
        model.addAttribute("matchs", challongeClient.getAllMatchesForTournament());
        return "index";
    }

    @ExceptionHandler(WebClientResponseException.class)
    public ResponseEntity<String> handleWebClientResponseException(WebClientResponseException ex) {
        logger.error("Error from WebClient - Status {}, Body {}", ex.getRawStatusCode(),
                ex.getResponseBodyAsString(), ex);
        return ResponseEntity.status(ex.getRawStatusCode()).body(ex.getResponseBodyAsString());
    }
}
