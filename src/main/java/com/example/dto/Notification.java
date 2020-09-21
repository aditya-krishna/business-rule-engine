package com.example.dto;

import com.example.enums.NotificationChannel;

public class Notification {
	private NotificationChannel channel;
	
	private String address;
	private String content;
	
	private Notification() {
		
	}
	
	private Notification(Builder builder) {
		this.address = builder.address;
		this.channel = builder.channel;
		this.content = builder.content;
	}

	public NotificationChannel getChannel() {
		return channel;
	}

	public String getAddress() {
		return address;
	}

	public String getContent() {
		return content;
	}
	
	public static class Builder {
		private NotificationChannel channel;
		
		private String address;
		private String content;
		
		public Builder onChannel(NotificationChannel channel) {
			this.channel = channel;
			return this;
		}
		
		public Builder toAddress(String address) {
			this.address = address;
			return this;
		}
		
		public Builder withContent(String content) {
			this.content = content;
			return this;
		}
		
		public Notification build() {
			return new Notification(this);
		}
	}
}
