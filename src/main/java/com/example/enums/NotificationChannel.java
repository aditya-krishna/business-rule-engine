package com.example.enums;

public enum NotificationChannel {
	EMAIL("EMAIL"),
	PUSH_MOBILE("PUSH_MOBILE"),
	PUSH_BROWSER("PUSH_BROWSER"),
	SMS("SMS");
	
	private String channel;
	
	private NotificationChannel(String channel) {
		this.channel = channel;
	}

	public String getChannel() {
		return channel;
	}
}
