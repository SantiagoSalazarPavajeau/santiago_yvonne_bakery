package com.galvanize.bakery;

import java.util.ArrayList;
import java.util.List;

public class Pastry {
    private String name;
    private double price;
    private boolean glutenFree;
    private List<String> ingredients = new ArrayList<>();

    Pastry(String name, double price, boolean glutenFree){
        this.name = name;
        this.price = price;
        this.glutenFree = glutenFree;
    }

    public List<String> getIngredients(){
        return ingredients;
    }

    public void addIngredient(String ingredient) {
        ingredients.add(ingredient);
    }


}
