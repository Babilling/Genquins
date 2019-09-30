package github.kaysoro.Genquins.payload;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.Builder;

@Builder
@JsonRootName("match")
public class MatchUpdate {

    @JsonProperty("winner_id")
    private String winnerId;

    @JsonProperty("scores_csv")
    private String scores;


    public String getWinnerId() {
        return this.winnerId;
    }

    public String getScores() {
        return this.scores;
    }
}
