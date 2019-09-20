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

}
