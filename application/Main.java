package application;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Product;

class Main {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner entrada = new Scanner(System.in);
        
        List<Product> produtos = new ArrayList<>();

        System.out.print("Enter file path: ");
        String path = entrada.nextLine();

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            System.out.println("Reading the .csv file:");
            String line = br.readLine();
            while (line != null) {
                String[] dataProduct = line.split(",");

                String name = dataProduct[0].replaceAll("\"", "").replaceAll(" ", "");
                double value = Double.valueOf(dataProduct[1].replaceAll(" ", ""));
                int quantity = Integer.valueOf(dataProduct[2].replaceAll("\"", "").replaceAll(" ", ""));

                produtos.add(new Product(name, value, quantity));

                System.out.println(line);
                line = br.readLine();
            }
        }
        catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }

        // criando a subpasta
        File subPath = new File(path);
        String path2 = subPath.getParent() + "\\out";
        boolean newDirectory = new File(path2).mkdir();
        System.out.print("Create new directory: " + newDirectory);

        // criando o novo arquivo
        path2 += "\\summary.csv";
        try (BufferedWriter br = new BufferedWriter(new FileWriter(path2))) {
            for (Product p : produtos) {
                String text = p.getName() + ", " + p.totalValue();
                br.write(text);
                br.newLine();
            }
        }
        catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }

        entrada.close();

    }
}