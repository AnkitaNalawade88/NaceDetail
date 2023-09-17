package com.springboot.nacedetail.service;

import com.springboot.nacedetail.entity.NaceDetail;
import com.springboot.nacedetail.repository.NaceDetailsRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@Slf4j
public class NaceDetailServiceImpl implements NaceDetailService{

    @Autowired
    NaceDetailsRepository repository;

    @Override
    public NaceDetail save(NaceDetail naceDetail) {
       return repository.save(naceDetail);
    }

    @Override
    public List<NaceDetail> getNaceList() {
        return repository.findAll();
    }

}
