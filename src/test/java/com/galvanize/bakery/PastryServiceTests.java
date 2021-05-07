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

    @Test
    public void createAddDataMethodReturnsData() {
        Pastry pastry = new Pastry("Cheese cake", 5.00, false);
        Pastry actual = pastryDataService.addToMyData(pastry);

        assertEquals(pastry, actual, "Creates addData method and passes in pastry and returns the passed argument");
    }

    @Test
    void getDataMethodExists() {
        assertEquals(3, pastryDataService.getData().size(), "getData() method exists");
    }
}
