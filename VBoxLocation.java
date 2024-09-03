package application;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class VBoxLocation {
	private VBox vLocation = new VBox(5);
	private static Label lblRes;
	private static Label lblResD;
	private static Label lblResU;
	private TextField tfInsert;
	private static ComboBox<LocationTree> comboDelete;
	private static ComboBox<LocationTree> comboUpdate;
	private TextField tfNew;

	public VBox getvLocation() {
		return vLocation;
	}

	public void setvLocation(VBox vLocation) {
		this.vLocation = vLocation;
	}

	public Label getLblRes() {
		return lblRes;
	}

	public void setLblRes(Label lblRes) {
		this.lblRes = lblRes;
	}

	public Label getLblResD() {
		return lblResD;
	}

	public void setLblResD(Label lblResD) {
		this.lblResD = lblResD;
	}

	public Label getLblResU() {
		return lblResU;
	}

	public void setLblResU(Label lblResU) {
		this.lblResU = lblResU;
	}


	public TextField getTfInsert() {
		return tfInsert;
	}

	public void setTfInsert(TextField tfInsert) {
		this.tfInsert = tfInsert;
	}

	public TextField getTfNew() {
		return tfNew;
	}

	public void setTfNew(TextField tfNew) {
		this.tfNew = tfNew;
	}
	

	public static ComboBox<LocationTree> getComboDelete() {
		return comboDelete;
	}

	public static void setComboDelete(ComboBox<LocationTree> comboDelete) {
		VBoxLocation.comboDelete = comboDelete;
	}


	public static ComboBox<LocationTree> getComboUpdate() {
		return comboUpdate;
	}

	public static void setComboUpdate(ComboBox<LocationTree> comboUpdate) {
		VBoxLocation.comboUpdate = comboUpdate;
	}

	public VBoxLocation() {
		Stage stage = new Stage();
		stage.setTitle("Martyr Operations");

		StackPane insert = new StackPane();
		insert.setAlignment(Pos.CENTER);
		Rectangle recInsert = new Rectangle(300, 150);
		recInsert.setStyle("-fx-stroke-width: 3px;-fx-fill:#990000;");
		recInsert.setArcWidth(50);
		recInsert.setArcHeight(50);
		HBox hInsert = new HBox(5);
		hInsert.setAlignment(Pos.CENTER);
		tfInsert = new TextField();
		tfInsert.setPrefColumnCount(10);
		Button bInsert = new Button("Insert");
		bInsert.setStyle(
				"-fx-font-weight: bold;-fx-font-family: 'Times New Roman'; -fx-font-size: 12px;-fx-background-color: white;");
		hInsert.getChildren().addAll(tfInsert, bInsert);
		VBox vInsert = new VBox(10);
		vInsert.setAlignment(Pos.CENTER);
		lblRes = new Label("");
		lblRes.setStyle(
				"-fx-font-style: italic; -fx-font-weight: bold; -fx-font-size: 15;-fx-font-family: 'Times New Roman';-fx-text-fill:#FFEECC;");
		Label lbl = new Label("To insert a new Loaction Enter it's name");
		lbl.setTextFill(Color.WHITE);
		lbl.setStyle(
				"-fx-font-style: italic;-fx-font-weight: bold;-fx-font-family: 'Times New Roman'; -fx-font-size: 15px;");
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
		comboDelete = new ComboBox<LocationTree>();
		this.fillComboBox(comboDelete);
		comboDelete.setStyle("-fx-background-color: white;");
		comboDelete.setPrefWidth(150);
		Button bDelete = new Button("Delete");
		bDelete.setStyle(
				"-fx-font-weight: bold;-fx-font-family: 'Times New Roman'; -fx-font-size: 12px;-fx-background-color: white;");
		hDelete.getChildren().addAll(comboDelete, bDelete);
		VBox vDelete = new VBox(8);
		vDelete.setAlignment(Pos.CENTER);
		lblResD = new Label("");
		lblResD.setStyle(
				"-fx-font-style: italic; -fx-font-weight: bold; -fx-font-size: 15;-fx-font-family: 'Times New Roman';-fx-text-fill:#FFEECC;");
		Label lblD = new Label("To delete a Location Enter it's name");
		lblD.setTextFill(Color.WHITE);
		lblD.setStyle(
				"-fx-font-style: italic;-fx-font-weight: bold;-fx-font-family: 'Times New Roman'; -fx-font-size: 15px;");
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
		comboUpdate = new ComboBox<LocationTree>();
		this.fillComboBox(comboUpdate);
		comboUpdate.setStyle("-fx-background-color: white;");
		comboUpdate.setPrefWidth(150);
		tfNew = new TextField();
		tfNew.setPrefColumnCount(10);
		vTf.getChildren().addAll(comboUpdate, tfNew);
		Button bUpdate = new Button("Update");
		bUpdate.setStyle(
				"-fx-font-weight: bold;-fx-font-family: 'Times New Roman'; -fx-font-size: 12px;-fx-background-color: white;");
		hUpdate.getChildren().addAll(vTf, bUpdate);
		VBox vUpdate = new VBox(8);
		vUpdate.setAlignment(Pos.CENTER);
		lblResU = new Label("");
		lblResU.setStyle(
				"-fx-font-style: italic; -fx-font-weight: bold; -fx-font-size: 15;-fx-font-family: 'Times New Roman';-fx-text-fill:#FFEECC;");
		Label lblU = new Label(
				"To Update a Location First Enter the old Location,\n               Then enter the new Location");
		lblU.setTextFill(Color.WHITE);
		lblU.setStyle(
				"-fx-font-style: italic;-fx-font-weight: bold; -fx-font-size: 15px;-fx-font-family: 'Times New Roman'");
		vUpdate.getChildren().addAll(lblU, hUpdate, lblResU);
		update.getChildren().addAll(recUpdate, vUpdate);

		Image image = new Image(
				"https://scontent.fjrs2-2.fna.fbcdn.net/v/t1.15752-9/434373847_446103431201067_4416719034738146133_n.jpg?_nc_cat=104&ccb=1-7&_nc_sid=5f2048&_nc_ohc=3l0yupeO2bkQ7kNvgGvaBG1&_nc_ht=scontent.fjrs2-2.fna&oh=03_Q7cD1QGxCUimqAXRvNxTK957_83RB6S_ZDrPYp6T9RA9irZE1g&oe=665DB7FC");
		ImageView imageView = new ImageView(image);
		imageView.setFitHeight(120);
		imageView.setFitWidth(150);

		HBox hLocation = new HBox(5);
		hLocation.setAlignment(Pos.CENTER);
		hLocation.getChildren().addAll(insert, delete);

		vLocation.getChildren().addAll(hLocation, update, imageView);
		vLocation.setAlignment(Pos.CENTER);

		bInsert.setOnAction(e -> {
			if (tfInsert.getText().isBlank() == true) {
				lblRes.setText("The Box Is Empty!");
				lblRes.setTextFill(Color.BLACK);
				return;
			} else {
				LocationTree location = new LocationTree(tfInsert.getText());
				if (BorderPaneDistrict.getNode().getData().getLocation().insert(location) == false) {
					lblRes.setText("The Location Exist Before");
					lblRes.setTextFill(Color.BLACK);
				} else {
					lblRes.setText("Added Successfully");
					lblRes.setStyle(
							"-fx-font-style: italic; -fx-font-weight: bold; -fx-font-size: 15;-fx-font-family: 'Times New Roman';-fx-text-fill:#FFEECC;");
					VBoxButtonsLocation.getStackNext().clear();
					VBoxButtonsLocation.getStackPrev().clear();
					comboUpdate.getItems().clear();
					comboDelete.getItems().clear();
					Phase2Main.fillStack(BorderPaneDistrict.getDistrict().getLocation());
					BorderPaneLocation.getLblLocation().setText(VBoxButtonsLocation.getStackNext().peek() + "");
					BorderPaneLocation.setLocation(VBoxButtonsLocation.getStackNext().peek());
					BorderPaneLocation.getMaxDate().setText("The Max Date is " + BorderPaneDistrict.getDistrict().maxDate(VBoxButtonsLocation.getStackNext().peek().getDate().getRoot(),BorderPaneDistrict.getDistrict().countDateMartyrs(BorderPaneLocation.getLocation().getDate().getRoot())));
					BorderPaneLocation.getEarliest().setText("The earlist Date is " + BorderPaneDistrict.getDistrict().earliestMartyrDate(VBoxButtonsLocation.getStackNext().peek().getDate().getRoot()));
					BorderPaneLocation.getLastest().setText("The Latest Date is " + BorderPaneDistrict.getDistrict().latestMartyrDate(VBoxButtonsLocation.getStackNext().peek().getDate().getRoot()));
					VBoxButtonsDate.getStackNext().clear();
					VBoxButtonsDate.getStackPrev().clear();
					Phase2Main.fillStackDate(BorderPaneLocation.getLocation().getDate().getRoot());
					BorderPaneDate.getLblDate().setText(VBoxButtonsDate.getStackNext().peek() + "");
					BorderPaneDate.setDate(VBoxButtonsDate.getStackNext().peek());
				}
			}
		});

		bDelete.setOnAction(e -> {
			Alert confirmation = new Alert(Alert.AlertType.CONFIRMATION);
			confirmation.setTitle("Confirmation");
			confirmation.setHeaderText("Are you sure you want to delete the location?");
			confirmation.setContentText("Any unsaved changes will be lost.");
			confirmation.showAndWait().ifPresent(response -> {
				if (response == ButtonType.OK) {
					if (comboDelete.getValue() == null) {
						lblResD.setText("Choose A Location!");
						lblResD.setTextFill(Color.BLACK);
						return;
					} else {
						BorderPaneDistrict.getNode().getData().getLocation().delete(comboDelete.getValue());
						lblResD.setText("Deleted Successfully");
						lblResD.setStyle(
								"-fx-font-style: italic; -fx-font-weight: bold; -fx-font-size: 15;-fx-font-family: 'Times New Roman';-fx-text-fill:#FFEECC;");
						VBoxButtonsLocation.getStackNext().clear();
						VBoxButtonsLocation.getStackPrev().clear();
						comboUpdate.getItems().clear();
						comboDelete.getItems().clear();
						Phase2Main.fillStack(BorderPaneDistrict.getDistrict().getLocation());
						BorderPaneLocation.getLblLocation().setText(VBoxButtonsLocation.getStackNext().peek() + "");
						BorderPaneLocation.setLocation(VBoxButtonsLocation.getStackNext().peek());
						BorderPaneLocation.getMaxDate().setText("The Max Date is " + BorderPaneDistrict.getDistrict().maxDate(VBoxButtonsLocation.getStackNext().peek().getDate().getRoot(),BorderPaneDistrict.getDistrict().countDateMartyrs(BorderPaneLocation.getLocation().getDate().getRoot())));
						BorderPaneLocation.getEarliest().setText("The earlist Date is " + BorderPaneDistrict.getDistrict().earliestMartyrDate(VBoxButtonsLocation.getStackNext().peek().getDate().getRoot()));
						BorderPaneLocation.getLastest().setText("The Latest Date is " + BorderPaneDistrict.getDistrict().latestMartyrDate(VBoxButtonsLocation.getStackNext().peek().getDate().getRoot()));
						VBoxButtonsDate.getStackNext().clear();
						VBoxButtonsDate.getStackPrev().clear();
						Phase2Main.fillStackDate(BorderPaneLocation.getLocation().getDate().getRoot());
						BorderPaneDate.getLblDate().setText(VBoxButtonsDate.getStackNext().peek() + "");
						BorderPaneDate.setDate(VBoxButtonsDate.getStackNext().peek());
					}
				}
			});

		});

		bUpdate.setOnAction(e -> {
			Alert confirmation = new Alert(Alert.AlertType.CONFIRMATION);
			confirmation.setTitle("Confirmation");
			confirmation.setHeaderText("Are you sure you want to update the location?");
			confirmation.setContentText("Any unsaved changes will be lost.");
			confirmation.showAndWait().ifPresent(response -> {
				if (response == ButtonType.OK) {
					if (comboUpdate.getValue() == null || tfNew.getText().isBlank()) {
						lblResU.setText("Fill All Required Feilds!");
						lblResU.setTextFill(Color.BLACK);
					} else {
						LocationTree newLocation = new LocationTree(tfNew.getText());
						if (BorderPaneDistrict.getNode().getData().getLocation().update(comboUpdate.getValue(), newLocation) == true){
							lblResU.setText("Updated Successfully");
							lblResU.setStyle(
									"-fx-font-style: italic; -fx-font-weight: bold; -fx-font-size: 15;-fx-font-family: 'Times New Roman';-fx-text-fill:#FFEECC;");
							VBoxButtonsLocation.getStackNext().clear();
							VBoxButtonsLocation.getStackPrev().clear();
							comboUpdate.getItems().clear();
							comboDelete.getItems().clear();
							Phase2Main.fillStack(BorderPaneDistrict.getDistrict().getLocation());
							BorderPaneLocation.getLblLocation().setText(VBoxButtonsLocation.getStackNext().peek() + "");
							BorderPaneLocation.setLocation(VBoxButtonsLocation.getStackNext().peek());
							BorderPaneLocation.getMaxDate().setText("The Max Date is " + BorderPaneDistrict.getDistrict().maxDate(VBoxButtonsLocation.getStackNext().peek().getDate().getRoot(),BorderPaneDistrict.getDistrict().countDateMartyrs(BorderPaneLocation.getLocation().getDate().getRoot())));
							BorderPaneLocation.getEarliest().setText("The earlist Date is " + BorderPaneDistrict.getDistrict().earliestMartyrDate(VBoxButtonsLocation.getStackNext().peek().getDate().getRoot()));
							BorderPaneLocation.getLastest().setText("The Latest Date is " + BorderPaneDistrict.getDistrict().latestMartyrDate(VBoxButtonsLocation.getStackNext().peek().getDate().getRoot()));
							VBoxButtonsDate.getStackNext().clear();
							VBoxButtonsDate.getStackPrev().clear();
							Phase2Main.fillStackDate(BorderPaneLocation.getLocation().getDate().getRoot());
							BorderPaneDate.getLblDate().setText(VBoxButtonsDate.getStackNext().peek() + "");
							BorderPaneDate.setDate(VBoxButtonsDate.getStackNext().peek());
						} else {
							lblResU.setText("The New Location Exist Before");
							lblResU.setTextFill(Color.BLACK);
						}
					}
				}
			});

		});
	}

	public void fillComboBox(ComboBox<LocationTree> box) {
		fillComboBox(((DistrictTree) Phase2Main.districtTree.find(BorderPaneDistrict.getNode().getData()).getData())
				.getLocation().getRoot(), box);
	}

	private void fillComboBox(TNode<LocationTree> node, ComboBox<LocationTree> box) {
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

