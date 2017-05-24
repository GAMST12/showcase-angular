package ua.com.pb.showcase.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import ua.com.pb.showcase.dao.entity.Category;
import ua.com.pb.showcase.service.WSCategoryService;
import javax.ws.rs.core.MediaType;


import java.util.List;

@RestController
public class CategoryXMLRestController {
    @Autowired
    private WSCategoryService wsCategoryService;


    @RequestMapping(value = "/xmlcategory/", method = RequestMethod.GET, produces = MediaType.APPLICATION_XML)
    public ResponseEntity<List<Category>> getAllCategories() {
        List<Category> categories = wsCategoryService.getAllCategories();
        if (categories.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }

    @RequestMapping(value = "/xmlcategory/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_XML)
    public ResponseEntity<Category> getCategory(@PathVariable("id") long id) {
        Category category = wsCategoryService.getCategory(id);
        if (category == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(category, HttpStatus.OK);
    }

    @RequestMapping(value = "/xmlcategory/", method = RequestMethod.POST, consumes = MediaType.APPLICATION_XML)
    public ResponseEntity<Void> addCategory(@RequestBody Category category, UriComponentsBuilder ucBuilder) {
        if (false) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        wsCategoryService.addCategory(category);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/producer/{id}").buildAndExpand(category.getId()).toUri());
        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/xmlcategory/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_XML)
    public ResponseEntity<Category> updateCategory(@PathVariable("id") long id, @RequestBody Category category) {
        Category currentCategory = wsCategoryService.getCategory(id);
        if (currentCategory==null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        currentCategory.setName(category.getName());
        currentCategory.setMainCategory(category.getMainCategory());

        wsCategoryService.updateCategory(currentCategory);
        return new ResponseEntity<>(currentCategory, HttpStatus.OK);
    }


    @RequestMapping(value = "/xmlcategory/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteCategory(@PathVariable("id") long id) {
        Category category = wsCategoryService.getCategory(id);
        if (category == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        wsCategoryService.deleteCategoryById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
