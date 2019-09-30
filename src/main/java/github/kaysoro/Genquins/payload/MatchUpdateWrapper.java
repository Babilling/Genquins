package github.kaysoro.Genquins.payload;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MatchUpdateWrapper {

        @JsonProperty("match")
        private MatchUpdate matchUpdate;

        public MatchUpdateWrapper(MatchUpdate matchUpdate) {
            this.matchUpdate = matchUpdate;
        }

        public MatchUpdate getMatchUpdate() {
            return matchUpdate;
        }

        public void setMatchUpdate(MatchUpdate matchUpdate) {
            this.matchUpdate = matchUpdate;
        }
}