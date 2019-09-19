package github.kaysoro.Genquins.payload;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName("match")
public class Match {
    public final static Match NONE = new Match();

    public final static String STATE_OPEN = "open";
    public final static String STATE_PENDING = "pending";
    public final static String STATE_COMPLETE = "complete";

    @JsonProperty("id")
    private String id;

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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
