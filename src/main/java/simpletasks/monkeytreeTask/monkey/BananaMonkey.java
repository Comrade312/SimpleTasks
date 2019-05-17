package simpletasks.monkeytreeTask.monkey;

import simpletasks.monkeytreeTask.fruit.Banana;
import simpletasks.monkeytreeTask.tree.FruitTree;

import java.util.ListIterator;

public class BananaMonkey implements Monkey<Banana> {
    private int monkeyCalculationResult;

    public void countFruits(FruitTree<Banana> fruitTree){
        ListIterator<FruitTree<Banana>> listIterator = fruitTree.getNodes().listIterator();

        if(fruitTree.getFruits() != null) this.monkeyCalculationResult += fruitTree.getFruits().size();

        while (listIterator.hasNext()) {
            FruitTree<Banana> currentTree = listIterator.next();
            countFruits(currentTree);
        }
    }

    public int getMonkeyCalculationResult() {
        return monkeyCalculationResult;
    }

    public void setMonkeyCalculationResult(int monkeyCalculationResult) {
        this.monkeyCalculationResult = monkeyCalculationResult;
    }
}
