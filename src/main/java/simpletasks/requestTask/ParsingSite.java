package simpletasks.requestTask;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.*;
import java.net.UnknownHostException;
import java.util.*;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import java.util.regex.Pattern;

public class ParsingSite {

    private static Logger log = Logger.getLogger(ParsingSite.class.getName());

    public static void main(String[] args) {
        new ParsingSite().work();
    }

    public void search(String url, String searchWord, String username) throws IOException, UnknownHostException {
        Document doc = Jsoup.connect(url).get();
        Elements elements = doc.select("html");

        if(elements.text().toLowerCase().contains(searchWord.toLowerCase())){
            addToLog(username, searchWord);
        }
    }

    public void addToLog(String username, String searchWord) throws IOException {
        FileHandler logFile = new FileHandler("C:\\Users\\comra\\IdeaProjects\\SimpleTasks\\src\\main\\java\\simpletasks\\requestTask\\MyLogFile.log",true);
        log.addHandler(logFile);
        SimpleFormatter simpleFormatter = new SimpleFormatter();
        logFile.setFormatter(simpleFormatter);
        Date date = new Date();
        log.info(username + " " + date.toString() + " " + searchWord);
        logFile.close();

        new DBWorker().insertUser(username, searchWord);
    }

    public String enterLogin(){
        System.out.println("Введите логин");
        Scanner in = new Scanner(System.in);
        return in.next();
    }

    public String enterUrl(){
        System.out.println("Введите URL");
        Scanner in = new Scanner(System.in);
        return in.next();
    }

    public String enterSeacrhWord(){
        System.out.println("Введите поисковое слово");
        Scanner in = new Scanner(System.in);
        return in.next();
    }

    public int chooseMenuItem(){
        System.out.println("Выберете пункт меню");
        Scanner in = new Scanner(System.in);
        int item = 0;

        try{
            item = in.nextInt();
        }
        catch (InputMismatchException exc){
            System.out.println("Ошибка ввода, повторите попытку");
            chooseMenuItem();
        }
        return item;
    }

    public void work(){
        String login = enterLogin();

        while (true) {
            System.out.println("1) Ввести URL и произвести поиск слова");
            System.out.println("2) Разлогиниться");
            System.out.println("3) Выход");
            switch (chooseMenuItem()) {
                case 1:
                    try {
                        search(enterUrl(), enterSeacrhWord(), login);
                    } catch (IllegalArgumentException exc){
                        System.out.println("Неверно задан URL!");
                    }
                    catch (IOException exc) {
                        exc.printStackTrace();
                    }
                    break;
                case 2:
                    work();
                    break;
                case 3:
                    System.exit(0);
                default:
                    break;
            }
        }
    }





}