package com.chrisferdev.pragmabackend.ports.driven.jpa.repository;

import com.chrisferdev.pragmabackend.ports.driven.jpa.entity.ProductEntity;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IProductJpaRepository extends JpaRepository<ProductEntity, Long> {
    @Query("SELECT p FROM ProductEntity p JOIN p.brands b WHERE b.name = :brandName")
    Page<ProductEntity> findProductByBrand(@Param("brandName") String brandName, Pageable pageable);

}
