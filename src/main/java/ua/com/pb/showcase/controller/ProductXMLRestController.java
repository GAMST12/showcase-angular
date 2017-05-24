package ua.com.pb.showcase.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import ua.com.pb.showcase.dao.entity.Product;
import ua.com.pb.showcase.service.WSProductService;

import java.util.List;
import javax.ws.rs.core.MediaType;


@RestController
public class ProductXMLRestController {
    @Autowired
    private WSProductService wsProductService;


    @RequestMapping(value = "/xmlproduct/", method = RequestMethod.GET,  produces = MediaType.APPLICATION_XML)
    public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> products = wsProductService.getAllProducts();
        if (products.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @RequestMapping(value = "/xmlproduct/{id}", method = RequestMethod.GET,  produces = MediaType.APPLICATION_XML)
    public ResponseEntity<Product> getProduct(@PathVariable("id") long id) {
        Product product = wsProductService.getProduct(id);
        if (product == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @RequestMapping(value = "/xmlproduct/", method = RequestMethod.POST, consumes = MediaType.APPLICATION_XML)
    public ResponseEntity<Void> addProduct(@RequestBody Product product, UriComponentsBuilder ucBuilder) {
        if (false) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        wsProductService.addProduct(product);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/producer/{id}").buildAndExpand(product.getId()).toUri());
        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/xmlproduct/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_XML)
    public ResponseEntity<Product> updateProduct(@PathVariable("id") long id, @RequestBody Product product) {
        Product currentProduct = wsProductService.getProduct(id);
        if (currentProduct==null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        currentProduct.setName(product.getName());
        currentProduct.setProducer(product.getProducer());
        currentProduct.setCategory(product.getCategory());
        currentProduct.setDescription(product.getDescription());
        currentProduct.setPrice(product.getPrice());
        currentProduct.setAvailable(product.isAvailable());

        wsProductService.updateProduct(currentProduct);
        return new ResponseEntity<>(currentProduct, HttpStatus.OK);
    }


    @RequestMapping(value = "/xmlproduct/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteProduct(@PathVariable("id") long id) {
        Product product = wsProductService.getProduct(id);
        if (product == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        wsProductService.deleteProductById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
