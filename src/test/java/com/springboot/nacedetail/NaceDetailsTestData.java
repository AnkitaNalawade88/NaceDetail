package com.springboot.nacedetail;

import com.springboot.nacedetail.entity.NaceDetail;
import java.util.Arrays;
import java.util.List;

public class NaceDetailsTestData {

    public static List<NaceDetail> naceDetailList() {
        NaceDetail naceDetail1 = new NaceDetail();
        naceDetail1.setId(1L);
        naceDetail1.setCode("A");
        naceDetail1.setDescription("Description A");

        NaceDetail naceDetail2 = new NaceDetail();
        naceDetail2.setId(2L);
        naceDetail2.setCode("B");
        naceDetail2.setDescription("Description B");

       return Arrays.asList(naceDetail1, naceDetail2);
    }

    public static NaceDetail getNace() {
        NaceDetail naceDetail = new NaceDetail();
        naceDetail.setCode("398481");
        naceDetail.setDescription("Test Description");
        naceDetail.setParent("Test Parent");
        return naceDetail;
    }

    public static NaceDetail getNaceData() {
        NaceDetail naceDetail = new NaceDetail();
        naceDetail.setNOrder("Test Order");
        naceDetail.setLevel(1);
        naceDetail.setCode("Test Code");
        naceDetail.setParent("Test Parent");
        naceDetail.setDescription("Test Description");
        return naceDetail;
    }

    public static Object naceDetail1() {
        NaceDetail naceDetail1 = new NaceDetail();
        naceDetail1.setNOrder("Test Order 1");
        naceDetail1.setLevel(1);
        naceDetail1.setCode("Test Code 1");
        naceDetail1.setParent("Test Parent 1");
        naceDetail1.setDescription("Test Description 1");

        return naceDetail1;
    }

    public static Object naceDetail2() {
        NaceDetail naceDetail2 = new NaceDetail();
        naceDetail2.setNOrder("Test Order 2");
        naceDetail2.setLevel(2);
        naceDetail2.setCode("Test Code 2");
        naceDetail2.setParent("Test Parent 2");
        naceDetail2.setDescription("Test Description 2");
        return naceDetail2;
    }
}
