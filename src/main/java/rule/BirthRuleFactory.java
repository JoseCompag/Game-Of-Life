package rule;

import java.util.List;

public class BirthRuleFactory extends RuleFactory {

    @Override
    public Rule createRule (List<Integer> params) {
        int num = params.get(0);
        return new BirthRule(num);
    }

}
