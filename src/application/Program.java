package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

public class Program {

	public static void main(String[] args) throws ParseException {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		// getting the client's info
		System.out.println("Enter client data: ");
		System.out.print("Name: ");
		String name = sc.nextLine();
		System.out.print("Email: ");
		String email = sc.next();
		System.out.print("Birthdate (DD/MM/YYYY): ");
		Date date = sdf.parse(sc.next());
		Client client = new Client(name, email, date);
		//set the order status to processing
		OrderStatus status = OrderStatus.PROCESSING;

		System.out.println();
		System.out.println("Enter order data: ");
		// creating a order with the moment that it's made and the client
		Order order = new Order(new Date(), status, client);
		System.out.println("Status: " + status);

		System.out.print("How many items to this order? ");
		// getting all the info for the items that the user will input in the order
		int amountOrder = sc.nextInt();
		for (int i = 0; i < amountOrder; i++) {
			System.out.println("Enter #" + (i + 1) + " item data: ");
			System.out.print("Product name: ");
			String productName = sc.next();
			System.out.print("Product price: ");
			Double productPrice = sc.nextDouble();
			System.out.print("Quantity: ");
			int productQuant = sc.nextInt();
			Product product = new Product(productName, productPrice);
			order.addItem(new OrderItem(productQuant, productPrice, product));
		}

		System.out.println();
		System.out.println(order);
		System.out.println("Total: $" + order.total());

		sc.close();
	}

}
