package edu.sharif.ce.ood.taghi.namayeshgah.model.enums;

public enum PenaltyStatus {
	newAdded, paid;

	public String persianName() {
		String[] name = new String[] { "جدید", "پرداخت شته" };
		return name[this.ordinal()];
	}
}
