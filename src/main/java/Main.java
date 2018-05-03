import ui.MainFrame;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        //MainFrame frame = new MainFrame();
       consoleUI();
    }

    public static void consoleUI(){
        String name="num.txt";
        Scanner in = null;
        try {
            in = new Scanner(new File(name));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ArrayList<Double> arr = new ArrayList<Double>();
        while (in.hasNext()) {//пока есть следуюищй
            arr.add(Double.valueOf(in.next()));//переводит из строкового в дабл
        }
        Collections.sort(arr);//сортировка по возрастанию
        double min = arr.get(0);//так как отсортированный
        double max = arr.get(arr.size() - 1);
        final double[] average = {0};
        arr.forEach(a -> average[0] += a);//смотрим каждый элемент, -> выражение
        average[0] /= arr.size();
        double mediana = 0;
        if (arr.size() % 2 != 0) {
            mediana = arr.get((arr.size() - 2) / 2 + 1);
        } else mediana = (arr.get(arr.size() / 2 - 1) + arr.get(arr.size() / 2)) / 2;
        double sum = 0;
        for (int i = 0; i < arr.size(); i++) {
        sum += arr.get(i);
        }
        System.out.println("Min: " + min);
        System.out.println("Max: " + max);
        System.out.println("Count: " + arr.size());
        System.out.println("Average: " + average[0]);
        System.out.println("Mediana: " + mediana);
        System.out.println("Сумма:" + sum);
    }
}
