package com.galvanize.bakery;

import org.apache.tomcat.util.json.JSONParser;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class PastryController {

    PastryDataService pastryDataService;

    public PastryController (PastryDataService pastryDataService){
        this.pastryDataService = pastryDataService;

    }

    @GetMapping("/pastries")
    public List<Pastry> getAllPastries(){
        return pastryDataService.getData();
    }

    @PostMapping("/pastries")
    public Pastry addNewPastry(@RequestBody Pastry pastry){ //init pastry from json
        return pastryDataService.addToMyData((pastry));
    }

    @GetMapping("/pastries/{name}")
    public Pastry getPastryByName(@PathVariable String name) {
        System.out.println(pastryDataService.getData());
        return pastryDataService.getByName(name);
    }

    @PatchMapping("/pastries/{name}")
    public Pastry editPastryByName(@PathVariable String name, @RequestBody String newName) {
        String substring = newName.substring(9, newName.length()-2);
        Pastry pastry = pastryDataService.editByName(name, substring);
        return pastry;
    }

    @DeleteMapping("/pastries/{name}")
    public List<Pastry> deletePastryByName(@PathVariable String name) {
        return pastryDataService.deleteItemByName(name);
    }

}
