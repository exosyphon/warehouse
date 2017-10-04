package com.example.warehouse.controllers;

import com.example.warehouse.domain.Warehouse;
import com.example.warehouse.repos.WarehouseRepository;
import com.example.warehouse.services.WarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
public class WarehouseController {

    private WarehouseRepository warehouseRepository;
    private WarehouseService warehouseService;

    @Autowired
    public WarehouseController(WarehouseRepository warehouseRepository, WarehouseService warehouseService) {
        this.warehouseRepository = warehouseRepository;
        this.warehouseService = warehouseService;
    }

    @RequestMapping("/")
    public ResponseEntity<String> index() {
        warehouseRepository.save(new Warehouse(null, "wow it works"));
        warehouseRepository.save(new Warehouse(null, " with things"));

        List<Warehouse> themAll = warehouseService.getThemAll();
        Warehouse warehouse1 = themAll.get(0);
        Warehouse warehouse2 = themAll.get(1);

        return ResponseEntity.ok(warehouse1.getName() + warehouse2.getName());
    }
}
