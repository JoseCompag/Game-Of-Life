package abstracfactory;

import cell.CellFactory;
import cell.TraditionalHLGame.CellFactoryTraditionalHLGame;
import rule.Rule;
import rule.TraditionalHLGame.BirthRule;
import rule.TraditionalHLGame.DeathRule;
import rule.TraditionalHLGame.SurviveRule;

import java.util.ArrayList;
import java.util.List;

public class TraditionalHLFactory implements AbstracFactory {

    public TraditionalHLFactory(){}

    @Override
    public CellFactory getCellFactory(){
        return new CellFactoryTraditionalHLGame();
    }

    @Override
    public List<Rule> createRules() {
        List<Rule> rules = new ArrayList<>();
        Rule rule1 = new BirthRule();
        Rule rule2 = new SurviveRule();
        Rule rule3 = new DeathRule();
        rules.add(rule1);
        rules.add(rule2);
        rules.add(rule3);
        return rules;
    }
}
