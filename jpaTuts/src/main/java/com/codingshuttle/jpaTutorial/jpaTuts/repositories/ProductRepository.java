package com.codingshuttle.jpaTutorial.jpaTuts.repositories;

import com.codingshuttle.jpaTutorial.jpaTuts.entities.ProductEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity,Long>
{

    List<ProductEntity> findByTitle(String pepsii);

    List<ProductEntity> findByCreatedAtAfter(LocalDateTime of);

    List<ProductEntity> findByQuantityGreaterThan(int i);

    List<ProductEntity> findByPriceLessThan(BigDecimal bigDecimal);

    List<ProductEntity> findByQuantityGreaterThanAndPriceLessThan(int i, BigDecimal bigDecimal);

    List<ProductEntity> findByQuantityGreaterThanOrPriceLessThan(int i, BigDecimal bigDecimal);

    List<ProductEntity> findByPriceBetween(BigDecimal bigDecimal, BigDecimal bigDecimal1);

    List<ProductEntity> findByTitleLike(String s);

    List<ProductEntity> findByTitleContaining(String choco);

//    List<ProductEntity> findByTitleContainingIgnoreCase(String chOco);

    List<ProductEntity> findByTitleStartingWith(String par);

    List<ProductEntity> findByTitleEndingWith(String uits);

    List<ProductEntity> findByTitleIn(List<String> parleBuiscuits);

    List<ProductEntity> findByTitleOrderByPriceDesc(String pepsii);

    ProductEntity findTopByOrderByPriceDesc();

    List<ProductEntity> findDistinctByTitle(String pepsii);

    long countByTitle(String pepsii);

    boolean existsBySku(String pepsi1234);

//     OrderBy
    List<ProductEntity> findByOrderByPrice();

//    Pageable
Page<ProductEntity> findByTitleContainingIgnoreCase(String title , Pageable pageable);

}

