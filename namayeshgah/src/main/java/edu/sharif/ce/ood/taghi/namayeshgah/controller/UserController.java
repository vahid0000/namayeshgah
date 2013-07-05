package edu.sharif.ce.ood.taghi.namayeshgah.controller;

import java.util.ArrayList;

import edu.sharif.ce.ood.taghi.namayeshgah.model.entity.UserEntity;

public class UserController {

	private ArrayList<Integer> buttons;
	private String fullName;

	public UserController(UserEntity entity) {
		buttons = new ArrayList<Integer>();
		// buttons.add(22);
		buttons.add(20);
		buttons.add(15);
		fullName = entity.getFirstName() + " " + entity.getLastName();

	}

	public ArrayList<Integer> getButtons() {
		return buttons;
	}

	public String getFullname() {
		return fullName;
	}

}
