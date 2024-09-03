package application;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class BorderPaneLocation {
	private static BorderPane BPLocation = new BorderPane();
	private static TNode<LocationTree> node = ((DistrictTree) Phase2Main.districtTree
			.find(BorderPaneDistrict.getNode().getData()).getData()).getLocation().getRoot();
	private static Label maxDate = new Label("");
	private static Label earliest = new Label("");
	private static Label lastest = new Label("");
	private static Label lblLocation;
	private static LocationTree location ;

	public static BorderPane getBPLocation() {
		return BPLocation;
	}

	public static void setBPLocation(BorderPane bPLocation) {
		BPLocation = bPLocation;
	}

	public BorderPaneLocation() {
		BPLocation.setStyle("-fx-background-color: white;");
		lblLocation = new Label("");
		lblLocation.setStyle("-fx-font-weight: bold;-fx-font-family: 'Times New Roman'; -fx-font-size: 35px;");
		lblLocation.setText(node + "");
		BPLocation.setTop(lblLocation);
		BPLocation.setAlignment(lblLocation, Pos.CENTER);
		BPLocation.setMargin(lblLocation, new Insets(50, 0, 0, 0));

		VBoxLocation vLocation = new VBoxLocation();
		BPLocation.setLeft(vLocation.getvLocation());
		BPLocation.setMargin(vLocation.getvLocation(), new Insets(0, 0, 0, 100));

		VBoxButtonsLocation vButtons = new VBoxButtonsLocation();
		BPLocation.setBottom(vButtons.getvButtons());
		BPLocation.setMargin(vButtons.getvButtons(), new Insets(0, 0, 40, 0));
		BPLocation.setAlignment(vButtons.getvButtons(), Pos.CENTER);

		maxDate.setStyle(
				"-fx-font-family: 'Times New Roman';-fx-font-style: italic; -fx-font-weight: bold; -fx-font-size: 20;");

		earliest.setStyle(
				"-fx-font-family: 'Times New Roman';-fx-font-style: italic; -fx-font-weight: bold; -fx-font-size: 20;");

		lastest.setStyle(
				"-fx-font-family: 'Times New Roman';-fx-font-style: italic; -fx-font-weight: bold; -fx-font-size: 20;");

		StackPane sPane = new StackPane();
		Image imageData = new Image(
				"https://scontent.fjrs4-1.fna.fbcdn.net/v/t1.15752-9/370099455_931682898520873_1480713249280401791_n.jpg?_nc_cat=110&ccb=1-7&_nc_sid=5f2048&_nc_ohc=FWg_CU3ZOZoQ7kNvgGEi7Re&_nc_ht=scontent.fjrs4-1.fna&oh=03_Q7cD1QF7R0lIgIDavLex_AdHAL-BUndYWQkVSjYz_xjpo13xMg&oe=666EFA3E");
		ImageView imageViewData = new ImageView(imageData);
		imageViewData.setOpacity(0.2);
		imageViewData.setFitHeight(500);
		imageViewData.setFitWidth(600);
		Rectangle recData = new Rectangle(600, 500);
		recData.setStyle("-fx-fill: white; -fx-stroke:black; -fx-stroke-width: 3;");

		VBox vData = new VBox(30);
		vData.setAlignment(Pos.CENTER);
		vData.getChildren().addAll(maxDate, earliest, lastest);
		sPane.getChildren().addAll(recData, imageViewData, vData);
		BPLocation.setRight(sPane);
		BPLocation.setMargin(sPane, new Insets(0, 100, 0, 0));

	}

	public static TNode<LocationTree> getNode() {
		return node;
	}

	public static void setNode(TNode<LocationTree> node) {
		BorderPaneLocation.node = node;
	}

	public static Label getLblLocation() {
		return lblLocation;
	}

	public static void setLblLocation(Label lblLocation) {
		BorderPaneLocation.lblLocation = lblLocation;
	}

	
	public static Label getMaxDate() {
		return maxDate;
	}

	public static void setMaxDate(Label maxDate) {
		BorderPaneLocation.maxDate = maxDate;
	}

	public static LocationTree getLocation() {
		return location;
	}

	public static void setLocation(LocationTree location) {
		BorderPaneLocation.location = location;
	}

	public static Label getEarliest() {
		return earliest;
	}

	public static void setEarliest(Label earliest) {
		BorderPaneLocation.earliest = earliest;
	}

	public static Label getLastest() {
		return lastest;
	}

	public static void setLastest(Label lastest) {
		BorderPaneLocation.lastest = lastest;
	}
	
	

	

}
