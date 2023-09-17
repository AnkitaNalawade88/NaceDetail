package com.springboot.nacedetail.controller;

import com.springboot.nacedetail.NaceDetailsTestData;
import com.springboot.nacedetail.entity.NaceDetail;
import com.springboot.nacedetail.service.NaceDetailService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@WebMvcTest(NaceDetailController.class)
public class NaceDetailControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private NaceDetailService service;

    private NaceDetail nace;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        nace = NaceDetail.builder()
                .id(1L)
                .nOrder("testOrder")
                .level(1)
                .code("testCode")
                .parent("testParent")
                .description("testDescription")
                .build();
    }

    @Test
    public void testAddNaceDetails() throws Exception {
        when(service.save(NaceDetailsTestData.getNace())).thenReturn(nace);
        mockMvc.perform(post("/nace")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\n" +
                                "\t\"id\" : \"1\",\n" +
                                "\t\"order\" : \"testOrder\",\n" +
                                "\t\"level\" : \"1\",\n" +
                                "\t\"code\" : \"testCode\",\n" +
                                "\t\"parent\" : \"testParent\",\n" +
                                "\t\"description\" : \"testDescription\"\n" +
                                "}"))
                .andExpect(status().isOk());
    }

    @Test
    public void testGetNaceList() throws Exception {
        when(service.getNaceList()).thenReturn(NaceDetailsTestData.naceDetailList());
        // Perform the GET request
        mockMvc.perform(get("/nace"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].code").value("A"))
                .andExpect(jsonPath("$[0].description").value("Description A"))
                .andExpect(jsonPath("$[1].code").value("B"))
                .andExpect(jsonPath("$[1].description").value("Description B"));
    }
}
