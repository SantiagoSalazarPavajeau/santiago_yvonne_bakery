package com.galvanize.bakery;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class PastryTests {
    // name, price, gluten-free, ingredients

    @Test
    public void initializePastryWithFields(){
        Pastry pastry = new Pastry("Cheese cake", 5.00, false);

        assertTrue(pastry instanceof Pastry, "Should be able to initialize a pastry with fields: name, price, gluten-free");
    }
}
