package ru.job4j.openfeign.service;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ru.job4j.openfeign.model.Item;

import java.util.List;

@AllArgsConstructor
@Service
public class OpenFeignService {
    private final OpenFeignProxy client;

    public Item save(Item item) {
        return client.save(item);
    }

    public ResponseEntity<HttpStatus> update(int id, Item item) {
        return client.update(id, item);
    }

    public void delete(int id) {
        client.delete(id);
    }

    public Item findById(int id) {
        return client.getById(id);
    }

    public List<Item> findByName(String name) {
        return client.getByName(name);
    }

    public List<Item> findAll() {
        return client.getAll();
    }

}
