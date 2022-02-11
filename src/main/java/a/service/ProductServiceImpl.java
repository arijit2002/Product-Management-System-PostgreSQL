package a.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import a.model.Product;
import a.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService{

	
	private ProductRepository productRepository;
	
	
	public ProductServiceImpl(ProductRepository productRepository) {
		super();
		this.productRepository=productRepository;
	}
	
	@Override
	public List<Product> getAllProducts() {
		return productRepository.findAll();
	}
	@Override
	public Product saveProduct(Product product) {
		return productRepository.save(product);
	}
	
	@Override
	public Product getProductById(Long id) {
		return productRepository.findById(id).get();
		
	}
	
	
	@Override
	public Product updateProduct(Product product) {
		return productRepository.save(product);
		
		
	}
	
	@Override
	public void deleteProductById(Long id) {
		productRepository.deleteById(id);
	}
}
