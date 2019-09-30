package github.kaysoro.Genquins.mapper;

import github.kaysoro.Genquins.model.Match;
import github.kaysoro.Genquins.payload.Participant;

import java.util.Map;
import java.util.stream.Collectors;

public class MatchMapper {
    public static Match map(github.kaysoro.Genquins.payload.Match match, Map<String, Participant> participantMap){
        return Match.builder().id(match.getId())
                .participant1(ParticipantMapper.map(getParticipantFromMap(match.getPlayer1_id(),participantMap)))
                .participant2(ParticipantMapper.map(getParticipantFromMap(match.getPlayer2_id(),participantMap)))
                .winner_id(match.getWinner_id() != null ? getParticipantFromMap(match.getWinner_id(),participantMap).getName() : null)
                .scores(match.getScores_csv())
                .state(match.getState().equals(github.kaysoro.Genquins.payload.Match.STATE_COMPLETE) ? "Joué" : "Non joué")
                .build();
    }

    private static Participant getParticipantFromMap(String participantId, Map<String, Participant> participantMap) {
        if (participantMap.get(participantId) != null) return participantMap.get(participantId);
        return participantMap.entrySet().stream().filter(p -> p.getValue().getGroup_player_ids().contains(participantId)).collect(Collectors.toList()).get(0).getValue();
    }
}
