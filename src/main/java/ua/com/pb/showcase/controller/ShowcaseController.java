package ua.com.pb.showcase.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ua.com.pb.showcase.dao.CategoryDao;
import ua.com.pb.showcase.dao.MainCategoryDao;
import ua.com.pb.showcase.dao.ProducerDao;
import ua.com.pb.showcase.dao.ProductDao;
import ua.com.pb.showcase.dao.entity.Category;
import ua.com.pb.showcase.dao.entity.Producer;
import ua.com.pb.showcase.dao.entity.Product;

import javax.servlet.http.HttpServletRequest;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
public class ShowcaseController {
    @Autowired
    private ProductDao productDao;
    @Autowired
    private ProducerDao producerDao;
    @Autowired
    private CategoryDao categoryDao;
    @Autowired
    private MainCategoryDao mainCategoryDao;


    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index(Model model, HttpServletRequest request) {
/*
        List<Product> products = productDao.findAll();
        Set<Category> categories = new HashSet<>();
        Set<Producer> producers = new HashSet<>();
        for (Product product : products) {
            categories.add(product.getCategory());
            producers.add(product.getProducer());
        }
*/
        //model.addAttribute("product", productDao.findAll());
        model.addAttribute("category", categoryDao.findAll());
        model.addAttribute("producer", producerDao.findAll());


/*
        model.addAttribute("producer", producerDao.findAll());
        model.addAttribute("category", categoryDao.findAll());
        model.addAttribute("main-category", mainCategoryDao.findAll());
*/

        System.out.println(model);
        return "/index";
    }

}
