package comparators;

import java.util.Comparator;

import entities.Purchase;

public class PurchaseComparatorByDate implements Comparator<Purchase> {

	@Override
	public int compare(Purchase purchase1, Purchase purchase2) {

		if (purchase1.getDate().substring(6).compareTo(purchase2.getDate().substring(6)) < 0) {
			return -1;
		} else if (purchase1.getDate().substring(6).compareTo(purchase2.getDate().substring(6)) > 0) {
			return 1;
		} else {
			if (purchase1.getDate().substring(3, 4).compareTo(purchase2.getDate().substring(3, 4)) < 0) {
				return -1;
			} else if (purchase1.getDate().substring(3, 4).compareTo(purchase2.getDate().substring(3, 4)) > 0) {
				return 1;
			} else {
				if (purchase1.getDate().substring(0, 2).compareTo(purchase2.getDate().substring(0, 2)) < 0) {
					return -1;
				} else if (purchase1.getDate().substring(0, 2).compareTo(purchase2.getDate().substring(0, 2)) > 0)
					return 1;
				else {

					/**
					 * The criterion used for the tiebreaker if the dates are strictly equal is the
					 * concatenation of clientName + supplierName + purchaseDescription
					 */
					String stringDesempate = purchase1.getClientName() + purchase1.getSupplier()
							+ purchase1.getDescription();
					String stringDesempate2 = purchase2.getClientName() + purchase2.getSupplier()
							+ purchase2.getDescription();

					if (stringDesempate.compareTo(stringDesempate2) < 0) {
						return -1;
					} else if (stringDesempate.compareTo(stringDesempate2) > 0) {
						return 1;
					} else {
						return 0;
					}
				}
			}
		}
	}
}
