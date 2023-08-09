/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.java.threads;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

class StarvationWorker {

	public synchronized void work() {
		String name = Thread.currentThread().getName();
		String fileName = name + ".txt";

		try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
			writer.write("Thread " + name + " wrote this mesasge");
		} catch (IOException ex) {
			ex.printStackTrace();
		}

		while (true) {
			System.out.println(name + " is working");
                        try {
				wait(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}
	}
}

public class Starvation {
	public static void main(String[] args) {
		StarvationWorker worker = new StarvationWorker();
		for (int i = 0; i < 10; i++) {
			new Thread(new Runnable() {
				public void run() {
					worker.work();
				}
			}).start();
		}
	}
}