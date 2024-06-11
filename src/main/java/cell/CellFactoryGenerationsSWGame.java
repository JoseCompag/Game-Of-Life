package cell;

public class CellFactoryGenerationsSWGame extends CellFactory {

    public CellFactoryGenerationsSWGame() {}

    @Override
    public Cell createCell(Character symbol) {
        switch (symbol) {
            case '■':
                return new LivingCell();
            case 'R':
                return new DyingCell1();
            case 'O':
                return new DyingCell2();
        }
        return new DeadCell();
    }
}
