package github.kaysoro.Genquins.mapper;

import github.kaysoro.Genquins.model.Participant;
import github.kaysoro.Genquins.model.Tournament;

public class TournamentMapper {
    public static Tournament map(github.kaysoro.Genquins.payload.Tournament tournament){
        return Tournament.builder().description(tournament.getDescription())
                .build();
    }
}
