package application;

import java.io.File;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TabPane;
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


public class BorderPaneDistrict {
	private static BorderPane mainPane = new BorderPane();
	private static Label lblDistrict = new Label("");
	private static TNode<DistrictTree> node = Phase2Main.districtTree.getRoot();
	private static Label totalMartyrs = new Label("");
	private static DistrictTree district;
	

	public static DistrictTree getDistrict() {
		return district;
	}

	public static void setDistrict(DistrictTree district) {
		BorderPaneDistrict.district = district;
	}

	public BorderPaneDistrict() {
		mainPane.setStyle("-fx-background-color: white;");
		totalMartyrs.setStyle(
				"-fx-font-style: italic;-fx-font-family: 'Times New Roman'; -fx-font-weight: bold; -fx-font-size: 30;");

		VBoxDistrict vDistrict = new VBoxDistrict();
		VBoxButtons vButtons = new VBoxButtons();
		mainPane.setLeft(vDistrict.getvDistrict());
		mainPane.setBottom(vButtons.getvButtons());
		mainPane.setMargin(vDistrict.getvDistrict(), new javafx.geometry.Insets(0, 0, 0, 100));
		mainPane.setMargin(vButtons.getvButtons(), new javafx.geometry.Insets(0, 0, 40, 0));
		mainPane.setTop(lblDistrict);
		mainPane.setAlignment(lblDistrict, Pos.CENTER);
		mainPane.setMargin(lblDistrict, new javafx.geometry.Insets(20, 0, 0, 0));

		StackPane sPane = new StackPane();
		Image imageData = new Image(
				"https://scontent.fjrs4-1.fna.fbcdn.net/v/t1.15752-9/370099455_931682898520873_1480713249280401791_n.jpg?_nc_cat=110&ccb=1-7&_nc_sid=5f2048&_nc_ohc=FWg_CU3ZOZoQ7kNvgGEi7Re&_nc_ht=scontent.fjrs4-1.fna&oh=03_Q7cD1QF7R0lIgIDavLex_AdHAL-BUndYWQkVSjYz_xjpo13xMg&oe=666EFA3E");
		ImageView imageViewData = new ImageView(imageData);
		imageViewData.setOpacity(0.2);
		imageViewData.setFitHeight(500);
		imageViewData.setFitWidth(600);
		Rectangle recData = new Rectangle(600, 500);
		recData.setStyle("-fx-fill: white; -fx-stroke:black; -fx-stroke-width: 3;");
		totalMartyrs.setText("               In This District, \n The Total Number Of Martyrs is \n            "
				+ Phase2Main.totalNumberOfMartyr(node.getData().getLocation().getRoot()));
		mainPane.setRight(sPane);
		sPane.getChildren().addAll(recData, imageViewData, totalMartyrs);
		mainPane.setMargin(sPane, new javafx.geometry.Insets(0, 150, 0, 0));
	}

	public BorderPane getMainPane() {
		return mainPane;
	}
	
	public static void setDistrictFromStack() {
		district=VBoxButtons.getStackNext().peek();
		lblDistrict.setStyle("-fx-font-weight: bold; -fx-font-size: 40; -fx-font-family: 'Times New Roman';");
		lblDistrict.setText(VBoxButtons.getStackNext().peek() + "");
	}

	public static void setMainPane(BorderPane mainPane) {
		BorderPaneDistrict.mainPane = mainPane;
	}

	public static Label getLblDistrict() {
		return lblDistrict;
	}

	public static void setLblDistrict(Label lblDistrict) {
		BorderPaneDistrict.lblDistrict = lblDistrict;
	}

	public static Label getTotalMartyrs() {
		return totalMartyrs;
	}

	public static void setTotalMartyrs(Label totalMartyrs) {
		BorderPaneDistrict.totalMartyrs = totalMartyrs;
	}

	public static TNode<DistrictTree> getNode() {
		return node;
	}

	public static void setNode(TNode<DistrictTree> node) {
		BorderPaneDistrict.node = node;
	}
	
	

}

