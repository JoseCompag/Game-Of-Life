package rule;

import cell.Cell;

import java.util.HashMap;
import java.util.List;

public class HashMapLoad {

    public HashMapLoad(){;}

    public HashMap<Class<?>, Integer> loadMapOfNeighbors (List<Cell> neighborsCells){
        HashMap<Class<?>, Integer> neighborsRes = new HashMap<>();
        for (Cell cell : neighborsCells) {
            Class<? extends Cell> currentCellClass = cell.getClass();
            if(neighborsRes.containsKey(currentCellClass)){
                Integer newValueCurrentCellClass = neighborsRes.get(currentCellClass)+1;
                neighborsRes.put(currentCellClass, newValueCurrentCellClass);
            }else{
                neighborsRes.put(currentCellClass, 1);
            }
        }
        return neighborsRes;
    }

}
