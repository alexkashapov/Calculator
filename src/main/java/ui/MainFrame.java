package ui;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class MainFrame extends JFrame {
    private String path;
    private JPanel panel = new JPanel();
    private JButton fileButton = new JButton("Открыть файл");
    private JLabel maxNumLabel = new JLabel("Max:");
    private JLabel minNumLabel = new JLabel("Min:");
    private JLabel countLabel = new JLabel("Count:");
    private JLabel avgLabel = new JLabel("Average:");
    private JLabel medLabel = new JLabel("Mediana:");
    private JFileChooser openFile = new JFileChooser();


    public MainFrame() {
        super("Number Analize");
        setPreferredSize(new Dimension(300, 120));
        setLocation(500, 300);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        fileButton.addActionListener(e -> {
            int retVal = openFile.showDialog(null, "Choose File");
            if (retVal == JFileChooser.APPROVE_OPTION) {
                File file = openFile.getSelectedFile();
                calculate(file);
            }
        });
        panel.add(maxNumLabel);//
        panel.add(minNumLabel);
        panel.add(countLabel);
        panel.add(avgLabel);
        panel.add(medLabel);
        panel.add(fileButton);
        getContentPane().add(panel);
        pack();
        setVisible(true);
    }

    private void calculate(File file) {
        try {
            Scanner in = new Scanner(file);
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
            minNumLabel.setText("Min: " + min);
            maxNumLabel.setText("Max: " + max);
            countLabel.setText("Count: " + arr.size());
            avgLabel.setText("Average: " + average[0]);
            medLabel.setText("Mediana: " + mediana);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
