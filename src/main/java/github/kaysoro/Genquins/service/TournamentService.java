package github.kaysoro.Genquins.service;

import github.kaysoro.Genquins.controller.ChallongeController;
import github.kaysoro.Genquins.mapper.TournamentMapper;
import github.kaysoro.Genquins.model.Tournament;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class TournamentService {

    private ChallongeClient challongeClient;

    private static final Logger LOGGER = LoggerFactory.getLogger(ChallongeController.class);

    public TournamentService(ChallongeClient challongeClient){
        this.challongeClient = challongeClient;
    }

    public Mono<Tournament> getModelTournament(String tournamentId) {
        return challongeClient.getTournament(tournamentId).map(tournament -> TournamentMapper.map(tournament));
    }
}
