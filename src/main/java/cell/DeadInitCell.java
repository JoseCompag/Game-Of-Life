package cell;

public class DeadInitCell extends Cell {

    @Override
    public String toString() {
        String black="\033[30m";
        String reset="\u001B[0m";
        return black+"■"+reset;
    }

}
