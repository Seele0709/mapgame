import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.KeyCode;
import javafx.scene.Group;
import javafx.scene.layout.Pane;


public class MapGameController implements Initializable {
    private int dx;
    private int dy;
    public MapData mapData;
    public MoveChara chara;
    public GridPane mapGrid;
    public ImageView[] mapImageViews;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        mapData = new MapData(21, 15);
        chara = new MoveChara(1, 1, mapData);
        mapImageViews = new ImageView[mapData.getHeight()*mapData.getWidth()];
        for(int y=0; y<mapData.getHeight(); y++){
            for(int x=0; x<mapData.getWidth(); x++){
                int index = y*mapData.getWidth() + x;
                mapImageViews[index] = mapData.getImageView(x,y);
            }
        }
        drawMap(chara, mapData);
    }

    // Draw the map
    public void drawMap(MoveChara c, MapData m){
        int cx = c.getPosX();
        int cy = c.getPosY();
        mapGrid.getChildren().clear();
        for(int y=0; y<mapData.getHeight(); y++){
            for(int x=0; x<mapData.getWidth(); x++){
                int index = y*mapData.getWidth() + x;
                if (x==cx && y==cy) {
                    mapGrid.add(c.getCharaImageView(), x, y);
                } else {
                    mapGrid.add(mapImageViews[index], x, y);
                }
            }
        }
    }

    // Get users key actions
    public void keyAction(KeyEvent event){
        KeyCode key = event.getCode(); System.out.println("keycode:"+key);
        if (key == KeyCode.H){
        	leftButtonAction();
        }else if (key == KeyCode.J){
            downButtonAction();
        }else if (key == KeyCode.K){
            upButtonAction();
        }else if (key == KeyCode.L){
            rightButtonAction();
        }
    }

    // Operations for going the cat down
    public void upButtonAction(){
        dx = 0; dy = -1;
        printAction("UP");
        chara.setCharaDirection(MoveChara.TYPE_UP);
        int data = mapData.getMap(chara.getPosX()+dx, chara.getPosY()+dy);
        if (data >= 2) {
            mapData.setMap(chara.getPosX()+dx, chara.getPosY()+dy, MapData.TYPE_SPACE);
            mapData.setImageViews();
            setMapImageViews(chara.getPosX()+dx, chara.getPosY()+dy);
        }
        chara.move(dx, dy);
        drawMap(chara, mapData);
    }

    // Operations for going the cat down
    public void downButtonAction(){
        dx = 0; dy = 1;
        printAction("DOWN");
        chara.setCharaDirection(MoveChara.TYPE_DOWN);        
        int data = mapData.getMap(chara.getPosX()+dx, chara.getPosY()+dy);
        if (data >= 2) {
            mapData.setMap(chara.getPosX()+dx, chara.getPosY()+dy, MapData.TYPE_SPACE);
            mapData.setImageViews();
            setMapImageViews(chara.getPosX()+dx, chara.getPosY()+dy);
        }
        chara.move(dx, dy);
        drawMap(chara, mapData);
    }

    // Operations for going the cat right
    public void leftButtonAction(){
        dx = -1; dy = 0;
        printAction("LEFT");
        chara.setCharaDirection(MoveChara.TYPE_LEFT);
        int data = mapData.getMap(chara.getPosX()+dx, chara.getPosY()+dy);
        if (data >= 2) {
            mapData.setMap(chara.getPosX()+dx, chara.getPosY()+dy, MapData.TYPE_SPACE);
            mapData.setImageViews();
            setMapImageViews(chara.getPosX()+dx, chara.getPosY()+dy);
        }
        chara.move(dx, dy);
        drawMap(chara, mapData);
    }

    // Operations for going the cat right
    public void rightButtonAction(){
        dx = 1; dy = 0;
        printAction("RIGHT");
        chara.setCharaDirection(MoveChara.TYPE_RIGHT);
        int data = mapData.getMap(chara.getPosX()+dx, chara.getPosY()+dy);
        if (data >= 2) {
            mapData.setMap(chara.getPosX()+dx, chara.getPosY()+dy, MapData.TYPE_SPACE);
            mapData.setImageViews();
            setMapImageViews(chara.getPosX()+dx, chara.getPosY()+dy);
        }
        chara.move(dx, dy);
        drawMap(chara, mapData);
    }

    public void func1ButtonAction(ActionEvent event) {
        System.out.println("func1: Nothing to do");
    }

    // Print actions of user inputs
    public void printAction(String actionString) {
        System.out.println("Action: " + actionString);
    }

    //MapGameControllerにおけるアイテムを取ったあとの白紙の画像を反映させる関数
        public void setMapImageViews(int x, int y){
        int index = y*mapData.getWidth() + x;
        mapImageViews[index] = mapData.getImageView(x, y);
    }


}
