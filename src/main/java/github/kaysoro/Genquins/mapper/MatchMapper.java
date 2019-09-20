package github.kaysoro.Genquins.mapper;

import github.kaysoro.Genquins.model.Match;
import github.kaysoro.Genquins.payload.Participant;

import java.util.Map;

public class MatchMapper {
    public static Match map(github.kaysoro.Genquins.payload.Match match, Map<String, Participant> participantMap){
        return Match.builder().id(match.getId())
                .participant1(ParticipantMapper.map(participantMap.get(match.getPlayer1_id())))
                .participant2(ParticipantMapper.map(participantMap.get(match.getPlayer2_id())))
                .winner_id(match.getWinner_id() != null ? participantMap.get(match.getWinner_id()).getName() : null)
                .scores(match.getScores_csv())
                .state(match.getState().equals(github.kaysoro.Genquins.payload.Match.STATE_COMPLETE) ? "Joué" : "Non joué")
                .build();
    }
}
