package main.attraction;

import main.interfaces.IReviewed;
import main.visitor.Visitor;

import java.util.ArrayList;

public abstract class Attraction implements IReviewed {

    protected String name;
    protected int rating;

    public Attraction(String name, int rating) {
        this.name = name;
        this.rating = rating;
    }

    public abstract boolean visit(Visitor visitor);

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getRating(){
        return rating;
    }
}
