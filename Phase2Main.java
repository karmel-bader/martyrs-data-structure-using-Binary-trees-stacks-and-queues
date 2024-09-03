package application;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import java.util.*;

public class Phase2Main extends Application {
	static File file;
	static File newFile = new File("");
	static BST<DistrictTree> districtTree = new BST<DistrictTree>();

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		TabPane tabpane = new TabPane();
		FileChooser fileChooser = new FileChooser();
		Locale.setDefault(Locale.ENGLISH);
		Tab district = new Tab();
		Tab location = new Tab();
		Tab date = new Tab();
		StackPane pane = new StackPane();
		VBox vMain = new VBox(10);
		vMain.setAlignment(Pos.CENTER);
		Label lbl = new Label();
		lbl.setStyle("-fx-font-size: 16px; -fx-font-weight: bold;-fx-font-family: 'Times New Roman';");
		Label lblSave = new Label();
		lbl.setStyle("-fx-font-size: 16px; -fx-font-weight: bold;-fx-font-family: 'Times New Roman';");
		Button choose = new Button("Choose A File To Start");
		Button save = new Button("Save To File");
		save.setStyle(
				"-fx-background-color: white; -fx-text-fill: black; -fx-font-size: 16px; -fx-font-weight: bold;-fx-font-family: 'Times New Roman';");
		choose.setStyle(
				"-fx-background-color: white; -fx-text-fill: black; -fx-font-size: 16px; -fx-font-weight: bold;-fx-font-family: 'Times New Roman';");
		vMain.getChildren().addAll(choose, lbl,save, lblSave);
		choose.setOnAction(e -> {
			try {
				File selectedFile = fileChooser.showOpenDialog(stage);
				file = selectedFile;
				this.readFromFile();
				district.setDisable(false);
				location.setDisable(false);
				date.setDisable(false);
				BorderPaneDistrict BPDistrict = new BorderPaneDistrict();
				district.setContent(BPDistrict.getMainPane());
				fillStack(districtTree.getRoot());
				BorderPaneDistrict.setNode(districtTree.find(VBoxButtons.getStackNext().peek()));
				BPDistrict.setDistrictFromStack();
				BorderPaneDistrict.setDistrict(VBoxButtons.getStackNext().peek());
				BorderPaneDistrict.getTotalMartyrs().setText("               In This District, \n The Total Number Of Martyrs is \n                          "
						+ Phase2Main.totalNumberOfMartyr(VBoxButtons.getStackNext().peek().getLocation().getRoot()));
				BorderPaneLocation BPLocation = new BorderPaneLocation();
				location.setContent(BPLocation.getBPLocation());
				VBoxLocation.getComboDelete().getItems().clear();
				VBoxLocation.getComboUpdate().getItems().clear();
				fillStack(VBoxButtons.getStackNext().peek().getLocation());
				BorderPaneLocation.setLocation(VBoxButtonsLocation.getStackNext().peek());
				BPLocation.getLblLocation().setText(VBoxButtonsLocation.getStackNext().peek()+"");
				BorderPaneLocation.getMaxDate().setText("The Max Date is " + BorderPaneDistrict.getDistrict().maxDate(VBoxButtonsLocation.getStackNext().peek().getDate().getRoot(),BorderPaneDistrict.getDistrict().countDateMartyrs(BorderPaneLocation.getLocation().getDate().getRoot())));
				BorderPaneLocation.getEarliest().setText("The earlist Date is " + BorderPaneDistrict.getDistrict().earliestMartyrDate(VBoxButtonsLocation.getStackNext().peek().getDate().getRoot()));
				BorderPaneLocation.getLastest().setText("The Latest Date is " + BorderPaneDistrict.getDistrict().latestMartyrDate(VBoxButtonsLocation.getStackNext().peek().getDate().getRoot()));
				BorderPaneDate PBDate = new BorderPaneDate();
				fillStackDate(VBoxButtonsLocation.getStackNext().peek().getDate().getRoot());
				BorderPaneDate.getLblDate().setText(VBoxButtonsDate.getStackNext().peek() + "");
				BorderPaneDate.setDate(VBoxButtonsDate.getStackNext().peek());
				BorderPaneDate.getYoungest().setText("The Youngest Martyr is " + BorderPaneDate.getDate().youngest(VBoxButtonsDate.getStackNext().peek().getMartyr()));
				BorderPaneDate.getOldest().setText("The Oldest Martyr is " + BorderPaneDate.getDate().oldest(VBoxButtonsDate.getStackNext().peek().getMartyr()));
				BorderPaneDate.getAvgAge().setText("The Average Age is " + BorderPaneDate.getDate().avgAge(VBoxButtonsDate.getStackNext().peek().getMartyr().getHead()));
				date.setContent(PBDate.getMainPane());
				lbl.setText("File selected Successfully");
				lbl.setTextFill(Color.GREEN);
			} catch (Exception ex) {
				lbl.setText("Choose File Please");
				lbl.setTextFill(Color.RED);
			}

		});
		
		save.setOnAction(e ->{
			fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("CSV File", "*.csv"));
			Stage stageSave = new Stage();
			File fileSave = fileChooser.showSaveDialog(stageSave);
			if(fileSave != null) {
				try {
					boolean created = fileSave.createNewFile();
					if(created) {
						newFile = fileSave;
						writeToFile();
						lblSave.setText("Saved Successfully");
						lblSave.setTextFill(Color.GREEN);
					}
				}catch(IOException ex) {
					
				}
			}
		});
		//Image image = new Image(" ");
		//ImageView imageView = new ImageView(image);
		//imageView.fitWidthProperty().bind(stage.widthProperty());
		//imageView.fitHeightProperty().bind(stage.heightProperty());
		//imageView.setOpacity(0.5);
		pane.getChildren().addAll( vMain);
		Tab main = new Tab();
		main.setText("Choose File");
		main.setContent(pane);

		district.setText("District");
		district.setDisable(true);

		location.setText("Location");
		location.setDisable(true);

		date.setText("Date");
		date.setDisable(true);

		tabpane.getTabs().addAll(main, district, location, date);
		Scene scene = new Scene(tabpane, 400, 400);
		stage.setMaximized(true);
		stage.setScene(scene);
		stage.show();

	}

	public void readFromFile() {
		try {
			Scanner scan = new Scanner(file);
			scan.nextLine();
			DistrictTree districtObj = null;

			int count=0;
			while (scan.hasNext()) {
				String Line = scan.nextLine();
				String[] data = Line.split(",");
				if (data.length == 6 && !data[2].equals("")) {
					String name = data[0];
					String date = data[1];
					
			        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("M/d/yyyy");
			        LocalDate localDate = LocalDate.parse(date, formatter);
			        Date dateObjSplit = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
			        
					int age = Integer.parseInt(data[2]);
					String location = data[3];
					String district = data[4];
					String gender = data[5];
					districtObj = new DistrictTree(district);
					districtTree.insert(districtObj);
					LocationTree locationObj = new LocationTree(location);
					((DistrictTree) districtTree.find(districtObj).getData()).getLocation().insert(locationObj);
					DateTree dateObj = new DateTree(dateObjSplit);
					((DistrictTree) districtTree.find(districtObj).getData()).getLocation().find(locationObj).getData()
							.getDate().insert(dateObj);
					MartyrList martyrObj = new MartyrList(name, age, gender);
					((DistrictTree) districtTree.find(districtObj).getData()).getLocation().find(locationObj).getData()
							.getDate().find(dateObj).getData().getMartyr().insert(martyrObj);

				}
			}
			System.out.println(count);
			

		} catch (IOException ex) {

		}
	}

	public static int totalNumberOfMartyr(TNode<LocationTree> node) {
		if (node == null)
			return 0;
		else {
			return countDateMartyrs(node.getData().getDate().getRoot()) + totalNumberOfMartyr(node.getLeft())
					+ totalNumberOfMartyr(node.getRight());
		}
	}

	private static int countDateMartyrs(TNode<DateTree> node) {
		if (node == null)
			return 0;
		else {
			return totalMartyrs(node) + countDateMartyrs(node.getLeft())
					+ countDateMartyrs(node.getRight());
		}
	}

	private static int totalMartyrs(TNode<DateTree> node) {
		SingleNode<MartyrList> curr = node.getData().getMartyr().getHead();
		int counter = 0;
		while (curr != null) {
			curr = curr.getNext();
			counter++;
		}
		return counter;
	}
	
	public static void fillStack(TNode<DistrictTree> node) {
		if(node == null) return;
		fillStack(node.getRight());
		VBoxButtons.getStackNext().push(node.getData());
		fillStack(node.getLeft());
	}
	

	public static void fillStack(BST<LocationTree> bst) {
		if(bst.getRoot() == null) return;
		Queue<LocationTree> q = new Queue<LocationTree>();
		q.enQueue(bst.getRoot().getData());
		while(!q.isEmpty()) {
			LocationTree loc = q.deQueue();
			TNode<LocationTree> locationNode = bst.find(loc);
			if(locationNode.getLeft()!=null) q.enQueue(locationNode.getLeft().getData());
			if(locationNode.getRight()!=null)q.enQueue(locationNode.getRight().getData());
			VBoxLocation.getComboDelete().getItems().add(loc);
			VBoxLocation.getComboUpdate().getItems().add(loc);
			VBoxButtonsLocation.getStackPrev().push(loc);
		}
		while(!VBoxButtonsLocation.getStackPrev().isEmpty()) VBoxButtonsLocation.getStackNext().push(VBoxButtonsLocation.getStackPrev().pop());
	}
	
	public static void fillStackDate(TNode<DateTree> node) {
		if(node == null) return;
		fillStackDate(node.getRight());
		VBoxButtonsDate.getStackNext().push(node.getData());
		fillStackDate(node.getLeft());
	}
	
	public static void writeToFile() {
		try {
			PrintWriter pw = new PrintWriter(newFile);
			pw.write("Name,Date,Age,Location,District,Gender");
			if(districtTree.getRoot() == null) return;
			Queue<DistrictTree> qDistrict = new Queue<DistrictTree>();
			qDistrict.enQueue(districtTree.getRoot().getData());
			while(!qDistrict.isEmpty()) {
				DistrictTree district = qDistrict.deQueue();
				TNode<DistrictTree> DistrictNode = districtTree.find(district);
				if(DistrictNode.getLeft()!=null) qDistrict.enQueue(DistrictNode.getLeft().getData());
				if(DistrictNode.getRight()!=null)qDistrict.enQueue(DistrictNode.getRight().getData());
				
				Queue<LocationTree> qLocation = new Queue<LocationTree>();
				qLocation.enQueue(district.getLocation().getRoot().getData());
				while(!qLocation.isEmpty()) {
					LocationTree location = qLocation.deQueue();
					TNode<LocationTree> LocationNode = district.getLocation().find(location);
					if(LocationNode.getLeft()!=null) qLocation.enQueue(LocationNode.getLeft().getData());
					if(LocationNode.getRight()!=null)qLocation.enQueue(LocationNode.getRight().getData());
					
					Queue<DateTree> qDate = new Queue<DateTree>();
					qDate.enQueue(location.getDate().getRoot().getData());
					while(!qDate.isEmpty()) {
						DateTree date = qDate.deQueue();
						TNode<DateTree> DateNode = location.getDate().find(date);
						if(DateNode.getLeft()!=null) qDate.enQueue(DateNode.getLeft().getData());
						if(DateNode.getRight()!=null)qDate.enQueue(DateNode.getRight().getData());
						
						SingleNode<MartyrList> curr = date.getMartyr().getHead();
						while(curr != null) {
							pw.println(curr.getData().getName() +"," + date + "," + curr.getData().getAge() + "," + location.getLocation() + "," + district.getDistrict() + "," + curr.getData().getGender());
							curr = curr.getNext();
						}
						
						
					}
				}
				
			}
			pw.close();
		}catch(IOException ex){
			
		}
	}

}