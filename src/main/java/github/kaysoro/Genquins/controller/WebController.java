package github.kaysoro.Genquins.controller;

import github.kaysoro.Genquins.service.ChallongeClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebController {

    private ChallongeClient challongeClient;

    public WebController(ChallongeClient challongeClient){
        this.challongeClient = challongeClient;
    }

    @GetMapping({ "/", "/index" })
    public String index(Model model) {
        model.addAttribute("matchs", challongeClient.getAllMatchesForTournament());
        return "index";
    }
}
