package com.linkedlist.intersect;

 class NodeEx1 {
	int data;
	NodeEx1 next;
	NodeEx1(int data) {
		this.data = data;
		this.next = null;
	}

}


/**
 * You are given two singly linked lists. The lists intersect at some node.
 * Find, and return the node. Note: the lists are non-cyclical.
 *
 * Example:
 *
 * A = 1 -> 2 -> 3 -> 4 B = 6 -> 3 -> 4
 *
 * This should return 3 (you may assume that any nodes with the same value are
 * the same node).
 * 
 * @author mrityunjaykumar
 *
 */

public class IntersectionOfLinkedList {

	private static NodeEx1 head = null;

	private static NodeEx1 head2 = null;

	private static NodeEx1 addNode(int data, NodeEx1 headRef) {
		NodeEx1 node = new NodeEx1(data);

		if (headRef == null) {
			node.next = null;
			headRef = node;
			return headRef;
		}

		NodeEx1 temp = headRef;
		while (temp.next != null) {
			temp = temp.next;
		}

		temp.next = node;
		return node;
	}

	private static void printNode(NodeEx1 headRef) {
		NodeEx1 temp = headRef;
		while (temp != null) {
			System.out.print(temp.data + " -> ");
			temp = temp.next;
		}
		System.out.println("NULL");
	}

	private static int checkIntesectionPoint(NodeEx1 head1, NodeEx1 head2) {

		NodeEx1 temp1 = head1;
		int intersectionData = 0;
		boolean isFound = false;
		while (temp1 != null) {
			NodeEx1 temp2 = head2;

			while (temp2 != null) {
				if (temp1 == temp2) {
					intersectionData = temp1.data;
					isFound = true;
					break;
				}
				temp2 = temp2.next;
			}

			if (isFound) {
				break;
			}
			temp1 = temp1.next;
		}

		return intersectionData;
	}

	public static void main(String[] args) {

		head = addNode(1, head);
		addNode(2, head);
		NodeEx1 intPoint = addNode(3, head);
		addNode(4, head);

		head2 = addNode(6, head2);
		head2.next = intPoint;

		printNode(head);
		printNode(head2);

		System.out.println("\nIntersection point: " + checkIntesectionPoint(head, head2));

	}

}
