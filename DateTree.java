package application;

import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class DateTree implements Comparable<DateTree> {
	private Date date;
	private SingleLinkedList<MartyrList> martyr;
	
	
	public DateTree(Date date) {
		super();
		this.date = date;
		martyr = new SingleLinkedList<MartyrList>();
	}


	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}


	public SingleLinkedList<MartyrList> getMartyr() {
		return martyr;
	}


	public void setMartyr(SingleLinkedList<MartyrList> martyr) {
		this.martyr = martyr;
	}


	@Override
	public int compareTo(DateTree o) {
		return this.date.compareTo(o.date);
	}


	@Override
	public String toString() {
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		String formatDate = sdf.format(date);
		return formatDate;
	}
	
	public SingleNode<MartyrList> youngest(SingleLinkedList<MartyrList> node) {
		return node.getHead();
	}
	
	public SingleNode<MartyrList> oldest(SingleLinkedList<MartyrList> node){
		return node.getTail();
	}
	
	public double avgAge(SingleNode<MartyrList> node) {
		double avg = 0.0;
		int counter = 0;
		double ages = 0.0;
		SingleNode<MartyrList> martyrs = node;
		while(martyrs != null) {
			counter++;
			ages = ages  + martyrs.getData().getAge();
			martyrs = martyrs.getNext();
		}
		
		avg = ages/counter;
		return avg;
	}
	
	public void searchByName(DateTree node){
		SingleNode<MartyrList> searchMar = node.getMartyr().getHead();
		while(searchMar != null) {
			if(searchMar.getData().getName().contains(VBoxDate.getTfSearch().getText())) {
				VBoxDate.getData().add(searchMar.getData());
			}
			searchMar = searchMar.getNext();
		}
		
	}
	
	public void search(DateTree node) {
		SingleNode<MartyrList> searchAllMar = node.getMartyr().getHead();
		BorderPaneDate.getData().clear();
		while(searchAllMar != null) {
			BorderPaneDate.getData().add(searchAllMar.getData());
			searchAllMar = searchAllMar.getNext();
		}
	}
}



















