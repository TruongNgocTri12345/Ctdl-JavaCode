package Lab_11_Tree;

import java.util.LinkedList;
import java.util.List;

public class BNode<E extends Comparable<E>> {
	private E data;
	private BNode<E> left;
	private BNode<E> right;

	public BNode(E data, BNode<E> left, BNode<E> right) {
		this.data = data;
		this.left = left;
		this.right = right;
	}

	public BNode(E data) {
		this.data = data;
		this.left = null;
		this.right = null;
	}
	
	 public E getData() {
		return data;
	}

	public BNode<E> getLeft() {
		return left;
	}

	public BNode<E> getRight() {
		return right;
	}

	//for add method
	public void add(E e) {
		int comp = data.compareTo(e);
		if (comp == 0) {
			System.out.println("Trung gia tri !!");
		}
		if (data.compareTo(e) < 0) {
			if (left == null)
				left = new BNode<>(e);
			else
				left.add(e);
		} else {
			if (right == null)
				right = new BNode<>(e);
			else
				right.add(e);
		}
	}
	//for height method
	public int height() {
		int leftHeight = 0;
		int rightHeight = 0;
		if (left == null) {
			rightHeight = 1 + right.height();
		} else if (right == null) {
			leftHeight = 1 + left.height();
		} else {
			return 0;
		}
		return 1 + Math.max(leftHeight, rightHeight);
	}
	//for size method
	public int size() {
		int leftSize = 0;
		int rightSize = 0;
		if (data == null) {
			return 0;
		} else if (left == null && right != null) {
			rightSize = 1 + right.size();
		} else if (left != null && right == null) {
			leftSize = 1 + left.size();
		} else {
			return 1;
		}
		return 1 + leftSize + rightSize;
	}
	//for depth method
	public int depth(E node) {
		int comp = data.compareTo(node);
		int leftSize = 0;
		int rightSize = 0;
		if (comp == 0) {
			return 0;
		} else if (comp < 0 && left != null) {
			leftSize = 1 + left.depth(node);
		} else if (comp > 0 && right != null) {
			rightSize = 1 + right.depth(node);
		} else {
			return -1;
		}
		return Math.max(leftSize, rightSize);
	}
	//for contains method
	public boolean contains(E e) {
		int comp = e.compareTo(data);
		if (comp == 0) {
			return true;
		} else if (comp < 0) {
			return (left == null) ? false : left.contains(e);
		} else if (comp > 0) {
			return (right == null) ? false : right.contains(e);
		}
		return false;
	}
	//for findMin method
	public E findMin() {
		return (left == null) ? data : left.findMin();
	}
	//for findMax method
	public E findMax() {
		return (right == null) ? data : right.findMax();
	}

	public BNode<E> findNode(E node) {
		int comp = node.compareTo(data);
		if (comp == 0) {
			return this;
		} else if (comp > 0) {
			return (right == null) ? null : right.findNode(node);
		} else if (comp < 0) {
			return (left == null) ? null : left.findNode(node);
		}
		return null;
	}

	public void setRight(BNode<E> right) {
		this.right = right;
	}

	public void setData(E data) {
		this.data = data;
	}

	public void setLeft(BNode<E> left) {
		this.left = left;
	}
	//for remove method
	public boolean remove(E e) {
		BNode<E> removeNode = search(this, e);
		if (removeNode == null)
			return false;
		else {
			BNode<E> parent = findNodeParent(this, e);
			// if Node don't have child
			if (removeNode.left == null && removeNode.right == null) {
				if (parent.data.compareTo(removeNode.data) < 0)
					parent.setRight(null);
				else
					parent.setLeft(null);
			}
			// if Node have 1 child
			else if (removeNode.left == null)
				parent.setRight(removeNode.right);
			else if (removeNode.right == null)
				parent.setLeft(removeNode.left);
			// if Node have 2 child
			else {
				BNode<E> newNode = findSuccessor(removeNode.right);
				// recreate Successor node
				remove(newNode.data);
				newNode.setLeft(removeNode.left);
				newNode.setRight(removeNode.right);
				// add Successor node
				if (parent.data.compareTo(newNode.data) < 0)
					parent.setRight(newNode);
				else
					parent.setLeft(newNode);
			}
		}
		return true;
	}

	public BNode<E> search(BNode<E> root, E e) {
		if (root != null) {
			int compareValue = root.data.compareTo(e);
			// like binary search
			if (compareValue > 0)
				return search(root.left, e);
			else if (compareValue < 0)
				return search(root.right, e);
			else
				return root;
		} else
			return null;
	}

	public BNode<E> findSuccessor(BNode<E> node) {
		return (left == null) ? node : findSuccessor(node.left);
	}
	 public BNode<E> findNodeParent(BNode<E> node, E data) {
	        //if Node have 2 child
	        if (node.left != null && node.right != null) {
	            if (node.left.data.compareTo(data) == 0 || node.right.data.compareTo(data) == 0)
	                return node;
	            else {
	                BNode<E> leftVal = findNodeParent(node.left, data);
	                return (leftVal != null) ? leftVal : findNodeParent(node.right, data);
	            }
	        }
	        //if Node have 0 child
	        else if (node.left == null && node.right == null) return null;
	            //if Node have 1 child
	        else {
	            if (node.left == null) {
	                return (node.right.data.compareTo(data) == 0) ? node : findNodeParent(node.right, data);
	            } else return (node.left.data.compareTo(data) == 0) ? node : findNodeParent(node.left, data);
	        }
	    }
	//for descendants method
	    public List<E> addDescendants(BNode<E> node, E data) {
	        List<E> result = new LinkedList<>();
	        if (node != null) {
	            if (node.getData().compareTo(data) != 0) result.add(node.getData());
	            if (node.getLeft() != null) {
	                result.addAll(addDescendants(node.left, data));
	            }
	            if (node.getRight() != null) {
	                result.addAll(addDescendants(node.right, data));
	            }
	        }
	        return result;
	    }
	// for ancestor method
	public List<E> addAncestors(E e) {
		List<E> result = new LinkedList<>();
		int comp = data.compareTo(e);
		if (comp != 0)
			result.add(data);
		if (comp > 0 && this.left != null) {
			result.addAll(left.addAncestors(e));
		} else {
			if (this.right != null) {
				result.addAll(right.addAncestors(e));
			}
		}

		return result;
	}

	// print BST
	public void inorderPrint() {
		if (left != null)
			left.inorderPrint();
		System.out.print(data + " ");
		if (right != null)
			right.inorderPrint();
	}

	public void preorderPrint() {
		System.out.print(data + " ");
		if (left != null)
			left.preorderPrint();
		if (right != null)
			right.preorderPrint();
	}

	public void postorderPrint() {
		if (left != null)
			left.postorderPrint();
		if (right != null)
			right.postorderPrint();
		System.out.print(data + " ");
	}

	@Override
	public String toString() {
		return data + "";
	}
}