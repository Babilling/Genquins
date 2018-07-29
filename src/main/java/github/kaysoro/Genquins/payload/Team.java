package github.kaysoro.Genquins.payload;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName("participant")
public class Team {
    public final static Team NONE = new Team();
    @JsonProperty("id")
    private String id;
    @JsonProperty("name")
    private String name;
    private int matchNumber;
    private int goalAverage;
    private int victoryNumber;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMatchNumber() {
        return matchNumber;
    }

    public void setMatchNumber(int matchNumber) {
        this.matchNumber = matchNumber;
    }

    public int getGoalAverage() {
        return goalAverage;
    }

    public void setGoalAverage(int goalAverage) {
        this.goalAverage = goalAverage;
    }

    public int getVictoryNumber() {
        return victoryNumber;
    }

    public void setVictoryNumber(int victoryNumber) {
        this.victoryNumber = victoryNumber;
    }

    public static int compareTeams(Team team1, Team team2){
        if (team2.getVictoryNumber() != team1.getVictoryNumber())
            return team2.getVictoryNumber() - team1.getVictoryNumber();
        return team2.getGoalAverage() - team1.getGoalAverage();
    }
}
