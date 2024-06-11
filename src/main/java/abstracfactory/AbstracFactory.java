package abstracfactory;

import cell.CellFactory;
import rule.Rule;

import java.util.List;

public interface AbstracFactory {

    CellFactory getCellFactory();
    List<Rule> createRules();

}
