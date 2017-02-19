
package com.projectdfacto.controller;

import com.projectdfacto.dao.ProductDao;
import com.projectdfacto.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import javax.naming.Binding;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 * Created by equinoxmohit on 2/18/17.
 */
@Controller
public class HomeController {



    @Autowired
    ProductDao productDao;

    @RequestMapping("/")
    public String indexPage() {
        return "index";
    }

    @RequestMapping("/products")
    public String productsListing(Model model) {
        List<Product> productList = productDao.getAll();
        model.addAttribute("products", productList);
        return "products";
    }


    @RequestMapping("/product/{id}")
    public String viewProduct(@PathVariable("id") int id, Model model) {
        Product product = productDao.getById(id);
        model.addAttribute("product", product);
        return "product";
    }



}

