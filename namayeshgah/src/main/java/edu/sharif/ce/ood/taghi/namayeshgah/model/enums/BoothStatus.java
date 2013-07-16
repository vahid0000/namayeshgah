package edu.sharif.ce.ood.taghi.namayeshgah.model.enums;

public enum BoothStatus {
	builed, reserved, available,deliqunet;

	public String persianName() {
		String[] status = new String[] { "ساخته شده", "گرفته شده", "آزاد" ,"خطاکار"};
		return status[this.ordinal()];
	}

}
