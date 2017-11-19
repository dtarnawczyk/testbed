package game_of_life;

import game_of_life.Cell.State;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.function.Supplier;

@Setter
@Getter
class Board {

    private int size;
    private List<Cell> cellsCollection;

    private Board(){}

    public Board(int size, Cell...cells){
        checkOversizedCells(size, cells);
        setSize(size);
        this.cellsCollection = new ArrayList<>();
        for (int y = 0; y < size; y++) {
            for (int x = 0; x < size; x++) {

                Cell cell = Arrays.stream(cells)
                        .filter(matchingCoordinates(x, y))
                        .findAny()
                        .orElse(new Cell(x, y, State.DEAD));

                this.cellsCollection.add(cell);
            }
        }
    }

    public Board nextGeneration() throws Exception {
        Board board = new Board(getSize());
        List<Cell> newCellsCollection = new ArrayList<>();

        for (int y = 0; y < this.size; y++) {
            for (int x = 0; x < this.size; x++) {
                Cell cell = getCellByCoordinates(x,y);
                int aliveNeighbours = getNeighboursWithStateCount(cell);
                if(cell.getState() == State.LIVE){
                    if(aliveNeighbours < 2 || aliveNeighbours > 3){
                        cell.setState(State.DEAD);
                    }
                } else {
                    if( aliveNeighbours == 3)
                        cell.setState(State.LIVE);
                }
                newCellsCollection.add(cell);
            }
        }

        board.setCellsCollection(newCellsCollection);
        return board;
    }

    public int getNeighboursWithStateCount(Cell cell) throws Exception {
        int liveCounter = 0;
        int x = cell.getX();
        int y = cell.getY();
        for (int i = y-1; i <= y+1; i++) {
            for (int j = x-1; j <= x+1; j++) {
                if(i != y || j != x){
                    Cell neighbour = getCellByCoordinates(j,i);
                    if(neighbour.getState() == State.LIVE)
                        liveCounter += 1;
                }
            }
        }
        return liveCounter;
    }

    @Override
    public String toString() {
        StringBuffer buffer = new StringBuffer();
        for (int y = 0; y < getSize(); y++) {
            for (int x = 0; x < getSize(); x++) {
                try {
                    if (getCellByCoordinates(x, y).getState() == State.LIVE) {
                        buffer.append("X");
                    } else {
                        buffer.append("O");
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            buffer.append("\n");
        }
        return buffer.toString();
    }

    private Cell getCellByCoordinates(int x, int y) throws Exception {
        Cell cell = getCellsCollection().stream()
                .filter(matchingCoordinates(x, y))
                .findAny()
                .orElseThrow(illlegalCellState());
        return new Cell(cell.getX(), cell.getY(), cell.getState());
    }

    private Predicate<Cell> matchingCoordinates(int x, int y){
        int size = getSize();
        int X = x < 0 ? ((x % size) + size) % size : x % size;
        int Y = y < 0 ? ((y % size) + size) % size : y % size;
        return c -> c.getX() == X && c.getY() == Y;
    }

    private Supplier<Exception> illlegalCellState(){
        return () -> new IllegalStateException("Can't find cell");
    }

    private void checkOversizedCells(int size, Cell[] cells) {
        for (Cell cell : cells) {
            if(cell.getX() >= size || cell.getY() >= size){
                throw new IllegalStateException("Cell coordinates over board size");
            }
        }
    }
}
