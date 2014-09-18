import junit.framework.TestCase;
//Choose between, java, scala, groovy
//import tennis.java.TennisGame;
//import tennis.scala.TennisGame;
//import tennis.groovy.TennisGame;

/*
Based on 
  https://raw.githubusercontent.com/follesoe/TennisKataJava/master/src/TennisGameTest.java
  http://web.archive.org/web/20131222161827/http://codingdojo.org/cgi-bin/wiki.pl?KataTennis
*/

public class TennisGameTest extends TestCase {

    TennisGame game = new TennisGame("Boris Becker", "Bjorn Borg");

    public void testNewGameShouldReturnLoveAll() {
        String score = game.getScore();

        assertEquals("Love all", score);
    }

    public void testPlayerOneWinsFirstBall() {
        game.playerOneScores();

        String score = game.getScore();
        assertEquals("Fifteen,Love", score);
    }

    public void testFifteenAll() {
        game.playerOneScores();
        game.playerTwoScores();

        String score = game.getScore();
        assertEquals("Fifteen all", score);
    }

    public void testPlayerTwoWinsFirstTwoBalls() {
        createScore(0, 2);

        String score = game.getScore();
        assertEquals("Love,Thirty", score);
    }


    public void testPlayerOneWinsFirstThreeBalls() {
        createScore(3, 0);
        String score = game.getScore();
        assertEquals("Forty,Love", score);
    }

    public void testPlayersAreDeuce() {
        createScore(3, 3);

        String score = game.getScore();
        assertEquals("Deuce", score);
    }

    public void testPlayerOneWinsGame() {
        createScore(4, 0);

        String score = game.getScore();
        assertEquals("Boris Becker wins", score);
    }

    public void testPlayerTwoWinsWithLoveGame() {
        createScore(0, 4);

        String score = game.getScore();
        assertEquals("Bjorn Borg wins", score);
    }

    public void testPlayerTwoWinsGame() {
        createScore(1, 4);

        String score = game.getScore();
        assertEquals("Bjorn Borg wins", score);
    }

    public void testPlayersAreDuce4() {
        createScore(4, 4);
        String score = game.getScore();
        assertEquals("Deuce", score);
    }

    public void testPlayerTwoAdvantage() {
        createScore(4, 5);

        String score = game.getScore();
        assertEquals("Advantage Bjorn Borg", score);
    }

    public void testPlayerOneAdvantage() {
        createScore(5, 4);

        String score = game.getScore();
        assertEquals("Advantage Boris Becker", score);
    }

    public void testPlayerTwoWins() {
        createScore(2, 4);
        String score = game.getScore();
        assertEquals("Bjorn Borg wins", score);
    }


    public void testPlayerTwoWinsAfterAdvantage() {
        createScore(6, 8);
        String score = game.getScore();
        assertEquals("Bjorn Borg wins", score);
    }


    public void testPlayerOneWinsAfterAdvantage() {
        createScore(8, 6);
        String score = game.getScore();
        assertEquals("Boris Becker wins", score);
    }

    private void createScore(int playerOneBalls, int playerTwoBalls) {
        for (int i = 0; i < playerOneBalls; i++) {
            game.playerOneScores();
        }
        for (int i = 0; i < playerTwoBalls; i++) {
            game.playerTwoScores();
        }
    }


}
