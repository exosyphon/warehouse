package com.example.warehouse.acceptance;

import com.example.warehouse.models.Warehouse;
import com.example.warehouse.repos.WarehouseRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import testutilities.TestUtils;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@EnableAutoConfiguration
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class WarehouseAcceptanceTest {

  @Autowired
  private MockMvc mockMvc;

  @Autowired
  private WarehouseRepository warehouseRepository;

  @Before
  public void setUp() {
    warehouseRepository.save(new Warehouse(null, "Avengers Weapon Supply"));
    warehouseRepository.save(new Warehouse(null, "Batman Vehicles"));
  }

  @Test
  public void index_shouldRetrieveAllWarehouses() throws Exception {
    mockMvc.perform(get("/"))
        .andExpect(status().isOk())
        .andExpect(content().json(TestUtils.readJsonFixture("warehouse-response/get_warehouses.json")));
  }
}
