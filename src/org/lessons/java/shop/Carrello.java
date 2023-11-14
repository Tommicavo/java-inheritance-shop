package org.lessons.java.shop;

import java.util.Scanner;

public class Carrello {
	
	static final int MAX_CART_SPACE = 2;
	static Prodotto[] products = new Prodotto[MAX_CART_SPACE];
	private static double totalCost = 0;
	private static boolean hasCard = false;
	
	public static void checkout() {
		if (products.length > 0) {	
			
			System.out.println("SHOPPING DONE!\nHere's the list of product you bought\n");
			
			for (int i = 0; i < products.length; i++) {
				if (products[i] != null) {
					System.out.println(products[i]);
					if (hasCard) totalCost += products[i].getSalePrice();
					else totalCost += products[i].getPricePlusIva();
				}
			}

			System.out.println("Total Cost: " + String.format("%.2f", totalCost) + "€\n\n");
			
		} else System.out.println("Non hai acquistato niente");
	}
	
	public static void main(String[] args) {

	    int currentItem = 0;
	    boolean isDone = false;
	    
	    try (Scanner in = new Scanner(System.in)) {
	        while (!isDone) {
	        	
	        	if (currentItem == products.length - 1) isDone = true;
	        	
	            System.out.println("If you want to buy something type:");
	            System.out.println("'s' for Smartphone\n'c' for Cuffie\n't' for Televisore");
	            System.out.println("Type '0' if you want nothing more");
	            String answer = in.nextLine();

	            if (answer.equals("0")) isDone = true;
	            else if (answer.equals("s")) {
	                products[currentItem] = new Smartphone(in); 
	            } else if (answer.equals("t")) {
	                products[currentItem] = new Televisore(in);
	            } else if (answer.equals("c")) {
	                products[currentItem] = new Cuffia(in);
	            }
	            currentItem += 1;
	        }
			System.out.println("Do you have Fidelty Card?\n");
			System.out.println("Type 'y' or 'n'");
			String cardAnswer = in.nextLine();
			if (cardAnswer.equals("y")) hasCard = true;
			else if (cardAnswer.equals("n")) hasCard = false;
	        checkout();
	    }
	}
}
