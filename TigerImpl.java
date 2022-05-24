package com.klxy.interfacedemo;

public class TigerImpl implements IMammal {
	String name;
	public TigerImpl(String nm) {
		this.name=nm;
	}

	@Override
	public void eat() {
		// TODO Auto-generated method stub
		System.out.println(name+"³Ô");
	}

	@Override
	public void breath() {
		// TODO Auto-generated method stub
		System.out.println(name+"ºôÎü");
	}

	@Override
	public void sleep() {
		// TODO Auto-generated method stub
		System.out.println(name+"Ë¯¾õ");
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println(name+"ÅÜ");
	}

}
