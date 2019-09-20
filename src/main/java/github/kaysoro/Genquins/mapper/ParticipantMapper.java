package github.kaysoro.Genquins.mapper;


import github.kaysoro.Genquins.model.Participant;

class ParticipantMapper {
    static Participant map(github.kaysoro.Genquins.payload.Participant participant){
        return Participant.builder().id(participant.getGroup_player_ids().get(0))
                .name(participant.getName())
                .build();
    }
}
