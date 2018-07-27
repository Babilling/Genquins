package github.kaysoro.Genquins.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "app")
public class AppProperties {
    private final Challonge challonge = new Challonge();

    public static class Challonge {
        private String username;
        private String token;

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }
    }

    public Challonge getChallonge() {
        return challonge;
    }
}
