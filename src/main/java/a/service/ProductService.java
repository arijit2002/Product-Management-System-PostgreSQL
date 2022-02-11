package a.service;

import java.util.List;

import a.model.Product;

public interface ProductService {
	List<Product> getAllProducts();
	Product saveProduct(Product product);
	Product getProductById(Long id);
	Product updateProduct(Product product);
	void deleteProductById(Long id);
	
}
