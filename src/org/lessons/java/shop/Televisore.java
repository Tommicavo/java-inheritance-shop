package org.lessons.java.shop;

import java.util.Scanner;

public class Televisore extends Prodotto {

	private int thumbs;
	private boolean isSmart;
	
	public Televisore(Scanner in) {
		super(in);
		askThumbs(in);
		askIsSmart(in);
	}

	public int getThumbs() {
		return thumbs;
	}

	public void setThumbs(int thumbs) {
		this.thumbs = thumbs;
	}

	public boolean isSmart() {
		return isSmart;
	}

	public void setSmart(boolean isSmart) {
		this.isSmart = isSmart;
	}
	
	private void askThumbs(Scanner in) {
		System.out.println("Thumbs: ");
		int intThumbs = Integer.valueOf(in.nextLine());
		setThumbs(intThumbs);
	}
	
	private void askIsSmart(Scanner in) {
		System.out.println("Is Smart? ");
		System.out.println("Type 'y' or 'n'");
		boolean answer = false;
		String strAnswer = in.nextLine();
		if (strAnswer.equals("y")) answer = true;
		else if (strAnswer.equals("n")) {
			answer = false;
			double extraSalePrice = super.getPricePlusIva() - (super.getPricePlusIva() * 0.1);
			super.setSalePrice(extraSalePrice);
		}
		setSmart(answer); 
	}
	
	@Override
	public String toString() {
		return super.toString() +
				"Thumbs: " + getThumbs() + '\n' +
				"Is Smart: " + isSmart() + '\n' +
				"Saled Price (if hasCard): " + getSalePrice() + "\n\n";
	}	
}
