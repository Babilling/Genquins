package github.kaysoro.Genquins.controller;

import github.kaysoro.Genquins.mapper.MatchMapper;
import github.kaysoro.Genquins.model.Match;
import github.kaysoro.Genquins.service.ChallongeClient;
import github.kaysoro.Genquins.service.MatchService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.function.Function;
import java.util.stream.Collectors;

@Controller
public class WebController {

    private ChallongeClient challongeClient;
    private MatchService matchService;

    public WebController(ChallongeClient challongeClient, MatchService matchService){
        this.challongeClient = challongeClient;
        this.matchService = matchService;
    }

    @GetMapping({ "/", "/index" })
    public String index(Model model) {
        model.addAttribute("matchs", matchService.getModelMatches()
                .collectMap(match-> match.getId(), Function.identity()));
        model.addAttribute("matchToSave", Match.builder().build());
        return "index";
    }

    @PostMapping("/save")
    public String save(Model model, Match matchToSave) {
        return "index";
    }
}
