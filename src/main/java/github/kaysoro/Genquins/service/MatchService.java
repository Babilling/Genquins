package github.kaysoro.Genquins.service;

import github.kaysoro.Genquins.controller.ChallongeController;
import github.kaysoro.Genquins.mapper.MatchMapper;
import github.kaysoro.Genquins.model.Match;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class MatchService {

    private ChallongeClient challongeClient;

    private static final Logger LOGGER = LoggerFactory.getLogger(ChallongeController.class);

    public MatchService(ChallongeClient challongeClient){
        this.challongeClient = challongeClient;
    }

    public Flux<Match> getModelMatches() {
        return challongeClient.getAllParticipantsForTournament()
                .collectMap(p -> p.getId(), participant -> participant)
                .flatMapMany(participants -> challongeClient.getAllMatchesForTournament()
                        .map(match -> MatchMapper.map(match, participants)));
        }
}
