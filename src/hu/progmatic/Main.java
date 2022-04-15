package hu.progmatic;

import hu.models.Coffee;
import hu.models.CoffeeMachine;
import hu.models.Customer;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Coffee[] coffees = {
                new Coffee("Rövid kávé",50,6,6,70),
                new Coffee("Rövid kávé tejjel", 60, 5, 6, 6, 70),
                new Coffee("Hosszú kávé", 100, 12,9,100),
                new Coffee("Hosszú kávé tejjel", 120, 20, 12,9,100),
                new Coffee("Cappuccino", 150,30,6,9,120)
        };

        CoffeeMachine coffeeMachine = new CoffeeMachine(coffees);

        System.out.println("Add meg a neved: ");
        String name = scanner.nextLine();

        System.out.println("Add meg mennyi pénz van nálad(Ft): ");
        int money = scanner.nextInt(); scanner.nextLine();

        Customer customer = new Customer(name,money);

        boolean run = true;
        while(run){
            System.out.println("Kedves " + customer.getName() + "!");
            System.out.println("Válassz az alábbi menüből: ");
            System.out.println("Kávé vásárlás(v)");
            System.out.println("Kávégép feltöltése(f)");
            System.out.println("Kávégép állapot jelentés(j)");
            System.out.println("Kilépés(x)");

            String choice = scanner.nextLine();

            switch(choice.toLowerCase()){
                case "v":
                    break;
                case "f":
                    break;
                case "j":
                    System.out.println(coffeeMachine.getRiport());
                    System.out.println("Folytatáshoz nyomja meg az [Enter] billentyűt");
                    scanner.nextLine();
                    break;
                case "x":
                    run = false;
                    break;
            }

        }
    }
}
