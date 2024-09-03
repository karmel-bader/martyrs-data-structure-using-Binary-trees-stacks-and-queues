package application;

import java.io.File;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class BorderPaneDate {
	private static BorderPane mainDate = new BorderPane();
	private static Label lblDate = new Label("");
	private static TNode<DateTree> node = ((DistrictTree) Phase2Main.districtTree
			.find(BorderPaneDistrict.getNode().getData()).getData()).getLocation()
			.find(BorderPaneLocation.getNode().getData()).getData().getDate().getRoot();
	private static Label youngest = new Label("");
	private static Label oldest = new Label("");
	private static Label AvgAge = new Label("");
	private TableView<MartyrList> tableView;
	private static ObservableList<MartyrList> data;
	private static DateTree date ;

	

	public static DateTree getDate() {
		return date;
	}

	public static void setDate(DateTree date) {
		BorderPaneDate.date = date;
	}

	public BorderPaneDate() {
		mainDate.setStyle("-fx-background-color: white;");
		youngest.setText("The Youngest Martyr is \n " + node.getData().youngest(node.getData().getMartyr())); 
		youngest.setStyle(
				"-fx-font-family: 'Times New Roman'; -fx-font-style: italic; -fx-font-weight: bold; -fx-font-size: 20;");
		oldest.setText("The Oldest Martyr is \n " + node.getData().oldest(node.getData().getMartyr())); 
		oldest.setStyle(
				"-fx-font-family: 'Times New Roman';-fx-font-style: italic; -fx-font-weight: bold; -fx-font-size: 20;");
		AvgAge.setText("The Avg Age is " + node.getData().avgAge(node.getData().getMartyr().getHead()));
		AvgAge.setStyle(
				"-fx-font-style: italic;-fx-font-family: 'Times New Roman'; -fx-font-weight: bold; -fx-font-size: 20;");

		lblDate.setStyle("-fx-font-weight: bold; -fx-font-size: 40; -fx-font-family: 'Times New Roman';");
		lblDate.setText(node + " ");
		VBoxDate vDate = new VBoxDate();
		VBoxButtonsDate vButtons = new VBoxButtonsDate();
		mainDate.setLeft(vDate.gethDate());
		mainDate.setBottom(vButtons.getvButtons());
		mainDate.setMargin(vDate.gethDate(), new javafx.geometry.Insets(0, 0, 0, 80));
		mainDate.setMargin(vButtons.getvButtons(), new javafx.geometry.Insets(0, 0, 40, 0));
		mainDate.setTop(lblDate);
		mainDate.setAlignment(lblDate, Pos.CENTER);
		mainDate.setMargin(lblDate, new javafx.geometry.Insets(20, 0, 0, 0));

		StackPane sPane = new StackPane();
		Image imageData = new Image(
				"https://scontent.fjrs4-1.fna.fbcdn.net/v/t1.15752-9/370099455_931682898520873_1480713249280401791_n.jpg?_nc_cat=110&ccb=1-7&_nc_sid=5f2048&_nc_ohc=FWg_CU3ZOZoQ7kNvgGEi7Re&_nc_ht=scontent.fjrs4-1.fna&oh=03_Q7cD1QF7R0lIgIDavLex_AdHAL-BUndYWQkVSjYz_xjpo13xMg&oe=666EFA3E");
		ImageView imageViewData = new ImageView(imageData);
		imageViewData.setOpacity(0.2);
		imageViewData.setFitHeight(500);
		imageViewData.setFitWidth(600);
		Rectangle recData = new Rectangle(600, 500);
		recData.setStyle("-fx-fill: white; -fx-stroke:black; -fx-stroke-width: 3;");
		Button bData = new Button("Show Martyrs Info");
		bData.setStyle(
				"-fx-background-color: white; -fx-text-fill: black; -fx-font-size: 16px; -fx-font-weight: bold;-fx-font-family: 'Times New Roman'; -fx-border-color: black;");
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
		VBox vData = new VBox(30);
		vData.setAlignment(Pos.CENTER);
		vData.getChildren().addAll(youngest, oldest, AvgAge, bData);
		mainDate.setRight(sPane);
		sPane.getChildren().addAll(recData, imageViewData, vData);
		mainDate.setMargin(sPane, new javafx.geometry.Insets(0, 100, 0, 0));
		
		bData.setOnAction(e ->{
			date.search(date);
			tableView.getSortOrder().add(nameColumn);
			nameColumn.setSortType(TableColumn.SortType.ASCENDING);
			tableView.sort();
			stageSearch.show();
		});
	}

	public static BorderPane getMainPane() {
		return mainDate;
	}

	public static void setMainPane(BorderPane mainDate) {
		BorderPaneDate.mainDate = mainDate;
	}

	public static Label getLblDate() {
		return lblDate;
	}

	public static void setLblDate(Label lblDate) {
		BorderPaneDate.lblDate = lblDate;
	}

	public static TNode<DateTree> getNode() {
		return node;
	}

	public static void setNode(TNode<DateTree> node) {
		BorderPaneDate.node = node;
	}

	public static Label getAvgAge() {
		return AvgAge;
	}

	public static void setAvgAge(Label avgAge) {
		AvgAge = avgAge;
	}

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
		BorderPaneDate.data = data;
	}

	public static Label getYoungest() {
		return youngest;
	}

	public static void setYoungest(Label youngest) {
		BorderPaneDate.youngest = youngest;
	}

	public static Label getOldest() {
		return oldest;
	}

	public static void setOldest(Label oldest) {
		BorderPaneDate.oldest = oldest;
	}

	
}
