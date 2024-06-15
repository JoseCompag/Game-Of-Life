package abstracfactory;

import cell.CellFactory;
import cell.TraditionalGame.CellFactoryTraditionalGame;
import rule.Rule;
import rule.TraditionalGame.BirthRule;
import rule.TraditionalGame.DeathRule;
import rule.TraditionalGame.SurviveRule;

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
