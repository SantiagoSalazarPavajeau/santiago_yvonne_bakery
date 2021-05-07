package com.galvanize.bakery;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
