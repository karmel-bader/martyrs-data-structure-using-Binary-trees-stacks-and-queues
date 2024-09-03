package application;

public class BST<T extends Comparable<T>> {
	private TNode<T> root;

	public boolean insert(T data) {
		if (this.find(data) != null)
			return false;
		if (root == null) {
			root = new TNode<T>(data);
			return true;
		} else {
			this.insert(data, root);
			return true;
		}
	}

	public void insert(T data, TNode<T> node) {
		if (data.compareTo(node.getData()) > 0) {
			if (!node.hasRight())
				node.setRight(new TNode<T>(data));
			else
				insert(data, node.getRight());
		} else if (data.compareTo(node.getData()) < 0) {
			if (!node.hasLeft())
				node.setLeft(new TNode<T>(data));
			else
				insert(data, node.getLeft());
		} else
			return;
	}

	public TNode<T> find(T data) {
		return find(data, root);

	}

	public TNode<T> find(T data, TNode<T> node) {
		if (node != null) {
			int comp = node.getData().compareTo(data);
			if (comp == 0)
				return node;
			else if (comp > 0 && node.hasLeft())
				return find(data, node.getLeft());
			else if (comp < 0 && node.hasRight())
				return find(data, node.getRight());
		}
		return null;
	}

	public int height(TNode<T> node) {
		if (node == null)
			return 0;
		if (node.isLeaf())
			return 1;
		int left = 0;
		int right = 0;
		if (node.hasLeft())
			left = height(node.getLeft());
		if (node.hasRight())
			right = height(node.getRight());
		return (left > right) ? (left + 1) : (right + 1);
	}

	public TNode<T> delete(T data) {
		TNode<T> current = root;
		TNode<T> parent = root;
		boolean isLeftChild = false;

		if (root == null)
			return null;// tree is empty
		while (current != null && !current.getData().equals(data)) {
			parent = current;
			if (data.compareTo((T) current.getData()) < 0) {
				current = current.getLeft();
				isLeftChild = true;
			} else {
				current = current.getRight();
				isLeftChild = false;
			}
		}
		if (current == null)
			return null; // node to be deleted not found

		// case 1: node is a leaf
		if (!current.hasLeft() && !current.hasRight()) {
			if (current == root) // tree has one node
				root = null;
			else {
				if (isLeftChild)
					parent.setLeft(null);
				else
					parent.setRight(null);
			}
			return current;
		}
		// other cases

		if (current.hasLeft() && !current.hasRight()) { // current has left child only
			if (current == root) {
				root = current.getLeft();
			} else if (isLeftChild) {
				parent.setLeft(current.getLeft());
			} else {
				parent.setRight(current.getLeft());
			}
		} else if (current.hasRight() && !current.hasLeft()) { // current has right child only
			if (current == root) {
				root = current.getRight();
			} else if (isLeftChild) {
				parent.setLeft(current.getRight());
			} else {
				parent.setRight(current.getRight());
			}
			return current;
		} else {
			TNode<T> successor = getSuccessor(current);
			if (current == root)
				root = successor;
			else if (isLeftChild) {
				parent.setLeft(successor);
			} else {
				parent.setRight(successor);
			}
			successor.setLeft(current.getLeft());
			return current;
		}
		return null;

	}

	private TNode<T> getSuccessor(TNode<T> node) {
		TNode<T> parentOfSuccessor = node;
		TNode<T> successor = node;
		TNode<T> current = node.getRight();
		while (current != null) {
			parentOfSuccessor = successor;
			successor = current;
			current = current.getLeft();
		}
		if (successor != node.getRight()) { // fix successor connections
			parentOfSuccessor.setLeft(successor.getRight());
			successor.setRight(node.getRight());
		}
		return successor;
	}

	public void traversalInOrder() {
		traversalInOrder(root);
	}

	private void traversalInOrder(TNode<T> node) {
		if (node != null) {
			if (node.getLeft() != null)
				traversalInOrder(node.getLeft());
			System.out.print(node + " ");
			if (node.getData() instanceof DistrictTree)
				((DistrictTree) node.getData()).getLocation().traversalInOrder();
			if (node.getRight() != null)
				traversalInOrder(node.getRight());
		}
	}

	public boolean update(T oldData, T newData) {
		if (this.find(newData) != null)
			return false;
		TNode<T> findData = this.find(oldData);
		TNode<T> findNew = this.find(oldData);
		this.delete(findData.getData());
		if (newData instanceof DistrictTree) {
			((DistrictTree) findNew.getData()).setDistrict(((DistrictTree) newData).getDistrict());
		}else if (newData instanceof LocationTree) {
			((LocationTree) findNew.getData()).setLocation(((LocationTree) newData).getLocation());
		}
		this.insert(findNew.getData());
		return true;
	}

	public TNode<T> getRoot() {
		return root;
	}

	public void setRoot(TNode<T> root) {
		this.root = root;
	}
}
