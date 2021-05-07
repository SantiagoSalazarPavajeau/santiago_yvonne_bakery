package com.galvanize.bakery;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
public class PastryControllerTests {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    PastryDataService pastryDataService;

    List<Pastry> myPastryList;

    @BeforeEach
    void setUp(){
        myPastryList = new ArrayList<>();
        myPastryList.add(new Pastry("Cheese cake", 5.00, false));
        myPastryList.add(new Pastry("Strawberry shortcake", 5.50, false));
        myPastryList.add(new Pastry("Carrot cake", 4.75, false));
    }

    @Test
    void getAllPastries() throws Exception{
        when(pastryDataService.getData()).thenReturn(myPastryList);

        mockMvc.perform(get("/pastries"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(3)));
    }

//    @Test
//    void addNewPastry() throws Exception{
//
//        when(pastryDataService.addToMyData(any(Pastry.class))).thenReturn(new Pastry("Cupcake", 7.99, true));
//
//        mockMvc.perform(post("/pastries")
//                            .contentType(MediaType.APPLICATION_JSON)
//                            .content("{\"name\":\"Cupcake\",\"price\":\"7.99\",\"gluten-free\":\"true\"}"))
//                .andExpect(status().isOk())
////                .andExpect(jsonPath("$", hasSize(1)));
//                .andExpect(jsonPath("name").value("Cupcake"))
//                .andExpect(jsonPath("price").value("7.99"))
//                .andExpect(jsonPath("gluten-free").value("true"));
//    }

    @Test
    void getByNameTest() throws Exception {
        Pastry actual = new Pastry("cupcake", 5.00, false);
        when(pastryDataService.getByName("cupcake")).thenReturn(actual);

        mockMvc.perform(get("/pastries/cupcake"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("name").value("cupcake"));
    }
}
