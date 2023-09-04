package com.springboot.nacedetail.repository;

import com.springboot.nacedetail.entity.NaceDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface NaceDetailsRepository extends JpaRepository<NaceDetail, Long> {
    Optional<NaceDetail> findByCode(Long code);
}

