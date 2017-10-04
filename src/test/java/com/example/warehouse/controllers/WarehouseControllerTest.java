package com.example.warehouse.controllers;

import com.example.warehouse.domain.Warehouse;
import com.example.warehouse.repos.WarehouseRepository;
import com.example.warehouse.services.WarehouseService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class WarehouseControllerTest {

    @Mock
    private WarehouseRepository mockWarehouseRepository;

    private WarehouseService mockWarehouseService;
    private WarehouseController warehouseController;

    @Before
    public void setup() {
        mockWarehouseService = Mockito.spy(new WarehouseService(mockWarehouseRepository));
        warehouseController = new WarehouseController(mockWarehouseRepository, mockWarehouseService);
    }

    @Test
    public void testIndex() {
        when(mockWarehouseRepository.findAll()).thenReturn(asList(new Warehouse(1L, "name"), new Warehouse(2L, "other name")));

        ResponseEntity<String> response = warehouseController.index();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        verify(mockWarehouseRepository).findAll();
    }
}
