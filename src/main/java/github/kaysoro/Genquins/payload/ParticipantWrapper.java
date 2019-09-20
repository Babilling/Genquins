package github.kaysoro.Genquins.payload;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ParticipantWrapper {

    @JsonProperty("participant")
    private Participant participant;

    public Participant getParticipant() {
        return participant;
    }

    public void setParticipant(Participant participant) {
        this.participant = participant;
    }
}
