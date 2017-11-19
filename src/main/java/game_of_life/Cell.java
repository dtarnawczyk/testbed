package game_of_life;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
class Cell {
    private int x;
    private int y;
    private State state;
    public Cell(int x, int y){
        setX(x);
        setY(y);
        this.state = State.LIVE;
    }

    public enum State {
        LIVE, DEAD;
    }
}
