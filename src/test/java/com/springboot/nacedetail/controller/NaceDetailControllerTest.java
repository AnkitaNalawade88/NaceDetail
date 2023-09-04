package com.springboot.nacedetail.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.springboot.nacedetail.entity.NaceDetail;

import com.springboot.nacedetail.repository.NaceDetailsRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@SpringBootTest
public class NaceDetailControllerTest {

    private MockMvc mockMvc;

    @Mock
    private NaceDetailsRepository repository;

    private NaceDetailController controller;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        controller = new NaceDetailController();
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    public void testAddNaceDetails() throws Exception {
        NaceDetail naceDetail = new NaceDetail();
        naceDetail.setCode(398481L);
        naceDetail.setDescription("Test Description");
        naceDetail.setParent("Test Parent");

        when(repository.save(any(NaceDetail.class))).thenReturn(naceDetail);

        mockMvc.perform(post("/nace/add")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(naceDetail)))
                .andExpect(status().isOk())
                .andExpect(content().string("NACE details added successfully"));

        verify(repository, times(1)).save(any(NaceDetail.class));
        verifyNoMoreInteractions(repository);
    }

    @Test
    public void testGetNaceDetails() throws Exception {
        Long code = 398481L;
        NaceDetail naceDetail = new NaceDetail();
        naceDetail.setCode(code);
        naceDetail.setDescription("Test Description");
        naceDetail.setParent("Test Parent");

        when(repository.findByCode(code)).thenReturn(Optional.of(naceDetail));

        mockMvc.perform(get("/nace/get/{code}", code))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value(code))
                .andExpect(jsonPath("$.description").value("Test Description"))
                .andExpect(jsonPath("$.parent").value("Test Parent"));

        verify(repository, times(1)).findByCode(code);
        verifyNoMoreInteractions(repository);
    }

    @Test
    public void testGetNaceDetailsNotFound() throws Exception {
        Long code = 398482L; // Assuming this code doesn't exist in the database

        when(repository.findByCode(code)).thenReturn(Optional.empty());

        mockMvc.perform(get("/nace/get/{code}", code))
                .andExpect(status().isNotFound());

        verify(repository, times(1)).findByCode(code);
        verifyNoMoreInteractions(repository);
    }
}
