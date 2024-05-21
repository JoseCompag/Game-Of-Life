package rule;

import java.util.ArrayList;

public class SurviveRuleFactory extends RuleFactory {

    @Override
    public Rule createRule (ArrayList<Integer> params) {
        int numA = params.get(0);
        int numB = params.get(1);
        return new SurviveRule(numA, numB);
    }

}
