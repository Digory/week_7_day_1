package main.attraction;

import main.visitor.Visitor;

public class Park extends Attraction{

    public Park(String name, int rating) {
        super(name, rating);
    }

    @Override
    public boolean visit(Visitor visitor) {
        return true;
    }

}
