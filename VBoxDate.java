package application;

import java.time.LocalDate;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;


import java.util.*;

public class VBoxDate {
	private HBox hDate = new HBox(5);
	private static Label insertRes;
	private static Label lblResD;
	private static Label lblResU;
	private static Label lblRes;
	private TextField tfInsert;
	private TextField tfUpdate;
	private static TextField tfSearch;
	private TextField tfNew;
	private TableView<MartyrList> tableView;
	private static ObservableList<MartyrList> data;
	
	

	public TableView<MartyrList> getTableView() {
		return tableView;
	}

	public void setTableView(TableView<MartyrList> tableView) {
		this.tableView = tableView;
	}

	

	public static ObservableList<MartyrList> getData() {
		return data;
	}

	public static void setData(ObservableList<MartyrList> data) {
		VBoxDate.data = data;
	}

	public HBox gethDate() {
		return hDate;
	}

	public void sethDate(HBox vDate) {
		this.hDate = vDate;
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
	
	

	public static TextField getTfSearch() {
		return tfSearch;
	}

	public static void setTfSearch(TextField tfSearch) {
		VBoxDate.tfSearch = tfSearch;
	}

	public VBoxDate() {
		StackPane insert = new StackPane();
		Rectangle recInsert = new Rectangle(400, 450);
		recInsert.setStyle("-fx-stroke-width: 3px;-fx-fill:#990000;");
		recInsert.setArcWidth(50);
		recInsert.setArcHeight(50);
		insert.setAlignment(Pos.CENTER);
		VBox vInsert = new VBox(10);
		vInsert.setAlignment(Pos.CENTER);
		Label lblInsert = new Label("Enter The Required Data To Insert New Martyr");
		lblInsert.setStyle(
				"-fx-font-style: italic;-fx-font-weight: bold;-fx-font-family: 'Times New Roman'; -fx-font-size: 15px;-fx-text-fill:white;");
		lblInsert.setAlignment(Pos.CENTER);
		GridPane gpInsert = new GridPane();
		gpInsert.setAlignment(Pos.CENTER);
		gpInsert.setHgap(8);
		gpInsert.setVgap(8);
		Label name = new Label("Enter The Name");
		name.setStyle(
				"-fx-font-style: italic;-fx-font-weight: bold;-fx-font-family: 'Times New Roman'; -fx-font-size: 15px;-fx-text-fill:white;");
		gpInsert.add(name, 0, 0);
		TextField tfName = new TextField();
		tfName.setPrefColumnCount(10);
		gpInsert.add(tfName, 1, 0);

		Label age = new Label("Enter The Age");
		age.setStyle(
				"-fx-font-style: italic;-fx-font-weight: bold;-fx-font-family: 'Times New Roman'; -fx-font-size: 15px;-fx-text-fill:white;");
		gpInsert.add(age, 0, 1);
		TextField tfAge = new TextField();
		tfAge.setPrefColumnCount(10);
		gpInsert.add(tfAge, 1, 1);

		HBox hbox = new HBox(5);
		hbox.setAlignment(Pos.CENTER);
		Label gender = new Label("Choose The Gender");
		gender.setStyle(
				"-fx-font-style: italic;-fx-font-weight: bold;-fx-font-family: 'Times New Roman'; -fx-font-size: 15px;-fx-text-fill:white;");
		gpInsert.add(gender, 0, 2);
		ComboBox<String> CB = new ComboBox<String>();
		CB.getItems().addAll("M", "F");
		Button bInsert = new Button("Insert");
		bInsert.setStyle(
				"-fx-font-style: italic;-fx-font-weight: bold;-fx-font-family: 'Times New Roman'; -fx-font-size: 15px;-fx-background-color:white;");
		insertRes = new Label();
		insertRes.setStyle(
				"-fx-font-style: italic;-fx-font-weight: bold;-fx-font-family: 'Times New Roman'; -fx-font-size: 15px;-fx-text-fill:#FFEECC;");
		hbox.getChildren().addAll(CB, bInsert);
		gpInsert.add(hbox, 1, 2);

		vInsert.getChildren().addAll(lblInsert, gpInsert, insertRes);
		insert.getChildren().addAll(recInsert, vInsert);

		StackPane delete = new StackPane();
		delete.setAlignment(Pos.CENTER);
		Rectangle recDelete = new Rectangle(300, 150);
		recDelete.setStyle("-fx-stroke-width: 3px;-fx-fill:#990000;");
		recDelete.setArcWidth(50);
		recDelete.setArcHeight(50);
		HBox hDelete = new HBox(5);
		hDelete.setAlignment(Pos.CENTER);
		TextField tfDelete = new TextField();
		tfDelete.setPrefColumnCount(10);
		Button bDelete = new Button("Delete");
		bDelete.setStyle(
				"-fx-font-weight: bold;-fx-font-family: 'Times New Roman'; -fx-font-size: 15px;-fx-background-color:white;");
		hDelete.getChildren().addAll(tfDelete, bDelete);
		VBox vDelete = new VBox(8);
		vDelete.setAlignment(Pos.CENTER);
		lblResD = new Label("");
		lblResD.setStyle(
				"-fx-font-style: italic;-fx-font-weight: bold;-fx-font-family: 'Times New Roman'; -fx-font-size: 15px;-fx-text-fill:#FFEECC;");
		Label lblD = new Label("To delete a Martyr Enter His name");
		lblD.setStyle(
				"-fx-font-style: italic;-fx-font-weight: bold;-fx-font-family: 'Times New Roman'; -fx-font-size: 15px;-fx-text-fill:white;");
		vDelete.getChildren().addAll(lblD, hDelete, lblResD);
		delete.getChildren().addAll(recDelete, vDelete);

		StackPane update = new StackPane();
		update.setAlignment(Pos.CENTER);
		Rectangle recUpdate = new Rectangle(300, 150);
		recUpdate.setStyle("-fx-stroke-width: 3px;-fx-fill:#990000;");
		recUpdate.setArcWidth(50);
		recUpdate.setArcHeight(50);
		VBox vUpdate = new VBox(10);
		vUpdate.setAlignment(Pos.CENTER);
		HBox hUpdate = new HBox(8);
		hUpdate.setAlignment(Pos.CENTER);
		Label lblUpdate = new Label("Enter The Name Of The Martyr Whose\n          data You Want To Modify");
		lblUpdate.setStyle(
				"-fx-font-style: italic;-fx-font-weight: bold;-fx-font-family: 'Times New Roman'; -fx-font-size: 15px;-fx-text-fill:white;");
		tfUpdate = new TextField();
		tfUpdate.setPrefColumnCount(10);
		Button bLoad = new Button("Load");
		bLoad.setStyle(
				"-fx-font-weight: bold;-fx-font-family: 'Times New Roman'; -fx-font-size: 15px;-fx-background-color:white;");
		lblResU = new Label();
		lblResU.setStyle(
				"-fx-font-style: italic;-fx-font-weight: bold;-fx-font-family: 'Times New Roman'; -fx-font-size: 15px;-fx-text-fill:#FFEECC;");
		hUpdate.getChildren().addAll(tfUpdate, bLoad);
		vUpdate.getChildren().addAll(lblUpdate, hUpdate, lblResU);
		update.getChildren().addAll(recUpdate, vUpdate);

		GridPane gpUpdate = new GridPane();
		gpUpdate.setAlignment(Pos.CENTER);
		gpUpdate.setHgap(10);
		gpUpdate.setVgap(10);
		VBox vUp = new VBox(5);
		vUp.setAlignment(Pos.CENTER);
		Label lblU = new Label(
				"This is The Data Of The Martyr Whose Name\n You Enterd. Update The Data You Want And Enter\n The Same Old Information For The Data You Don't\n                          Want To Update");
		lblU.setAlignment(Pos.CENTER);
		lblU.setStyle(
				"-fx-font-style: italic;-fx-font-weight: bold;-fx-font-family: 'Times New Roman'; -fx-font-size: 15px;");
		Label lblResFirst = new Label();
		lblResFirst.setStyle(
				"-fx-font-style: italic;-fx-font-weight: bold;-fx-font-family: 'Times New Roman'; -fx-font-size: 15px;-fx-text-fill:#990000;");
		Label nameU = new Label("Enter The Name");
		nameU.setStyle(
				"-fx-font-style: italic;-fx-font-weight: bold;-fx-font-family: 'Times New Roman'; -fx-font-size: 15px;");
		gpUpdate.add(nameU, 0, 0);
		TextField tfNameU = new TextField();
		tfNameU.setPrefColumnCount(10);
		gpUpdate.add(tfNameU, 1, 0);

		Label ageU = new Label("Enter The Age");
		ageU.setStyle(
				"-fx-font-style: italic;-fx-font-weight: bold;-fx-font-family: 'Times New Roman'; -fx-font-size: 15px;");
		gpUpdate.add(ageU, 0, 1);
		TextField tfAgeU = new TextField();
		tfAgeU.setPrefColumnCount(10);
		gpUpdate.add(tfAgeU, 1, 1);

		HBox hboxU = new HBox(5);
		hboxU.setAlignment(Pos.CENTER);
		Label genderU = new Label("Choose The Gender");
		genderU.setStyle(
				"-fx-font-style: italic;-fx-font-weight: bold;-fx-font-family: 'Times New Roman'; -fx-font-size: 15px;");
		gpUpdate.add(genderU, 0, 2);
		ComboBox<String> CBU = new ComboBox<String>();
		CBU.getItems().addAll("M", "F");
		Button bUpdate = new Button("Update");
		bUpdate.setStyle(
				"-fx-font-style: italic;-fx-font-weight: bold;-fx-font-family: 'Times New Roman'; -fx-font-size: 15px;-fx-background-color:#990000;-fx-text-fill:white;");
		Label updateRes = new Label();
		updateRes.setStyle(
				"-fx-font-style: italic;-fx-font-weight: bold;-fx-font-family: 'Times New Roman'; -fx-font-size: 15px;-fx-text-fill:#990000;");
		hboxU.getChildren().addAll(CBU, bUpdate);
		gpUpdate.add(hboxU, 1, 2);

		vUp.getChildren().addAll(lblU, lblResFirst, gpUpdate, updateRes);
		vUp.setStyle("-fx-background-color: white;");
		
		Stage stage = new Stage();
		stage.setTitle("Update Martyr Information");
		Scene scene = new Scene(vUp, 400, 400);
		stage.setScene(scene);

		StackPane search = new StackPane();
		search.setAlignment(Pos.CENTER);
		Rectangle recSearch = new Rectangle(300, 150);
		recSearch.setStyle("-fx-stroke-width: 3px;-fx-fill:#990000;");
		recSearch.setArcWidth(50);
		recSearch.setArcHeight(50);
		HBox hSearch = new HBox(5);
		hSearch.setAlignment(Pos.CENTER);
		tfSearch = new TextField();
		tfSearch.setPrefColumnCount(10);
		Button bSearch = new Button("Search");
		bSearch.setStyle(
				"-fx-font-weight: bold;-fx-font-family: 'Times New Roman'; -fx-font-size: 15px;-fx-background-color:white;");
		hSearch.getChildren().addAll(tfSearch, bSearch);
		VBox vSearch = new VBox(10);
		vSearch.setAlignment(Pos.CENTER);
		lblRes = new Label("");
		lblRes.setStyle(
				"-fx-font-style: italic;-fx-font-weight: bold;-fx-font-family: 'Times New Roman'; -fx-font-size: 15px;-fx-text-fill:#FFEECC;");
		Label lbl = new Label("To Search For a Martyr Enter His name");
		lbl.setStyle(
				"-fx-font-style: italic;-fx-font-weight: bold;-fx-font-family: 'Times New Roman'; -fx-font-size: 15px;-fx-text-fill:white;");
		vSearch.getChildren().addAll(lbl, hSearch, lblRes);
		search.getChildren().addAll(recSearch, vSearch);
		
		tableView = new TableView<>();
		data = FXCollections.observableArrayList();
		TableColumn<MartyrList, String> nameColumn = new TableColumn<MartyrList, String>("Name");
		TableColumn<MartyrList, Integer> ageColumn = new TableColumn<MartyrList, Integer>("Age");
		TableColumn<MartyrList, String> genderColumn = new TableColumn<MartyrList, String>("Gender");
		
		tableView.getColumns().addAll(nameColumn, ageColumn, genderColumn);
		nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
		ageColumn.setCellValueFactory(new PropertyValueFactory<>("Age"));
		genderColumn.setCellValueFactory(new PropertyValueFactory<>("Gender"));
		
		nameColumn.setStyle("-fx-alignment: CENTER");
		ageColumn.setStyle("-fx-alignment: CENTER");
		genderColumn.setStyle("-fx-alignment: CENTER");
		
		tableView.setItems(data);
		tableView.setMinWidth(330);
		tableView.setMaxHeight(240);
		
		Stage stageSearch = new Stage();
		Scene sceneSearch = new Scene(tableView,400,400);
		stageSearch.setScene(sceneSearch);
		

		VBox vDateOp = new VBox(5);
		vDateOp.setAlignment(Pos.CENTER);
		vDateOp.getChildren().addAll(delete, search, update);

		hDate.getChildren().addAll(insert, vDateOp);
		hDate.setAlignment(Pos.CENTER);

		bInsert.setOnAction(e -> {
			if (tfName.getText().isBlank() == true || tfAge.getText().isBlank() || CB.getValue() == null) {
				insertRes.setText("Please Fill All The Required Data Fields!");
				insertRes.setTextFill(Color.BLACK);
			} else {
				if (tfAge.getText().isEmpty() == false) {
					try {
						if (Integer.parseInt(tfAge.getText()) > 120 || Integer.parseInt(tfAge.getText()) < 0) {
							insertRes.setText("Sorry, The Age must be between 1 and 120");
							insertRes.setTextFill(Color.BLACK);
							return;
						}
						MartyrList martyr = new MartyrList(tfName.getText(), Integer.parseInt(tfAge.getText()),
								CB.getValue());
						if (BorderPaneDate.getDate().getMartyr()
								.insert(martyr) == false){
							insertRes.setText("The Martyr Exist Before");
							insertRes.setTextFill(Color.BLACK);
							return;
						} else {
							insertRes.setText("Added Successfully");
							insertRes.setStyle(
									"-fx-font-style: italic;-fx-font-weight: bold;-fx-font-family: 'Times New Roman'; -fx-font-size: 15px;-fx-text-fill:#FFEECC;");
						}
					} catch (NumberFormatException ex) {
						insertRes.setText("Sorry, The Age must be a number between 1 and 120");
						insertRes.setTextFill(Color.BLACK);
						return;
					}
				}

			}
		});

		bDelete.setOnAction(e -> {
			Alert confirmation = new Alert(Alert.AlertType.CONFIRMATION);
			confirmation.setTitle("Confirmation");
			confirmation.setHeaderText("Are you sure you want to delete this martyr?");
			confirmation.setContentText("Any unsaved changes will be lost.");
			confirmation.showAndWait().ifPresent(response -> {
				if (response == ButtonType.OK) {
					if (tfDelete.getText().isBlank() == true) {
						lblResD.setText("The Box is Empty");
						lblResD.setTextFill(Color.BLACK);
						return;
					}
					MartyrList martyr = new MartyrList(tfDelete.getText());
					LocationTree martyrLocation = new LocationTree(BorderPaneLocation.getLblLocation().getText().trim());
					DistrictTree martyrDistrict = new DistrictTree(BorderPaneDistrict.getLblDistrict().getText().trim());
					String[] dateSplit = BorderPaneDate.getLblDate().getText().trim().split("/");
					Date dateS = new Date(Integer.parseInt(dateSplit[2]), Integer.parseInt(dateSplit[0]),
							Integer.parseInt(dateSplit[1]));
					DateTree martyrDate = new DateTree(dateS);
					if (BorderPaneDate.getDate().getMartyr().findNode(martyr) != null) {
						BorderPaneDate.getDate().getMartyr().delete(martyr);
						lblResD.setText("Deleted Successfully");
						lblResD.setStyle(
								"-fx-font-style: italic;-fx-font-weight: bold;-fx-font-family: 'Times New Roman'; -fx-font-size: 15px; -fx-text-fill:#FFEECC;");
						BorderPaneDate.getYoungest().setText("The Youngest Martyr is " + BorderPaneDate.getDate().youngest(VBoxButtonsDate.getStackNext().peek().getMartyr()));
						BorderPaneDate.getOldest().setText("The Oldest Martyr is " + BorderPaneDate.getDate().oldest(VBoxButtonsDate.getStackNext().peek().getMartyr()));
						BorderPaneDate.getAvgAge().setText("The Average Age is " + BorderPaneDate.getDate().avgAge(VBoxButtonsDate.getStackNext().peek().getMartyr().getHead()));
				
					} else {
						lblResD.setText("The Martyr Dose Not Exist");
						lblResD.setTextFill(Color.BLACK);
					}
				}
			});
		});

		bLoad.setOnAction(e -> {
			if (tfUpdate.getText().isBlank()) {
				lblResU.setText("The Box is Empty");
				lblResU.setTextFill(Color.BLACK);
			} else {
				MartyrList martyr = new MartyrList(tfUpdate.getText());
				if (BorderPaneDate.getDate().getMartyr()
						.findNode(martyr) == null) {
					lblResU.setText("The Martyr Does Not Exist");
					lblResU.setTextFill(Color.BLACK);
					
				}else {
					stage.show();
				}
				
			}
		});
		
		bUpdate.setOnAction(e ->{
			Alert confirmation = new Alert(Alert.AlertType.CONFIRMATION);
			confirmation.setTitle("Confirmation");
			confirmation.setHeaderText("Are you sure you want to update this martyr?");
			confirmation.setContentText("Any unsaved changes will be lost.");
			confirmation.showAndWait().ifPresent(response -> {
				if (response == ButtonType.OK) {
					if(tfNameU.getText().isBlank() || tfAgeU.getText().isBlank() || CBU.getValue() ==  null) {
						updateRes.setText("Please Fill All Required Data Field");
						updateRes.setStyle(
								"-fx-font-style: italic;-fx-font-weight: bold;-fx-font-family: 'Times New Roman'; -fx-font-size: 15px;-fx-text-fill:#990000;");
					}else {
						if (tfAgeU.getText().isBlank() == false) {
							try {
								if (Integer.parseInt(tfAgeU.getText()) > 120 || Integer.parseInt(tfAgeU.getText()) < 0) {
									updateRes.setText("Sorry, The Age must be a number between 1 and 120");
									updateRes.setStyle(
											"-fx-font-style: italic;-fx-font-weight: bold;-fx-font-family: 'Times New Roman'; -fx-font-size: 15px;-fx-text-fill:#990000;");
									return;
								}
							MartyrList oldMartyr = BorderPaneDate.getNode().getData().getMartyr().findNode(new MartyrList(tfUpdate.getText())).getData();
							MartyrList newMartyr = new MartyrList(tfNameU.getText(),Integer.parseInt(tfAgeU.getText()), CBU.getValue());
							
							if(BorderPaneDate.getDate().getMartyr().update(oldMartyr, newMartyr) == false) {
								updateRes.setText("There is something wrong, Try again");
								updateRes.setTextFill(Color.BLACK);
							}else {
								updateRes.setText("Updated Successfully");
								updateRes.setStyle(
										"-fx-font-style: italic;-fx-font-weight: bold;-fx-font-family: 'Times New Roman'; -fx-font-size: 15px;-fx-text-fill:green;");
							}

							} catch (NumberFormatException ex) {
								updateRes.setText("Sorry, The Age must be a number between 1 and 120");
								updateRes.setStyle(
										"-fx-font-style: italic;-fx-font-weight: bold;-fx-font-family: 'Times New Roman'; -fx-font-size: 15px;-fx-text-fill:#990000;");
								return;
							}
						}

					
					}
				}
			});
		});
		
		bSearch.setOnAction(e ->{
			if(tfSearch.getText().isBlank()) {
				lblRes.setText("The Box is Empty");
				lblRes.setTextFill(Color.BLACK);
			}else {
				System.out.println(BorderPaneDate.getNode().getData());
				data.clear();
				BorderPaneDate.getNode().getData().searchByName(BorderPaneDate.getDate());
				stageSearch.show();
			}
		});
	}
	
	public static void clear() {
		insertRes.setText("");
		lblResD.setText("");
		lblResU.setText("");
		lblRes.setText("");
	}

}
