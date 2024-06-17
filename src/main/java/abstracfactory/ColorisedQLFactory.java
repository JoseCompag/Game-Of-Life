//package abstracfactory;
//
//import cell.CellFactory;
//import cell.ColourisedQLGame.CellFactoryColourisedQLGame;
//import rule.ColourisedQLGame.BirthRule;
//import rule.ColourisedQLGame.DeathRule;
//import rule.ColourisedQLGame.SurviveRule;
//import rule.Rule;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class ColorisedQLFactory implements AbstracFactory {
//
//    public ColorisedQLFactory(){}
//
//    @Override
//    public CellFactory getCellFactory(){
//        return new CellFactoryColourisedQLGame();
//    }
//
//    @Override
//    public List<Rule> createRules() {
//        List<Rule> rules = new ArrayList<>();
//        Rule rule1 = new BirthRule(List.of(3));
//        Rule rule2 = new SurviveRule(List.of(2,3));
//        Rule rule3 = new DeathRule();
//        rules.add(rule1);
//        rules.add(rule2);
//        rules.add(rule3);
//        return rules;
//    }
//}