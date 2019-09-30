package github.kaysoro.Genquins.service;

import github.kaysoro.Genquins.mapper.MatchMapper;
import github.kaysoro.Genquins.model.Match;
import github.kaysoro.Genquins.payload.Participant;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class MatchService {

    private ChallongeClient challongeClient;

    public MatchService(ChallongeClient challongeClient){
        this.challongeClient = challongeClient;
    }

    public Flux<Match> getModelMatches(String tournamentId) {
        return challongeClient.getAllParticipantsForTournament(tournamentId)
                .collectMap(Participant::getId, participant -> participant)
                .flatMapMany(participants -> challongeClient.getAllMatchesForTournament(tournamentId)
                        .map(match -> MatchMapper.map(match, participants)));
        }
}
