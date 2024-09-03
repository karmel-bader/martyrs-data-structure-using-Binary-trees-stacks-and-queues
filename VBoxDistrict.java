package application;

import java.time.LocalDate;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class VBoxDistrict {
	private static VBox vDistrict = new VBox(5);
	private  static Label lblRes;
	private static Label lblResU;
	private static Label lblResD;
	private ComboBox<DistrictTree> comboDelete;
	private TextField tfInsert;
	private ComboBox<DistrictTree> comboUpdate;
	private TextField tfNew;

	public VBoxDistrict() {
		StackPane insert = new StackPane();
		insert.setAlignment(Pos.CENTER);
		Rectangle recInsert = new Rectangle(300, 150);
		recInsert.setArcWidth(50);
		recInsert.setArcHeight(50);
		recInsert.setStyle("-fx-stroke-width: 3px;-fx-fill:#990000;");
		HBox hInsert = new HBox(5);
		hInsert.setAlignment(Pos.CENTER);
		tfInsert = new TextField();
		tfInsert.setPrefColumnCount(10);
		Button bInsert = new Button("Insert");
		bInsert.setStyle(
				" -fx-font-weight: bold;-fx-font-family: 'Times New Roman'; -fx-font-size: 12px;-fx-background-color:white;");
		hInsert.getChildren().addAll(tfInsert, bInsert);
		VBox vInsert = new VBox(10);
		vInsert.setAlignment(Pos.CENTER);
		lblRes = new Label("");
		lblRes.setStyle(
				"-fx-font-style: italic; -fx-font-weight: bold; -fx-font-size: 15;-fx-font-family: 'Times New Roman';-fx-text-fill:#FFEECC;");
		Label lbl = new Label("To insert a new District Enter it's name");
		lbl.setStyle(
				"-fx-font-style: italic; -fx-font-weight: bold; -fx-font-size: 15;-fx-font-family: 'Times New Roman';-fx-text-fill: white;");
		vInsert.getChildren().addAll(lbl, hInsert, lblRes);
		insert.getChildren().addAll(recInsert, vInsert);

		StackPane delete = new StackPane();
		delete.setAlignment(Pos.CENTER);
		Rectangle recDelete = new Rectangle(300, 150);
		recDelete.setArcWidth(50);
		recDelete.setArcHeight(50);
		recDelete.setStyle("-fx-stroke-width: 3px;-fx-fill:#990000;");
		HBox hDelete = new HBox(5);
		hDelete.setAlignment(Pos.CENTER);
		comboDelete = new ComboBox<DistrictTree>();
		this.fillComboBox(comboDelete);
		comboDelete.setStyle("-fx-background-color: white;");
		comboDelete.setPrefWidth(150);
		Button bDelete = new Button("Delete");
		bDelete.setStyle(
				" -fx-font-weight: bold;-fx-font-family: 'Times New Roman'; -fx-font-size: 12px; -fx-background-color:white;");
		hDelete.getChildren().addAll(comboDelete, bDelete);
		VBox vDelete = new VBox(8);
		vDelete.setAlignment(Pos.CENTER);
		lblResD = new Label("");
		lblResD.setStyle(
				"-fx-font-style: italic; -fx-font-weight: bold; -fx-font-size: 15; -fx-font-family: 'Times New Roman';-fx-text-fill:#FFEECC;");
		Label lblD = new Label("To delete a District Enter it's name");
		lblD.setStyle(
				"-fx-font-style: italic; -fx-font-weight: bold; -fx-font-size: 15; -fx-font-family: 'Times New Roman';-fx-text-fill: white;");
		vDelete.getChildren().addAll(lblD, hDelete, lblResD);
		delete.getChildren().addAll(recDelete, vDelete);

		StackPane update = new StackPane();
		update.setAlignment(Pos.CENTER);
		Rectangle recUpdate = new Rectangle(450, 150);
		recUpdate.setArcWidth(50);
		recUpdate.setArcHeight(50);
		recUpdate.setStyle("-fx-stroke-width: 3px;-fx-fill:#990000;");
		HBox hUpdate = new HBox(8);
		hUpdate.setAlignment(Pos.CENTER);
		VBox vTf = new VBox(5);
		vTf.setAlignment(Pos.CENTER);
		comboUpdate = new ComboBox<DistrictTree>();
		this.fillComboBox(comboUpdate);
		comboUpdate.setStyle("-fx-background-color: white;");
		comboUpdate.setPrefWidth(150);
		tfNew = new TextField();
		tfNew.setPrefColumnCount(10);
		vTf.getChildren().addAll(comboUpdate, tfNew);
		Button bUpdate = new Button("Update");
		bUpdate.setStyle(
				" -fx-font-weight: bold;-fx-font-family: 'Times New Roman'; -fx-font-size: 12px;-fx-background-color:white;");
		hUpdate.getChildren().addAll(vTf, bUpdate);
		VBox vUpdate = new VBox(8);
		vUpdate.setAlignment(Pos.CENTER);
		lblResU = new Label("");
		lblResU.setStyle(
				"-fx-font-style: italic; -fx-font-weight: bold; -fx-font-size: 15; -fx-font-family: 'Times New Roman';-fx-text-fill:#FFEECC;");
		Label lblU = new Label(
				"To Update a District First Enter the old District,\n              Then enter the new District");
		lblU.setStyle(
				"-fx-font-style: italic; -fx-font-weight: bold; -fx-font-size: 15; -fx-font-family: 'Times New Roman'; -fx-text-fill: white;");
		vUpdate.getChildren().addAll(lblU, hUpdate, lblResU);
		update.getChildren().addAll(recUpdate, vUpdate);

		Image image = new Image(
				"https://scontent.fjrs2-2.fna.fbcdn.net/v/t1.15752-9/434373847_446103431201067_4416719034738146133_n.jpg?_nc_cat=104&ccb=1-7&_nc_sid=5f2048&_nc_ohc=3l0yupeO2bkQ7kNvgGvaBG1&_nc_ht=scontent.fjrs2-2.fna&oh=03_Q7cD1QGxCUimqAXRvNxTK957_83RB6S_ZDrPYp6T9RA9irZE1g&oe=665DB7FC");
		ImageView imageView = new ImageView(image);
		imageView.setFitHeight(120);
		imageView.setFitWidth(150);

		HBox hDistrict = new HBox(5);
		hDistrict.setAlignment(Pos.CENTER);
		hDistrict.getChildren().addAll(insert, delete);

		vDistrict.getChildren().addAll(hDistrict, update, imageView);
		vDistrict.setAlignment(Pos.CENTER);

		bInsert.setOnAction(e -> {
			if (tfInsert.getText().isBlank() == true) {
				lblRes.setText("The Text Field is Empty!");
				lblRes.setTextFill(Color.BLACK);
				return;
			} else {
				DistrictTree district = new DistrictTree(tfInsert.getText());
				if (Phase2Main.districtTree.insert(district) == false) {
					lblRes.setText("The District Exist Before");
					lblRes.setTextFill(Color.BLACK);
				} else {
					lblRes.setText("Added Successfully");
					lblRes.setStyle(
							"-fx-font-style: italic; -fx-font-weight: bold; -fx-font-size: 15;-fx-font-family: 'Times New Roman';-fx-text-fill:#FFEECC;");
					VBoxButtons.getStackNext().clear();
					VBoxButtons.getStackPrev().clear();
					comboDelete.getItems().clear();
					comboUpdate.getItems().clear();
					fillComboBox(comboDelete);
					fillComboBox(comboUpdate);
					Phase2Main.fillStack(Phase2Main.districtTree.getRoot());
					BorderPaneDistrict.setDistrictFromStack();
					VBoxButtonsLocation.getStackNext().clear();
					VBoxButtonsLocation.getStackPrev().clear();
					VBoxLocation.getComboDelete().getItems().clear();
					VBoxLocation.getComboUpdate().getItems().clear();
					Phase2Main.fillStack(BorderPaneDistrict.getDistrict().getLocation());
					BorderPaneLocation.getLblLocation().setText(VBoxButtonsLocation.getStackNext().peek() + "");
					BorderPaneLocation.setLocation(VBoxButtonsLocation.getStackNext().peek());
					VBoxButtonsDate.getStackNext().clear();
					VBoxButtonsDate.getStackPrev().clear();
					Phase2Main.fillStackDate(BorderPaneLocation.getLocation().getDate().getRoot());
					BorderPaneDate.getLblDate().setText(VBoxButtonsDate.getStackNext().peek() + "");
					BorderPaneDate.setDate(VBoxButtonsDate.getStackNext().peek());
				}
			}

		});

		bUpdate.setOnAction(e -> {
			Alert confirmation = new Alert(Alert.AlertType.CONFIRMATION);
			confirmation.setTitle("Confirmation");
			confirmation.setHeaderText("Are you sure you want to Update this district?");
			confirmation.setContentText("Any unsaved changes will be lost.");
			confirmation.showAndWait().ifPresent(response -> {
				if (response == ButtonType.OK) {
					if (comboUpdate.getValue() == null || tfNew.getText().isBlank()) {
						lblResU.setText("Fill The Required Fields!");
						lblResU.setTextFill(Color.BLACK);
					} else {
						DistrictTree newDistrict = new DistrictTree(tfNew.getText());
						if (Phase2Main.districtTree.update(comboUpdate.getValue(), newDistrict) == true) {
							lblResU.setText("Updated Successfully");
							lblResU.setStyle(
									"-fx-font-style: italic; -fx-font-weight: bold; -fx-font-size: 15;-fx-font-family: 'Times New Roman';-fx-text-fill:#FFEECC;");
						
							VBoxButtons.getStackNext().clear();
							VBoxButtons.getStackPrev().clear();
							comboDelete.getItems().clear();
							comboUpdate.getItems().clear();
							fillComboBox(comboDelete);
							fillComboBox(comboUpdate);
							Phase2Main.fillStack(Phase2Main.districtTree.getRoot());
							BorderPaneDistrict.setDistrictFromStack();
							VBoxButtonsLocation.getStackNext().clear();
							VBoxButtonsLocation.getStackPrev().clear();
							VBoxLocation.getComboDelete().getItems().clear();
							VBoxLocation.getComboUpdate().getItems().clear();
							Phase2Main.fillStack(BorderPaneDistrict.getDistrict().getLocation());
							BorderPaneLocation.getLblLocation().setText(VBoxButtonsLocation.getStackNext().peek() + "");
							BorderPaneLocation.setLocation(VBoxButtonsLocation.getStackNext().peek());
							VBoxButtonsDate.getStackNext().clear();
							VBoxButtonsDate.getStackPrev().clear();
							Phase2Main.fillStackDate(BorderPaneLocation.getLocation().getDate().getRoot());
							BorderPaneDate.getLblDate().setText(VBoxButtonsDate.getStackNext().peek() + "");
							BorderPaneDate.setDate(VBoxButtonsDate.getStackNext().peek());
						} else {
							lblResU.setText("The New District Exist Before");
							lblResU.setTextFill(Color.BLACK);
							
						}
					}
				}
			});

		});

		bDelete.setOnAction(e -> {
			Alert confirmation = new Alert(Alert.AlertType.CONFIRMATION);
			confirmation.setTitle("Confirmation");
			confirmation.setHeaderText("Are you sure you want to delete the district?");
			confirmation.setContentText("Any unsaved changes will be lost.");
			confirmation.showAndWait().ifPresent(response -> {
				if (response == ButtonType.OK) {
					if (comboDelete.getValue() == null) {
						lblResD.setText("Choose A District!");
						lblResD.setTextFill(Color.BLACK);
						return;
					} else {
						Phase2Main.districtTree.delete(comboDelete.getValue());
						lblResD.setText("Deleted Successfully");
						lblResD.setStyle(
								"-fx-font-style: italic; -fx-font-weight: bold; -fx-font-size: 15;-fx-font-family: 'Times New Roman';-fx-text-fill:#FFEECC;");
						VBoxButtons.getStackNext().clear();
						VBoxButtons.getStackPrev().clear();
						comboUpdate.getItems().remove(comboDelete.getValue());
						comboDelete.getItems().remove(comboDelete.getValue());
						Phase2Main.fillStack(Phase2Main.districtTree.getRoot());
						BorderPaneDistrict.setDistrictFromStack();
						VBoxButtonsLocation.getStackNext().clear();
						VBoxButtonsLocation.getStackPrev().clear();
						VBoxLocation.getComboDelete().getItems().clear();
						VBoxLocation.getComboUpdate().getItems().clear();
						Phase2Main.fillStack(BorderPaneDistrict.getDistrict().getLocation());
						BorderPaneLocation.getLblLocation().setText(VBoxButtonsLocation.getStackNext().peek() + "");
						BorderPaneLocation.setLocation(VBoxButtonsLocation.getStackNext().peek());
						VBoxButtonsDate.getStackNext().clear();
						VBoxButtonsDate.getStackPrev().clear();
						Phase2Main.fillStackDate(BorderPaneLocation.getLocation().getDate().getRoot());
						BorderPaneDate.getLblDate().setText(VBoxButtonsDate.getStackNext().peek() + "");
						BorderPaneDate.setDate(VBoxButtonsDate.getStackNext().peek());
						
						
						
					}
				}
			});

		});

	}

	public static VBox getvDistrict() {
		return vDistrict;
	}

	public static void setvDistrict(VBox vDistrict) {
		VBoxDistrict.vDistrict = vDistrict;
	}

	public void fillComboBox(ComboBox<DistrictTree> box) {
		fillComboBox(Phase2Main.districtTree.getRoot(), box);
	}

	private void fillComboBox(TNode<DistrictTree> node, ComboBox<DistrictTree> box) {
		if (node != null) {
			if (node.getLeft() != null)
				fillComboBox(node.getLeft(), box);
			box.getItems().add(node.getData());
			if (node.getRight() != null)
				fillComboBox(node.getRight(), box);
		}
	}
	
	public static void clear() {
		lblRes.setText("");
		lblResD.setText("");
		lblResU.setText("");
		
	}

}

