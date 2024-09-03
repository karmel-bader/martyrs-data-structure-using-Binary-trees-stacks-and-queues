package application;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;


public class VBoxButtons {
	private VBox vButtons = new VBox(10);
	private static Button next;
	private static Button prev;
	private static QStack<DistrictTree> stackNext;
	private static QStack<DistrictTree> stackPrev;

	public VBoxButtons() {
		stackNext = new QStack<DistrictTree>();
		stackPrev = new QStack<DistrictTree>();
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
		hButtons.getChildren().addAll(prev, next, load);
		vButtons.getChildren().addAll(hButtons, lbl);

		next.setOnAction(e -> {
			VBoxDistrict.clear();
			lbl.setText("");
			prev.setDisable(false);
			stackPrev.push(stackNext.pop());
			if (stackNext.isEmpty()) {
				stackNext.push(stackPrev.pop());
			}
			BorderPaneDistrict.setNode(Phase2Main.districtTree.find(VBoxButtons.getStackNext().peek()));
			BorderPaneDistrict.getLblDistrict().setText(stackNext.peek() + "");
			BorderPaneDistrict.setDistrict(stackNext.peek());
			BorderPaneDistrict.getTotalMartyrs().setText("               In This District, \n The Total Number Of Martyrs is \n                         "
					+ Phase2Main.totalNumberOfMartyr(stackNext.peek().getLocation().getRoot()));

		});

		prev.setOnAction(e -> {
			VBoxDistrict.clear();
			lbl.setText("");
			if (!stackPrev.isEmpty()) {
				stackNext.push(stackPrev.pop());
				BorderPaneDistrict.setNode(Phase2Main.districtTree.find(VBoxButtons.getStackNext().peek()));
				BorderPaneDistrict.getLblDistrict().setText(stackNext.peek() + "");
				BorderPaneDistrict.setDistrict(stackNext.peek());
				BorderPaneDistrict.getTotalMartyrs().setText("               In This District, \n The Total Number Of Martyrs is \n                       "
						+ Phase2Main.totalNumberOfMartyr(stackNext.peek().getLocation().getRoot()));
			}
		});
		
		load.setOnAction(e ->{
			if(BorderPaneDistrict.getDistrict().getLocation().getRoot() == null) {
				lbl.setText("This District dose Not Has Locations");
				lbl.setTextFill(Color.RED);
				return;
			}
			if(BorderPaneDistrict.getDistrict() != null) {
				VBoxButtonsLocation.getStackNext().clear();
				VBoxButtonsLocation.getStackPrev().clear();
				VBoxLocation.getComboDelete().getItems().clear();
				VBoxLocation.getComboUpdate().getItems().clear();
				Phase2Main.fillStack(BorderPaneDistrict.getDistrict().getLocation());
				BorderPaneLocation.getLblLocation().setText(VBoxButtonsLocation.getStackNext().peek() + "");
				BorderPaneLocation.setLocation(VBoxButtonsLocation.getStackNext().peek());
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
		VBoxButtons.next = next;
	}

	public static Button getPrev() {
		return prev;
	}

	public static void setPrev(Button prev) {
		VBoxButtons.prev = prev;
	}

	public static QStack<DistrictTree> getStackNext() {
		return stackNext;
	}

	public static void setStackNext(QStack<DistrictTree> stackNext) {
		VBoxButtons.stackNext = stackNext;
	}

	public static QStack<DistrictTree> getStackPrev() {
		return stackPrev;
	}

	public static void setStackPrev(QStack<DistrictTree> stackPrev) {
		VBoxButtons.stackPrev = stackPrev;
	}

	

	
}

