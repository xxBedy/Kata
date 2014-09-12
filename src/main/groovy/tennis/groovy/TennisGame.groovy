package tennis.groovy

/**
 * User: mbednar
 * Date: 09.09.14
 * Time: 9:04
 */
class TennisGame {
    def player1
    def player2
    def player1Name
    def player2Name

    TennisGame(String player1Name, String player2Name) {
        this.player1Name = player1Name
        this.player2Name = player2Name
        this.player1 = 0
        this.player2 = 0
    }

    String getScore() {
        def result = "default"
        if (player1.equals(player2)) {
            if (player1 == 0)   result = "Love all"
            else if (player1 == 1)  result = "Fifteen all"
            else if (player1 == 2)  result = "Thirty all"
            else if (player1 == 3 || player1 == 4)  result = "Deuce"
        } else {
            result = getNumberInText()
        }
        return result
    }

    String getNumberInText() {
        def score = player1 > player2 ? player1 : player2
        def playerName = player1 > player2 ? player1Name : player2Name
        def result = ""
        if (score == 1) {
            result = "Fifteen,Love"
        } else if (score == 2) {
            result = "Love,Thirty"
        } else if (score == 3) {
            result = "Forty,Love"
        } else if (score == 4) {
            result = "${playerName} wins"
        } else if (score == 5) {
            result = "Advantage ${playerName}"
        } else if (score > 5 ) {
            if (Math.abs(player1 - player2) == 2) result = "${playerName} wins"
        }
        return result
    }

    void playerOneScores() {
        player1 += 1
    }

    void playerTwoScores() {
        player2 += 1
    }
}
