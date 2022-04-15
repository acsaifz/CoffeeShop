package hu.models;

public class CoffeeMachine {
    final static int WATER_TANK_SIZE = 4000; //ml
    final static int COFFEE_TANK_SIZE = 1000; //g
    final static int MILK_POWDER_TANK_SIZE = 350; //g
    final static int CUP_CONTAINER_SIZE = 25; //pcs
    private int waterAmount;
    private int coffeeAmount;
    private int milkPowderAmount;
    private int cupAmount;
    private Coffee[] coffees;
    private int money = 0;

    public CoffeeMachine(Coffee[] coffees){
        this.waterAmount = WATER_TANK_SIZE;
        this.coffeeAmount = COFFEE_TANK_SIZE;
        this.milkPowderAmount = MILK_POWDER_TANK_SIZE;
        this.cupAmount = CUP_CONTAINER_SIZE;
        this.coffees = coffees;
    }

    public void setWaterAmount(int waterAmount) {
        this.waterAmount = waterAmount;
    }

    public int getWaterAmount(){
        return waterAmount;
    }

    public void setCoffeeAmount(int coffeeAmount) {
        this.coffeeAmount = coffeeAmount;
    }

    public int getCoffeeAmount() {
        return coffeeAmount;
    }

    public void setMilkPowderAmount(int milkPowderAmount){
        this.milkPowderAmount = milkPowderAmount;
    }

    public int getMilkPowderAmount(){
        return milkPowderAmount;
    }

    public void setCupAmount(int cupAmount){
        this.cupAmount = cupAmount;
    }

    public int getCupAmount(){
        return  cupAmount;
    }

    public void setCoffees(Coffee[] coffees){
        this.coffees = coffees;
    }

    public Coffee[] getCoffees(){
        return coffees;
    }

    public void setMoney(int money){
        this.money = money;
    }

    public int getMoney(){
        return money;
    }


}
