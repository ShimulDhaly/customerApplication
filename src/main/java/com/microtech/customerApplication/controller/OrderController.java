package com.microtech.customerApplication.controller;

import com.microtech.customerApplication.entity.Order;
import com.microtech.customerApplication.entity.Product;
import com.microtech.customerApplication.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ord")
public class OrderController {
    @Autowired
    OrderRepository orderRepository;

    @PostMapping("/insertord")
    public ResponseEntity<String> insertOrder(@RequestBody Order order){
        orderRepository.save(order);
        return new ResponseEntity<>("order addded successfully",HttpStatus.CREATED);

    }
    @GetMapping()
    public ResponseEntity<Order>  getOrder(@RequestParam Integer id){
        Order order = orderRepository.findById(id).orElse(null);
        if(order!=null){
            return ResponseEntity.ok(order);
        }else{
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping("/all")
    public List<Order> getOrderAll(){
        return orderRepository.findAll();

    }
    @PutMapping("{id}")
    public ResponseEntity<Order> updateOrderById(@PathVariable Integer id,@RequestBody Order updateOrder){
        Order order = orderRepository.findById(id).orElse(null);
        if (order!=null){
            order.setDeliveryDate(updateOrder.getDeliveryDate());
            order.setCustId(updateOrder.getCustId());
            order.setEmpId(updateOrder.getEmpId());
            order.setProdId(updateOrder.getProdId());
            order.setOrdId(updateOrder.getOrdId());
            order.setShipingDate(updateOrder.getShipingDate());
            order.setOrddate(updateOrder.getOrddate());
            orderRepository.save(order);
            return ResponseEntity.ok(order);
        }else {
            return ResponseEntity.noContent().build();
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Order> deleteById(@PathVariable Integer id){
        if (orderRepository.existsById(id)) {
            orderRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }else{
            return ResponseEntity.notFound().build();
        }
    }


}
