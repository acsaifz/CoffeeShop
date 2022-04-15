package hu.models;

public class Coffee {
    private String name;
    private int water;
    private int milk;
    private int coffee;
    private int sugar;
    private int price;

    public Coffee(String name, int water, int coffee, int sugar, int price){
        this.name = name;
        this.water = water;
        this.coffee = coffee;
        this.sugar = sugar;
        this.price = price;
    }

    public Coffee(String name, int water, int milk, int coffee, int sugar, int price){
        this(name,water,coffee,sugar,price);
        this.milk = milk;
        this.sugar = sugar;
        this.price = price;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public void setWater(int water){
        this.water = water;
    }

    public int getWater(){
        return water;
    }

    public void setMilk(int milk){
        this.milk = milk;
    }

    public int getMilk(){
        return milk;
    }

    public void setCoffee(int coffee){
        this.coffee = coffee;
    }

    public int getCoffee(){
        return coffee;
    }

    public void setSugar(int sugar){
        this.sugar = sugar;
    }

    public int getSugar(){
        return sugar;
    }

    public void setPrice(int price){
        this.price = price;
    }

    public int getPrice(){
        return price;
    }


}
