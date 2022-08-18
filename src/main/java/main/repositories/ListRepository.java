package main.repositories;

import main.model.List;
import main.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ListRepository extends JpaRepository<List,Long> {

    @Query(value = "SELECT product_id FROM product2list  WHERE list_id= :listId", nativeQuery = true)
    java.util.List<Long> getIdProdList(@Param("listId") long listId);
}
