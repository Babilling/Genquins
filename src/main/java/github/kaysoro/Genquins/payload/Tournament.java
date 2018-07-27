package github.kaysoro.Genquins.payload;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

import java.util.List;
import java.util.Map;

@JsonRootName("tournament")
public class Tournament {
    @JsonProperty("name")
    private String name;

    @JsonProperty("participants")
    private List<Map<String, Team>> teams;

    @JsonProperty("matches")
    private List<Map<String, Match>> matches;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Map<String, Team>> getTeams() {
        return teams;
    }

    public void setTeams(List<Map<String, Team>> teams) {
        this.teams = teams;
    }

    public List<Map<String, Match>> getMatches() {
        return matches;
    }

    public void setMatches(List<Map<String, Match>> matches) {
        this.matches = matches;
    }
}