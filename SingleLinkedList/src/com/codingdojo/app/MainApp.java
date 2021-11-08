package com.codingdojo.app;

import com.codingdojo.datastructure.*;

public class MainApp {
	
	public static void main( String args[] ) {
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
			if( currentList1.hashCode()== currentList2.hashCode() ) {
				return currentList1;
			}
			currentList1 = currentList1.getNext();
			currentList2 = currentList2.getNext();
		}
		
		
		return null;
	}
}
