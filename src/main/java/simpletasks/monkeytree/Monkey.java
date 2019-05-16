package simpletasks.monkeytree;

public interface Monkey<T extends Fruit> {
    void countFruits(FruitTree<T> fruitTree);
}
