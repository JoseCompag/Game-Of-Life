package rule;

import java.util.ArrayList;

public class DeathRuleFactory extends RuleFactory {

    @Override
    public Rule createRule (ArrayList<Integer> params) {
        return new DeathRule();
    }

}
