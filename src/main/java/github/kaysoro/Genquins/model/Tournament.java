package github.kaysoro.Genquins.model;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Tournament {
    public Tournament(){};
    public Tournament(String description){
        this.description = description;
    };
    private String description;
}
