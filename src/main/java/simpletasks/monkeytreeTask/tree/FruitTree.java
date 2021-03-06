package simpletasks.monkeytreeTask.tree;

import simpletasks.monkeytreeTask.fruit.Fruit;

import java.util.ArrayList;
import java.util.List;

public class FruitTree<T extends Fruit> {
    private List<FruitTree<T>> nodes;
    private List<T> fruits;

    public FruitTree() {
        this.nodes = new ArrayList<>();
        this.fruits = new ArrayList<>();
    }

    public List<FruitTree<T>> getNodes() {
        return nodes;
    }

    public void setNodes(List<FruitTree<T>> nodes) {
        this.nodes = nodes;
    }

    public List<T> getFruits() {
        return fruits;
    }

    public void setFruits(List<T> fruits) {
        this.fruits = fruits;
    }
}
