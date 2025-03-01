package com.bharath.microservices.order.service;

import com.bharath.microservices.order.client.InventoryClient;
import com.bharath.microservices.order.dto.OrderRequest;
import com.bharath.microservices.order.event.OrderPlacedEvent;
import com.bharath.microservices.order.model.Order;
import com.bharath.microservices.order.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final InventoryClient inventoryClient;
    Logger LOG = LoggerFactory.getLogger(InventoryClient.class);
    private final KafkaTemplate<String,OrderPlacedEvent> kafkaTemplate;

    public void placeOrder(OrderRequest orderRequest){

        Boolean isProductInStock = inventoryClient.isInStock(orderRequest.skuCode(), orderRequest.quantity());

        //map OrderRequest to Order object
        if(isProductInStock){
            Order order = new Order();
            order.setOrderNumber(UUID.randomUUID().toString());
            order.setPrice(orderRequest.price());
            order.setSkuCode(orderRequest.skuCode());
            order.setQuantity(orderRequest.quantity());

            //save order to OrderRepository
            orderRepository.save(order);

            //send the message to Kafta Topic
            //Order number, email
            OrderPlacedEvent orderPlacedEvent=new OrderPlacedEvent();
            orderPlacedEvent.setOrderNumber(order.getOrderNumber());
            orderPlacedEvent.setEmail(orderRequest.userDetails().email());
            orderPlacedEvent.setFirstName(orderRequest.userDetails().firstName());
            orderPlacedEvent.setLastName(orderRequest.userDetails().lastName());

            LOG.info("Start - Sending OrderPlacedEvents {} to Kafka Topic",orderPlacedEvent);
            kafkaTemplate.send("order-placed",orderPlacedEvent);
            LOG.info("End - Sending OrderPlacedEvents {} to Kafka Topic",orderPlacedEvent);

        }else{
            throw new RuntimeException("Product with SkuCode "+orderRequest.skuCode()+" is out of stock");
        }


    }
}
