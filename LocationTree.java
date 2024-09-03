package application;

public class LocationTree implements Comparable<LocationTree>{
	private String location;
	private BST<DateTree> date;

	

	public LocationTree(String location) {
		this.location = location;
		date = new BST<DateTree>();
		
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	
	public BST<DateTree> getDate() {
		return date;
	}

	public void setDate(BST<DateTree> date) {
		this.date = date;
		
	}

	@Override
	public int compareTo(LocationTree o) {
		return this.location.toLowerCase().compareTo(o.getLocation().toLowerCase());
	}


	@Override
	public String toString() {
		return  this.location;
	}


	

}
