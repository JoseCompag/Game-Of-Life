package cell.GenerationsBBGame;

import cell.Cell;
import cell.CellFactory;
import cell.DeadInitCell;

public class CellFactoryGenerationsBBGame extends CellFactory {

    public CellFactoryGenerationsBBGame() {}

    @Override
    public Cell createCell(Character symbol) {
        switch (symbol) {
            case 'Y':
                return new LivingCell();
            case 'R':
                return new DyingCell1();
            case 'I':
                return new DeadInitCell();
        }
        return new DeadCell();
    }
}
