package main.visitor;

public class Visitor {
    private int age;
    private double heightInCm;
    private double money;

    public Visitor(int age, double heightInCm, double money) {
        this.age = age;
        this.heightInCm = heightInCm;
        this.money = money;
    }

    public int getAge() {
        return age;
    }

    public double getHeightInCm() {
        return heightInCm;
    }


    public boolean canAfford(double amount){
        return (money >= amount);
    }

    public void charge(double amount){
            money -= amount;
    }

}
