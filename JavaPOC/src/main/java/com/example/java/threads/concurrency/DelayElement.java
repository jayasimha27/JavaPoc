/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.java.threads.concurrency;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

public class DelayElement implements Delayed {
	private String element;
	private long expiryTime;

	public DelayElement(String element, long delay) {
		this.element = element;
		this.expiryTime = System.currentTimeMillis() + delay;
	}

	@Override
	public long getDelay(TimeUnit timeUnit) {
		long diff = expiryTime - System.currentTimeMillis();
		return timeUnit.convert(diff, TimeUnit.MILLISECONDS);
	}

	@Override
	public int compareTo(Delayed o) {
		if (this.expiryTime < ((DelayElement) o).expiryTime) {
			return -1;
		}
		if (this.expiryTime > ((DelayElement) o).expiryTime) {
			return 1;
		}
		return 0;
	}

	@Override
	public String toString() {
		return element + ": " + expiryTime;
	}
}