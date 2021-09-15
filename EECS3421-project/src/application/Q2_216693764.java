package application;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import application.Q3_216693764;

import javafx.animation.FadeTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Q2_216693764 implements Initializable {
	
	@FXML
	private AnchorPane rootPane;
	
	@FXML
	private Button back;
	
	@FXML
	private Label screen;
	
	@FXML
	private Label label1;
	
	@FXML
	private Label conferenceLabel;
	
	@FXML
	private Label journalLabel;
	
	@FXML
	private Label bookLabel;
	
	@FXML
	private Button queryA;
	
	@FXML
	private Button queryB;
	
	@FXML
	private Button change;
	
	@FXML
	private ListView conferenceList;
	
	@FXML
	private ListView journalList;
	
	@FXML
	private ListView bookList;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		makeFade();
		change.setVisible(false);
		conferenceLabel.setVisible(false);
		journalLabel.setVisible(false);
		bookLabel.setVisible(false);
		conferenceList.setVisible(false);
		journalList.setVisible(false);
		bookList.setVisible(false);
		
	}
	
	private void makeFade() {
		FadeTransition fadeTransition = new FadeTransition();
		fadeTransition.setDuration(Duration.millis(500));
		fadeTransition.setNode(rootPane);
		fadeTransition.setFromValue(0);
		fadeTransition.setToValue(1);
	
		fadeTransition.play();
		
	}
	
	public void BackAction() {
		ButtonType YES = new ButtonType("Yes");
		ButtonType NO = new ButtonType("No");
		AlertType type = AlertType.WARNING; 
		Alert alert = new Alert(type, "Would you like to go back?", YES, NO);
		alert.setHeaderText("Confirmation");
		alert.getDialogPane();
		alert.showAndWait().ifPresent(response ->{
			if(response == YES) {
				makeFadeOutBack();
			}
			if(response == NO) {
				
			}
			
		});;
	}
	
	private void makeFadeOutBack() {
		FadeTransition fadeTransition = new FadeTransition();
		fadeTransition.setDuration(Duration.millis(500));
		fadeTransition.setNode(rootPane);
		fadeTransition.setFromValue(1);
		fadeTransition.setToValue(0);
		fadeTransition.setOnFinished(event -> loadBackScene());
		fadeTransition.play();
	}
	
	private void loadBackScene() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource("MainScreen.fxml"));
			Parent secondView = loader.load();
			Scene newScene = new Scene(secondView);
			Q3_216693764 controller = loader.getController();
			Stage curStage = (Stage) rootPane.getScene().getWindow();
			curStage.setScene(newScene);
			curStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void QueryAAction() throws Exception {
		label1.setText("Query A");
		
		queryA.setVisible(false);
		queryB.setVisible(false);
		
		ArrayList<String> listA1 = new ArrayList<String>();
		ArrayList<String> listA2 = new ArrayList<String>();
		ArrayList<String> listA3 = new ArrayList<String>();
		
		Q3_216693764 newSelect = new Q3_216693764();
		listA1 = newSelect.selectTable("a1");
		listA2 = newSelect.selectTable("a2");
		listA3 = newSelect.selectTable("a3");
		
		conferenceList.getItems().add("    Month		Conference Events  ");
		journalList.getItems().add("    Month		Journal Events  ");
		bookList.getItems().add("    Month		  Book Events  ");
		
		for(int i = 0; i < listA1.size(); i = i + 2) {
			conferenceList.getItems().add("    	" + listA1.get(i) + "					" + listA1.get(i + 1));
		}
		for(int j = 0; j < listA2.size(); j = j + 2) {
			journalList.getItems().add("    	" + listA2.get(j) + "					" + listA2.get(j + 1));
		}
		for(int k = 0; k < listA3.size(); k = k + 2) {
			bookList.getItems().add("    	" + listA3.get(k) + "					" + listA3.get(k + 1));
		}
		
		change.setVisible(true);
		conferenceLabel.setVisible(true);
		journalLabel.setVisible(true);
		bookLabel.setVisible(true);
		conferenceList.setVisible(true);
		journalList.setVisible(true);
		bookList.setVisible(true);
	}
	
	public void QueryBAction() throws Exception {
		label1.setText("Query B");
		
		queryA.setVisible(false);
		queryB.setVisible(false);
		
		ArrayList<String> listB1 = new ArrayList<String>();
		ArrayList<String> listB2 = new ArrayList<String>();
		ArrayList<String> listB3 = new ArrayList<String>();
		
		Q3_216693764 newSelect = new Q3_216693764();
		listB1 = newSelect.selectTable("b1");
		listB2 = newSelect.selectTable("b2");
		listB3 = newSelect.selectTable("b3");
		
		conferenceList.getItems().add("    Event Name												Earliest Conference Event Date  ");
		journalList.getItems().add("    Event Name													Earliest Journal Event Date  ");
		bookList.getItems().add("    Event Name																	Earliest Book Event Date  ");
		
		for(int i = 0; i < listB1.size(); i = i + 2) {
			conferenceList.getItems().add("    " + listB1.get(i) + "							" + listB1.get(i + 1));
		}
		for(int j = 0; j < listB2.size(); j = j + 2) {
			journalList.getItems().add("    " + listB2.get(j) + "				" + listB2.get(j + 1));
		}
		for(int k = 0; k < listB3.size(); k = k + 2) {
			bookList.getItems().add("    " + listB3.get(k) + "				" + listB3.get(k + 1));
		}
		
		change.setVisible(true);
		conferenceLabel.setVisible(true);
		journalLabel.setVisible(true);
		bookLabel.setVisible(true);
		conferenceList.setVisible(true);
		journalList.setVisible(true);
		bookList.setVisible(true);
	}
	
	public void ChangeAction() {
		label1.setText("Choose a query to continue");
		
		queryA.setVisible(true);
		queryB.setVisible(true);
		
		change.setVisible(false);
		conferenceLabel.setVisible(false);
		journalLabel.setVisible(false);
		bookLabel.setVisible(false);
		conferenceList.setVisible(false);
		journalList.setVisible(false);
		bookList.setVisible(false);
		
		conferenceList.getItems().remove(0, conferenceList.getItems().size());
		journalList.getItems().remove(0, journalList.getItems().size());
		bookList.getItems().remove(0, bookList.getItems().size());
	}

}
