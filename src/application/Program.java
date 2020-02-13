/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import entities.Company;
import entities.Indiviual;
import entities.TaxPayer;
import java.util.ArrayList;
import java.util.List;

import java.util.Locale;
import java.util.Scanner;

/**
 *
 * @author ut2u
 */
public class Program {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        
        List<TaxPayer> list = new ArrayList<>();
        
        System.out.print("Insert the number of tax payers: ");
        int n = sc.nextInt();
        
        for(int i = 1; i <= n; i++){
            System.out.println("Tax payer #" + i + ":");
            System.out.print("Individual or company (i/c)? ");
            char op = sc.next().charAt(0);
            while(op != 'i' && op != 'c'){
                System.out.print("ERROR! Please insert a correct value...\n");
                System.out.print("Individual or company (i/c)? ");
                op = sc.next().charAt(0);
            }
            if(op == 'i'){
                System.out.print("Name: ");
                String name = sc.next();
                System.out.print("Anual Income: ");
                double anualIncome = sc.nextDouble();
                System.out.print("Health expenditures: ");
                double healthExpenditures = sc.nextDouble();
                list.add(new Indiviual(name, anualIncome, healthExpenditures));
            }
            else{
                System.out.print("Name: ");
                String name = sc.next();
                System.out.print("Anual Income: ");
                double anualIncome = sc.nextDouble();
                System.out.print("Number of employees: ");
                int numberOfEmployees = sc.nextInt();
                list.add(new Company(name, anualIncome, numberOfEmployees));
            }
        }
        
        System.out.println("\nTAXES PAID:\n");
        double sumTaxes = 0.0;
        for(TaxPayer txpay : list){
            System.out.printf("%s: (US)$%.2f%n", txpay.getName(), txpay.tax());
            sumTaxes += txpay.tax();
        }
        
        System.out.printf("\nTOTAL TAXES: (US)$%.2f%n", sumTaxes);
        sc.close();
    }
}
