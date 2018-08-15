package main.attraction;

import main.interfaces.ISecurity;
import main.visitor.Visitor;

public class Playground extends Attraction implements ISecurity {

    public Playground(String name, int rating) {
        super(name, rating);
    }


    @Override
    public boolean visit(Visitor visitor) {
        return isAllowedTo(visitor);
    }


    @Override
    public boolean isAllowedTo(Visitor visitor) {
        return (visitor.getAge() <= 15);
    }
}
