package hu.progmatic;

import hu.models.Coffee;
import hu.models.CoffeeMachine;

public class Main {

    public static void main(String[] args) {
        Coffee[] coffees = {
                new Coffee("Rövid kávé",50,6,6,70),
                new Coffee("Rövid kávé tejjel", 60, 5, 6, 6, 70),
                new Coffee("Hosszú kávé", 100, 12,9,100),
                new Coffee("Hosszú kávé tejjel", 120, 20, 12,9,100),
                new Coffee("Cappuccino", 150,30,6,9,120)
        };

        CoffeeMachine coffeeMachine = new CoffeeMachine(coffees);
    }
}
