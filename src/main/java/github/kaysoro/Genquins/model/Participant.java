package github.kaysoro.Genquins.model;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Participant {
    public Participant(){};
    public Participant(String name, String id, int score) {
        this.name = name;
        this.id = id;
        this.score = score;
    }

    private String name;
    private String id;
    private int score;
}
