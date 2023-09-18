package com.springboot.nacedetail.repository;

import com.springboot.nacedetail.NaceDetailsTestData;
import com.springboot.nacedetail.entity.NaceDetail;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@DataJpaTest
class NaceDetailsRepositoryTest {
    @Autowired
    private NaceDetailsRepository repository;

    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void testSaveNaceDetail() {
        NaceDetail savedNaceDetail = repository.save(NaceDetailsTestData.getNaceData());
        assertNotNull(savedNaceDetail.getId());
        assertEquals("12345", savedNaceDetail.getNaceOrderNumber());
    }

    @Test
    public void testFindAll() {

        entityManager.persistAndFlush(NaceDetailsTestData.naceDetail1());
        entityManager.persistAndFlush(NaceDetailsTestData.naceDetail2());

        List<NaceDetail> naceDetails = repository.findAll();

        assertEquals(2, naceDetails.size());
        assertEquals("12345", naceDetails.get(0).getNaceOrderNumber());
        assertEquals("123456", naceDetails.get(1).getNaceOrderNumber());
    }
}