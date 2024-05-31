package rule;

import java.util.List;
import java.util.Objects;

public class RuleFactory {

    public Rule createRule (String type, List<Integer> params) {
        if (Objects.equals(type, "birth")){
            return new SurviveRule(params);
        } else if (Objects.equals(type, "survive")){
            return new SurviveRule(params);
        } else {
            return new DeathRule();
        }
    }

}
