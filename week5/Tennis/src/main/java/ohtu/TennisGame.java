package ohtu;

public class TennisGame {
    private final Player playerOne;
    private final Player playerTwo;

    public TennisGame(String player1Name, String player2Name) {
        this.playerOne = new Player(player1Name);
        this.playerTwo = new Player(player2Name);
    }

    public void wonPoint(String playerName) {
        if (playerName.equals(playerOne.getName())) {
            playerOne.increaseScore();
        } else {
            playerTwo.increaseScore();
        }
    }

    public String getScoreStateEqualScores() {
        switch (playerOne.getPoints()) {
            case 0:
                return "Love-All";
            case 1:
                return  "Fifteen-All";
            case 2:
                return "Thirty-All";
            case 3:
                return  "Forty-All";
            default:
                return  "Deuce";
        }
    }

    public String getWinnerScoreState() {
        int pointDifference = playerOne.getPoints() - playerTwo.getPoints();

        if (pointDifference==1) {
            return "Advantage player1";
        }
        else if (pointDifference ==-1){
            return "Advantage player2";
        }
        else if (pointDifference>=2) {
            return "Win for player1";
        } else {
            return "Win for player2";
        }
    }

    public String getScoreState() {
        return playerOne.getScoreState() + "-" + playerTwo.getScoreState();
    }

    public String getScore() {
        String score = "";
        if (playerOne.getPoints() == playerTwo.getPoints()) {
            score = getScoreStateEqualScores();
        } else if (playerOne.getPoints() >=4 || playerTwo.getPoints() >=4) {
            score = getWinnerScoreState();
        } else {
            score = getScoreState();
        }
        return score;
    }
}