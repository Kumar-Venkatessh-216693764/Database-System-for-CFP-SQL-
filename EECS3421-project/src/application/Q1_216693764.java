package application;

import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.util.StringConverter;

public class Q1_216693764 implements Initializable {
	
	@FXML
	private AnchorPane rootPane;
	
	@FXML
	private Button back;
	
	@FXML
	private Label screen;
	
	@FXML
	private Label title;
	
	@FXML
	private Button event;
	
	@FXML
	private Button eventConference;
	
	@FXML
	private Button eventJournal;
	
	@FXML
	private Button eventBook;
	
	@FXML
	private Button activityHappens;
	
	@FXML
	private Button researchTopic;
	
	@FXML
	private Button people;
	
	@FXML
	private Button covers;
	
	@FXML
	private Button organizes;
	
	@FXML
	private Label label1;
	
	@FXML
	private Label label2;
	
	@FXML
	private Label label3;
	
	@FXML
	private Label label4;
	
	@FXML
	private TextField text1;
	
	@FXML
	private TextField text2;
	
	@FXML
	private TextField text3;
	
	@FXML
	private TextArea textArea;
	
	@FXML
	private DatePicker datePicker;
	
	@FXML
	private Button change;
	
	@FXML
	private Button insert;
	
	Boolean t1 = false;
	Boolean t2 = false;
	Boolean t3 = false;
	Boolean t4 = false;
	Boolean t5 = false;
	Boolean t6 = false;
	Boolean t7 = false;
	Boolean t8 = false;
	Boolean t9 = false;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		makeFade();
		
		label1.setVisible(false);
		label2.setVisible(false);
		label3.setVisible(false);
		label4.setVisible(false);
		text1.setVisible(false);
		text2.setVisible(false);
		text3.setVisible(false);
		textArea.setVisible(false);
		datePicker.setVisible(false);
		
		title.setText("Choose a table and insert values");
		
		datePicker.setConverter(new StringConverter<LocalDate>() {
		     String pattern = "yyyy-MM-dd";
		     DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern(pattern);

		     {
		         datePicker.setPromptText(pattern.toLowerCase());
		     }

		     @Override public String toString(LocalDate date) {
		         if (date != null) {
		             return dateFormatter.format(date);
		         } else {
		             return "";
		         }
		     }

		     @Override public LocalDate fromString(String string) {
		         if (string != null && !string.isEmpty()) {
		             return LocalDate.parse(string, dateFormatter);
		         } else {
		             return null;
		         }
		     }
		 });
		
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
	
	public void EventAction() {
		t1 = true;
		
		event.setVisible(false);
		eventConference.setVisible(false);
		eventJournal.setVisible(false);
		eventBook.setVisible(false);
		activityHappens.setVisible(false);
		researchTopic.setVisible(false);
		people.setVisible(false);
		covers.setVisible(false);
		organizes.setVisible(false);
		
		label1.setVisible(true);
		label2.setVisible(true);
		label3.setVisible(true);
		text1.setVisible(true);
		text2.setVisible(true);
		textArea.setVisible(true);
		
		label1.setText("Name");
		label2.setText("EventWebLink");
		label3.setText("CFPText");
		title.setText("Event Table");
	}

	public void EventConferenceAction() {
		t2 = true;
		
		event.setVisible(false);
		eventConference.setVisible(false);
		eventJournal.setVisible(false);
		eventBook.setVisible(false);
		activityHappens.setVisible(false);
		researchTopic.setVisible(false);
		people.setVisible(false);
		covers.setVisible(false);
		organizes.setVisible(false);
		
		label1.setVisible(true);
		label2.setVisible(true);
		label3.setVisible(true);
		label4.setVisible(true);
		text1.setVisible(true);
		text2.setVisible(true);
		text3.setVisible(true);
		datePicker.setVisible(true);
		
		label1.setText("EventName");
		label2.setText("City");
		label3.setText("Country");
		label4.setText("Date");
		title.setText("EventConference Table");
	}
	
	public void EventJournalAction() {
		t3 = true;
		
		event.setVisible(false);
		eventConference.setVisible(false);
		eventJournal.setVisible(false);
		eventBook.setVisible(false);
		activityHappens.setVisible(false);
		researchTopic.setVisible(false);
		people.setVisible(false);
		covers.setVisible(false);
		organizes.setVisible(false);
		
		label1.setVisible(true);
		label2.setVisible(true);
		label3.setVisible(true);
		text1.setVisible(true);
		text2.setVisible(true);
		text3.setVisible(true);
		
		label1.setText("EventName");
		label2.setText("JournalName");
		label3.setText("Publisher");
		title.setText("EventJournal Table");
	}
	
	public void EventBookAction() {
		t4 = true;
		
		event.setVisible(false);
		eventConference.setVisible(false);
		eventJournal.setVisible(false);
		eventBook.setVisible(false);
		activityHappens.setVisible(false);
		researchTopic.setVisible(false);
		people.setVisible(false);
		covers.setVisible(false);
		organizes.setVisible(false);
		
		label2.setVisible(true);
		label3.setVisible(true);
		text2.setVisible(true);
		text3.setVisible(true);
		
		label2.setText("EventName");
		label3.setText("Publisher");
		title.setText("EventBook Table");
	}
	
	public void ActivityHappensAction() {
		t5 = true;
		
		event.setVisible(false);
		eventConference.setVisible(false);
		eventJournal.setVisible(false);
		eventBook.setVisible(false);
		activityHappens.setVisible(false);
		researchTopic.setVisible(false);
		people.setVisible(false);
		covers.setVisible(false);
		organizes.setVisible(false);
		
		label2.setVisible(true);
		label3.setVisible(true);
		label4.setVisible(true);
		text2.setVisible(true);
		text3.setVisible(true);
		datePicker.setVisible(true);
		
		label2.setText("EventName");
		label3.setText("ActivityName");
		label4.setText("ActivityDate");
		title.setText("ActivityHappens Table");
	}
	
	public void ResearchTopicAction() {
		t6 = true;
		
		event.setVisible(false);
		eventConference.setVisible(false);
		eventJournal.setVisible(false);
		eventBook.setVisible(false);
		activityHappens.setVisible(false);
		researchTopic.setVisible(false);
		people.setVisible(false);
		covers.setVisible(false);
		organizes.setVisible(false);
		
		label2.setVisible(true);
		label3.setVisible(true);
		text2.setVisible(true);
		text3.setVisible(true);
		
		label2.setText("Name");
		label3.setText("Area");
		title.setText("ResearchTopic Table");
	}
	
	public void PeopleAction() {
		t7 = true;
		
		event.setVisible(false);
		eventConference.setVisible(false);
		eventJournal.setVisible(false);
		eventBook.setVisible(false);
		activityHappens.setVisible(false);
		researchTopic.setVisible(false);
		people.setVisible(false);
		covers.setVisible(false);
		organizes.setVisible(false);
		
		label2.setVisible(true);
		label3.setVisible(true);
		text2.setVisible(true);
		text3.setVisible(true);
		
		label2.setText("Name");
		label3.setText("Affiliation");
		title.setText("People Table");
	}
	
	public void CoversAction() {
		t8 = true;
		
		event.setVisible(false);
		eventConference.setVisible(false);
		eventJournal.setVisible(false);
		eventBook.setVisible(false);
		activityHappens.setVisible(false);
		researchTopic.setVisible(false);
		people.setVisible(false);
		covers.setVisible(false);
		organizes.setVisible(false);
		
		label2.setVisible(true);
		label3.setVisible(true);
		text2.setVisible(true);
		text3.setVisible(true);
		
		label2.setText("EventName");
		label3.setText("TopicName");
		title.setText("Covers Table");
	}
	
	public void OrganizesAction() {
		t9 = true;
		
		event.setVisible(false);
		eventConference.setVisible(false);
		eventJournal.setVisible(false);
		eventBook.setVisible(false);
		activityHappens.setVisible(false);
		researchTopic.setVisible(false);
		people.setVisible(false);
		covers.setVisible(false);
		organizes.setVisible(false);
		
		label1.setVisible(true);
		label2.setVisible(true);
		label3.setVisible(true);
		text1.setVisible(true);
		text2.setVisible(true);
		text3.setVisible(true);
		
		label1.setText("EventName");
		label2.setText("PeopleName");
		label3.setText("Role");
		title.setText("Organizes Table");
	}
	
	public void ChangeAction() {
		event.setVisible(true);
		eventConference.setVisible(true);
		eventJournal.setVisible(true);
		eventBook.setVisible(true);
		activityHappens.setVisible(true);
		researchTopic.setVisible(true);
		people.setVisible(true);
		covers.setVisible(true);
		organizes.setVisible(true);
		
		title.setText("Choose a table and insert values");
		text1.setText("");
		text2.setText("");
		text3.setText("");
		textArea.setText("");
		label1.setVisible(false);
		label2.setVisible(false);
		label3.setVisible(false);
		label4.setVisible(false);
		text1.setVisible(false);
		text2.setVisible(false);
		text3.setVisible(false);
		textArea.setVisible(false);
		datePicker.setVisible(false);
		
		t1 = false;
		t2 = false;
		t3 = false;
		t4 = false;
		t5 = false;
		t6 = false;
		t7 = false;
		t8 = false;
		t9 = false;
	}
	
	public void InsertAction() throws Exception {
		if(t1) {
			String s = "";
			if(text1.getText().isEmpty()) {
				Alert errorAlert = new Alert(Alert.AlertType.ERROR);
	            errorAlert.setHeaderText("Name not specified");
	            errorAlert.setContentText("Please enter all details to insert");
	            errorAlert.showAndWait();
			}
			else if(text2.getText().isEmpty()) {
				Alert errorAlert = new Alert(Alert.AlertType.ERROR);
	            errorAlert.setHeaderText("EventWebLink not specified");
	            errorAlert.setContentText("Please enter all details to insert");
	            errorAlert.showAndWait();
			}
			else if(textArea.getText().isEmpty()) {
				Alert errorAlert = new Alert(Alert.AlertType.ERROR);
	            errorAlert.setHeaderText("CFPText not specified");
	            errorAlert.setContentText("Please enter all details to insert");
	            errorAlert.showAndWait();
			}
			else {
				Q3_216693764 newInsert = new Q3_216693764();
				s = newInsert.insertTable("t1", text1.getText(), text2.getText(), textArea.getText(), null, null, null, null, null, null, null, null, null, null, null, null, null);
				if(s != null) {
					if(s.contains("Duplicate")) {
						Alert errorAlert = new Alert(Alert.AlertType.ERROR);
			            errorAlert.setHeaderText("Duplicate value entered");
			            errorAlert.setContentText("The values you have entered appear to be a duplicate in the PRIMARY KEY field for this table. \n"
			            		+ "Please enter a set of values that are not duplicate. \n"
			            		+ "Error message: " + s);
			            errorAlert.showAndWait();
					}
					else if(s.contains("foreign")) {
						Alert errorAlert = new Alert(Alert.AlertType.ERROR);
			            errorAlert.setHeaderText("Invalid value entered");
			            errorAlert.setContentText("The values you have entered appear to violate the FOREIGN KEY field for this table. \n"
			            		+ "Please enter a set of values that are in accordance to the FOREIGN KEY guidelines. \n"
			            		+ "Error message: " + s);
			            errorAlert.showAndWait();
					}
					else {
						Alert errorAlert = new Alert(Alert.AlertType.ERROR);
			            errorAlert.setHeaderText("Invalid value entered");
			            errorAlert.setContentText("Error message: " + s);
			            errorAlert.showAndWait();
					}
				}
				else {
					Alert infoAlert = new Alert(Alert.AlertType.INFORMATION);
					infoAlert.setHeaderText("Values Successfully Inserted into table Event");
					infoAlert.setContentText("Continue to insert more values into either the Event table or any other table");
					infoAlert.showAndWait();
				}
				
				text1.setText("");
				text2.setText("");
				textArea.setText("");
			}
		}
		else if(t2) {
			String s = "";
			if(text1.getText().isEmpty()) {
				Alert errorAlert = new Alert(Alert.AlertType.ERROR);
	            errorAlert.setHeaderText("EventName not specified");
	            errorAlert.setContentText("Please enter all details to insert");
	            errorAlert.showAndWait();
			}
			else if(text2.getText().isEmpty()) {
				Alert errorAlert = new Alert(Alert.AlertType.ERROR);
	            errorAlert.setHeaderText("City not specified");
	            errorAlert.setContentText("Please enter all details to insert");
	            errorAlert.showAndWait();
			}
			else if(text3.getText().isEmpty()) {
				Alert errorAlert = new Alert(Alert.AlertType.ERROR);
	            errorAlert.setHeaderText("Country not specified");
	            errorAlert.setContentText("Please enter all details to insert");
	            errorAlert.showAndWait();
			}
			else if(datePicker.getValue() == null) {
				Alert errorAlert = new Alert(Alert.AlertType.ERROR);
	            errorAlert.setHeaderText("Date not specified");
	            errorAlert.setContentText("Please enter all details to insert");
	            errorAlert.showAndWait();
			}
			else {
				Q3_216693764 newInsert = new Q3_216693764();
				s = newInsert.insertTable("t2", text1.getText(), null, null, text2.getText(), text3.getText(), datePicker.getValue().toString(), null, null, null, null, null, null, null, null, null, null);
				
				if(s != null) {
					if(s.contains("Duplicate")) {
						Alert errorAlert = new Alert(Alert.AlertType.ERROR);
			            errorAlert.setHeaderText("Duplicate value entered");
			            errorAlert.setContentText("The values you have entered appear to be a duplicate in the PRIMARY KEY field for this table. \n"
			            		+ "Please enter a set of values that are not duplicate. \n"
			            		+ "Error message: " + s);
			            errorAlert.showAndWait();
					}
					else if(s.contains("foreign")) {
						Alert errorAlert = new Alert(Alert.AlertType.ERROR);
			            errorAlert.setHeaderText("Invalid value entered");
			            errorAlert.setContentText("The values you have entered appear to violate the FOREIGN KEY field for this table. \n"
			            		+ "Please enter a set of values that are in accordance to the FOREIGN KEY guidelines. \n"
			            		+ "Error message: " + s);
			            errorAlert.showAndWait();
					}
					else {
						Alert errorAlert = new Alert(Alert.AlertType.ERROR);
			            errorAlert.setHeaderText("Invalid value entered");
			            errorAlert.setContentText("Error message: " + s);
			            errorAlert.showAndWait();
					}
				}
				else {
					Alert infoAlert = new Alert(Alert.AlertType.INFORMATION);
					infoAlert.setHeaderText("Values Successfully Inserted into table EventConference");
					infoAlert.setContentText("Continue to insert more values into either the EventConference table or any other table");
					infoAlert.showAndWait();
				}
				text1.setText("");
				text2.setText("");
				text3.setText("");
				datePicker.setValue(null);
			}
		}
		else if(t3) {
			String s = "";
			if(text1.getText().isEmpty()) {
				Alert errorAlert = new Alert(Alert.AlertType.ERROR);
	            errorAlert.setHeaderText("EventName not specified");
	            errorAlert.setContentText("Please enter all details to insert");
	            errorAlert.showAndWait();
			}
			else if(text2.getText().isEmpty()) {
				Alert errorAlert = new Alert(Alert.AlertType.ERROR);
	            errorAlert.setHeaderText("JournalName not specified");
	            errorAlert.setContentText("Please enter all details to insert");
	            errorAlert.showAndWait();
			}
			else if(text3.getText().isEmpty()) {
				Alert errorAlert = new Alert(Alert.AlertType.ERROR);
	            errorAlert.setHeaderText("Publisher not specified");
	            errorAlert.setContentText("Please enter all details to insert");
	            errorAlert.showAndWait();
			}
			else {
				Q3_216693764 newInsert = new Q3_216693764();
				s = newInsert.insertTable("t3", text1.getText(), null, null, null, null, null, text2.getText(), text3.getText(), null, null, null, null, null, null, null, null);
				
				if(s != null) {
					if(s.contains("Duplicate")) {
						Alert errorAlert = new Alert(Alert.AlertType.ERROR);
			            errorAlert.setHeaderText("Duplicate value entered");
			            errorAlert.setContentText("The values you have entered appear to be a duplicate in the PRIMARY KEY field for this table. \n"
			            		+ "Please enter a set of values that are not duplicate. \n"
			            		+ "Error message: " + s);
			            errorAlert.showAndWait();
					}
					else if(s.contains("foreign")) {
						Alert errorAlert = new Alert(Alert.AlertType.ERROR);
			            errorAlert.setHeaderText("Invalid value entered");
			            errorAlert.setContentText("The values you have entered appear to violate the FOREIGN KEY field for this table. \n"
			            		+ "Please enter a set of values that are in accordance to the FOREIGN KEY guidelines. \n"
			            		+ "Error message: " + s);
			            errorAlert.showAndWait();
					}
					else {
						Alert errorAlert = new Alert(Alert.AlertType.ERROR);
			            errorAlert.setHeaderText("Invalid value entered");
			            errorAlert.setContentText("Error message: " + s);
			            errorAlert.showAndWait();
					}
				}
				else {
					Alert infoAlert = new Alert(Alert.AlertType.INFORMATION);
					infoAlert.setHeaderText("Values Successfully Inserted into table EventJournal");
					infoAlert.setContentText("Continue to insert more values into either the EventJournal table or any other table");
					infoAlert.showAndWait();
				}
				text1.setText("");
				text2.setText("");
				text3.setText("");
			}
		}
		else if(t4) {
			String s = "";
			if(text2.getText().isEmpty()) {
				Alert errorAlert = new Alert(Alert.AlertType.ERROR);
	            errorAlert.setHeaderText("EventName not specified");
	            errorAlert.setContentText("Please enter all details to insert");
	            errorAlert.showAndWait();
			}
			else if(text3.getText().isEmpty()) {
				Alert errorAlert = new Alert(Alert.AlertType.ERROR);
	            errorAlert.setHeaderText("Publisher not specified");
	            errorAlert.setContentText("Please enter all details to insert");
	            errorAlert.showAndWait();
			}
			else {
				Q3_216693764 newInsert = new Q3_216693764();
				s = newInsert.insertTable("t4", text2.getText(), null, null, null, null, null, null, text3.getText(), null, null, null, null, null, null, null, null);
				
				if(s != null) {
					if(s.contains("Duplicate")) {
						Alert errorAlert = new Alert(Alert.AlertType.ERROR);
			            errorAlert.setHeaderText("Duplicate value entered");
			            errorAlert.setContentText("The values you have entered appear to be a duplicate in the PRIMARY KEY field for this table. \n"
			            		+ "Please enter a set of values that are not duplicate. \n"
			            		+ "Error message: " + s);
			            errorAlert.showAndWait();
					}
					else if(s.contains("foreign")) {
						Alert errorAlert = new Alert(Alert.AlertType.ERROR);
			            errorAlert.setHeaderText("Invalid value entered");
			            errorAlert.setContentText("The values you have entered appear to violate the FOREIGN KEY field for this table. \n"
			            		+ "Please enter a set of values that are in accordance to the FOREIGN KEY guidelines. \n"
			            		+ "Error message: " + s);
			            errorAlert.showAndWait();
					}
					else {
						Alert errorAlert = new Alert(Alert.AlertType.ERROR);
			            errorAlert.setHeaderText("Invalid value entered");
			            errorAlert.setContentText("Error message: " + s);
			            errorAlert.showAndWait();
					}
				}
				else {
					Alert infoAlert = new Alert(Alert.AlertType.INFORMATION);
					infoAlert.setHeaderText("Values Successfully Inserted into table EventBook");
					infoAlert.setContentText("Continue to insert more values into either the EventBook table or any other table");
					infoAlert.showAndWait();
				}
				text2.setText("");
				text3.setText("");
			}
		}
		else if(t5) {
			String s = "";
			if(text2.getText().isEmpty()) {
				Alert errorAlert = new Alert(Alert.AlertType.ERROR);
	            errorAlert.setHeaderText("EventName not specified");
	            errorAlert.setContentText("Please enter all details to insert");
	            errorAlert.showAndWait();
			}
			else if(text3.getText().isEmpty()) {
				Alert errorAlert = new Alert(Alert.AlertType.ERROR);
	            errorAlert.setHeaderText("ActivityName not specified");
	            errorAlert.setContentText("Please enter all details to insert");
	            errorAlert.showAndWait();
			}
			else if(datePicker.getValue() == null) {
				Alert errorAlert = new Alert(Alert.AlertType.ERROR);
	            errorAlert.setHeaderText("ActivityDate not specified");
	            errorAlert.setContentText("Please enter all details to insert");
	            errorAlert.showAndWait();
			}
			else {
				Q3_216693764 newInsert = new Q3_216693764();
				s = newInsert.insertTable("t5", text2.getText(), null, null, null, null, null, null, null, text3.getText(), datePicker.getValue().toString(), null, null, null, null, null, null);
				
				if(s != null) {
					if(s.contains("Duplicate")) {
						Alert errorAlert = new Alert(Alert.AlertType.ERROR);
			            errorAlert.setHeaderText("Duplicate value entered");
			            errorAlert.setContentText("The values you have entered appear to be a duplicate in the PRIMARY KEY field for this table. \n"
			            		+ "Please enter a set of values that are not duplicate. \n"
			            		+ "Error message: " + s);
			            errorAlert.showAndWait();
					}
					else if(s.contains("foreign")) {
						Alert errorAlert = new Alert(Alert.AlertType.ERROR);
			            errorAlert.setHeaderText("Invalid value entered");
			            errorAlert.setContentText("The values you have entered appear to violate the FOREIGN KEY field for this table. \n"
			            		+ "Please enter a set of values that are in accordance to the FOREIGN KEY guidelines. \n"
			            		+ "Error message: " + s);
			            errorAlert.showAndWait();
					}
					else {
						Alert errorAlert = new Alert(Alert.AlertType.ERROR);
			            errorAlert.setHeaderText("Invalid value entered");
			            errorAlert.setContentText("Error message: " + s);
			            errorAlert.showAndWait();
					}
				}
				else {
					Alert infoAlert = new Alert(Alert.AlertType.INFORMATION);
					infoAlert.setHeaderText("Values Successfully Inserted into table ActivityHappens");
					infoAlert.setContentText("Continue to insert more values into either the ActivityHappens table or any other table");
					infoAlert.showAndWait();
				}
				text2.setText("");
				text3.setText("");
				datePicker.setValue(null);
			}
		}
		else if(t6) {
			String s = "";
			if(text2.getText().isEmpty()) {
				Alert errorAlert = new Alert(Alert.AlertType.ERROR);
	            errorAlert.setHeaderText("Name not specified");
	            errorAlert.setContentText("Please enter all details to insert");
	            errorAlert.showAndWait();
			}
			else if(text3.getText().isEmpty()) {
				Alert errorAlert = new Alert(Alert.AlertType.ERROR);
	            errorAlert.setHeaderText("Area not specified");
	            errorAlert.setContentText("Please enter all details to insert");
	            errorAlert.showAndWait();
			}
			else {
				Q3_216693764 newInsert = new Q3_216693764();
				s = newInsert.insertTable("t6", null, null, null, null, null, null, null, null, null, null, text2.getText(), text3.getText(), null, null, null, null);
				
				if(s != null) {
					if(s.contains("Duplicate")) {
						Alert errorAlert = new Alert(Alert.AlertType.ERROR);
			            errorAlert.setHeaderText("Duplicate value entered");
			            errorAlert.setContentText("The values you have entered appear to be a duplicate in the PRIMARY KEY field for this table. \n"
			            		+ "Please enter a set of values that are not duplicate. \n"
			            		+ "Error message: " + s);
			            errorAlert.showAndWait();
					}
					else if(s.contains("foreign")) {
						Alert errorAlert = new Alert(Alert.AlertType.ERROR);
			            errorAlert.setHeaderText("Invalid value entered");
			            errorAlert.setContentText("The values you have entered appear to violate the FOREIGN KEY field for this table. \n"
			            		+ "Please enter a set of values that are in accordance to the FOREIGN KEY guidelines. \n"
			            		+ "Error message: " + s);
			            errorAlert.showAndWait();
					}
					else {
						Alert errorAlert = new Alert(Alert.AlertType.ERROR);
			            errorAlert.setHeaderText("Invalid value entered");
			            errorAlert.setContentText("Error message: " + s);
			            errorAlert.showAndWait();
					}
				}
				else {
					Alert infoAlert = new Alert(Alert.AlertType.INFORMATION);
					infoAlert.setHeaderText("Values Successfully Inserted into table ResearchTopic");
					infoAlert.setContentText("Continue to insert more values into either the ResearchTopic table or any other table");
					infoAlert.showAndWait();
				}
				text2.setText("");
				text3.setText("");
			}
		}
		else if(t7) {
			String s = "";
			if(text2.getText().isEmpty()) {
				Alert errorAlert = new Alert(Alert.AlertType.ERROR);
	            errorAlert.setHeaderText("Name not specified");
	            errorAlert.setContentText("Please enter all details to insert");
	            errorAlert.showAndWait();
			}
			else if(text3.getText().isEmpty()) {
				Alert errorAlert = new Alert(Alert.AlertType.ERROR);
	            errorAlert.setHeaderText("Affiliation not specified");
	            errorAlert.setContentText("Please enter all details to insert");
	            errorAlert.showAndWait();
			}
			else {
				Q3_216693764 newInsert = new Q3_216693764();
				s = newInsert.insertTable("t7", null, null, null, null, null, null, null, null, null, null, null, null, text2.getText(), text3.getText(), null, null);
				
				if(s != null) {
					if(s.contains("Duplicate")) {
						Alert errorAlert = new Alert(Alert.AlertType.ERROR);
			            errorAlert.setHeaderText("Duplicate value entered");
			            errorAlert.setContentText("The values you have entered appear to be a duplicate in the PRIMARY KEY field for this table. \n"
			            		+ "Please enter a set of values that are not duplicate. \n"
			            		+ "Error message: " + s);
			            errorAlert.showAndWait();
					}
					else if(s.contains("foreign")) {
						Alert errorAlert = new Alert(Alert.AlertType.ERROR);
			            errorAlert.setHeaderText("Invalid value entered");
			            errorAlert.setContentText("The values you have entered appear to violate the FOREIGN KEY field for this table. \n"
			            		+ "Please enter a set of values that are in accordance to the FOREIGN KEY guidelines. \n"
			            		+ "Error message: " + s);
			            errorAlert.showAndWait();
					}
					else {
						Alert errorAlert = new Alert(Alert.AlertType.ERROR);
			            errorAlert.setHeaderText("Invalid value entered");
			            errorAlert.setContentText("Error message: " + s);
			            errorAlert.showAndWait();
					}
				}
				else {
					Alert infoAlert = new Alert(Alert.AlertType.INFORMATION);
					infoAlert.setHeaderText("Values Successfully Inserted into table People");
					infoAlert.setContentText("Continue to insert more values into either the People table or any other table");
					infoAlert.showAndWait();
				}
				text2.setText("");
				text3.setText("");
			}
		}
		else if(t8) {
			String s  = "";
			if(text2.getText().isEmpty()) {
				Alert errorAlert = new Alert(Alert.AlertType.ERROR);
	            errorAlert.setHeaderText("EventName not specified");
	            errorAlert.setContentText("Please enter all details to insert");
	            errorAlert.showAndWait();
			}
			else if(text3.getText().isEmpty()) {
				Alert errorAlert = new Alert(Alert.AlertType.ERROR);
	            errorAlert.setHeaderText("TopicName not specified");
	            errorAlert.setContentText("Please enter all details to insert");
	            errorAlert.showAndWait();
			}
			else {
				Q3_216693764 newInsert = new Q3_216693764();
				s = newInsert.insertTable("t8", text2.getText(), null, null, null, null, null, null, null, null, null, null, null, null, null, text3.getText(), null);
				
				if(s != null) {
					if(s.contains("Duplicate")) {
						Alert errorAlert = new Alert(Alert.AlertType.ERROR);
			            errorAlert.setHeaderText("Duplicate value entered");
			            errorAlert.setContentText("The values you have entered appear to be a duplicate in the PRIMARY KEY field for this table. \n"
			            		+ "Please enter a set of values that are not duplicate. \n"
			            		+ "Error message: " + s);
			            errorAlert.showAndWait();
					}
					else if(s.contains("foreign")) {
						Alert errorAlert = new Alert(Alert.AlertType.ERROR);
			            errorAlert.setHeaderText("Invalid value entered");
			            errorAlert.setContentText("The values you have entered appear to violate the FOREIGN KEY field for this table. \n"
			            		+ "Please enter a set of values that are in accordance to the FOREIGN KEY guidelines. \n"
			            		+ "Error message: " + s);
			            errorAlert.showAndWait();
					}
					else {
						Alert errorAlert = new Alert(Alert.AlertType.ERROR);
			            errorAlert.setHeaderText("Invalid value entered");
			            errorAlert.setContentText("Error message: " + s);
			            errorAlert.showAndWait();
					}
				}
				else {
					Alert infoAlert = new Alert(Alert.AlertType.INFORMATION);
					infoAlert.setHeaderText("Values Successfully Inserted into table Covers");
					infoAlert.setContentText("Continue to insert more values into either the Covers table or any other table");
					infoAlert.showAndWait();
				}
				text2.setText("");
				text3.setText("");
			}
		}
		else if(t9) {
			String s = "";
			if(text1.getText().isEmpty()) {
				Alert errorAlert = new Alert(Alert.AlertType.ERROR);
	            errorAlert.setHeaderText("EventName not specified");
	            errorAlert.setContentText("Please enter all details to insert");
	            errorAlert.showAndWait();
			}
			else if(text2.getText().isEmpty()) {
				Alert errorAlert = new Alert(Alert.AlertType.ERROR);
	            errorAlert.setHeaderText("PeopleName not specified");
	            errorAlert.setContentText("Please enter all details to insert");
	            errorAlert.showAndWait();
			}
			else if(text3.getText().isEmpty()) {
				Alert errorAlert = new Alert(Alert.AlertType.ERROR);
	            errorAlert.setHeaderText("Role not specified");
	            errorAlert.setContentText("Please enter all details to insert");
	            errorAlert.showAndWait();
			}
			else {
				Q3_216693764 newInsert = new Q3_216693764();
				s = newInsert.insertTable("t9", text1.getText(), null, null, null, null, null, null, null, null, null, null, null, text2.getText(), null, null, text3.getText());
				
				if(s != null) {
					if(s.contains("Duplicate")) {
						Alert errorAlert = new Alert(Alert.AlertType.ERROR);
			            errorAlert.setHeaderText("Duplicate value entered");
			            errorAlert.setContentText("The values you have entered appear to be a duplicate in the PRIMARY KEY field for this table. \n"
			            		+ "Please enter a set of values that are not duplicate. \n"
			            		+ "Error message: " + s);
			            errorAlert.showAndWait();
					}
					else if(s.contains("foreign")) {
						Alert errorAlert = new Alert(Alert.AlertType.ERROR);
			            errorAlert.setHeaderText("Invalid value entered");
			            errorAlert.setContentText("The values you have entered appear to violate the FOREIGN KEY field for this table. \n"
			            		+ "Please enter a set of values that are in accordance to the FOREIGN KEY guidelines. \n"
			            		+ "Error message: " + s);
			            errorAlert.showAndWait();
					}
					else {
						Alert errorAlert = new Alert(Alert.AlertType.ERROR);
			            errorAlert.setHeaderText("Invalid value entered");
			            errorAlert.setContentText("Error message: " + s);
			            errorAlert.showAndWait();
					}
				}
				else {
					Alert infoAlert = new Alert(Alert.AlertType.INFORMATION);
					infoAlert.setHeaderText("Values Successfully Inserted into table Organizes");
					infoAlert.setContentText("Continue to insert more values into either the Organizes table or any other table");
					infoAlert.showAndWait();
				}
				text1.setText("");
				text2.setText("");
				text3.setText("");
			}
		}
	}

}
