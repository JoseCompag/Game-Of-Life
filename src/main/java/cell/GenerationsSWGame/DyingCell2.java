package cell.GenerationsSWGame;

import cell.Cell;

public class DyingCell2 extends Cell {

    @Override
    public String toString() {
        String redBright ="\033[91m";
        String reset="\u001B[0m";
        return redBright +"■"+reset;
    }

}
