package ru.job4j.openfeign.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.job4j.openfeign.model.Item;

import java.util.List;

@FeignClient(name = "OpenFeignClient", url = "${source-api-url}")
public interface OpenFeignProxy {

    @PostMapping
    Item save(Item item);

    @PutMapping
    ResponseEntity<HttpStatus> update(@RequestParam int id, @RequestBody Item item);

    @DeleteMapping
    void delete(@RequestParam int id);

    @GetMapping("/getById")
    Item getById(@RequestParam int id);

    @GetMapping("/getByName")
    List<Item> getByName(@RequestParam String name);

    @GetMapping("/getAll")
    List<Item> getAll();

}
