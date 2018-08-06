package main.attraction;

import main.interfaces.ISecurity;
import main.interfaces.ITicketed;
import main.visitor.Visitor;

public class Rollercoaster extends Attraction implements ISecurity, ITicketed {

    private double price;

    public Rollercoaster(String name, int rating) {
        super(name, rating);
        price = 8.40;
    }


    @Override
    public boolean visit(Visitor visitor) {
        if (isAllowedTo(visitor) && visitor.canAfford(priceFor(visitor))){
            visitor.charge(priceFor(visitor));
            return true;
        }
        return false;
    }

    @Override
    public boolean isAllowedTo(Visitor visitor) {
        return (visitor.getHeightInCm() > 145 && visitor.getAge() > 12);
    }

    @Override
    public double defaultPrice() {
        return price;
    }

    @Override
    public double priceFor(Visitor visitor) {
        price = (visitor.getHeightInCm() > 200)? 2*price : price;
        return price;
    }
}
