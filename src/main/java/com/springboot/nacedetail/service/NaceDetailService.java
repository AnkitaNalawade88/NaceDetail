package com.springboot.nacedetail.service;

import com.springboot.nacedetail.entity.NaceDetail;
import java.util.List;

public interface NaceDetailService {

    public NaceDetail save(NaceDetail naceDetail);

    public List<NaceDetail> getNaceList();

}
