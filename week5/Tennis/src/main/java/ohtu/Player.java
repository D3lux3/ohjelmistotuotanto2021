package ohtu;

public class Player {

    private final String name;
    private int points;
    private String scoreState;

    public Player(String name) {
        this.name = name;
        this.points = 0;
        this.scoreState = "Love";
    }

    public String getScoreState() {
        return this.scoreState;
    }

    public void increaseScore() {
        this.points++;
        this.updateScoreState();
    }

    private void updateScoreState() {
        switch(this.points) {
            case 1:
                this.scoreState = "Fifteen";
                break;
            case 2:
                this.scoreState = "Thirty";
                break;
            case 3:
                this.scoreState = "Forty";
                break;
        }
    }

    public String getName() {
        return name;
    }

    public int getPoints() {
        return points;
    }
}
