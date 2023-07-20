package ru.job4j.webclient.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.job4j.webclient.model.Item;
import ru.job4j.webclient.service.WebClientService;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/webclient")
public class WebClientController {
    private final WebClientService service;

    @PostMapping
    public Item save(@RequestBody Item item) {
        return service.save(item);
    }

    @PutMapping
    public ResponseEntity<HttpStatus> update(@RequestParam int id, @RequestBody Item item) {
        boolean status = service.update(id, item);
        return ResponseEntity.status(status ? HttpStatus.OK : HttpStatus.NOT_FOUND).build();
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@RequestParam int id) {
        service.delete(id);
    }

    @GetMapping("/getById")
    public Item getById(@RequestParam int id) {
        return service.findById(id);
    }

    @GetMapping("/getByName")
    public List<Item> getByName(@RequestParam String name) {
        return service.findByName(name);
    }

    @GetMapping("/getAll")
    public List<Item> getAll() {
        return service.findAll();
    }

}
