package com.codingdojo.datastructure;

public class LinkedList {
	private Node head;
	
	public LinkedList() {
		this.head = null;
	}
	
	public void insert( int val, Node next ) {
		Node newNode = new Node( val, next );
		
		if( this.head == null ) {
			this.head = newNode;
		}
		else {
			Node current = this.head;
			while( current.getNext() != null ) {
				current = current.getNext();
			}
			
			current.setNext( newNode );
		}
	}
	
	public Node getLastNode() {
		Node current = this.head;
		
		if( current == null ) {
			return null;
		}
		
		while( current.getNext() != null ) {
			current = current.getNext();
		}
		
		return current;
	}
	
	public Node find( int val ) {
		Node current = this.head;
		
		if( current == null ) {
			return null;
		}
		
		while( current.getNext() != null ) {
			if( current.getValue() == val ) {
				return current;
			}
			current = current.getNext();
		}
		
		return null;
	}
	
	public void print() {
		Node current = this.head;
		
		while( current != null ) {
			System.out.print( current.getValue() + " " );
			current = current.getNext();
		}
	}
	
	public int length() {
		int count = 0;
		Node current = this.head;
		
		while( current != null ) {
			count ++;
			current = current.getNext();
		}
		
		return count;
	}

	public Node getHead() {
		return head;
	}

	public void setHead(Node head) {
		this.head = head;
	}
	
	
}
