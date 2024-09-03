package application;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class VBoxButtonsLocation {
	private VBox vButtons = new VBox(10);
	private static Button next;
	private static Button prev;
	private static QStack<LocationTree> stackNext;
	private static QStack<LocationTree> stackPrev;
	

	public VBoxButtonsLocation() {
		stackNext = new QStack<LocationTree>();
		stackPrev = new QStack<LocationTree>();
		vButtons.setAlignment(Pos.CENTER);
		HBox hButtons = new HBox(10);
		Label lbl = new Label("");
		lbl.setStyle(
				"-fx-font-style: italic; -fx-font-weight: bold;-fx-font-family: 'Times New Roman'; -fx-font-size: 12px;");
		hButtons.setAlignment(Pos.CENTER);
		next = new Button("Next");
		next.setStyle(
				" -fx-font-weight: bold;-fx-font-family: 'Times New Roman'; -fx-font-size: 12px;-fx-background-color:#990000; -fx-text-fill:white;");
		prev = new Button("Previous");
		prev.setStyle(
				" -fx-font-weight: bold;-fx-font-family: 'Times New Roman'; -fx-font-size: 12px;-fx-background-color:#990000; -fx-text-fill:white;");
		prev.setDisable(true);
		Button load = new Button("Load");
		load.setStyle(
				" -fx-font-weight: bold;-fx-font-family: 'Times New Roman'; -fx-font-size: 12px;-fx-background-color:#990000; -fx-text-fill:white;");
		hButtons.getChildren().addAll(prev, next,load);
		vButtons.getChildren().addAll(hButtons, lbl);
		
		next.setOnAction(e ->{
			VBoxLocation.clear();
			lbl.setText("");
			prev.setDisable(false);
			stackPrev.push(stackNext.pop());
			if (stackNext.isEmpty()) {
				stackNext.push(stackPrev.pop());
			}
			BorderPaneLocation.getLblLocation().setText(stackNext.peek() + "");
			BorderPaneLocation.setLocation(stackNext.peek());
			BorderPaneLocation.getMaxDate().setText("The Max Date is " + BorderPaneDistrict.getDistrict().maxDate(stackNext.peek().getDate().getRoot(),BorderPaneDistrict.getDistrict().countDateMartyrs(BorderPaneLocation.getLocation().getDate().getRoot())));
			BorderPaneLocation.getEarliest().setText("The earlist Date is " + BorderPaneDistrict.getDistrict().earliestMartyrDate(stackNext.peek().getDate().getRoot()));
			BorderPaneLocation.getLastest().setText("The Latest Date is " + BorderPaneDistrict.getDistrict().latestMartyrDate(stackNext.peek().getDate().getRoot()));
		});
		
		prev.setOnAction(e ->{
			VBoxLocation.clear();
			lbl.setText("");
			if (!stackPrev.isEmpty()) {
				stackNext.push(stackPrev.pop());
				BorderPaneLocation.getLblLocation().setText(stackNext.peek() + "");
				BorderPaneLocation.setLocation(stackNext.peek());
				BorderPaneLocation.getMaxDate().setText("The Max Date is " + BorderPaneDistrict.getDistrict().maxDate(stackNext.peek().getDate().getRoot(),BorderPaneDistrict.getDistrict().countDateMartyrs(BorderPaneLocation.getLocation().getDate().getRoot())));
				BorderPaneLocation.getEarliest().setText("The earlist Date is " + BorderPaneDistrict.getDistrict().earliestMartyrDate(stackNext.peek().getDate().getRoot()));
				BorderPaneLocation.getLastest().setText("The Latest Date is " + BorderPaneDistrict.getDistrict().latestMartyrDate(stackNext.peek().getDate().getRoot()));

			}
		});
		
		load.setOnAction(e ->{
			
			if(BorderPaneLocation.getLocation().getDate().getRoot() == null) {
				lbl.setText("This Location dose Not Has Locations");
				lbl.setTextFill(Color.RED);
				return;
			}
			if(BorderPaneLocation.getLocation() != null) {
				VBoxButtonsDate.getStackNext().clear();
				VBoxButtonsDate.getStackPrev().clear();
				Phase2Main.fillStackDate(BorderPaneLocation.getLocation().getDate().getRoot());
				BorderPaneDate.getLblDate().setText(VBoxButtonsDate.getStackNext().peek() + "");
				BorderPaneDate.setDate(VBoxButtonsDate.getStackNext().peek());
				BorderPaneDate.getYoungest().setText("The Youngest Martyr is " + BorderPaneDate.getDate().youngest(VBoxButtonsDate.getStackNext().peek().getMartyr()));
				BorderPaneDate.getOldest().setText("The Oldest Martyr is " + BorderPaneDate.getDate().oldest(VBoxButtonsDate.getStackNext().peek().getMartyr()));
				BorderPaneDate.getAvgAge().setText("The Average Age is " + BorderPaneDate.getDate().avgAge(VBoxButtonsDate.getStackNext().peek().getMartyr().getHead()));
				lbl.setText("Loaded Successfully");
				lbl.setTextFill(Color.GREEN);
				
			}
		});

	}

	public VBox getvButtons() {
		return vButtons;
	}

	public void setvButtons(VBox vButtons) {
		this.vButtons = vButtons;
	}

	public static Button getNext() {
		return next;
	}

	public static void setNext(Button next) {
		VBoxButtonsLocation.next = next;
	}

	public static Button getPrev() {
		return prev;
	}

	public static void setPrev(Button prev) {
		VBoxButtonsLocation.prev = prev;
	}

	public static QStack<LocationTree> getStackNext() {
		return stackNext;
	}

	public static void setStackNext(QStack<LocationTree> stackNext) {
		VBoxButtonsLocation.stackNext = stackNext;
	}

	public static QStack<LocationTree> getStackPrev() {
		return stackPrev;
	}

	public static void setStackPrev(QStack<LocationTree> stackPrev) {
		VBoxButtonsLocation.stackPrev = stackPrev;
	}

	
	
	

}

