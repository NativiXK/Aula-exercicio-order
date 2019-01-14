package entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entities.enums.OrderStatus;

public class Order {

	private Date moment;
	private OrderStatus status;

	private List<OrderItem> order = new ArrayList<>();

	public Order() {
	}

	public Order(Date moment, OrderStatus status) {
		this.moment = moment;
		this.status = status;
	}

	public Date getMoment() {
		return moment;
	}

	public void setMoment(Date moment) {
		this.moment = moment;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public List<OrderItem> getOrder() {
		return order;
	}

	public void addItem(OrderItem orderItem) {
		order.add(orderItem);
	}

	public void removeItem(OrderItem orderItem) {
		order.remove(orderItem);
	}

	public double total () {
		double sum = 0;
		
		for (OrderItem c : order) {
			sum += c.subTotal();
		}
		
		return sum;
	}
}
