import org.junit.Test;

import java.util.regex.Pattern;

import static org.junit.Assert.assertEquals;

public class RegexTicTacToeWinChecker {

    public static boolean regexTicTacToeWinChecker(String board) {

        return Pattern.compile("^XXX").matcher(board).find() ||
                Pattern.compile("^OOO").matcher(board).find() ||
                Pattern.compile(".{3}XXX").matcher(board).find() ||
                Pattern.compile(".{3}OOO").matcher(board).find() ||
                Pattern.compile(".{6}XXX").matcher(board).find() ||
                Pattern.compile(".{6}OOO").matcher(board).find() ||
                Pattern.compile("^X.{2}X.{2}X").matcher(board).find() ||
                Pattern.compile("^O.{2}O.{2}O").matcher(board).find() ||
                Pattern.compile(".X.{2}X.{2}X").matcher(board).find() ||
                Pattern.compile(".O.{2}O.{2}O").matcher(board).find() ||
                Pattern.compile(".{2}X.{2}X.{2}X").matcher(board).find() ||
                Pattern.compile(".{2}O.{2}O.{2}O").matcher(board).find() ||
                Pattern.compile("^X.{3}X.{3}X").matcher(board).find() ||
                Pattern.compile("^O.{3}O.{3}O").matcher(board).find() ||
                Pattern.compile(".{2}X.X.X").matcher(board).find() ||
                Pattern.compile(".{2}O.O.O").matcher(board).find();

    }

    @Test
    public void SomeBoardsWithWinnersTests () {
        String[] winners = new String[]{"XXX-O-O-O", "X--OOOX-X", "O--OO-XXX", "O-XOX-O-X", "OXOOXOXX-", "X-O-OOXXO", "XO--X-OOX", "X-OXOOOXX"};
        for (String winner : winners) {
            System.out.println("Testing with board " + winner);
            assertEquals(true, RegexTicTacToeWinChecker.regexTicTacToeWinChecker(winner));
        }
    }

    @Test
    public void SomeBoardsWithoutWinnersTests () {
        String[] notWinners = new String[]{"XO-------", "XX-XOO---", "-XX-OO-O-", "OXO--XXO-", "OOXXXO---", "OXXX-XOO-", "OOXXX----", "XXOOXXOO-", "OXOXOX---"};
        for (String notWinner : notWinners) {
            System.out.println("Testing with board " + notWinner);
            assertEquals(false, RegexTicTacToeWinChecker.regexTicTacToeWinChecker(notWinner));
        }
    }

}
