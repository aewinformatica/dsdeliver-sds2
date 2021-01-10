package com.devsuperior.DsDeliver.services;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.DsDeliver.dto.OrderDTO;
import com.devsuperior.DsDeliver.dto.ProductDTO;
import com.devsuperior.DsDeliver.entities.Order;
import com.devsuperior.DsDeliver.entities.OrderStatus;
import com.devsuperior.DsDeliver.entities.Product;
import com.devsuperior.DsDeliver.repositories.OrderRepository;
import com.devsuperior.DsDeliver.repositories.ProductRepository;

@Service
public class OrderService {

	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private ProductRepository producRepository;

	@Transactional(readOnly = true)
	public List<OrderDTO> findAll() {
		List<Order> list = orderRepository.findOrdersWithProducts();
		return list.stream().map(x -> new OrderDTO(x)).collect(Collectors.toList());
	}
	
	@Transactional
	public OrderDTO insert(OrderDTO dto) {
		
		Order order = new Order(null, dto.getAddress(), dto.getLatitude(), dto.getLongitude(), Instant.now(), OrderStatus.PENDING);
				for(ProductDTO p : dto.getProducts()) {
					Product product = producRepository.getOne(p.getId());
					order.getProducts().add(product);
				}
				order =  orderRepository.save(order);
				return  new OrderDTO(order);
	}
}
