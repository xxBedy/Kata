package tennis.groovy

/**
 * User: mbednar
 * Date: 09.09.14
 * Time: 9:04
 */
class TennisGame {
    String player1
    String player2
    int player1Score = 0
    int player2Score = 0

    TennisGame(String player1, String player2) {
        this.player1 = player1
        this.player2 = player2
    }

    String getScore() {
        if (player1Score - player2Score >= 2 && (player1Score > 3 || player2Score > 3))
            return player1 + " wins"
        else if (player2Score - player1Score >= 2 && (player1Score > 3 || player2Score > 3))
            return player2 + " wins"
        else if (player1Score == player2Score)
            if (player1Score < 3)
                return saySameScore(player1Score) + " all"
            else
                return saySameScore(player1Score)
        else if (player1Score > 3 || player2Score > 3)
            if (player1Score > player2Score)
                return "Advantage " + player1
            else
                return "Advantage " + player2
        else
            return sayDifferentScore(player1Score) + "," + sayDifferentScore(player2Score)
    }

    def saySameScore(int playerScore) {
        if (playerScore == 0)
            return "Love"
        if (playerScore == 1)
            return "Fifteen"
        if (playerScore == 2)
            return "Thirty"
        if (playerScore >= 3)
            return "Deuce"
    }

    def sayDifferentScore(int playerScore) {
        String say
        if (playerScore == 0)
            say= "Love"
        if (playerScore == 1)
            say= "Fifteen"
        if (playerScore == 2)
            say= "Thirty"
        if (playerScore == 3)
            say= "Forty"
        return say
    }

    void playerOneScores() {
        player1Score++
    }

    void playerTwoScores() {
        player2Score++
    }
}
