package test;

import main.attraction.Playground;
import main.themepark.ThemePark;
import main.visitor.Visitor;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class ThemeParkTest {

    private ThemePark themePark;
    private Playground playground;
    private Visitor child;
    private Visitor adult;

    @Before
    public void before(){
        themePark = new ThemePark();
        playground = new Playground("Funland", 2);
        child = new Visitor(10,110,10.0);
        adult = new Visitor(30, 210, 30.0);
    }

    @Test
    public void visit_playground_child(){
        boolean actual = themePark.visit(child, playground);
        assertEquals(true, actual);
    }

    @Test
    public void visit_playground_adult(){
        boolean actual = themePark.visit(adult, playground);
        assertEquals(false, actual);
    }

    @Test
    public void stringOfReviews(){
        String actual = themePark.stringOfReviews();
        assertEquals("Digory's nice park: 5, Digory's bumpy ride: 9, Digory's cool playground: 6, Digory's below average rollercoaster: 3, Sweet pink: 5, white stuff: 6, Tobacco cones: 3", actual);
    }

}
