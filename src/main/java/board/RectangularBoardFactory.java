package board;

public class RectangularBoardFactory extends BoardFactory {

    @Override
    public Board createBoard() {
        return new RectangularBoard();
    }

}
