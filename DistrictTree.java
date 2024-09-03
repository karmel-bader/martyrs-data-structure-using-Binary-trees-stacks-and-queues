package application;

import java.util.*;

public class DistrictTree implements Comparable<DistrictTree> {
	private String district;
	private BST<LocationTree> location;

	public DistrictTree(String district) {
		super();
		this.district = district;
		this.location = new BST<LocationTree>();
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public BST<LocationTree> getLocation() {
		return location;
	}

	public void setLocation(BST<LocationTree> location) {
		this.location = location;
	}

	@Override
	public int compareTo(DistrictTree o) {
		return this.district.toLowerCase().compareTo(o.getDistrict().toLowerCase());

	}

	@Override
	public String toString() {
		return district;
	}

	public void insertLocation(LocationTree data) {
		location.insert(data);
	}
	
	private int totalMartyrs(TNode<DateTree> node) {
		SingleNode<MartyrList> curr = node.getData().getMartyr().getHead();
		int counter = 0;
		while (curr != null) {
			curr = curr.getNext();
			counter++;
		}
		return counter;
	}

	public int countDateMartyrs(TNode<DateTree> node) {
		if (node == null)
			return 0;
		else {
			return Math.max(Math.max(totalMartyrs(node), countDateMartyrs(node.getLeft())),
					countDateMartyrs(node.getRight()));
		}
	}

	public DateTree maxDate(TNode<DateTree> node, int max) {
		if (node == null)
			return null;
		else {
			if(totalMartyrs(node) == max) {
				return node.getData();
			}
			DateTree maxLeft = maxDate(node.getLeft(),max);
			if(maxLeft != null) return maxLeft;
			DateTree maxRight = maxDate(node.getRight(),max);
			if(maxRight != null) return maxRight;
		}
		
		return null;
		
	}

	public TNode<DateTree> earliestMartyrDate(TNode<DateTree> node) {
		if (node == null)
			return null;
		if (node.getLeft() != null)
			return earliestMartyrDate(node.getLeft());
		return node;
	}

	public TNode<DateTree> latestMartyrDate(TNode<DateTree> node) {
		if (node == null)
			return null;
		if (node.getRight() != null)
			return earliestMartyrDate(node.getRight());
		return node;
	}

}
