package github.kaysoro.Genquins.model;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Tournament {
    public Tournament(){};
    public Tournament(String id, String description){
        this.id = id;
        this.description = description;
    }
    private String id;
    private String description;

}
