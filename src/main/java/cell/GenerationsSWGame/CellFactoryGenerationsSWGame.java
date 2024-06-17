package cell.GenerationsSWGame;

import cell.Cell;
import cell.CellFactory;
import cell.DeadInitCell;

public class CellFactoryGenerationsSWGame extends CellFactory {

    public CellFactoryGenerationsSWGame() {}

    @Override
    public Cell createCell(Character symbol) {
        switch (symbol) {
            case 'Y':
                return new LivingCell();
            case 'O':
                return new DyingCell1();
            case 'B':
                return new DyingCell2();
            case 'I':
                return new DeadInitCell();
        }
        return new DeadCell();
    }
}
