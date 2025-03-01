package com.bharath.microservices.product.dto;

import java.math.BigDecimal;

public record ProductResponce (String id, String name, String description,String skuCode, BigDecimal price ) {
}
