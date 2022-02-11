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
	@GetMapping("/showFormUpdate/{id}")
	public String showFormUpdate(@PathVariable(value = "id") long id,Model model) {
		Product product = productService.getProductById(id);
		model.addAttribute("product", product);
		return "update_product";
	}
	@GetMapping("/deleteProduct/{id}")
	public String deleteProduct(@PathVariable(value="id") long id) {
		this.productService.deleteById(id);
		return "redirect:/";
	}
}
