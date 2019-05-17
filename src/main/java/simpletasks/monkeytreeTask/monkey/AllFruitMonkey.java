package simpletasks.monkeytreeTask.monkey;

import simpletasks.monkeytreeTask.tree.FruitTree;

import java.util.ListIterator;

public class AllFruitMonkey implements Monkey {
    private int monkeyCalculationResult;

    public void countFruits(FruitTree fruitTree) {
        ListIterator<FruitTree> listIterator = fruitTree.getNodes().listIterator();

        if(fruitTree.getFruits() != null) {
            this.monkeyCalculationResult += fruitTree.getFruits().size();
        }

        while (listIterator.hasNext()) {
            FruitTree currentTree = listIterator.next();
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