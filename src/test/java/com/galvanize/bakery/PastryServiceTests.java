package com.galvanize.bakery;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)

public class PastryServiceTests {
    PastryDataService pastryDataService;
    List<Pastry> pastryData;

    @BeforeEach
    void setUp() {
        pastryData = new ArrayList<>();
        pastryDataService = new PastryDataService();

        pastryData.add(pastryDataService.addToMyData(new Pastry("Cheese cake", 5.00, false)));
        pastryData.add(pastryDataService.addToMyData(new Pastry("Strawberry shortcake", 5.50, false)));
        pastryData.add(pastryDataService.addToMyData(new Pastry("Carrot cake", 4.75, false)));

    }

    @Test // post
    public void createAddDataMethodReturnsData() {
        Pastry pastry = new Pastry("Cheese cake", 5.00, false);
        Pastry actual = pastryDataService.addToMyData(pastry);

        assertEquals(pastry, actual, "Creates addData method and passes in pastry and returns the passed argument");
    }

    @Test // get alll
    void getDataMethodExists() {
        assertEquals(3, pastryDataService.getData().size(), "getData() method exists");
    }

    @Test // get one
    void getByNameMethodExistsAndReturnsPastry() {
        Pastry expected = pastryDataService.getData().get(0);
        Pastry actual = pastryDataService.getByName("Cheese cake");

        assertEquals(expected, actual, "Can find a pastry by String name and return pastry");
    }
}
