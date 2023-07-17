package productcrudapp.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.RedirectView;

import productcrudapp.dao.ProductDao;
import productcrudapp.model.Product;

@Controller
public class MainController {

	@Autowired
	private ProductDao productDao;

	@RequestMapping("/")
	public String home(Model m) {
		List<Product> products = productDao.getProducts();
		m.addAttribute("products",products);
		return "index";
	}

	@RequestMapping("/add-product")
	public String add_product(Model m) {
		m.addAttribute("title", "Add Product");
		return "add_product_form";
	}

	@RequestMapping(value = "/handle-product", method = RequestMethod.POST)
	public RedirectView handleProduct(@ModelAttribute Product product, HttpServletRequest request) {
		System.out.println(product);
		this.productDao.createProduct(product);
		RedirectView rv = new RedirectView();
		rv.setUrl(request.getContextPath() + "/");
		return rv;
	}
	
	//delete handler
	@RequestMapping("/delete/{productId}")
	public RedirectView delete_product(@PathVariable("productId") int productId, HttpServletRequest request)
	{
		RedirectView rv = new RedirectView();
		this.productDao.deleteProduct(productId);
		rv.setUrl(request.getContextPath()+"/");
		return rv;
	}
	//update-handler
	@RequestMapping("/update/{productId}")
	public String updateForm(@PathVariable("productId") int pid, Model m)
	{
		Product product = this.productDao.getProduct(pid);
		m.addAttribute("product",product);
		return "update_form";
	}
}
