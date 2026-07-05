package com.product_service.repository;
import com.product_service.entity.Product;
import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
    @Query("""
        SELECT DISTINCT p
        FROM Product p
        LEFT JOIN p.brand b
        WHERE LOWER(p.productName) LIKE LOWER(CONCAT('%', :keyword, '%'))
           OR LOWER(b.name) LIKE LOWER(CONCAT('%', :keyword, '%'))
           OR LOWER(p.category.name) LIKE LOWER(CONCAT('%', :keyword, '%'))
           OR LOWER(p.subCategory.name) LIKE LOWER(CONCAT('%', :keyword, '%'))
        """)
    List<Product> searchProducts(@Param("keyword") String keyword);
}



