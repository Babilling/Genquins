package github.kaysoro.Genquins.controller;

import github.kaysoro.Genquins.model.Match;
import github.kaysoro.Genquins.service.ChallongeClient;
import github.kaysoro.Genquins.service.MatchService;
import github.kaysoro.Genquins.service.TournamentService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import reactor.core.publisher.Mono;

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
        matchToSave.setWinner_id(matchToSave.getParticipant1().getId());
        int winnerScore = matchToSave.getParticipant1().getScore();

        if (matchToSave.getParticipant2().getScore() > winnerScore){
            matchToSave.setWinner_id(matchToSave.getParticipant2().getId());
            matchToSave.setScores(matchToSave.getParticipant2().getScore()
                    + "-" + matchToSave.getParticipant1().getScore());
        }
        else
            matchToSave.setScores(matchToSave.getParticipant1().getScore()
                    + "-" + matchToSave.getParticipant2().getScore());
        Mono<github.kaysoro.Genquins.payload.Match> matchSaved = challongeClient.submitScores(matchToSave);
        matchSaved
                .flatMap(match -> Mono.just(match.getScores_csv()))
                .subscribe();
        return "redirect:/";
    }

    @GetMapping("/challonge")
    public String challonge(Model model) {
        model.addAttribute("tournamentId",tournamentId);
        return "challonge";
    }

}
