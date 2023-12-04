package Lab_11_Tree;

import java.util.*;

public class BST<E extends Comparable<E>> {
	private BNode<E> root;

	public BST() {
		this.root = null;
	}

	public void setRoot(BNode<E> root) {
		this.root = root;
	}

	// Task 1
	// Add element e into BST
	public void add(E e) {
		if (this.root == null)
			this.setRoot(new BNode<>(e));
		else
			this.root.add(e);
	}

	// Add a collection of elements col into BST
	public void add(Collection<E> col) {
		for (E e : col)
			add(e);
	}

	// compute the depth of a node in BST
	public int depth(E node) {
		return root.depth(node);
	}

	// compute the height of BST
	public int height() {
		return root.height();
	}

	// Compute total nodes in BST
	public int size() {
		if (root == null) {
			return 0;
		} else {
			return root.size();
		}
	}

	// Check whether element e is in BST
	public boolean contains(E e) {
		return root.contains(e);
	}

	// Find the minimum element in BST
	public E findMin() {
		if (root == null)
			return null;
		return root.findMin();
	}

	// Find the maximum element in BST
	public E findMax() {
		if (root == null)
			return null;
		return root.findMax();
	}

	// Remove element e from BST
	public boolean remove(E e) {
		return root.remove(e);
	}

	// get the descendants of a node
	public List<E> descendants(E data) {
		BNode<E> currentNode = this.root.search(this.root, data);
		return (currentNode == null) ? null : currentNode.addDescendants(currentNode, currentNode.getData());
	}

	// get the ancestors of a node
	public List<E> ancestors(E data) {
		return (this.root.search(this.root, data) == null) ? null : this.root.addAncestors(data);
	}

	// Task 2
	// display BST using inorder approach(tiep can theo thu tu)
	public void inorder() {
		root.inorderPrint();
		System.out.println();
	}

	// display BST using preorder approach(dat hang truoc)
	public void preorder() {
		root.preorderPrint();
		System.out.println();
	}

	// display BST using postorder approach ( dat hang sau )
	public void postorder() {
		root.postorderPrint();
		System.out.println();
	}
	
}