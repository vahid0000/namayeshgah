package edu.sharif.ce.ood.taghi.namayeshgah.model.enums;

public enum ReceiptStatus {
	nonPaid,paid;
	
	public String persianName() {
		String[] name = new String[] { "پرداخت نشده", "پرداخت شده" };
		return name[this.ordinal()];
	}

}
