package edu.sharif.ce.ood.taghi.namayeshgah.model.enums;

public enum StoreStuffStatus {

	enter, exit;

	public String persianName() {
		String[] name = new String[] { "ورود", "خروج" };
		return name[this.ordinal()];
	}
}
