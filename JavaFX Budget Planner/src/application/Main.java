package application;

// Imports all libraries used in application
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * Main; code where the FXML file is loaded in and used for the window layout and execution of "The Ultimate Budgeter" . Button
 * and textbook definitions are also defined and executed. Extends the JavaFX Application class. his is an application that can
 * plan your recommended monthly spending amounts based on monthly income and calculate expense percentages and expenditure totals. 
 *
 * @author Dharsan Ravindran
 * @since 2021-08-15
 * @version 1.0
 * Student ID: 20219218
 * Instructor: Professor Paul Allison
 */
public class Main extends Application {
	
    /**
     *Entry point for this JavaFX application, defines and shows the primary stage and scene for the application window.
     *Attempts to declare and show the stage and prints the stack if a Java error was caught.
     *
     * @param primaryStage
     */
	@Override
	public void start(Stage primaryStage) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("ExpandedBudget.fxml")); // Loads the provided FXML file for window layout
			loader.setController(this); // Allows the FXML file provided to control the window layout
			Parent root = loader.load(); // Sets a parent node that can hold the FXML file elements 
			Scene scene = new Scene(root,400,400); // Creates a scene that contains root (parent node) 
			primaryStage.setTitle("The Ultimate Budgeter"); // Sets the window title to the application name
			primaryStage.setScene(scene); // Sets the scene for the primary stage
			primaryStage.show(); // Shows the primary stage so the application can be interacted with
			
		} catch(Exception e) {
			e.printStackTrace(); // Prints all method calls the application was executing when the error was thrown for debugging
		}
	}
	
	@FXML Button btnVisualize; // Calls the visualize budget button from the FXML file using its fxID
	@FXML Button btnPlan; // Calls the plan budget button from the FXML file using its fxID
	@FXML Button btnTotal; // Calls the total button from the FXML file using its fxID
	@FXML TextField txtIncome; // Calls the Monthly income text field from the FXML file using its fxID
	@FXML TextField txtEducation; // Calls the education expenses text field from the FXML file using its fxID
	@FXML TextField txtHousing; // Calls the housing expenses text field from the FXML file using its fxID
	@FXML TextField txtFood; // Calls the food expenses text field from the FXML file using its fxID
	@FXML TextField txtTransportation; // Calls the transportation expenses text field from the FXML file using its fxID
	@FXML Label lblResult; // Calls the empty label where the result will be shown from the FXML file using its fxID
	
    /**
     *Initialize method for the JavaFX application which sets and defines the actions of the 3 buttons using lambda methods.
     *
     */
	public void initialize(){

		btnTotal.setOnAction((event)->{
			// Following set of actions occur when "Calculate Total Expenses" button is pressed
			
			double education = Double.parseDouble(txtEducation.getText());
			double housing = Double.parseDouble(txtHousing.getText());
			double food = Double.parseDouble(txtFood.getText());
			double transport = Double.parseDouble(txtTransportation.getText());
			String total = "Total Expenses: \n\n\t$" + Double.toString(education+housing+food+transport);// Creates a String to display total expenditure
			lblResult.setText("\t"+ total); // Sets the empty result label to the String to display total
		});
		
		btnVisualize.setOnAction((event)->{
			// Following set of actions occur when "Visualize Your Budget" button is pressed
			double education = Double.parseDouble(txtEducation.getText());
			double housing = Double.parseDouble(txtHousing.getText());
			double food = Double.parseDouble(txtFood.getText());
			double transport = Double.parseDouble(txtTransportation.getText());
			double totalNum = education+ housing + food + transport;
			String eduPercent = "\tEducation: " + String.format("%.2f",(education/totalNum)*100) +"%"; //Format the percentages to 2 decimal places
			String housingPercent = "Housing: " + String.format("%.2f",(housing/totalNum)*100)+"%";
			String foodPercent = "Food: " + String.format("%.2f",(food/totalNum)*100)+ "%";
			String transportPercent = "Transport: " + String.format("%.2f",(transport/totalNum)*100)+ "%";
			lblResult.setText(eduPercent+"\n\n\t" + housingPercent + "\n\n\t" + foodPercent +"\n\n\t" + transportPercent); // Displays all percentages with formating and labels
		});
		
		btnPlan.setOnAction((event)->{
			// Following set of actions occur when "Plan My Budget" button is pressed
			double budget = Double.parseDouble(txtIncome.getText());
			String needs = "\t Needs: $" + String.format("%.2f",budget*0.5); //Formats to 2 decimal places and ads dollar sign for clarity
			String wants = "\t Wants: $" + String.format("%.2f", budget*0.3);
			String savings = "\t Savings: $" + String.format("%.2f", budget*0.2); 
			lblResult.setText(needs +"\n\n" + wants + "\n\n" + savings); // Displays all recommended budgeting amounts in the empty label
		});
	}
	
    /**
     *Main method where the entire Budget application is launched and all methods are executed
     *
     */
	public static void main(String[] args) {
		launch(args);
	}
}
