package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TennisScoreSheetTest {
    private TennisScoreSheet scoreSheet;

    

    @BeforeEach
    void setUp() {
        scoreSheet = new TennisScoreSheet("Player 1", "Player 2");
    }

    @Test
    void testInitialScore() {
        assertEquals("0 - 0", scoreSheet.getScore());
        assertEquals("Match is ongoing", scoreSheet.getWinner());
    }

    @Test
    void testPlayer1Scores() {
        scoreSheet.player1Scores();
        assertEquals("15 - 0", scoreSheet.getScore());
        assertEquals("Match is ongoing", scoreSheet.getWinner());
    }

    @Test
    void testPlayer2Scores() {
        scoreSheet.player2Scores();
        assertEquals("0 - 15", scoreSheet.getScore());
        assertEquals("Match is ongoing", scoreSheet.getWinner());
    }

    @Test
    void testDeuce() {
        scoreSheet.player1Scores(); // 15
        scoreSheet.player1Scores(); // 30
        scoreSheet.player2Scores(); // 15
        scoreSheet.player2Scores(); // 30
        scoreSheet.player1Scores(); // 40
        scoreSheet.player2Scores(); // 40
        assertEquals("Deuce", scoreSheet.getMatchStatus());

        scoreSheet.player1Scores(); // Advantage Player 1
        assertEquals("Player 1 has Advantage", scoreSheet.getMatchStatus());

        scoreSheet.player2Scores(); // Back to Deuce
        assertEquals("Deuce", scoreSheet.getMatchStatus());
    }

    @Test
    void testWinningCondition() {
        scoreSheet.player1Scores(); // 15
        scoreSheet.player1Scores(); // 30
        scoreSheet.player1Scores(); // 40
        scoreSheet.player1Scores(); // Game Point (Player 1 wins)
        assertEquals("Player 1 wins!", scoreSheet.getWinner());

        scoreSheet = new TennisScoreSheet("Player 1", "Player 2");
        scoreSheet.player2Scores(); // 15
        scoreSheet.player2Scores(); // 30
        scoreSheet.player2Scores(); // 40
        scoreSheet.player2Scores(); // Game Point (Player 2 wins)
        assertEquals("Player 2 wins!", scoreSheet.getWinner());
    }
}
