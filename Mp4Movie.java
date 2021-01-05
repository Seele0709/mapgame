import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import java.io.File;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

// Movie file was from: https://www.pexels.com/ja-jp/videos/

public class Mp4Movie extends Application {
    Label label;
	Button b;
	Media m;
	
    public static void main(String[] args) {
        launch(args);
    }
 
    @Override
    public void start(Stage stage) throws Exception {
        label = new Label("Please click a button.");         
    	m = new Media(new File("Pexels_Videos_1722593.mp4").toURI().toString());
    	MediaPlayer mp = new MediaPlayer(m);
    	MediaView mv = new MediaView(mp);
    	mv.setFitHeight(240.0);
    	mv.setFitWidth(320.0);
    	b = new Button("play");
    	b.setOnAction(new EventHandler<ActionEvent>(){
    		@Override
    		public void handle(ActionEvent e){
    			 mp.play();
    		}
    	});
    	
    	BorderPane bp = new BorderPane();
        bp.setTop(label);
    	bp.setCenter(mv);
        bp.setBottom(b);
        Scene scene = new Scene(bp, 400, 300);
        stage.setScene(scene);
        stage.show();
    	
    }
 
}
