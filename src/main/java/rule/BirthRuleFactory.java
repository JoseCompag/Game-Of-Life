package rule;

import java.util.ArrayList;

public class BirthRuleFactory extends RuleFactory {

    @Override
    public Rule createRule (ArrayList<Integer> params) {
        int num = params.get(0);
        return new BirthRule(num);
    }

}
