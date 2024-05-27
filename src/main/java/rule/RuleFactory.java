package rule;

import java.util.List;

public abstract class RuleFactory {

    public abstract Rule createRule (List<Integer> params);

}
