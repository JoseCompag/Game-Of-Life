package abstracfactory;

import cell.CellFactory;
import cell.ColourisedImGame.CellFactoryColourisedImGame;
import rule.ColourisedImNewGame.*;
import rule.Rule;

import java.util.ArrayList;
import java.util.List;

public class ColorisedImNewFactory implements AbstracFactory{
  @Override
  public CellFactory getCellFactory() {
    return new CellFactoryColourisedImGame();
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
