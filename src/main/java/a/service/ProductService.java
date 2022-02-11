package a.service;

import java.util.List;

import a.model.Product;

public interface ProductService {
	List<Product> getAllProducts();
	void saveProduct(Product product);
	Product getProductById(long id);
	void deleteById(long id);
}
