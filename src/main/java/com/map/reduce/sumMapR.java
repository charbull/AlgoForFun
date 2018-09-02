package com.map.reduce;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;

class Transaction {
	int productID;
	int categoryID;
	int price;
	int buyerID;
	int sellerID;
	int quantity;
	long timestamp;

	public Transaction(int pId, int cId, int price, int bId, int sId, int quantity)
	{
		this.productID = pId;
		this.categoryID = cId;
		this.price = price;
		this.quantity = quantity;
		this.buyerID = bId;
		this.sellerID = sId;
		this.timestamp = (new Date()).getTime();
	}
	public int getQuantity()
	{
		return quantity;
	}
}

class MergedTransaction {
	int productID;
	int categoryID;
	int quantity;

	public MergedTransaction(int pId, int cId, int quantity)
	{
		this.productID = pId;
		this.categoryID = cId;
		this.quantity = quantity;
	}

}


public class sumMapR {

	public static List<Transaction> Init()
	{
		List<Transaction> listTransactions = new ArrayList<Transaction>();	
		Random r = new Random();
		for(int i=1; i<=10; i++)
		{
			Transaction t = new Transaction(r.nextInt(10), r.nextInt(10), r.nextInt(10), 
					r.nextInt(10), r.nextInt(10), r.nextInt(10));
			listTransactions.add(t);
		}
		return listTransactions;
	}

	public static void main(String[] args) {
		List<Transaction> listTransactions = sumMapR.Init();
		for(Transaction t : listTransactions)
		{
			System.out.println("pId "+t.productID+
					" , cId "+t.categoryID+
					" , price "+t.price+
					" , Q "+t.quantity);
		}
		long x = listTransactions.parallelStream().map(t -> t.productID).count();
				






	}
}
