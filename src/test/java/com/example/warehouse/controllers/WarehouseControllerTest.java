package com.example.warehouse.controllers;

import com.example.warehouse.models.Warehouse;
import com.example.warehouse.services.WarehouseService;
import com.example.warehouse.viewmodels.WarehouseResponse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class WarehouseControllerTest {

  @Mock
  private WarehouseService mockWarehouseService;

  @InjectMocks
  private WarehouseController warehouseController;

  @Test
  public void testIndex() {
    when(mockWarehouseService.getThemAll()).thenReturn(asList(new Warehouse(1L, "name"), new Warehouse(2L, "other name")));

    ResponseEntity<List<WarehouseResponse>> response = warehouseController.index();

    assertEquals(HttpStatus.OK, response.getStatusCode());
    assertEquals(response.getBody(), asList(
        new WarehouseResponse(1L, "name"),
        new WarehouseResponse(2L, "other name")
    ));

    verify(mockWarehouseService).getThemAll();
  }
}
