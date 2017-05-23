package ua.com.pb.showcase.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import ua.com.pb.showcase.dao.entity.Producer;
import ua.com.pb.showcase.service.ShowcaseService;
import ua.com.pb.showcase.service.WSProducerService;
import java.util.List;

@RestController
public class ProducerRestController {
    @Autowired
    private WSProducerService wsProducerService;
    @Autowired
    private ShowcaseService showcaseService;


    @RequestMapping(value = "/producer/", method = RequestMethod.GET)
    public ResponseEntity<List<Producer>> getAllProducers() {
        List<Producer> producers = wsProducerService.getAllProducers();
        if (producers.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(producers, HttpStatus.OK);
    }

    @RequestMapping(value = "/producer/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Producer> getProducer(@PathVariable("id") long id) {
        Producer producer = wsProducerService.getProducer(id);
        if (producer == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(producer, HttpStatus.OK);
    }

    @RequestMapping(value = "/producer/", method = RequestMethod.POST)
    public ResponseEntity<Void> addProducer(@RequestBody Producer producer, UriComponentsBuilder ucBuilder) {
        if (false) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        wsProducerService.addProducer(producer);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/producer/{id}").buildAndExpand(producer.getId()).toUri());
        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/producer/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Producer> updateUser(@PathVariable("id") long id, @RequestBody Producer producer) {
        Producer currentProducer = wsProducerService.getProducer(id);
        if (currentProducer==null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        currentProducer.setName(producer.getName());

        wsProducerService.updateProducer(currentProducer);
        return new ResponseEntity<>(currentProducer, HttpStatus.OK);
    }


    @RequestMapping(value = "/producer/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Producer> deleteUser(@PathVariable("id") long id) {
        Producer producer = wsProducerService.getProducer(id);
        if (producer == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        wsProducerService.deleteUserById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
