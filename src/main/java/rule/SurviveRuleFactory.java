package rule;

import java.util.List;

public class SurviveRuleFactory extends RuleFactory {

    @Override
    public Rule createRule (List<Integer> params) {
        int numA = params.get(0);
        int numB = params.get(1);
        return new SurviveRule(numA, numB);
    }

}
