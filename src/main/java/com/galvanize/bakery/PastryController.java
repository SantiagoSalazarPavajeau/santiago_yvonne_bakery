package com.galvanize.bakery;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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

    @PatchMapping("/pastries/{name}")
    public Pastry editPastryByName(@PathVariable String name, @RequestBody String newName) {
        return pastryDataService.editByName(name, newName);
    }

//    @RestController
//    @RequestMapping("/api/{api}/users")
//    public class UserController {
//
//        @PatchMapping("/{id}")
//        String update(@PathVariable String id, @RequestBody UpdateUserRequest request){
//            service.update(id, request);
//        }
//    }

    @DeleteMapping("/pastries/{name}")
    public List<Pastry> deletePastryByName(@PathVariable String name) {
        return pastryDataService.deleteItemByName(name);
    }

}
