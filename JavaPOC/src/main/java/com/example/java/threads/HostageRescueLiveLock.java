/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.java.threads;

class Criminal {
	private boolean hostageReleased = false;

	public boolean isHostageReleased() {
		return hostageReleased;
	}

	public void releaseHostage(Police police) {
		while (!police.isMoneySent()) {

			System.out.println("Criminal: waiting police to give ransom");

			try {
				Thread.sleep(1000);
			} catch (InterruptedException ex) {
				ex.printStackTrace();
			}
		}

		System.out.println("Criminal: released hostage");

		this.hostageReleased = true;
	}

}

class Police {
	private boolean moneySent = false;

	public boolean isMoneySent() {
		return moneySent;
	}

	public void giveRansom(Criminal criminal) {

		while (!criminal.isHostageReleased()) {

			System.out.println("Police: waiting criminal to release hostage");

			try {
				Thread.sleep(1000);
			} catch (InterruptedException ex) {
				ex.printStackTrace();
			}
		}

		System.out.println("Police: sent money");

		this.moneySent = true;
	}

}

public class HostageRescueLiveLock {

	static final Police police = new Police();

	static final Criminal criminal = new Criminal();

	public static void main(String[] args) {
		new Thread(() -> {
			police.giveRansom(criminal);
		}).start();

		new Thread(() -> {
			criminal.releaseHostage(police);
		}).start();
	}

}