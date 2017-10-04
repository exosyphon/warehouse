package com.example.warehouse.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
@AllArgsConstructor
@Builder
public class Warehouse {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    public Warehouse() {

    }

//    public Warehouse(Long id, String name) {
//        this.id = 1L;
//        this.name = name;
//    }
//
//    public String getName() {
//        return name;
//    }
}
