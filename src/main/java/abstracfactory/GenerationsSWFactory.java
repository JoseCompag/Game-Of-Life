package abstracfactory;

import cell.CellFactory;
import cell.CellFactoryGenerationsSWGame;
import rule.*;

import java.util.ArrayList;
import java.util.List;

public class GenerationsSWFactory implements AbstracFactory {

    public GenerationsSWFactory(){}

    @Override
    public CellFactory getCellFactory(){
        return new CellFactoryGenerationsSWGame();
    }

    @Override
    public List<Rule> createRules() {
        List<Rule> rules = new ArrayList<>();
        Rule rule1 = new BirthRule(List.of(2));
        Rule rule2 = new SurviveRule(List.of(3,4,5));
        Rule rule3 = new Dying1Rule();
        Rule rule4 = new Dying2Rule();
        Rule rule5 = new DeathRule();
        rules.add(rule1);
        rules.add(rule2);
        rules.add(rule3);
        rules.add(rule4);
        rules.add(rule5);
        return rules;
    }
}