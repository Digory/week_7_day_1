package main.themepark;

import main.attraction.*;
import main.interfaces.IReviewed;
import main.interfaces.ISecurity;
import main.interfaces.ITicketed;
import main.stall.CandyFlossStall;
import main.stall.IceCreamStall;
import main.stall.Stall;
import main.stall.TobaccoStall;
import main.visitor.Visitor;

import java.util.ArrayList;

public class ThemePark {

    private ArrayList<Attraction> attractions;
    private ArrayList<Stall> stalls;
    private Dodgems dodgems;
    private Park park;
    private Playground playground;
    private Rollercoaster rollercoaster;
    private CandyFlossStall candyFlossStall;
    private IceCreamStall iceCreamStall;
    private TobaccoStall tobaccoStall;

    public ThemePark() {
        attractions = new ArrayList<>();
        stalls = new ArrayList<>();
        setUpAttractions();
        setUpStalls();
    }

    private void setUpAttractions(){
        park = new Park("Digory's nice park", 5);
        dodgems = new Dodgems("Digory's bumpy ride", 9);
        playground = new Playground("Digory's cool playground", 6);
        rollercoaster = new Rollercoaster("Digory's below average rollercoaster", 3);
        attractions.add(park);
        attractions.add(dodgems);
        attractions.add(playground);
        attractions.add(rollercoaster);
    }

    private void setUpStalls(){
        candyFlossStall = new CandyFlossStall("Sweet pink", "Digory", 1, 5);
        iceCreamStall = new IceCreamStall("white stuff", "Digory", 2, 6);
        tobaccoStall = new TobaccoStall("Tobacco cones", "Digory", 3, 3);
        stalls.add(candyFlossStall);
        stalls.add(iceCreamStall);
        stalls.add(tobaccoStall);
    }


    public boolean visit(Visitor visitor, Attraction attraction){
        return attraction.visit(visitor);
    }

    public ArrayList<IReviewed> getAllReviewed(){
        ArrayList<IReviewed> reviewed = new ArrayList<>();
        reviewed.addAll(attractions);
        reviewed.addAll(stalls);
        return reviewed;
    }

    public String stringOfReviews(){
        String result = "";
        for(int i = 0 ; i < getAllReviewed().size() ; i ++){
            result += getAllReviewed().get(i).getName() + ": " + getAllReviewed().get(i).getRating();
            if (i < getAllReviewed().size() - 1){
                result += ", ";
            }
        }
        return result;
    }

    public ArrayList<ITicketed> getAllAllowedFor(Visitor visitor){
        ArrayList<ITicketed> allowedThings = new ArrayList<>();
        if(visitor.canAfford(dodgems.priceFor(visitor))){
            allowedThings.add(dodgems);
        }
        if(visitor.canAfford(rollercoaster.priceFor(visitor)) && rollercoaster.isAllowedTo(visitor)){
            allowedThings.add(rollercoaster);
        }
        for(Stall stall : stalls){
            if(visitor.canAfford(stall.priceFor(visitor))){
                allowedThings.add(stall);
            }
        }
        return allowedThings;
    }
}
