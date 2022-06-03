package capuli;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

public class LogWindowController {
	@FXML private TextArea txtArea;
	@FXML private Button loadBttn;
	@FXML private Button clrBttn;
	@FXML private Button saveBttn;
	private ArrayList<String> _log = MainController._log; // A reference to the list of items

	@FXML private void initialize() {
		// Attach event handler(s)
		loadBttn.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				onLoadClicked();    // Always call a method in the outer class
			}
		});

		clrBttn.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				onClearClicked();    // Always call a method in the outer class
			}
		});

		saveBttn.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				onSaveClicked();    // Always call a method in the outer class
			}
		});
	}

	//Loads the objects saved in the _log Arraylist to the text area
	private void onLoadClicked() {
		try{
			for (int i=0; i < _log.size(); i++ ){
				txtArea.appendText(_log.get(i) + "\n");
			}
		} catch (Exception e){
			System.out.print(e.getMessage());
		}

	}

	//Clears the objects in saved in the _log Arraylist and the text area
	private void onClearClicked() {
		txtArea.clear();
		_log.clear();
	}

	//Saves the objects saved in the _log Arraylist to the log.txt file
	private void onSaveClicked() {

		try{
			//Writing into the log.txt
			File file = new File ("log.txt");

			FileWriter fw = new FileWriter(file,true);
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter writer = new PrintWriter(bw);

			//Checks if the file exists
			if(!file.exists()){
				file.createNewFile();
			}

			for (int i=0; i < _log.size(); i++ ){
				writer.println(_log.get(i));
			}

			writer.close();

		} catch(IOException ioe){
			System.out.println("Exception occurred:");
			ioe.printStackTrace();
		}

	}

}

















