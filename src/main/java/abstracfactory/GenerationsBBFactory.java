package abstracfactory;

import cell.CellFactory;
import cell.GenerationsBBGame.CellFactoryGenerationsBBGame;
import rule.GenerationsBBGame.BirthRule;
import rule.GenerationsBBGame.DeathRule;
import rule.GenerationsBBGame.Dying1Rule;
import rule.Rule;

import java.util.ArrayList;
import java.util.List;

public class GenerationsBBFactory implements AbstracFactory {

    public GenerationsBBFactory(){}

    @Override
    public CellFactory getCellFactory(){
        return new CellFactoryGenerationsBBGame();
    }

    @Override
    public List<Rule> createRules() {
        List<Rule> rules = new ArrayList<>();
        Rule rule1 = new BirthRule(List.of(2));
        Rule rule2 = new Dying1Rule();
        Rule rule3 = new DeathRule();
        rules.add(rule1);
        rules.add(rule2);
        rules.add(rule3);
        return rules;
    }
}