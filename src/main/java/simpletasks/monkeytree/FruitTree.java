package simpletasks.monkeytree;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

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
