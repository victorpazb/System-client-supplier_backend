package comparators;

import java.util.Comparator;

import entities.Purchase;

public class PurchaseComparatorByClient implements Comparator<Purchase> {

	@Override
	public int compare(Purchase purchase1, Purchase purchase2) {

		String comparatorString = purchase1.getSupplier() + purchase1.getDescription() + purchase1.getDate();
		String comparatorString2 = purchase2.getSupplier() + purchase2.getDescription() + purchase2.getDate();

		return (purchase1.getClientName() + comparatorString).compareTo(purchase2.getClientName() + comparatorString2);
	}
	
	

}
