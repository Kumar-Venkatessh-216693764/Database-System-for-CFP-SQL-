package application;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.animation.FadeTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Q3_216693764 implements Initializable {
	
	@FXML
	private AnchorPane rootPane;
	
	@FXML
	private Button q1;
	
	@FXML
	private Button q2;
	
	@FXML
	private Label screen;
	
	ArrayList<String> listA11 = new ArrayList<String>();
	ArrayList<String> listA12 = new ArrayList<String>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		makeFade();
		
	}
	
	private void makeFade() {
		FadeTransition fadeTransition = new FadeTransition();
		fadeTransition.setDuration(Duration.millis(500));
		fadeTransition.setNode(rootPane);
		fadeTransition.setFromValue(0);
		fadeTransition.setToValue(1);
	
		fadeTransition.play();
		
	}
	
	public static Connection getConnection() throws Exception{
		try{
			String driver = "com.mysql.cj.jdbc.Driver";
			String url = "jdbc:mysql://localhost:3306/3421a03";
			String username = "root";
			String password = "";
			Class.forName(driver);
		   
			Connection conn = DriverManager.getConnection(url,username,password);
			return conn;
		} 
		catch(Exception e){
			System.out.println(e);
		}
		  
		  
		return null;
	}
	
	public static String insertTable(String TableName, String EventName, String EventWebLink, String CFPText, 
			String City, String Country, String EventConferenceDate, 
			String JournalName, String Publisher, 
			String ActivityName, String ActivityDate, 
			String ResearchName, String ResearchArea, 
			String PeopleName, String Affiliation, 
			String TopicName, 
			String Role) throws Exception {
		
		try{
			Connection con = getConnection();
			if(TableName.equals("t1")) {
				PreparedStatement insert = con.prepareStatement("INSERT INTO Event VALUES ('"+EventName+"', '"+EventWebLink+"', '"+CFPText+"');");
				insert.executeUpdate();
			}
			else if(TableName.equals("t2")) {
				PreparedStatement insert = con.prepareStatement("INSERT INTO EventConference VALUES ('"+EventName+"', '"+City+"', '"+Country+"', '"+EventConferenceDate+"');");
				insert.executeUpdate();
			}
			else if(TableName.equals("t3")) {
				PreparedStatement insert = con.prepareStatement("INSERT INTO EventJournal VALUES ('"+EventName+"', '"+JournalName+"', '"+Publisher+"');");
				insert.executeUpdate();
			}
			else if(TableName.equals("t4")) {
				PreparedStatement insert = con.prepareStatement("INSERT INTO EventBook VALUES ('"+EventName+"', '"+Publisher+"');");
				insert.executeUpdate();
			}
			else if(TableName.equals("t5")) {
				PreparedStatement insert = con.prepareStatement("INSERT INTO ActivityHappens VALUES ('"+EventName+"', '"+ActivityName+"', '"+ActivityDate+"');");
				insert.executeUpdate();
			}
			else if(TableName.equals("t6")) {
				PreparedStatement insert = con.prepareStatement("INSERT INTO ResearchTopic VALUES ('"+ResearchName+"', '"+ResearchArea+"');");
				insert.executeUpdate();
			}
			else if(TableName.equals("t7")) {
				PreparedStatement insert = con.prepareStatement("INSERT INTO People VALUES ('"+PeopleName+"', '"+Affiliation+"');");
				insert.executeUpdate();
			}
			else if(TableName.equals("t8")) {
				PreparedStatement insert = con.prepareStatement("INSERT INTO Covers VALUES ('"+EventName+"', '"+TopicName+"');");
				insert.executeUpdate();
			}
			else if(TableName.equals("t9")) {
				PreparedStatement insert = con.prepareStatement("INSERT INTO Organizes VALUES ('"+EventName+"', '"+PeopleName+"', '"+Role+"');");
				insert.executeUpdate();
			}
			
		} 
		catch(Exception e){
			return e.toString();
		}
		return null;
		
	}
	
	public static ArrayList<String> selectTable(String val) throws Exception {
		try{
			if(val.equals("a1")) {
				Connection con = getConnection();
				PreparedStatement select1 = con.prepareStatement("SELECT EXTRACT(MONTH FROM EventConference.Date) AS Month, COUNT(EventName) AS ConferenceEvents\n"
						+ "FROM EventConference\n"
						+ "GROUP BY Month;");
				
				ResultSet result1 = select1.executeQuery();
				
				ArrayList<String> listA1 = new ArrayList<String>();
				while(result1.next()) {
					listA1.add(result1.getString("Month"));
					listA1.add(result1.getString("ConferenceEvents"));
				}
				return listA1;
			}
			else if(val.equals("a2")) {
				Connection con = getConnection();
				PreparedStatement select2 = con.prepareStatement("SELECT EXTRACT(MONTH FROM ActivityHappens.ActivityDate) AS Month, COUNT(ActivityHappens.EventName) AS JournalEvents\n"
						+ "FROM EventJournal, ActivityHappens\n"
						+ "WHERE EventJournal.EventName = ActivityHappens.EventName\n"
						+ "GROUP BY Month;");
				
				ResultSet result2 = select2.executeQuery();
				
				ArrayList<String> listA2 = new ArrayList<String>();
				while(result2.next()) {
					listA2.add(result2.getString("Month"));
					listA2.add(result2.getString("JournalEvents"));
				}
				return listA2;
			}
			else if(val.equals("a3")) {
				Connection con = getConnection();
				PreparedStatement select3 = con.prepareStatement("SELECT EXTRACT(MONTH FROM ActivityHappens.ActivityDate) AS Month, COUNT(ActivityHappens.EventName) AS BookEvents\n"
						+ "FROM EventBook, ActivityHappens\n"
						+ "WHERE EventBook.EventName = ActivityHappens.EventName\n"
						+ "GROUP BY Month;");
				
				ResultSet result3 = select3.executeQuery();
				
				ArrayList<String> listA3 = new ArrayList<String>();
				while(result3.next()) {
					listA3.add(result3.getString("Month"));
					listA3.add(result3.getString("BookEvents"));
				}
				return listA3;
			}
			else if(val.equals("b1")) {
				Connection con = getConnection();
				PreparedStatement select4 = con.prepareStatement("SELECT EventConference.EventName, MIN(ActivityHappens.ActivityDate) AS EarliestConferenceEventDate\n"
						+ "FROM EventConference, ActivityHappens\n"
						+ "WHERE EventConference.EventName = ActivityHappens.EventName\n"
						+ "GROUP BY EventConference.EventName;");
				
				ResultSet result4 = select4.executeQuery();
				
				ArrayList<String> listA4 = new ArrayList<String>();
				while(result4.next()) {
					listA4.add(result4.getString("EventName"));
					listA4.add(result4.getString("EarliestConferenceEventDate"));
				}
				return listA4;
			}
			else if(val.equals("b2")) {
				Connection con = getConnection();
				PreparedStatement select5 = con.prepareStatement("SELECT EventJournal.EventName, MIN(ActivityHappens.ActivityDate) AS EarliestJournalEventDate\n"
						+ "FROM EventJournal, ActivityHappens\n"
						+ "WHERE EventJournal.EventName = ActivityHappens.EventName\n"
						+ "GROUP BY EventJournal.EventName;");
				
				ResultSet result5 = select5.executeQuery();
				
				ArrayList<String> listA5 = new ArrayList<String>();
				while(result5.next()) {
					listA5.add(result5.getString("EventName"));
					listA5.add(result5.getString("EarliestJournalEventDate"));
				}
				return listA5;
			}
			else if(val.equals("b3")) {
				Connection con = getConnection();
				PreparedStatement select6 = con.prepareStatement("SELECT EventBook.EventName, MIN(ActivityHappens.ActivityDate) AS EarliestBookEventDate\n"
						+ "FROM EventBook, ActivityHappens\n"
						+ "WHERE EventBook.EventName = ActivityHappens.EventName\n"
						+ "GROUP BY EventBook.EventName;");
				
				ResultSet result6 = select6.executeQuery();
				
				ArrayList<String> listA6 = new ArrayList<String>();
				while(result6.next()) {
					listA6.add(result6.getString("EventName"));
					listA6.add(result6.getString("EarliestBookEventDate"));
				}
				return listA6;
			}
			return null;
		} 
		catch(Exception e){
			ArrayList<String> list3 = new ArrayList<String>();
			list3.add(e.toString());
			return list3;
		}
		
	}
	
	public void QuestionOneAction() {
		makeFadeOutQuestionOne();
	}
	
	public void QuestionTwoAction() {
		makeFadeOutQuestionTwo();
	}
	
	private void makeFadeOutQuestionOne() {
		FadeTransition fadeTransition = new FadeTransition();
		fadeTransition.setDuration(Duration.millis(500));
		fadeTransition.setNode(rootPane);
		fadeTransition.setFromValue(1);
		fadeTransition.setToValue(0);
		fadeTransition.setOnFinished(event -> loadQuestionOne());
		fadeTransition.play();
	}
	
	private void makeFadeOutQuestionTwo() {
		FadeTransition fadeTransition = new FadeTransition();
		fadeTransition.setDuration(Duration.millis(500));
		fadeTransition.setNode(rootPane);
		fadeTransition.setFromValue(1);
		fadeTransition.setToValue(0);
		fadeTransition.setOnFinished(event -> loadQuestionTwo());
		fadeTransition.play();
	}
	
	public void loadQuestionOne() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource("QuestionOne.fxml"));
			Parent secondView = loader.load();
			Scene newScene = new Scene(secondView);
			Q1_216693764 controller = loader.getController();
			Stage curStage = (Stage) rootPane.getScene().getWindow();
			curStage.setScene(newScene);
			curStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void loadQuestionTwo() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource("QuestionTwo.fxml"));
			Parent secondView = loader.load();
			Scene newScene = new Scene(secondView);
			Q2_216693764 controller = loader.getController();
			Stage curStage = (Stage) rootPane.getScene().getWindow();
			curStage.setScene(newScene);
			curStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

}
