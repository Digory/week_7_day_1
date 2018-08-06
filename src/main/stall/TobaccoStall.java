package main.stall;

import main.interfaces.ISecurity;
import main.visitor.Visitor;

public class TobaccoStall extends Stall implements ISecurity {

    private double price;

    public TobaccoStall(String name, String ownerName, int parkingSpot, int rating) {
        super(name, ownerName, parkingSpot, rating);
        price = 6.60;
    }

    @Override
    public boolean isAllowedTo(Visitor visitor) {
        return (visitor.getAge() >= 18);
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
