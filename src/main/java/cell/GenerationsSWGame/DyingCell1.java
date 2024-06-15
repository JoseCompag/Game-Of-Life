package cell.GenerationsSWGame;

import cell.Cell;

public class DyingCell1 extends Cell {

    @Override
    public String toString() {
        String orange="\033[38;2;255;165;0m";
        String reset="\u001B[0m";
        return orange+"■"+reset;
    }

}
