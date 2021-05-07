package com.galvanize.bakery;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class PastryTests {
    // name, price, gluten-free, ingredients
    Pastry pastry;

    @BeforeEach
    void setUp(){
        pastry = new Pastry("Cheese cake", 5.00, false);
    }

    @Test
    public void initializePastryWithFields(){
        assertNotNull(pastry, "Should be able to initialize a pastry with fields: name, price, gluten-free");
    }

    @Test
    public void getIngredientsExistsOnPastry() {
        assertTrue(pastry.getIngredients() instanceof List, "getIngredients method returns Array list of ingredients");
    }
}
