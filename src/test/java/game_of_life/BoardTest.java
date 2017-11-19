package game_of_life;

import org.junit.Test;

public class BoardTest {

    @Test
    public void shouldReturnCorrectNextState() throws Exception {

        Board expectedBoard = getExpectedBoard();

        Cell cell1 = new Cell(1, 2);
        Cell cell2 = new Cell(2,2);
        Cell cell3 = new Cell(3, 2);
        Board board = new Board(5, cell1, cell2, cell3);

        Board newBoard = board.nextGeneration().nextGeneration().nextGeneration();

        System.out.println("Current: ");
        System.out.println(board);

        System.out.println("Next Gen: ");
        System.out.println(newBoard);

        System.out.println("Expected: ");
        System.out.println(expectedBoard);
    }

    private Board getExpectedBoard(){

        Cell cell1 = new Cell(2, 1);
        Cell cell2 = new Cell(2,2);
        Cell cell3 = new Cell(2, 3);

        return new Board(5, cell1, cell2, cell3);

    }
}
