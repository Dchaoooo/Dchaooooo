package com.klxy.interfacedemo;

public class TigerImpl implements IMammal {
	String name;
	public TigerImpl(String nm) {
		this.name=nm;
	}

	@Override
	public void eat() {
		// TODO Auto-generated method stub
		System.out.println(name+"��");
	}

	@Override
	public void breath() {
		// TODO Auto-generated method stub
		System.out.println(name+"����");
	}

	@Override
	public void sleep() {
		// TODO Auto-generated method stub
		System.out.println(name+"˯��");
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println(name+"��");
	}

}
