package glsccompgraph;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch();

	}

	@Override
	public void start(Stage stage) throws Exception {
		// TODO Auto-generated method stub
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/upload.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("GLSC Image Converter");
        stage.setScene(scene);
        stage.show();
		
	}

}
