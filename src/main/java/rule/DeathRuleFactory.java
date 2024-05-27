package rule;

import java.util.List;

public class DeathRuleFactory extends RuleFactory {

    @Override
    public Rule createRule (List<Integer> params) {
        return new DeathRule();
    }

}
