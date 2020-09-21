package com.example.dto;

import com.example.enums.NotificationChannel;

public class Notification {
	private NotificationChannel channel;
	
	private String address;
	private String content;

	public NotificationChannel getChannel() {
		return channel;
	}

	public String getAddress() {
		return address;
	}

	public String getContent() {
		return content;
	}
}
