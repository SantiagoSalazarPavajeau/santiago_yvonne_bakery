package com.galvanize.bakery;

import org.springframework.web.bind.annotation.*;

import java.util.List;

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
        return pastryDataService.getByName(name);
    }

}
