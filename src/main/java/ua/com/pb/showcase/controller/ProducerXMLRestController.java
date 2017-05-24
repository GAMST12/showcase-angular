package ua.com.pb.showcase.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import ua.com.pb.showcase.dao.entity.Producer;
import ua.com.pb.showcase.service.WSProducerService;

import javax.ws.rs.core.MediaType;
import java.util.List;

@RestController
public class ProducerXMLRestController {
    @Autowired
    private WSProducerService wsProducerService;


    @RequestMapping(value = "/xmlproducer/", method = RequestMethod.GET,  produces = MediaType.APPLICATION_XML)
    public ResponseEntity<List<Producer>> getAllProducers() {
        List<Producer> producers = wsProducerService.getAllProducers();
        if (producers.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(producers, HttpStatus.OK);
    }

    @RequestMapping(value = "/xmlproducer/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_XML)
    public ResponseEntity<Producer> getProducer(@PathVariable("id") long id) {
        Producer producer = wsProducerService.getProducer(id);
        if (producer == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(producer, HttpStatus.OK);
    }

    @RequestMapping(value = "/xmlproducer/", method = RequestMethod.POST, consumes = MediaType.APPLICATION_XML)
    public ResponseEntity<Void> addProducer(@RequestBody Producer producer, UriComponentsBuilder ucBuilder) {
        if (false) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        wsProducerService.addProducer(producer);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/producer/{id}").buildAndExpand(producer.getId()).toUri());
        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/xmlproducer/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_XML)
    public ResponseEntity<Producer> updateProducer(@PathVariable("id") long id, @RequestBody Producer producer) {
        Producer currentProducer = wsProducerService.getProducer(id);
        if (currentProducer==null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        currentProducer.setName(producer.getName());

        wsProducerService.updateProducer(currentProducer);
        return new ResponseEntity<>(currentProducer, HttpStatus.OK);
    }


    @RequestMapping(value = "/xmlproducer/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteProducer(@PathVariable("id") long id) {
        Producer producer = wsProducerService.getProducer(id);
        if (producer == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        wsProducerService.deleteProducerById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
