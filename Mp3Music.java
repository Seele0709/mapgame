import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.scene.media.AudioClip;
import java.io.File;

// Music file was from: https://www.tam-music.com/m000_category/musicbox

public class Mp3Music extends Application {
    Label label;
	Button b;
	AudioClip ac;
	
    public static void main(String[] args) {
        launch(args);
    }
 
    @Override
    public void start(Stage stage) throws Exception {
        label = new Label("Please click a button.");         
    	ac = new AudioClip(new File("tammb14.mp3").toURI().toString());
    	b = new Button("play");
    	ac.setVolume(1);
		ac.setCycleCount(AudioClip.INDEFINITE);
    	b.setOnAction(new EventHandler<ActionEvent>(){
    		@Override
    		public void handle(ActionEvent e){
    			 ac.play();
    		}
    	});
    	
    	BorderPane bp = new BorderPane();
        bp.setTop(label);
        bp.setCenter(b);
        Scene scene = new Scene(bp, 320, 120);
        stage.setScene(scene);
        stage.show();
    	
    }
 
}
