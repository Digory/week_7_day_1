package main.stall;

import main.visitor.Visitor;

public class CandyFlossStall extends Stall{

    private double price;

    public CandyFlossStall(String name, String ownerName, int parkingSpot, int rating) {
        super(name, ownerName, parkingSpot, rating);
        price = 4.20;
    }

    @Override
    public double defaultPrice() {
        return price;
    }

    @Override
    public double priceFor(Visitor visitor) {
        return price;
    }
}
