package github.kaysoro.Genquins.model;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Match {
    private String id;
    private Participant participant1;
    private Participant participant2;
    private String winner_id;
    private String scores;
    private String state;
    public Match(){}

    public Match(String id, Participant participant1, Participant participant2, String winner_id, String scores, String state) {
        this.id = id;
        this.participant1 = participant1;
        this.participant2 = participant2;
        this.winner_id = winner_id;
        this.scores = scores;
        this.state = state;
    }
}
