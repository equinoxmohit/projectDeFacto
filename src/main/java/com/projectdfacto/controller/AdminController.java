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

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 * Created by equinoxmohit on 2/19/17.
 */
@Controller
public class AdminController {

    private Path path;

    @Autowired
    ProductDao productDao;

    @RequestMapping("/admin")
    public String admin(Model model) {
        List<Product> productList = productDao.getAll();
        model.addAttribute("products", productList);
        return "admin/admin";
    }

    @RequestMapping("/admin/addproduct")
    public String addProduct(Model model) {
        Product product = new Product();
        model.addAttribute(product);
        return "admin/addproduct";
    }


    @RequestMapping(value = "/admin/addproduct", method = RequestMethod.POST)
    public String addProduct(@Valid @ModelAttribute("product") Product product, BindingResult result, HttpServletRequest request) {

        if(result.hasErrors()){
            return "admin/addproduct";
        }

        productDao.insert(product);

        MultipartFile productImage = product.getProductImage();

        String rootDirectory = request.getSession().getServletContext().getRealPath("/");
        path = Paths.get(rootDirectory + "/WEB-INF/resources/images/" + product.getProductId() + ".png");

        if (productImage != null && !productImage.isEmpty()) {
            try {
                productImage.transferTo(new File(path.toString()));
            } catch (IOException ex) {
                ex.printStackTrace();
            }

        }
        return "redirect:/admin?success";
    }


    @RequestMapping("/admin/deleteproduct/{productId}" )
    public String deleteProduct(@PathVariable("productId") int productId, HttpServletRequest request){

        String rootDirectory = request.getSession().getServletContext().getRealPath("/");
        path = Paths.get(rootDirectory + "/WEB-INF/resources/images/" + productId + ".png");

        if(Files.exists(path)){
            try {
                Files.delete(path);
            }catch(IOException ex){
                ex.printStackTrace();
            }
        }

        productDao.delete(productId);
        return "redirect:/admin?deletesuccess";
    }




    @RequestMapping("/admin/updateproduct/{productId}")
    public String updateProduct(@PathVariable("productId") int productId,Model model)  {
        Product product=productDao.getById(productId);
        model.addAttribute(product);
        return "admin/updateproduct";
    }

    @RequestMapping(value="/admin/updateproduct/",method = RequestMethod.POST)
    public String updateProduct(@Valid @ModelAttribute("product") Product product,BindingResult result,HttpServletRequest request)
    {
        if(result.hasErrors()){
            return "admin/updateproduct";
        }

        MultipartFile productImage=product.getProductImage();
        String rootDirectory=request.getSession().getServletContext().getRealPath("/");
        path=Paths.get(rootDirectory+"/WEB-INF/resources/images/"+product.getProductId()+".png");
        if(productImage!=null && !productImage.isEmpty()){
            try{
                productImage.transferTo(new File(path.toString()));
            }catch (IOException ex){
                ex.printStackTrace();
            }
        }

        productDao.update(product);
        return "redirect:/admin?success";
    }
}
