package data;

public class Run {
    private boolean isPlayed;
    private Team winner;
    private int diffPoints;

    public boolean isPlayed() {
        return isPlayed;
    }

    public void setPlayed(boolean played) {
        isPlayed = played;
    }

    public Team getWinner() {
        return winner;
    }

    public void setWinner(Team winner) {
        this.winner = winner;
    }

    public int getDiffPoints() {
        return diffPoints;
    }

    public void setDiffPoints(int diffPoints) {
        this.diffPoints = diffPoints;
    }
}
