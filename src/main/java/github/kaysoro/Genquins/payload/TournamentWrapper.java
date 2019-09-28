package github.kaysoro.Genquins.payload;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TournamentWrapper {

    @JsonProperty
    private Tournament tournament;

    public Tournament getTournament() {
        return tournament;
    }

    public void setTournament(Tournament tournament) {
        this.tournament = tournament;
    }
}
