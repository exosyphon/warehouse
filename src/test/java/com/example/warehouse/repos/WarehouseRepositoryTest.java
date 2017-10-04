package com.example.warehouse.repos;

import com.example.warehouse.domain.Warehouse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@EnableAutoConfiguration
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class WarehouseRepositoryTest {

    @Autowired
    private WarehouseRepository warehouseRepository;

    @Test
    public void testShouldWork() throws Exception {
        warehouseRepository.save(new Warehouse(null, "name"));

        List<Warehouse> actual = warehouseRepository.findAll();

        assertEquals(1, actual.size());
    }
}
