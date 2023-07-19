package ru.job4j.openfeign.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.job4j.openfeign.model.Item;
import ru.job4j.openfeign.service.OpenFeignService;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/feign")
public class OpenFeignController {
    private final OpenFeignService service;

    @PostMapping
    public Item save(@RequestBody Item item) {
        return service.save(item);
    }

    @PutMapping
    public ResponseEntity<HttpStatus> update(@RequestParam int id, @RequestBody Item item) {
        return service.update(id, item);
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
    public List<Item> geByName(@RequestParam String name) {
        return service.findByName(name);
    }

    @GetMapping("/getAll")
    public List<Item> getAll() {
        return service.findAll();
    }

}
