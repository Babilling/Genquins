package github.kaysoro.Genquins.payload;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MatchWrapper {

    @JsonProperty("match")
    private Match match;

    public Match getMatch() {
        return match;
    }

    public void setMatch(Match match) {
        this.match = match;
    }
}
