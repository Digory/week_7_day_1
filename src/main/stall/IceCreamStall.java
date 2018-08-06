package main.stall;

import main.visitor.Visitor;

public class IceCreamStall extends Stall{
    private double price;

    public IceCreamStall(String name, String ownerName, int parkingSpot, int rating) {
        super(name, ownerName, parkingSpot, rating);
        price = 2.80;
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
