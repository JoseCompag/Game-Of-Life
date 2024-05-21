package rule;

import java.util.ArrayList;

public abstract class RuleFactory {

    public abstract Rule createRule (ArrayList<Integer> params);

}
