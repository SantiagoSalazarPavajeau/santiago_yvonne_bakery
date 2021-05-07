package com.galvanize.bakery;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PastryDataService {
    private List<Pastry> pastryList = new ArrayList<>();

    public Pastry addToMyData(Pastry pastry) {
        pastryList.add(pastry);
        return pastry;
    }

    public List<Pastry> getData() {
        return pastryList;
    }

    public Pastry getByName(String name) {
        for (int i = 0; i < pastryList.size(); i++) {
            if (pastryList.get(i).getName().equals(name)) {
                return pastryList.get(i);
            }
        }

        return null;
    }

    public Pastry editByName(String originalName, String editName) {
        Pastry pastry = getByName(originalName);
        pastry.setName(editName);
        return pastry;
    }

    public List<Pastry> deleteItemByName(String name) {
        for (int i = 0; i < pastryList.size(); i++) {
            if (pastryList.get(i).getName().equals(name)) {
                pastryList.remove(pastryList.get(i));
            }
        }

        return pastryList;
    }
}
