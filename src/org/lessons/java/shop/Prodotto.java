package org.lessons.java.shop;

import java.util.Random;
import java.util.Scanner;

public class Prodotto {
	
	private int code;
	private String name;
	private String description;
	private double price;
	private double iva;
	private double salePrice;
	
	// Constructor
	public Prodotto(Scanner in) {
        generateRandomCode();
        askName(in);
        askDescription(in);
        askPrice(in);
        askIva(in);
        calculateSalePrice();
	}
	
	// Getters
	public int getCode() {
		return code;
	}
	
	public String getName() {
		return name;
	}
	
	public String getDescription() {
		return description;
	}
	
	public double getPrice() {
		return price;
	}
	
	public double getIva() {
		return iva;
	}
	
	public double getSalePrice() {
		return salePrice;
	}
	
	// Setters
	private void setCode(int code) {
		this.code = code;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
	
	public void setIva(double iva) {
		this.iva = iva;
	}
	
	public void setSalePrice(double salePrice) {
		this.salePrice = salePrice;
	}
	
	// Methods
	public double getPricePlusIva() {
		return getPrice() + (getPrice() * getIva());
	}
	
	public String getFullName() {
		return getCode() + "-" + getName();
	}
	
	public String getPrettyIva() { 
		double iva = getIva() * 100;
		String strIva =  String.format("%.0f", iva);
		return strIva + '%';
	}
	
	private void generateRandomCode() {
		final int minCode = 0;
		final int maxCode = Integer.MAX_VALUE;
		
		Random rnd = new Random();
		int randomCode = rnd.nextInt(maxCode - minCode) + minCode;
		
		setCode(randomCode);
	}
	
	private void askName(Scanner in) {
		System.out.println("Name: ");
		setName(in.nextLine());
	}
	
	private void askDescription(Scanner in) {
		System.out.println("Description: ");
		setDescription(in.nextLine());
	}
	
	private void askPrice(Scanner in) {
		System.out.println("Price: ");
		double dPrice = Double.valueOf(in.nextLine());
		setPrice(dPrice);
	}
	
	private void askIva(Scanner in) {
		System.out.println("Iva: ");
		double dIva = Double.valueOf(in.nextLine());
		setIva(dIva);	
	}
	
	private void calculateSalePrice() {
		double salePrice = getPricePlusIva() - (getPricePlusIva() * 0.02);
		setSalePrice(salePrice);
	}
	
	// Override
	@Override
	public String toString() {
		return "PRODOTTO: " + getFullName() + '\n' +
				"Code: " + String.format("%08d", getCode()) + '\n' +
				"Name: " + getName() + '\n' +
				"Description: " + getDescription() + '\n' +
				"Price (without iva): " + getPrice() + "€\n" +
				"Iva: " + getPrettyIva() + '\n' +
				"Price (plus Iva): " + String.format("%.2f", getPricePlusIva()) + "€\n";
	}
} 

