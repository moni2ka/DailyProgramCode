package com.dataStructute.tree;
/**
 * 
 *  You are given the root of a binary tree. Invert the binary tree in place. That is, all left children should become right children, and all right children should become left children.
 *
 *	Example:
 *	
 *	    a
 *	   / \
 *	  b   c
 *	 / \  /
 *	d   e f
 *	
 *	The inverted version of this tree is as follows:
 *	
 *	  a
 *	 / \
 *	 c  b
 *	 \  / \
 *	  f e  d
 *	  
 * 
 *
 */

public class InvertBinaryTree {
	TreeNodeEx root;

	InvertBinaryTree() {
		root = null;
	}

	private static void treeTraverse(TreeNodeEx root) {

		if (root == null) {
			return;
		}

		treeTraverse(root.left);
		System.out.print(root.data + " ");
		treeTraverse(root.right);

	}

	private static void invertTree(TreeNodeEx root) {

		if (root == null) {
			return;
		}

		invertTree(root.left);
		invertTree(root.right);

		TreeNodeEx temp = root.left;
		root.left = root.right;
		root.right = temp;

	}

	public static void main(String[] args) {

		InvertBinaryTree tree = new InvertBinaryTree();
		tree.root = new TreeNodeEx('a');
		tree.root.left = new TreeNodeEx('b');
		tree.root.right = new TreeNodeEx('c');
		tree.root.left.left = new TreeNodeEx('d');
		tree.root.left.right = new TreeNodeEx('e');
		tree.root.right.left = new TreeNodeEx('f');

		treeTraverse(tree.root);
		System.out.println("\nAfter inversion: ");
		invertTree(tree.root);
		treeTraverse(tree.root);
	}

}
