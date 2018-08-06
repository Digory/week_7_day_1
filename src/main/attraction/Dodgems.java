package main.attraction;

import main.interfaces.ITicketed;
import main.visitor.Visitor;

public class Dodgems extends Attraction implements ITicketed {

    private double price;

    public Dodgems(String name, int rating) {
        super(name, rating);
        price = 4.50;
    }

    @Override
    public boolean visit(Visitor visitor) {
        if(visitor.canAfford(priceFor(visitor))){
            visitor.charge(priceFor(visitor));
            return true;
        }
        return false;
    }


    @Override
    public double defaultPrice() {
        return price;
    }

    @Override
    public double priceFor(Visitor visitor) {
        price = (visitor.getAge() < 12)? price/2 : price;
        return price;
    }

}
