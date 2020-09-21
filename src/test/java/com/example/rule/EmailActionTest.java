package com.example.rule;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.example.dto.Notification;
import com.example.entities.Contact;
import com.example.entities.Order;
import com.example.entities.User;
import com.example.enums.ContactCategory;
import com.example.enums.ContactMethod;
import com.example.enums.NotificationChannel;
import com.example.service.NotificationService;

@RunWith(MockitoJUnitRunner.class)
public class EmailActionTest {
	private EmailAction action;
	
	@Mock
	private NotificationService service;
	
	@Captor
	private ArgumentCaptor<Notification> notificationCaptor;

	@Before
	public void setUp() throws Exception {
		action = new EmailAction(service);
	}

	@Test
	public void shouldSendEmail() {
		Order order = new Order();
		User user = new User();
		
		Contact contact = new Contact.Builder().withCategory(ContactCategory.PRIMARY).withMethod(ContactMethod.EMAIL).withValue("a@b.com").build();
		
		List<Contact> contactList = new ArrayList<>();
		contactList.add(contact);
		
		user.setContactList(contactList);
		order.setUser(user);
		
		doNothing().when(service).send(notificationCaptor.capture());
		
		action.execute(order);
		
		verify(service, times(1)).send(notificationCaptor.getValue());
		verifyNoMoreInteractions(service);
		
		assertEquals("a@b.com", notificationCaptor.getValue().getAddress());
		assertEquals(NotificationChannel.EMAIL, notificationCaptor.getValue().getChannel());
		assertEquals("Your membership updated", notificationCaptor.getValue().getContent());
	}
}
