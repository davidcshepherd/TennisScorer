package org.example;

public class TennisScoreSheet {
    private int player1Score;
    private int player2Score;
    private String player1Name;
    private String player2Name;

    public TennisScoreSheet(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
        this.player1Score = 0;
        this.player2Score = 0;
    }

    public void player1Scores() {
        player1Score++;
    }

    public void player2Scores() {
        player2Score++;
    }

    public String getScore() {
        return formatScore(player1Score) + " - " + formatScore(player2Score);
    }

    private String formatScore(int score) {
        switch (score) {
            case 0: return "0";
            case 1: return "15";
            case 2: return "30";
            case 3: return "40";
            default: return "Advantage";
        }
    }

    public String getMatchStatus() {
        if (player1Score >= 3 && player2Score >= 3) {
            if (player1Score == player2Score) {
                return "Deuce";
            }
            if (Math.abs(player1Score - player2Score) == 1) {
                return player1Score > player2Score ? player1Name + " has Advantage" : player2Name + " has Advantage";
            }
        }
        return getScore();
    }

    public String getWinner() {
        // A simple condition to determine the winner; adjust as needed for your rules
        if (player1Score >= 4 && player1Score - player2Score >= 2) {
            return player1Name + " wins!";
        }
        if (player2Score >= 4 && player2Score - player1Score >= 2) {
            return player2Name + " wins!";
        }
        return "Match is ongoing";
    }

}
