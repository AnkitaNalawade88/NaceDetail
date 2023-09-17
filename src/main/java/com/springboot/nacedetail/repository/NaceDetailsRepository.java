package com.springboot.nacedetail.repository;

import com.springboot.nacedetail.entity.NaceDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;

@Repository
@Transactional
public interface NaceDetailsRepository extends JpaRepository<NaceDetail, Long> {
}

