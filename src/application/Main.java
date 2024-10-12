package application;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;


public class Main extends Application {
	
	static boolean salariedEmp = false;
	static boolean hourlyEmp = false;
	static boolean comEmp = false;
	static boolean bPComEmp = false;
	
	TextField tfFirstName = new TextField();
	TextField tfLastName = new TextField();
	TextField tfSSN = new TextField();
	TextField tfSUSSN = new TextField();
	TextField tfGrossSales = new TextField();
	TextField tfCommissionRates = new TextField();
	TextField tfBaseSalary = new TextField();
	TextField tfWeeklySalary = new TextField();
	TextField tfWage = new TextField();
	TextField tfHours = new TextField();
	
	Button btAdd = new Button("Add");
	Button btSbSSN = new Button("Search by SSN");
	Button btUbSSN = new Button("Update by SSN");
	Button btClean = new Button("Clean All Text Fields");
	
	Label lbFirstName = new Label("First Name");
	Label lbLastName = new Label("Last Name");
	Label lbSSN = new Label("SSN");
	Label lbSUSSN = new Label("Search/Update SSN");
	Label lbGrossSales = new Label("Gross Sales");
	Label lbCommissionRates = new Label("Commission Rates");
	Label lbBaseSalary = new Label("Base Salary");
	Label lbweeklySalary = new Label("Weekly Salary");
	Label lbwage = new Label("Wage");
	Label lbHours = new Label("Hours");
	Label lbSalary = new Label("Salary");
	Label lbvalue = new Label("");
	Label lbChooseType = new Label("Choose Employee Type");
	
	
	@Override
	public void start(Stage primaryStage) {
		try {
			
			tfFirstName.setPrefColumnCount(10);
			tfLastName.setPrefColumnCount(10);
			tfSSN.setPrefColumnCount(10);
			tfSUSSN.setPrefColumnCount(10);
			tfGrossSales.setPrefColumnCount(10);
			tfCommissionRates.setPrefColumnCount(10);
			tfBaseSalary.setPrefColumnCount(10);
			tfWeeklySalary.setPrefColumnCount(10);
			tfWage.setPrefColumnCount(10);
			tfHours.setPrefColumnCount(10);
			
			
			
			GridPane p1 = new GridPane();
			p1.setAlignment(Pos.CENTER);
			p1.setVgap(0);
			p1.setHgap(5);
			
			VBox v1 = new VBox(12);
			v1.getChildren().addAll(lbFirstName,lbLastName,lbSSN,lbSUSSN,lbSalary);
			p1.add(v1, 0, 0);
			
			VBox v2 = new VBox(5);
			v2.getChildren().addAll(tfFirstName,tfLastName,tfSSN,tfSUSSN,lbvalue);
			p1.add(v2, 1, 0);
						
			VBox v3 = new VBox(12);
			v3.getChildren().addAll(lbGrossSales,lbCommissionRates,lbBaseSalary,lbweeklySalary,lbwage,lbHours);
			p1.add(v3, 2, 0);
			
			VBox v4 = new VBox(5);
			v4.getChildren().addAll(tfGrossSales,tfCommissionRates,tfBaseSalary,tfWeeklySalary,tfWage,tfHours);
			p1.add(v4, 3, 0);
			
			
			
			GridPane p2 = new GridPane();
			p2.setAlignment(Pos.BOTTOM_CENTER);
			p2.setVgap(0);
			p2.setHgap(10);
			p2.add(lbChooseType, 0, 0);
			
			String empTypes[] = {"Salaried Employee","Hourly Employee","Commission Employee","Base Plus Commission Employee","None"};
			
			ComboBox<String> comboBox = new ComboBox<String>(FXCollections.observableArrayList(empTypes));
			
			p2.add(comboBox, 1, 0);
			tfSSN.setDisable(true);
			
			EventHandler<ActionEvent> eventt = new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent e) {
					if(comboBox.getValue()=="None") {
						salariedEmp = false;
						hourlyEmp = false;
						comEmp = false;
						bPComEmp = false;
						tfFirstName.setDisable(true);
						tfLastName.setDisable(true);
						tfGrossSales.setDisable(true);
						tfCommissionRates.setDisable(true);
						tfBaseSalary.setDisable(true);
						tfWeeklySalary.setDisable(true);
						tfWage.setDisable(true);
						tfHours.setDisable(true);
					}
					else if(comboBox.getValue()=="Salaried Employee") {
						salariedEmp = true;
						hourlyEmp = false;
						comEmp = false;
						bPComEmp = false;
						tfFirstName.setDisable(false);
						tfLastName.setDisable(false);
						tfGrossSales.setDisable(true);
						tfCommissionRates.setDisable(true);
						tfBaseSalary.setDisable(true);
						tfWeeklySalary.setDisable(false);
						tfWage.setDisable(true);
						tfHours.setDisable(true);
					}
					else if (comboBox.getValue()=="Hourly Employee") {
						salariedEmp = false;
						hourlyEmp = true;
						comEmp = false;
						bPComEmp = false;
						tfFirstName.setDisable(false);
						tfLastName.setDisable(false);
						tfGrossSales.setDisable(true);
						tfCommissionRates.setDisable(true);
						tfBaseSalary.setDisable(true);
						tfWeeklySalary.setDisable(true);
						tfWage.setDisable(false);
						tfHours.setDisable(false);
					}
					else if(comboBox.getValue()=="Commission Employee") {
						salariedEmp = false;
						hourlyEmp = false;
						comEmp = true;
						bPComEmp = false;
						tfFirstName.setDisable(false);
						tfLastName.setDisable(false);
						tfGrossSales.setDisable(false);
						tfCommissionRates.setDisable(false);
						tfBaseSalary.setDisable(true);
						tfWeeklySalary.setDisable(true);
						tfWage.setDisable(true);
						tfHours.setDisable(true);
					}
					else if(comboBox.getValue()=="Base Plus Commission Employee") {
						salariedEmp = false;
						hourlyEmp = false;
						comEmp = false;
						bPComEmp = true;
						tfFirstName.setDisable(false);
						tfLastName.setDisable(false);
						tfGrossSales.setDisable(false);
						tfCommissionRates.setDisable(false);
						tfBaseSalary.setDisable(false);
						tfWeeklySalary.setDisable(true);
						tfWage.setDisable(true);
						tfHours.setDisable(true);
					}
				}
			};
			comboBox.setOnAction(eventt);
			
			GridPane p3 = new GridPane();
			p3.setAlignment(Pos.TOP_CENTER);
			p3.setVgap(0);
			p3.setHgap(5);
			
			HBox h1 = new HBox(5);
			h1.getChildren().addAll(btAdd,btSbSSN,btUbSSN,btClean);
			p3.add(h1, 0, 4);
			
			btAdd.setOnAction(event ->{
				btAdd();
			});
			
			btSbSSN.setOnAction(event ->{
				btSbSSN();
				if(employee[Integer.parseInt(tfSUSSN.getText())].getClass().getSimpleName().equals("SalariedEmployee")) {
					comboBox.getSelectionModel().select("Salaried Employee");
				}
				else if(employee[Integer.parseInt(tfSUSSN.getText())].getClass().getSimpleName().equals("HourlyEmployee")) {
					comboBox.getSelectionModel().select("Hourly Employee");
				}
				else if(employee[Integer.parseInt(tfSUSSN.getText())].getClass().getSimpleName().equals("CommissionEmployee")) {
					comboBox.getSelectionModel().select("Commission Employee");
				}
				else if(employee[Integer.parseInt(tfSUSSN.getText())].getClass().getSimpleName().equals("BasePlusCommissionEmployee")) {
					comboBox.getSelectionModel().select("Base Plus Commission Employee");
				}
			});
			
			btUbSSN.setOnAction(event ->{
				btUbSSN();
			});
			
			btClean.setOnAction(event ->{
				btClean();
				comboBox.getSelectionModel().select("None");
			});
			
			
			BorderPane borderPane= new BorderPane();
			borderPane.setCenter(p1);
			borderPane.setTop(p2);
			borderPane.setBottom(p3);

			Scene scene = new Scene(borderPane,600,350);
			primaryStage.setTitle("Employee Salary Calculator");
			primaryStage.setScene(scene);
			primaryStage.show();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		findCountandAddBack();
		launch(args);
	}
	
	static Employee employee[] = new Employee[100]; 
	static String fileName = "employees.txt";
	static int count = 1;
	
	public static void findCountandAddBack() {
		try {
			File file = new File(fileName);
			String lineString;
			if(file.exists()) {
				BufferedReader reader = new BufferedReader(new FileReader(fileName));
				while((lineString = reader.readLine()) != null) {
					ArrayList<String> data = new ArrayList<String>();
					Collections.addAll(data, lineString.split(" ",0));
					if(data.get(0).equalsIgnoreCase("salaried")) {
						employee[count] = new SalariedEmployee(data.get(2),data.get(3),data.get(4),Double.parseDouble(data.get(5)));
					}
					else if(data.get(0).equalsIgnoreCase("hourly")) {
						employee[count] = new HourlyEmployee(data.get(2),data.get(3),data.get(4),Double.parseDouble(data.get(5)),Double.parseDouble(data.get(6)));
					}
					else if(data.get(0).equalsIgnoreCase("commission")) {
						employee[count] = new CommissionEmployee(data.get(2),data.get(3),data.get(4),Double.parseDouble(data.get(5)),Double.parseDouble(data.get(6)));
					}
					else if(data.get(0).equalsIgnoreCase("base")) {	
						employee[count] = new BasePlusCommissionEmployee(data.get(4),data.get(5),data.get(6),Double.parseDouble(data.get(7)),Double.parseDouble(data.get(8)),Double.parseDouble(data.get(9)));
					}
					count++;				
				}
				reader.close();
			}
			else {
				file.createNewFile();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void btAdd() { 
		try {
			FileWriter writer = new FileWriter(fileName,true);
			if(salariedEmp) {
				employee[count] = new SalariedEmployee(tfFirstName.getText(),tfLastName.getText(),String.valueOf(count),Double.parseDouble(tfWeeklySalary.getText()));
				writer.write(employee[count].toString());
			}
			else if(hourlyEmp) {
				employee[count] = new HourlyEmployee(tfFirstName.getText(),tfLastName.getText(),String.valueOf(count),Double.parseDouble(tfWage.getText()),Double.parseDouble(tfHours.getText()));
				writer.write(employee[count].toString());
			}
			else if (comEmp) {
				employee[count] = new CommissionEmployee(tfFirstName.getText(),tfLastName.getText(),String.valueOf(count),Double.parseDouble(tfGrossSales.getText()),Double.parseDouble(tfCommissionRates.getText()));
				writer.write(employee[count].toString());
			}
			else if (bPComEmp) {
				employee[count] = new BasePlusCommissionEmployee(tfFirstName.getText(),tfLastName.getText(),String.valueOf(count),Double.parseDouble(tfGrossSales.getText()),Double.parseDouble(tfCommissionRates.getText()),Double.parseDouble(tfBaseSalary.getText()));
				writer.write(employee[count].toString());
			}
			writer.write(" " + employee[count].getPaymentAmount() + "\n");
			tfSSN.setText(String.valueOf(count));
			lbvalue.setText(String.valueOf(employee[count].getPaymentAmount()));
			count++;
			writer.close();				
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void btSbSSN(){
		tfFirstName.setText(employee[Integer.parseInt(tfSUSSN.getText())].getFirstName());
		tfLastName.setText(employee[Integer.parseInt(tfSUSSN.getText())].getLastName());
		tfSSN.setText(employee[Integer.parseInt(tfSUSSN.getText())].getSocialSecuritynumber());
		if(employee[Integer.parseInt(tfSUSSN.getText())].getClass().getSimpleName().equals("SalariedEmployee")) {
			SalariedEmployee newSE = (SalariedEmployee)employee[Integer.parseInt(tfSUSSN.getText())];
			tfWeeklySalary.setText(String.valueOf(newSE.getWeeklySalary()));
			lbvalue.setText(String.valueOf(newSE.getPaymentAmount()));
			tfWage.clear();
			tfHours.clear();
			tfGrossSales.clear();
			tfCommissionRates.clear();
			tfBaseSalary.clear();
		}
		else if(employee[Integer.parseInt(tfSUSSN.getText())].getClass().getSimpleName().equals("HourlyEmployee")) {
			HourlyEmployee newHE = (HourlyEmployee)employee[Integer.parseInt(tfSUSSN.getText())];
			tfWage.setText(String.valueOf(newHE.getWage()));
			tfHours.setText(String.valueOf(newHE.getHours()));
			lbvalue.setText(String.valueOf(newHE.getPaymentAmount()));
			tfWeeklySalary.clear();
			tfGrossSales.clear();
			tfCommissionRates.clear();
			tfBaseSalary.clear();
		}
		else if(employee[Integer.parseInt(tfSUSSN.getText())].getClass().getSimpleName().equals("CommissionEmployee")) {
			CommissionEmployee newCE = (CommissionEmployee)employee[Integer.parseInt(tfSUSSN.getText())];
			tfGrossSales.setText(String.valueOf(newCE.getGrossSales()));
			tfCommissionRates.setText(String.valueOf(newCE.getCommissionRates()));
			lbvalue.setText(String.valueOf(newCE.getPaymentAmount()));
			tfWage.clear();
			tfHours.clear();
			tfWeeklySalary.clear();
			tfBaseSalary.clear();
		}
		else if(employee[Integer.parseInt(tfSUSSN.getText())].getClass().getSimpleName().equals("BasePlusCommissionEmployee")) {
			BasePlusCommissionEmployee newBPCE = (BasePlusCommissionEmployee)employee[Integer.parseInt(tfSUSSN.getText())];
			tfGrossSales.setText(String.valueOf(newBPCE.getGrossSales()));
			tfCommissionRates.setText(String.valueOf(newBPCE.getCommissionRates()));
			tfBaseSalary.setText(String.valueOf(newBPCE.getBaseSalary()));
			lbvalue.setText(String.valueOf(newBPCE.getPaymentAmount()));
			tfWage.clear();
			tfHours.clear();
			tfWeeklySalary.clear();
		}
	}
	
	public void btUbSSN() {
		employee[Integer.parseInt(tfSUSSN.getText())].setFirstName(tfFirstName.getText());
		employee[Integer.parseInt(tfSUSSN.getText())].setLastName(tfLastName.getText());
		employee[Integer.parseInt(tfSUSSN.getText())].setSocialSecuritynumber(tfSSN.getText());
		if(employee[Integer.parseInt(tfSUSSN.getText())].getClass().getSimpleName().equals("SalariedEmployee")) {
			SalariedEmployee newSE = (SalariedEmployee)employee[Integer.parseInt(tfSUSSN.getText())];
			newSE.setWeeklySalary(Double.parseDouble(tfWeeklySalary.getText()));
			lbvalue.setText(String.valueOf(newSE.getPaymentAmount()));
		}
		else if(employee[Integer.parseInt(tfSUSSN.getText())].getClass().getSimpleName().equals("HourlyEmployee")) {
			HourlyEmployee newHE = (HourlyEmployee)employee[Integer.parseInt(tfSUSSN.getText())];
			newHE.setWage(Double.parseDouble(tfWage.getText()));
			newHE.setHours(Double.parseDouble(tfHours.getText()));
			lbvalue.setText(String.valueOf(newHE.getPaymentAmount()));
		}
		else if(employee[Integer.parseInt(tfSUSSN.getText())].getClass().getSimpleName().equals("CommissionEmployee")) {
			CommissionEmployee newCE = (CommissionEmployee)employee[Integer.parseInt(tfSUSSN.getText())];
			newCE.setGrossSales(Double.parseDouble(tfGrossSales.getText()));
			newCE.setCommissionRates(Double.parseDouble(tfCommissionRates.getText()));	
			lbvalue.setText(String.valueOf(newCE.getPaymentAmount()));
		}
		else if(employee[Integer.parseInt(tfSUSSN.getText())].getClass().getSimpleName().equals("BasePlusCommissionEmployee")) {
			BasePlusCommissionEmployee newBPCE = (BasePlusCommissionEmployee)employee[Integer.parseInt(tfSUSSN.getText())];
			newBPCE.setGrossSales(Double.parseDouble(tfGrossSales.getText()));
			newBPCE.setCommissionRates(Double.parseDouble(tfCommissionRates.getText()));
			newBPCE.setBaseSalary(Double.parseDouble(tfBaseSalary.getText()));
			lbvalue.setText(String.valueOf(newBPCE.getPaymentAmount()));
		}
		try {
			FileWriter writer = new FileWriter(fileName);
			for(int i=1;i<count;i++) {
				writer.write(employee[i].toString() + " " + employee[i].getPaymentAmount() + "\n");
			}
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void btClean() {
		tfFirstName.clear();
		tfLastName.clear();
		tfSSN.clear();
		tfSUSSN.clear();
		tfGrossSales.clear();
		tfCommissionRates.clear();
		tfBaseSalary.clear();
		tfWeeklySalary.clear();
		tfWage.clear();
		tfHours.clear();
		lbvalue.setText("");
	}
}