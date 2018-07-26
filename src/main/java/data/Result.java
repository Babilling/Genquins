package data;

public class Result {

    private Run run1;
    private Run run2;
    private Run run3;

    public Team getWinner(){
        if (run1.isPlayed()){
            // BO3 : the last win is the winner
            if (run3.isPlayed()) return run3.getWinner();
            // 2-0 so winner run1 = winner run 2
            return run1.getWinner();
        }
        return Team.NONE;
    }

    public Run getRun1() {
        return run1;
    }

    public void setRun1(Run run1) {
        this.run1 = run1;
    }

    public Run getRun2() {
        return run2;
    }

    public void setRun2(Run run2) {
        this.run2 = run2;
    }

    public Run getRun3() {
        return run3;
    }

    public void setRun3(Run run3) {
        this.run3 = run3;
    }
}
