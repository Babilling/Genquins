package github.kaysoro.Genquins.controller;

import github.kaysoro.Genquins.mapper.MatchMapper;
import github.kaysoro.Genquins.model.Match;
import github.kaysoro.Genquins.service.ChallongeClient;
import github.kaysoro.Genquins.service.MatchService;
import github.kaysoro.Genquins.service.TournamentService;
import org.springframework.beans.factory.annotation.Value;
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
    @Value("${challonge.tournament}")
    private String tournamentId;
    private ChallongeClient challongeClient;
    private MatchService matchService;
    private TournamentService tournamentService;

    public WebController(ChallongeClient challongeClient, MatchService matchService, TournamentService tournamentService){
        this.challongeClient = challongeClient;
        this.matchService = matchService;
        this.tournamentService = tournamentService;
    }

    @GetMapping({ "/", "/index" })
    public String index(Model model) {
        model.addAttribute("tournament", tournamentService.getModelTournament());
        model.addAttribute("matchs", matchService.getModelMatches());
        model.addAttribute("matchToSave", Match.builder().build());
        return "index";
    }

    @PostMapping("/save")
    public String save(Model model, Match matchToSave) {
        return "redirect:/";
    }

    @GetMapping("/challonge")
    public String challonge(Model model) {
        model.addAttribute("tournamentId",tournamentId);
        return "challonge";
    }

}
