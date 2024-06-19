package cell;

public class DeadCell extends Cell {

    @Override
    public String toString() {
        String black="\u001B[30m";
        String reset="\u001B[0m";
        return black+"□"+reset;
//        return "□";
    }

}
