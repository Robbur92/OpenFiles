package application;

import java.io.File;
import java.util.List;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;

public class MainController {
	@FXML
	private Button btn1;
	
	@FXML
	private Button btn2;
	
	@FXML
	private ListView<String> listView;
	
	//Function for single file button
	public void button1Action(ActionEvent event) {
		FileChooser fc = new FileChooser();
		
		//Opens the filechooser in a specific directory
		fc.setInitialDirectory(
				new File ("C:\\Users\\Robin\\Music"));
		//Adds a filter to only show PDF files
		fc.getExtensionFilters().addAll(
				new ExtensionFilter("PDF Files", ".pdf"));
		
		File selectedFile = fc.showOpenDialog(null);
		
		if(selectedFile != null) {
			listView.getItems().add(selectedFile.getAbsolutePath());			
		} 
		else {
			System.out.println("file is not valid");
		}
		
	}
	
	//Function for multiple files button
	public void button2Action(ActionEvent event) {
		FileChooser fc = new FileChooser();
		
		List<File> selectedFiles = fc.showOpenMultipleDialog(null);
		
		if(selectedFiles != null) {
			for(int i = 0; i < selectedFiles.size(); i++) {
				listView.getItems().add(selectedFiles.get(i).getAbsolutePath());			
			}

		} 
		else {
			System.out.println("file is not valid");
		}
	}

}
