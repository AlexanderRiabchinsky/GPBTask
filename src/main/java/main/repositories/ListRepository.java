package main.repositories;

import main.model.List;
import main.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ListRepository extends JpaRepository<List,Long> {
    @Query(value = "SELECT * FROM product " +
            "JOIN product2list ON product.id = product2list.product_id " +
            "JOIN list ON product2list.list_id = list.id " +
            "WHERE list.id = :listId", nativeQuery = true)
   java.util.List<Product> getProductsOfList(@Param("listId") long listId);
}
