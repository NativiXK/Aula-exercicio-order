package entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entities.enums.OrderStatus;

public class Order {

	private Date moment;
	private OrderStatus status;
	private Client client;
	private List<OrderItem> order = new ArrayList<>();

	static SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

	public Order() {
	}

	public Order(Date moment, OrderStatus status, Client client) {
		this.moment = moment;
		this.status = status;
		this.client = client;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Date getMoment() {
		return moment;
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

	public double total() {
		double sum = 0;

		for (OrderItem c : order) {
			sum += c.subTotal();
		}

		return sum;
	}

	@Override
	// building the string to override the method toString, this string returns all
	// the orders summary
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("ORDER SUMMARY: \n");
		sb.append("Order moment: " + sdf1.format(getMoment()) + "\n");
		sb.append("Order status: " + getStatus() + "\n");
		sb.append("Client: " + getClient() + "\n");
		// concatenating all ordered items
		for (OrderItem items : order) {
			sb.append(items + "\n");
		}

		return sb.toString();
	}

}
