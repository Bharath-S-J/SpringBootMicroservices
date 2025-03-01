package com.bharath.microservices.inventory.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "t_inventory")
@Data

public class Inventory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String skuCode;
    private Integer quantity;
}
