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
    private String player1_id;

    @JsonProperty("player2_id")
    private String player2_id;

    @JsonProperty("state")
    private String state;

    @JsonProperty("winner_id")
    private String winner_id;

    @JsonProperty("round")
    private int round;

    @JsonProperty("scores_csv")
    private String scores_csv;

    @JsonProperty("group_id")
    private String group_id;

    @JsonProperty("tournament_id")
    private String tournament_id;

    public int getRound() {
        return round;
    }

    public void setRound(int round) {
        this.round = round;
    }

    public String getPlayer1_id() {
        return player1_id;
    }

    public void setPlayer1_id(String player1_id) {
        this.player1_id = player1_id;
    }

    public String getPlayer2_id() {
        return player2_id;
    }

    public void setPlayer2_id(String player2_id) {
        this.player2_id = player2_id;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getWinner_id() {
        return winner_id;
    }

    public void setWinner_id(String winner_id) {
        this.winner_id = winner_id;
    }

    public String getScores_csv() {
        return scores_csv;
    }

    public void setScores_csv(String scores_csv) {
        this.scores_csv = scores_csv;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getGroup_id() {
        return group_id;
    }

    public void setGroup_id(String group_id) {
        this.group_id = group_id;
    }

    public String getTournament_id() {
        return tournament_id;
    }

    public void setTournament_id(String tournament_id) {
        this.tournament_id = tournament_id;
    }
}
