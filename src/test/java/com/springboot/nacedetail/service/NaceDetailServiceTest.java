package com.springboot.nacedetail.service;

import com.springboot.nacedetail.NaceDetailsTestData;
import com.springboot.nacedetail.entity.NaceDetail;
import com.springboot.nacedetail.repository.NaceDetailsRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
class NaceDetailServiceTest {

    @MockBean
    private NaceDetailsRepository naceRepository;

    @Autowired
    private NaceDetailsRepository dao;

    @Autowired
    private NaceDetailService naceDetailService;



    private NaceDetail naceDetail;
    List<NaceDetail> naceDetailList = NaceDetailsTestData.naceDetailList();


    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        naceDetail = NaceDetail.builder()
                .id(1L)
                .naceOrderNumber("12345")
                .level(1)
                .code("A")
                .parent("testParent")
                .description("testDescription")
                .build();

        when(naceRepository.save(naceDetail)).thenReturn(naceDetail);
        when(naceRepository.findAll()).thenReturn(naceDetailList);

    }

    @Test
    void testSave() {
        NaceDetail savedNaceDetail = naceDetailService.save(naceDetail);
        assertEquals(naceDetail, savedNaceDetail);
        verify(dao, times(1)).save(naceDetail);
    }

    @Test
    void testGetNaceList(){
        List<NaceDetail> retrievedNaceDetailList = naceDetailService.getNaceList();
        assertEquals(naceDetailList, retrievedNaceDetailList);
        verify(dao, times(1)).findAll();
    }
}