package main.interfaces;

import main.visitor.Visitor;

public interface ITicketed {

    double defaultPrice();

    double priceFor(Visitor visitor);
}
