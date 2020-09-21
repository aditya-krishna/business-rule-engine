package com.example.rule;

import com.example.dto.Notification;
import com.example.entities.Order;
import com.example.enums.ContactMethod;
import com.example.enums.NotificationChannel;
import com.example.service.NotificationService;

public class EmailAction implements Action<Order> {
	private final NotificationService service;

	public EmailAction(NotificationService service) {
		this.service = service;
	}

	@Override
	public void execute(Order order) {
		Notification notification = new Notification.Builder().onChannel(NotificationChannel.EMAIL)
				.toAddress(order.getUser().getContactList().stream()
						.filter(contact -> ContactMethod.EMAIL.equals(contact.getType())).findFirst().get().getValue())
				.withContent("Your membership updated").build();
		
		service.send(notification);
	}
}
