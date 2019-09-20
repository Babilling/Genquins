package github.kaysoro.Genquins.payload;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Participant {
    @JsonProperty("id")
    private String id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("group_player_ids")
    private List<String> group_player_ids;

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

    public List<String> getGroup_player_ids() {
        return group_player_ids;
    }

    public void setGroup_player_ids(List<String> group_player_ids) {
        this.group_player_ids = group_player_ids;
    }
}
