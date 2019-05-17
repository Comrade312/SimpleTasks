package simpletasks.monkeytreeTask;

import simpletasks.monkeytreeTask.fruit.Apple;
import simpletasks.monkeytreeTask.fruit.Banana;
import simpletasks.monkeytreeTask.monkey.AllFruitMonkey;
import simpletasks.monkeytreeTask.monkey.AppleMonkey;
import simpletasks.monkeytreeTask.monkey.BananaMonkey;
import simpletasks.monkeytreeTask.tree.FruitTree;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    private int monkeyCalculationResult;

    public static void main(String[] args) {
        FruitTree<Banana> mainTree = new FruitTree<>();
        FruitTree<Banana> secTree1 = new FruitTree<>(); //1-ая ветка на главной
        FruitTree<Banana> secTree2 = new FruitTree<>(); //2-ая ветка на главной
        FruitTree<Banana> secTree3 = new FruitTree<>(); //3-ая ветка на главной
        FruitTree<Banana> secTree21 = new FruitTree<>(); //1-ая ветка на 2-ой ветке

        secTree1.getFruits().add(new Banana());
        secTree2.getFruits().add(new Banana());
        secTree2.getFruits().add(new Banana());

        secTree2.getNodes().add(secTree21);
        secTree2.getFruits().add(new Banana());
        secTree21.getFruits().add(new Banana());
        secTree21.getFruits().add(new Banana());

       // secTree3.getFruits().add(new Banana());

        mainTree.getNodes().add(secTree1);
        mainTree.getNodes().add(secTree2);
        mainTree.getNodes().add(secTree3);

        //monkey.countFruits(mainTree);
        AllFruitMonkey allMonkey = new AllFruitMonkey();
        AppleMonkey appleMonkey = new AppleMonkey();
        BananaMonkey bananaMonkey = new BananaMonkey();

        allMonkey.countFruits(mainTree);
       // appleMonkey.countFruits(mainTree);
        bananaMonkey.countFruits(mainTree);
        System.out.println(bananaMonkey.getMonkeyCalculationResult());

    }

}
