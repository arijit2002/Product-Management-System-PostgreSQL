package a.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import a.model.Product;
import a.service.ProductService;

@Controller
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@GetMapping("/")
	public String homepage(Model m) {
		m.addAttribute("listProducts", productService.getAllProducts());
		return "index";
	}
	@GetMapping("/showNewProductForm")
	public String showNewProductform( Model m) {
		Product product=new Product();
		m.addAttribute("product",product);
		return "new_product";
	}
	@PostMapping("/saveProduct")
	public String saveProduct(@ModelAttribute("product") Product product) {
		productService.saveProduct(product);
		return "redirect:/";
	}
	
	@GetMapping("/edit/{id}")
	public String editProductForm(@PathVariable Long id,Model m) {
		m.addAttribute("product",productService.getProductById(id));
		return "edit_product";
		
	}
	
	
	
	public String updateProduct(@PathVariable Long id, @ModelAttribute("product") Product product, Model m) {
		
		Product existingProduct=productService.getProductById(id);
		existingProduct.setId(id);
		existingProduct.setName(product.getName());
		existingProduct.setManufacturer(product.getManufacturer());
		existingProduct.setPrice(product.getPrice());
		productService.updateProduct(existingProduct);
		
		return "redirect:/";
	}
	
	@GetMapping("/{}id")
	public String deleteProduct(@PathVariable Long id) {
		productService.deleteProductById(id);
		return "redirect:/";
	}
}
