package abstracfactory;

import cell.CellFactory;
import cell.ColourisedImGame.CellFactoryColourisedImGame;
import rule.ColourisedImGame.BirthRule;
import rule.ColourisedImGame.DeathRule;
import rule.ColourisedImGame.SurviveRule;
import rule.Rule;

import java.util.ArrayList;
import java.util.List;

public class ColorisedImFactory implements AbstracFactory {

    public ColorisedImFactory(){}

    @Override
    public CellFactory getCellFactory(){
        return new CellFactoryColourisedImGame();
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