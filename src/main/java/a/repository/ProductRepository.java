package a.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import a.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{

}
