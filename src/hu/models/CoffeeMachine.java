package hu.models;

public class CoffeeMachine {
    final static int WATER_TANK_SIZE = 4000; //ml
    final static int COFFEE_TANK_SIZE = 1000; //g
    final static int MILK_POWDER_TANK_SIZE = 350; //g
    final static int CUP_CONTAINER_SIZE = 25; //pcs
    final static int SUGAR_TANK_SIZE = 500; //g
    private int waterAmount;
    private int coffeeAmount;
    private int milkPowderAmount;
    private int sugarAmount;
    private int cupAmount;
    private Coffee[] coffees;
    private int money = 0;

    public CoffeeMachine(Coffee[] coffees){
        this.waterAmount = WATER_TANK_SIZE;
        this.coffeeAmount = COFFEE_TANK_SIZE;
        this.milkPowderAmount = MILK_POWDER_TANK_SIZE;
        this.cupAmount = CUP_CONTAINER_SIZE;
        this.sugarAmount = SUGAR_TANK_SIZE;
        this.coffees = coffees;
    }

    public String getRiport(){

        return "----------------------------------------\n" +
                "Kávégép állapot jelentés:\n" +
                "----------------------------------------\n" +
                "Víz mennyiség: " + waterAmount + "ml\n" +
                "Kávé mennyiség: " + coffeeAmount + "g\n" +
                "Tejpor mennyiség: " + milkPowderAmount + "g\n" +
                "Cukor mennyiség: " + sugarAmount + "g\n" +
                "Pohár mennyiség: " + cupAmount + "db\n" +
                "Profit: " + money + " Ft\n" +
                "----------------------------------------";
    }

    public void printCoffeeMenu(){
        int counter = 0;
        System.out.println("----------------------------------------");
        System.out.println("Kávé menülap: ");
        System.out.println("----------------------------------------");
        for (Coffee coffee: coffees) {
            System.out.println("(" + counter++ + ") " + coffee.getName() + "\tÁr: " + coffee.getPrice() + " Ft");
        }
    }

    public void buyCoffee(int id, Customer customer){
        if (coffees[id].getPrice() > customer.getMoney()){
            System.out.println("Hiba! Nincs elég pénzed a kávé megvásárlásához!");
            System.out.println("Kávé ára: " + coffees[id].getPrice() + " Ft");
            System.out.println("Ennyi pénzed van: " + customer.getMoney() + "Ft");
            return;
        }

        if (waterAmount >= coffees[id].getWater() &&
                coffeeAmount >= coffees[id].getCoffee() &&
                milkPowderAmount >= coffees[id].getMilk() &&
                sugarAmount >= coffees[id].getSugar() &&
                cupAmount > 0){
            waterAmount -= coffees[id].getWater();
            coffeeAmount -= coffees[id].getCoffee();
            milkPowderAmount -= coffees[id].getMilk();
            sugarAmount -= coffees[id].getSugar();
            cupAmount--;
            money += coffees[id].getPrice();

            customer.setMoney(customer.getMoney()-coffees[id].getPrice());

            System.out.println("Sikeres vásárlás! Maradt " + customer.getMoney() + "Ft-od.");
        }else
            System.out.println("Nincs elég alapanyag, töltsd fel a gépet!");
    }

    public void refill(){
        if (waterAmount == WATER_TANK_SIZE &&
                coffeeAmount == COFFEE_TANK_SIZE &&
                milkPowderAmount == MILK_POWDER_TANK_SIZE &&
                sugarAmount == SUGAR_TANK_SIZE &&
                cupAmount == CUP_CONTAINER_SIZE){
            System.out.println("Hiba! A kávégép tele van, nem tudod újratölteni!");
        }else{
            waterAmount = WATER_TANK_SIZE;
            coffeeAmount = COFFEE_TANK_SIZE;
            milkPowderAmount = MILK_POWDER_TANK_SIZE;
            sugarAmount = SUGAR_TANK_SIZE;
            cupAmount = CUP_CONTAINER_SIZE;
            System.out.println("Kávégép sikeresen feltöltve!");
        }
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

    public void setSugarAmount(int sugarAmount){
        this.sugarAmount = sugarAmount;
    }

    public int getSugarAmount(){
        return  sugarAmount;
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
