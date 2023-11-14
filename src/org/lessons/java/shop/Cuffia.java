package org.lessons.java.shop;

import java.util.Scanner;

public class Cuffia extends Prodotto {
	
	private String color;
	private boolean isWireless;

	public Cuffia(Scanner in) {
		super(in);
		askColor(in);
		askIsWireless(in);
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public boolean isWireless() {
		return isWireless;
	}

	public void setWireless(boolean isWireless) {
		this.isWireless = isWireless;
	}

	private void askColor(Scanner in) {
		System.out.println("Color: ");
		setColor(in.nextLine());
	}
	
	private void askIsWireless(Scanner in) {
		System.out.println("Is Wireless? ");
		System.out.println("Type 'y' or 'n'");
		boolean answer = false;
		String strAnswer = in.nextLine();
		if (strAnswer.equals("y")) {
			answer = true;
			double extraSalePrice = super.getPricePlusIva() - (super.getPricePlusIva() * 0.07);
			super.setSalePrice(extraSalePrice);
		}
		else if (strAnswer.equals("n")) answer = false;
		setWireless(answer);
	}
	
	@Override
	public String toString() {
		return super.toString() +
				"Color: " + getColor() + '\n' +
				"Is Wireless: " + isWireless() + '\n' +
				"Saled Price (if hasCard): " + getSalePrice() + "\n\n";
	}
}	
