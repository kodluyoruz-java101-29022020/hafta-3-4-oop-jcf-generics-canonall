package soru2.main;

import soru2.node.DoublyLinkedList;

public class Main {

	public static void main(String[] args) {

		DoublyLinkedList<Integer> dList = new DoublyLinkedList();
		// DoublyLinkedList<String> dList = new DoublyLinkedList();

		// Add nodes to the list
		dList.addNode(10);
		dList.addNode(5);
		dList.addNode(3);
		dList.addNode(7);
		dList.addNode(1);

		/*
		 * Add Strings to list dList.addNode("Can"); dList.addNode("Kawhi");
		 * dList.addNode("LeBron"); dList.addNode("Kobe"); dList.addNode("Durant");
		 */

		dList.display();

	}

}
