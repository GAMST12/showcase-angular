package ua.com.pb.showcase.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import ua.com.pb.showcase.dao.entity.Category;
import ua.com.pb.showcase.service.WSCategoryService;

import java.util.List;

@RestController
public class CategoryRestController {
    @Autowired
    private WSCategoryService wsCategoryService;


    @RequestMapping(value = "/category", method = RequestMethod.GET)
    public ResponseEntity<List<Category>> getAllCategories() {
        List<Category> categories = wsCategoryService.getAllCategories();
        if (categories.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }

    @RequestMapping(value = "/category/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Category> getCategory(@PathVariable("id") long id) {
        Category category = wsCategoryService.getCategory(id);
        if (category == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(category, HttpStatus.OK);
    }

    @RequestMapping(value = "/category", method = RequestMethod.POST)
    public ResponseEntity<Void> addCategory(@RequestBody Category category, UriComponentsBuilder ucBuilder) {
        if (false) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        wsCategoryService.addCategory(category);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/category/{id}").buildAndExpand(category.getId()).toUri());
        System.out.println("created " + category);
        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/category/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Category> updateCategory(@PathVariable("id") long id, @RequestBody Category category) {
        Category currentCategory = wsCategoryService.getCategory(id);
        if (currentCategory==null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        currentCategory.setName(category.getName());

        wsCategoryService.updateCategory(currentCategory);
        System.out.println("updated " + currentCategory);
        return new ResponseEntity<>(currentCategory, HttpStatus.OK);
    }


    @RequestMapping(value = "/category/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteCategory(@PathVariable("id") long id) {
        Category category = wsCategoryService.getCategory(id);
        if (category == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        wsCategoryService.deleteCategoryById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
