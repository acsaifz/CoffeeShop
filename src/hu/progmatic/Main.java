package hu.progmatic;

import hu.models.Coffee;
import hu.models.CoffeeMachine;
import hu.models.Customer;
import java.util.InputMismatchException;
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
        System.out.print("Add meg a neved: ");
        String name = scanner.nextLine();

        System.out.print("Add meg mennyi pénz van nálad(Ft): ");
        int money = 0;
        while (money == 0){
            try{
                money = scanner.nextInt(); scanner.nextLine();
            }catch(InputMismatchException e){
                scanner.nextLine();
                System.out.println("Hiba! Csak számot adhatsz meg!");
                System.out.print("Add meg mennyi pénz van nálad(Ft): ");
                continue;
            }
            if (money==0){
                System.out.println("Hiba! Nem vehetsz kávét 0 Ft-ból!");
                System.out.print("Add meg mennyi pénz van nálad(Ft): ");
            }
        }

        Customer customer = new Customer(name,money);

        boolean run = true;
        while(run){
            clrScreen();
            System.out.println("----------------------------------------");
            System.out.println("Kedves " + customer.getName() + "!");
            System.out.println("----------------------------------------");
            System.out.println("(v) Kávé vásárlás");
            System.out.println("(f) Kávégép feltöltése");
            System.out.println("(j) Kávégép állapot jelentés");
            System.out.println("(x) Kilépés");
            System.out.println("----------------------------------------");
            System.out.print("Válassz egyet a felsorolásból: ");
            String choice = scanner.nextLine();

            switch(choice.toLowerCase()){
                case "v":
                    String coffeeChoice;
                    do{
                        clrScreen();
                        coffeeMachine.printCoffeeMenu();
                        System.out.println("(x) Visszalépés a főmenübe");
                        System.out.println("----------------------------------------");
                        System.out.print("Válassz egyet a felsorolásból: ");
                        coffeeChoice = scanner.nextLine();
                        try{
                            int coffeeId = Integer.parseInt(coffeeChoice);
                            if (coffeeId <= coffeeMachine.getCoffees().length && coffeeId >= 0){
                                coffeeMachine.buyCoffee(coffeeId,customer);
                                System.out.print("Folytatáshoz nyomja meg az [Enter] billentyűt");
                                scanner.nextLine();
                                break;
                            }
                        }catch(NumberFormatException e){
                            //Do nothing
                        }
                    }while (!coffeeChoice.equals("x"));
                    break;
                case "f":
                    break;
                case "j":
                    clrScreen();
                    System.out.println(coffeeMachine.getRiport());
                    System.out.print("Folytatáshoz nyomja meg az [Enter] billentyűt");
                    scanner.nextLine();
                    break;
                case "x":
                    run = false;
                    break;
            }

        }

    }
    public static void clrScreen(){
        try{
            final String os = System.getProperty("os.name");
            if (os.contains("Windows")){
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            }else{
                new ProcessBuilder("sh", "-c", "clear").inheritIO().start().waitFor();
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
