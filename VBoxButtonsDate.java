package application;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class VBoxButtonsDate {

	private VBox vButtons = new VBox(10);
	private static Button next;
	private static Button prev;
	private static QStack<DateTree> stackNext;
	private static QStack<DateTree> stackPrev;
	

	public VBoxButtonsDate() {
		stackNext = new QStack<DateTree>();
		stackPrev = new QStack<DateTree>();
		vButtons.setAlignment(Pos.CENTER);
		HBox hButtons = new HBox(10);
		hButtons.setAlignment(Pos.CENTER);
		next = new Button("Next");
		next.setStyle(
				" -fx-font-weight: bold;-fx-font-family: 'Times New Roman'; -fx-font-size: 12px;-fx-background-color:#990000; -fx-text-fill:white;");
		prev = new Button("Previous");
		prev.setStyle(
				" -fx-font-weight: bold;-fx-font-family: 'Times New Roman'; -fx-font-size: 12px;-fx-background-color:#990000; -fx-text-fill:white;");
		hButtons.getChildren().addAll(prev, next);
		vButtons.getChildren().add(hButtons);
		
		
		next.setOnAction(e ->{
			VBoxDate.clear();
			prev.setDisable(false);
			stackPrev.push(stackNext.pop());
			if (stackNext.isEmpty()) {
				stackNext.push(stackPrev.pop());
			}
			BorderPaneDate.getLblDate().setText(stackNext.peek() + "");
			BorderPaneDate.setDate(stackNext.peek());
			BorderPaneDate.getYoungest().setText("The Youngest Martyr is " + BorderPaneDate.getDate().youngest(stackNext.peek().getMartyr()));
			BorderPaneDate.getOldest().setText("The Oldest Martyr is " + BorderPaneDate.getDate().oldest(stackNext.peek().getMartyr()));
			BorderPaneDate.getAvgAge().setText("The Average Age is " + BorderPaneDate.getDate().avgAge(stackNext.peek().getMartyr().getHead()));
		});
		
		prev.setOnAction(e ->{
			VBoxDate.clear();
			if (!stackPrev.isEmpty()) {
				stackNext.push(stackPrev.pop());
				BorderPaneDate.getLblDate().setText(stackNext.peek() + "");
				BorderPaneDate.setDate(stackNext.peek());
				BorderPaneDate.getYoungest().setText("The Youngest Martyr is " + BorderPaneDate.getDate().youngest(stackNext.peek().getMartyr()));
				BorderPaneDate.getOldest().setText("The Oldest Martyr is " + BorderPaneDate.getDate().oldest(stackNext.peek().getMartyr()));
				BorderPaneDate.getAvgAge().setText("The Average Age is " + BorderPaneDate.getDate().avgAge(stackNext.peek().getMartyr().getHead()));
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
		VBoxButtonsDate.next = next;
	}

	public static Button getPrev() {
		return prev;
	}

	public static void setPrev(Button prev) {
		VBoxButtonsDate.prev = prev;
	}

	public static QStack<DateTree> getStackNext() {
		return stackNext;
	}

	public static void setStackNext(QStack<DateTree> stackNext) {
		VBoxButtonsDate.stackNext = stackNext;
	}

	public static QStack<DateTree> getStackPrev() {
		return stackPrev;
	}

	public static void setStackPrev(QStack<DateTree> stackPrev) {
		VBoxButtonsDate.stackPrev = stackPrev;
	}

	
	
	

}
