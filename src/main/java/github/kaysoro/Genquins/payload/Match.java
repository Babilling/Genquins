package github.kaysoro.Genquins.payload;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName("match")
public class Match {

    @JsonProperty("player1_id")
    private String teamId1;

    @JsonProperty("player2_id")
    private String teamId2;

    @JsonProperty("state")
    private String state;

    @JsonProperty("winner_id")
    private String winnerId;

    @JsonProperty("round")
    private int roundNumber;

    @JsonProperty("scores_csv")
    private String scores;

    public String getTeam1() {
        return teamId1;
    }

    public void setTeam1(String team1) {
        this.teamId1 = team1;
    }

    public String getTeam2() {
        return teamId2;
    }

    public void setTeam2(String team2) {
        this.teamId2 = team2;
    }

    public int getRoundNumber() {
        return roundNumber;
    }

    public void setRoundNumber(int roundNumber) {
        this.roundNumber = roundNumber;
    }

    public String getTeamId1() {
        return teamId1;
    }

    public void setTeamId1(String teamId1) {
        this.teamId1 = teamId1;
    }

    public String getTeamId2() {
        return teamId2;
    }

    public void setTeamId2(String teamId2) {
        this.teamId2 = teamId2;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getWinnerId() {
        return winnerId;
    }

    public void setWinnerId(String winnerId) {
        this.winnerId = winnerId;
    }

    public String getScores() {
        return scores;
    }

    public void setScores(String scores) {
        this.scores = scores;
    }
}
