package com.springboot.nacedetail.controller;

import com.springboot.nacedetail.entity.NaceDetail;
import com.springboot.nacedetail.service.NaceDetailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class NaceDetailController {

    @Autowired
    private NaceDetailService naceDetailService;

    private final Logger LOGGER =
            LoggerFactory.getLogger(NaceDetailController.class);


    @PostMapping("/nace")
    public NaceDetail addNaceDetails(@RequestBody NaceDetail naceDetail) {
        LOGGER.info("Inside addNaceDetails of NaceDetailController");
        return naceDetailService.save(naceDetail);
    }

    @GetMapping("/nace")
    public List<NaceDetail> getNaceList() {
        LOGGER.info("Inside getNaceList of NaceDetailsController");
        return naceDetailService.getNaceList();
    }
}
