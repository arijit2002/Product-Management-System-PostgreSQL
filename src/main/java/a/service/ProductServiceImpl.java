package a.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import a.model.Product;
import a.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	private ProductRepository productRepository;
	
	@Override
	public List<Product> getAllProducts() {
		return productRepository.findAll();
	}
	
	@Override
	public void saveProduct(Product product) {
		this.productRepository.save(product);
	}
	
	@Override
	public Product getProductById(long id) {
		Optional<Product> optional = productRepository.findById(id);
		Product product = null;
		if(optional.isPresent()) {
			product = optional.get();
		}else {
			throw new RuntimeException("Product is not present with this id");
		}
		return product;
	}
	@Override
	public void deleteById(long id) {
	this.productRepository.deleteById(id);
	}
	
}
