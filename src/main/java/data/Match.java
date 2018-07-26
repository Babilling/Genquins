package data;

public class Match {

    private Team team1;
    private Team team2;
    private Result result;

    public boolean isPlayed(){
        return result.getWinner() != Team.NONE;
    }

    public Team getWinner(){
        return result.getWinner();
    }

    public Team getTeam1() {
        return team1;
    }

    public void setTeam1(Team team1) {
        this.team1 = team1;
    }

    public Team getTeam2() {
        return team2;
    }

    public void setTeam2(Team team2) {
        this.team2 = team2;
    }

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }
}
