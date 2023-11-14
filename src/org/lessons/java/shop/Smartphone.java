package org.lessons.java.shop;

import java.util.Random;
import java.util.Scanner;

public class Smartphone extends Prodotto {
	
	private String imei;
	private int memory;
	
	public Smartphone(Scanner in) {
		super(in);		
        generateImei();
        askMemory(in);
	}	
	
	public String getImei() {
		return imei;
	}

	public void setImei(String imei) {
		this.imei = imei;
	}

	public int getMemory() {
		return memory;
	}

	public void setMemory(int memory) {
		this.memory = memory;
	}
	
	private void generateImei() {
		Random rnd = new Random();
		String imeiCode = "";
		for (int i = 0; i < 15; i++) {
			imeiCode += rnd.nextInt(10);
		}
		setImei(imeiCode);
	}
	
	private void askMemory(Scanner in) {
		System.out.println("Memory: ");
		int intMemory = Integer.valueOf(in.nextLine());
		if (intMemory < 32) {
			double extraSalePrice = super.getPricePlusIva() - (super.getPricePlusIva() * 0.05);
			super.setSalePrice(extraSalePrice);
		}
		setMemory(intMemory);
	}
	
	@Override
	public String toString() {
		return super.toString() +
				"Imei: " + getImei() + '\n' +
				"Memory: " + getMemory() + '\n' +
				"Saled Price (if hasCard): " + getSalePrice() + "\n\n";
	}
}
