package com.codingshuttle.jpaTutorial.jpaTuts;

import com.codingshuttle.jpaTutorial.jpaTuts.entities.ProductEntity;
import com.codingshuttle.jpaTutorial.jpaTuts.repositories.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@SpringBootTest
@ActiveProfiles("test")
public class JpaTutorialApplicationTests
{
    @Autowired
    ProductRepository productRepository;

    @Test
    void contextLoads()
    {
    }

    @Test
    void testRepository()
    {
        ProductEntity productEntity = ProductEntity.builder()
                .sku("nestle234")
                .title("Nestle Chocolate")
                .price(BigDecimal.valueOf(23.45))
                .quantity(5)
                .build();

        ProductEntity savedProductEntity = productRepository.save(productEntity);
        System.out.println(savedProductEntity);
    }

    @Test
    void getRepository()
    {
        // FIND BY
        List<ProductEntity> products =
                productRepository.findByTitle("pepsii");
        System.out.println("findByTitle : " + products);

        // AFTER / BEFORE
        List<ProductEntity> after = productRepository.findByCreatedAtAfter(
                        LocalDateTime.of(2025, 1, 1, 0, 0)
                );
        System.out.println("findByCreatedAtAfter : " + after);

        // GREATER THAN / LESS THAN
        List<ProductEntity> quantityGreater = productRepository.findByQuantityGreaterThan(5);
        System.out.println("findByQuantityGreaterThan : " + quantityGreater);

        List<ProductEntity> priceLess =productRepository.findByPriceLessThan(BigDecimal.valueOf(150));
        System.out.println("findByPriceLessThan : "+ priceLess);

        // AND / OR
        List<ProductEntity> andQuery =productRepository.findByQuantityGreaterThanAndPriceLessThan(5, BigDecimal.valueOf(300));
        System.out.println("AND Query : " + andQuery);

        List<ProductEntity> orQuery = productRepository.findByQuantityGreaterThanOrPriceLessThan( 4,BigDecimal.valueOf(23.45));
        System.out.println("OR Query : " + orQuery);

        // BETWEEN
        List<ProductEntity> betweenPrice =productRepository.findByPriceBetween(
                        BigDecimal.valueOf(100),
                        BigDecimal.valueOf(300)
                );

        System.out.println("findByPriceBetween : " + betweenPrice);

        // LIKE
        List<ProductEntity> like = productRepository.findByTitleLike("%Choco%");
        System.out.println("findByTitleLike : " + like);


        // CONTAINING
        List<ProductEntity> containing = productRepository.findByTitleContaining("Choco");

        System.out.println("findByTitleContaining : " + containing);


        // IGNORE CASE
        List<ProductEntity> ignoreCase = productRepository.findByTitleContainingIgnoreCase("ChOco");
        System.out.println("findByTitleContainingIgnoreCase : "+ ignoreCase);

        // STARTING WITH / ENDING WITH
        List<ProductEntity> startsWith = productRepository.findByTitleStartingWith("Par");
        System.out.println("findByTitleStartingWith : " + startsWith);

        List<ProductEntity> endsWith = productRepository.findByTitleEndingWith("uits");

        System.out.println("findByTitleEndingWith : " + endsWith);

        // IN
        List<ProductEntity> inQuery = productRepository.findByTitleIn(List.of("ParleBuiscuits","pepsii"));
        System.out.println("findByTitleIn : " + inQuery);

        // ORDER BY
        List<ProductEntity> sorted = productRepository.findByTitleOrderByPriceDesc("pepsii");
        System.out.println("findByTitleOrderByPriceDesc : "+ sorted);

       // TOP / FIRST
        ProductEntity expensive =productRepository.findTopByOrderByPriceDesc();
        System.out.println("findTopByOrderByPriceDesc : "+ expensive);

        // DISTINCT
        List<ProductEntity> distinct =productRepository.findDistinctByTitle("pepsii");
        System.out.println("findDistinctByTitle : "+ distinct);

        // COUNT
        long count = productRepository.countByTitle("pepsii");
        System.out.println("countByTitle : "+ count);

        // EXISTS
        boolean exists =productRepository.existsBySku("pepsi1234");
        System.out.println("existsBySku : "+ exists);
    }

}
