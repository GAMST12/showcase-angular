package ua.com.pb.showcase.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import ua.com.pb.showcase.dao.CategoryDao;
import ua.com.pb.showcase.dao.MainCategoryDao;
import ua.com.pb.showcase.dao.ProducerDao;
import ua.com.pb.showcase.dao.entity.Product;
import ua.com.pb.showcase.model.filter.ProductFilter;
import ua.com.pb.showcase.service.ShowcaseService;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
public class ShowcaseController {
    @Autowired
    private MainCategoryDao mainCategoryDao;
    @Autowired
    private CategoryDao categoryDao;


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(Model model, HttpServletRequest request) {
        model.addAttribute("category", categoryDao.findAll());
        model.addAttribute("maincategory", mainCategoryDao.findAll());
        return "/index";
    }

}
