package simpletasks.monkeytree;

import java.util.ListIterator;

public class Monkey {
    private int monkeyCalculationResult;

    public static void main(String[] args) {

        FruitTree<Apple> mainTree = new FruitTree<>();
        FruitTree<Apple> secTree1 = new FruitTree<>(); //1-ая ветка на главной
        FruitTree<Apple> secTree2 = new FruitTree<>(); //2-ая ветка на главной
        FruitTree<Apple> secTree3 = new FruitTree<>(); //3-ая ветка на главной
        FruitTree<Apple> secTree21 = new FruitTree<>(); //1-ая ветка на 2-ой ветке

        secTree1.getFruits().add(new Apple());
        secTree2.getFruits().add(new Apple());
        secTree2.getFruits().add(new Apple());

        secTree2.getNodes().add(secTree21);
        secTree2.getFruits().add(new Apple());
        secTree21.getFruits().add(new Apple());
        secTree21.getFruits().add(new Apple());

        secTree3.getFruits().add(new Apple());

        mainTree.getNodes().add(secTree1);
        mainTree.getNodes().add(secTree2);
        mainTree.getNodes().add(secTree3);

        Monkey monkey = new Monkey();
        monkey.countFruits(mainTree);
        System.out.println(monkey.getMonkeyCalculationResult());
    }

    public void countFruits(FruitTree fruitTree){

        ListIterator<FruitTree> listIterator = fruitTree.getNodes().listIterator();
        while (listIterator.hasNext()){
            FruitTree currentTree = listIterator.next();
            if(currentTree.getFruits() != null) this.monkeyCalculationResult += currentTree.getFruits().size();
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
