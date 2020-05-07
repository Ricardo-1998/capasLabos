package com.uca.capas.tareaLabo4.domain;

import javax.validation.constraints.AssertTrue;

public class Robot {
	
	@AssertTrue(message="Ups no puedes agreagr producto porque eres un robot, favor hacer click en regresar")
	private Boolean soyRobot;

	public Robot() {
		super();
	}

	public Boolean getSoyRobot() {
		return soyRobot;
	}

	public void setSoyRobot(Boolean soyRobot) {
		this.soyRobot = soyRobot;
	}
	
	
}
