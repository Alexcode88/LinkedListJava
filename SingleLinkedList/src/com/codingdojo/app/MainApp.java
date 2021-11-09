package com.codingdojo.app;

import java.util.HashMap;

import com.codingdojo.datastructure.*;

public class MainApp {
	
	public static void main( String args[] ) {
		
		LinkedList list = new LinkedList();
		
		list.insert( 1, null );
		list.insert( 2, null );
		list.insert( 3, null );
		list.insert( 4, null );
		list.insert( 5, null );
		Node current = list.find( 3 );
		list.insert( 6, current );
		boolean result = isCycled( list );
		
		if( result == true ) {
			System.out.println( "The list is cycled!" );
		}
		else {
			System.out.println( "The list is not cycled." );
		}
		/*
		Solution for finding intersection in between 2 linked lists 
		 
		LinkedList list1 = new LinkedList();
		LinkedList list2 = new LinkedList();
		
		list1.insert( 4, null );
		list1.insert( 10, null );
		list1.insert( 20, null );
		list1.insert( 5, null );
		list1.insert( 7, null );
		//list1.insert( 9, null );
		
		list2.insert( 500, null );
		list2.insert( 100, null );
		list2.insert( 200, null );
		list2.insert( 400, null );
		list2.insert( 300, list1.getLastNode() );
		list2.insert( 300, null );
		list2.insert( 9, null );
		
		
		list1.print();
		System.out.println("");
		list2.print();
		System.out.println("");
		
		Node intersection = findIntersection( list1, list2 );
		
		if( intersection == null ) {
			System.out.println( "The lists do not intersect" );
		}
		else {
			System.out.println( "The lists intersect at Node with value: " + intersection.getValue() );
		}
		*/
		
	}
	
	public static boolean isCycled( LinkedList list ) {
		HashMap<Integer, Integer> hashTable = new HashMap<Integer, Integer>();
		
		Node current = list.getHead();
		while( current.getNext() != null ) {
			System.out.println( "Addres: " + current.hashCode() + " Value: " + current.getValue() );
			if( hashTable.get( current.hashCode()) == null ) {
				hashTable.put( current.hashCode(), current.getValue() );
				current = current.getNext();
			}
			else {
				return true;
			}
		}
		
		return false;
	}
	
	public static Node findIntersection( LinkedList list1, LinkedList list2 ) {
		
		Node currentList1 = list1.getHead();
		Node currentList2 = list2.getHead();
		
		int result = list1.length() - list2.length();
		
		if( result > 0 ) {
			for( int i = 0; i < result; i ++ ) {
				currentList1 = currentList1.getNext();
			}
		}
		else {
			for( int i = 0; i < Math.abs(result); i ++ ) {
				currentList2 = currentList2.getNext();
			}
		}
		
		while( currentList1 != null ) {
			//System.out.println( currentList1.hashCode() );
			if( currentList1.hashCode() == currentList2.hashCode() ) {
				return currentList1;
			}
			currentList1 = currentList1.getNext();
			currentList2 = currentList2.getNext();
		}
		
		
		return null;
	}
}
