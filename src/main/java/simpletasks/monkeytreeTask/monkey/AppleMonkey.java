package simpletasks.monkeytreeTask.monkey;

import simpletasks.monkeytreeTask.fruit.Apple;
import simpletasks.monkeytreeTask.tree.FruitTree;

import java.util.ListIterator;

public class AppleMonkey implements Monkey<Apple> {
    private int monkeyCalculationResult;

    public void countFruits(FruitTree<Apple> fruitTree) {
        ListIterator<FruitTree<Apple>> listIterator = fruitTree.getNodes().listIterator();

        if(fruitTree.getFruits() != null) {
            this.monkeyCalculationResult += fruitTree.getFruits().size();
        }

        while (listIterator.hasNext()) {
            FruitTree<Apple> currentTree = listIterator.next();
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
