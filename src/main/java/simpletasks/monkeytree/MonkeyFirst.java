package simpletasks.monkeytree;

import java.util.ListIterator;

public class MonkeyFirst {
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

        //MonkeyFirst monkey = new MonkeyFirst();
        //monkey.countFruits(mainTree);
        AllMonkey allMonkey = new AllMonkey();
        AppleMonkey appleMonkey = new AppleMonkey();
        allMonkey.countFruits(mainTree);
        appleMonkey.countFruits(mainTree);
        System.out.println(appleMonkey.getMonkeyCalculationResult());
    }

    public void countFruits(FruitTree fruitTree){
        ListIterator<FruitTree> listIterator = fruitTree.getNodes().listIterator();

        if(fruitTree.getFruits() != null) this.monkeyCalculationResult += fruitTree.getFruits().size();

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
