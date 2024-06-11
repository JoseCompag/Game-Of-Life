package cell;

public class CellFactoryGenerationsBBGame extends CellFactory {

    public CellFactoryGenerationsBBGame() {}

    @Override
    public Cell createCell(Character symbol) {
        switch (symbol) {
            case '■':
                return new LivingCell();
            case 'R':
                return new DyingCell1();
        }
        return new DeadCell();
    }
}
