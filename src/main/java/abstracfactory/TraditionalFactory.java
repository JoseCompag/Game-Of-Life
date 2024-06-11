package abstracfactory;

import cell.CellFactory;
import cell.CellFactoryTraditionalGame;
import rule.*;

import java.util.ArrayList;
import java.util.List;

public class TraditionalFactory implements AbstracFactory{

    public TraditionalFactory(){}

    @Override
    public CellFactory getCellFactory(){
        return new CellFactoryTraditionalGame();
    }

    @Override
    public List<Rule> createRules() {
        List<Rule> rules = new ArrayList<>();
        Rule rule1 = new BirthRule(List.of(3));
        Rule rule2 = new SurviveRule(List.of(2,3));
        Rule rule3 = new DeathRule();
        rules.add(rule1);
        rules.add(rule2);
        rules.add(rule3);
        return rules;
    }
}
