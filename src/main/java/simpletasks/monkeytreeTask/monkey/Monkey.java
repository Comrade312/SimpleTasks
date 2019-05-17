package simpletasks.monkeytreeTask.monkey;

import simpletasks.monkeytreeTask.fruit.Fruit;
import simpletasks.monkeytreeTask.tree.FruitTree;

public interface Monkey<T extends Fruit> {
    void countFruits(FruitTree<T> fruitTree);
}
