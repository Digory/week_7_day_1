package main.interfaces;

import main.visitor.Visitor;

public interface ISecurity {

    boolean isAllowedTo(Visitor visitor);
}
