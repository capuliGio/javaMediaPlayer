package capuli;

import java.util.ArrayList;
import java.util.Date;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class MainController {
	@FXML private TextField txtField;
	@FXML private Button loadBttn;
	@FXML private Button playBttn;
	@FXML private Button openLogBttn;
	@FXML private ImageView imgSong;
	@FXML private Label _title;
	@FXML private Label _productionYear;
	@FXML private Label nowPlayingLbl;
	private Song newSong = new Song();
	private Movie newMovie = new Movie();
	private MediaList newList = new MediaList();

	static ArrayList<String> _log = new ArrayList<String>();

	@FXML private void initialize() {
		// Attach event handler(s)
		loadBttn.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				onLoadClicked();    // Always call a method in the outer class
			}
		});

		playBttn.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				onPlayClicked();    // Always call a method in the outer class
			}
		});

		openLogBttn.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				onOpenSesameClicked();    // Always call a method in the outer class
			}
		});

	}

	private void onLoadClicked() {

		try{
			int loadNum = Integer.parseInt(txtField.getText());

			//Set title and production year in the labels
			_title.setText(newList.lookup(loadNum).getTitle());
			String log = newList.lookup(loadNum).getTitle();
			_productionYear.setText(String.valueOf(newList.lookup(loadNum).getProductionYear()));

			//Load respective images of loaded media
			Image image = new Image(newList.lookup(loadNum).getImagePath());
			imgSong.setImage(image);

			//Adding in the ArrayList _log
			Date date = new Date();
			_log.add("Loaded: " + log + " @ " + date);

		}catch(IndexOutOfBoundsException e){
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Error");
			alert.setHeaderText("Error: Index is Out of Bounds");
			alert.setContentText("Please input 0-5 only.");
			alert.showAndWait();
		}catch (Exception e){
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Error");
			alert.setHeaderText("Error: Invalid Input in the Index");
			alert.setContentText("Please input integers (0-5) only.");
			alert.showAndWait();
		}
	}

	private void onPlayClicked() {

		//If-else statement to prevent playing when no media is loaded
		if (_title.getText() != ""){
			try{

				//Set text that the loaded media is playing by calling playMedia()
				int loadNum = Integer.parseInt(txtField.getText());

				if (loadNum <= 2){
					nowPlayingLbl.setText(String.valueOf(newMovie.playMedia() + newList.lookup(loadNum).getTitle()));
					String playLogMovie = String.valueOf(newList.lookup(loadNum).getTitle());
					Date date2 = new Date();
					_log.add("Played: " + playLogMovie + " @ " + date2);
				}
				else if (loadNum >= 3 || loadNum <= 5){
					nowPlayingLbl.setText(String.valueOf(newSong.playMedia() + newList.lookup(loadNum).getTitle()));
					String playLogSong = String.valueOf(newList.lookup(loadNum).getTitle());
					Date date3 = new Date();
					_log.add("Played: " + playLogSong + " @ " + date3);
				}
			}catch(IndexOutOfBoundsException e){
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("Error");
				alert.setHeaderText("Error: Index is Out of Bounds");
				alert.setContentText("Please input 0-5 only. Then press Load");
				alert.showAndWait();
			}catch (Exception e){
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("Error");
				alert.setHeaderText("Error: Invalid Input in the Index");
				alert.setContentText("Please input integers (0-5) only. Then press Load");
				alert.showAndWait();
			}
		} else{
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Error");
			alert.setHeaderText("Error: No media is loaded");
			alert.setContentText("Please input an Index first. Then press Load");
			alert.showAndWait();
		}
	}

	// Click handler for Open Sesame button
	private void onOpenSesameClicked() {
		// Open the second window (stage)
		try {
			AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("LogWindow.fxml"));
			Scene scene = new Scene(root,853,619);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			Stage secondStage = new Stage();
			secondStage.setScene(scene);
			secondStage.setTitle("LogWindow");
			secondStage.initModality(Modality.APPLICATION_MODAL);  // Use this to make the 2nd window modal (must close 2nd window to return to main window)
			secondStage.showAndWait();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

}
