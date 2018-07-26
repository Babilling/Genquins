package data;

import java.util.List;

public class Team {

    public final static Team NONE = new Team();
    private String name;
    private List<String> players;
    private int matchNumber;
    private int goalAverage;
    private int victoryNumber;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getPlayers() {
        return players;
    }

    public void setPlayers(List<String> players) {
        this.players = players;
    }

    public int getMatchNumber() {
        return matchNumber;
    }

    public void setMatchNumber(int matchNumber) {
        this.matchNumber = matchNumber;
    }

    public int getGoalAverage() {
        return goalAverage;
    }

    public void setGoalAverage(int goalAverage) {
        this.goalAverage = goalAverage;
    }

    public int getVictoryNumber() {
        return victoryNumber;
    }

    public void setVictoryNumber(int victoryNumber) {
        this.victoryNumber = victoryNumber;
    }

    public static int compareTeams(Team team1, Team team2){
        if (team1.getVictoryNumber() != team2.getVictoryNumber())
            return team1.getVictoryNumber() - team2.getVictoryNumber();
        return team1.getGoalAverage() - team2.getGoalAverage();
    }
}
