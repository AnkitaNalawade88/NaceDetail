package com.springboot.nacedetail.controller;

import com.springboot.nacedetail.entity.NaceDetail;
import com.springboot.nacedetail.service.NaceDetailService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(value = "NACE", description = "Nomenclature of Economic Activities")
public class NaceDetailController {

    @Autowired
    private NaceDetailService naceDetailService;

    private final Logger LOGGER =
            LoggerFactory.getLogger(NaceDetailController.class);


    @PostMapping("/nace")
    @ApiOperation(value = "store nace details api")
    public NaceDetail addNaceDetails(@RequestBody NaceDetail naceDetail) {
        LOGGER.info("Inside addNaceDetails of NaceDetailController");
        return naceDetailService.save(naceDetail);
    }

    @GetMapping("/nace")
    @ApiOperation(value = "Fetch Nace List")
    public List<NaceDetail> getNaceList() {
        LOGGER.info("Inside getNaceList of NaceDetailsController");
        return naceDetailService.getNaceList();
    }
}
