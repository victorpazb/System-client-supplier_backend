package comparators;

import java.util.Comparator;
import entities.Purchase;

public class PurchaseComparatorBySupplier implements Comparator<Purchase> {

	@Override
	public int compare(Purchase purchase1, Purchase purchase2) {

		String comparatorString = purchase1.getClientName() + purchase1.getDescription() + purchase1.getDate();
		String comparatorString2 = purchase2.getClientName() + purchase2.getDescription() + purchase2.getDate();

		return (purchase1.getSupplier() + comparatorString).compareTo(purchase2.getSupplier() + comparatorString2);
	}

}
