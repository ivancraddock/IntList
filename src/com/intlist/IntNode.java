package com.intlist;

import java.util.Random;

public class IntNode {

	private int value;
	private IntNode next;

	// DVC
	public IntNode() {
		Random roll = new Random();
		this.value = roll.nextInt(1000);
		this.next = null;
	}

	// EVC's (Just in case)
	public IntNode(int i) {
		this.value = i;
		this.next = null;
	}

	public void setValue(int i) {
		this.value = i;
	}

	public int getValue() {
		return this.value;
	}

	public void setNext(IntNode n) {
		this.next = n;
	}

	public boolean lastNode() {
		if (this.getNext() == null) {
			return true;
		}
		return false;
	}

	public IntNode getNext() {
		return this.next;
	}

	public int compareTo(IntNode that) {
		return (this.value - that.value);
	}

	@Override
	public String toString() {
		String sss = "Node Value = " + this.value;
		return sss;
	}

}// end LLA class