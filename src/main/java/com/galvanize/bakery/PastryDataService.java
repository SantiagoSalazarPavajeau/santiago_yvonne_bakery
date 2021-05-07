package com.galvanize.bakery;

import java.util.ArrayList;
import java.util.List;

public class PastryDataService {
    private List<Pastry> pastryList = new ArrayList<>();

    public Pastry addToMyData(Pastry pastry) {
        pastryList.add(pastry);
        return pastry;
    }

    public List<Pastry> getData() {
        return pastryList;
    }
}
