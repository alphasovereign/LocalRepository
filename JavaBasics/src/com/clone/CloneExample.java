package com.clone;

import javax.xml.ws.WebServiceClient;

public class CloneExample {

	public static void main(String[] args) throws CloneNotSupportedException {
		
		B bb = new B();
		bb.child = "Elisha";
		A a = new A(10,"Alpha",bb);
		
		System.out.println(  a.clone() );
		
		A b= a.clone();
		a.b = "Sovereign";
		a.bb.child ="Elisha sovereign";
		
		System.out.println(   "Original Object"+a  );
		System.out.println(  "duplicate Object"+b );
		
	}
}

class A implements Cloneable{
	
	int a;
	String b;
	B bb;
	
	
	
	public A(int a, String b,B bb) {
		super();
		this.a = a;
		this.b = b;
		this.bb = bb;
	}



	



	@Override
	public String toString() {
		return "A [a=" + a + ", b=" + b + ", bb=" + bb + "]";
	}







	@Override
	public A clone() throws CloneNotSupportedException {//throws CloneNotSupportedException {
		
		B bv = ((A)super.clone() ).bb.clone();
		A aa = (A)super.clone();
		aa.bb = bv;
		return aa;
	}
}

class B implements Cloneable{
	
	String child ;

	@Override
	public String toString() {
		return "B [child=" + child + "]";
	}
	
	@Override
	protected B clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return (B)super.clone();
	}
	
	
}
