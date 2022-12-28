package class13;
import java.awt.Point;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.util.Duration;
public class FreeWork extends Application implements EventHandler, Map.GameEndListener  {
	private RadioButton rb1,rb2,rb3;
	private Label startLabel,statusLabel,lb1,lb2,lb3;
	private ToggleGroup tg=new ToggleGroup();
	private Scene sc1,sc2;
	private Stage stage;
	private double time = 100.0;
	private int duration = 100;
	private Timeline timeline;
	private boolean isRunning = false;
	private Button playButton,playButton1,playButton2;
	private Map map;
	private Image image;
	private MenuBar menuBar = new MenuBar();
	private BorderPane borderPane = new BorderPane();
	private BorderPane borderPane1 = new BorderPane();
	private BorderPane borderPane2 = new BorderPane();
	private FlowPane topFlowPane1 = new FlowPane();
	private FlowPane topFlowPane2 = new FlowPane();
	private FlowPane footerFlowPane1 = new FlowPane();
	private FlowPane footerFlowPane2 = new FlowPane();
	private VBox vb =new VBox(100);
	private VBox vb1 =new VBox(100);
	private VBox vb2 =new VBox(100);
	private int level = 0;
	private MenuItem openItem = new MenuItem("開く");
    private MenuItem saveItem = new MenuItem("保存");
    
	public static void main(String[] args){
		launch(args);
		}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		stage = primaryStage;
		
		DropShadow ds = new DropShadow();
	       ds.setOffsetX( 5.0f );
	       ds.setOffsetY( 5.0f );
	       ds.setColor( Color.RED );
		
		startLabel = new Label("スライドパズル");
		startLabel.setFont( Font.font( null , FontWeight.BOLD , 120 ) );
		startLabel.setTextFill( Color.YELLOW );
		startLabel.setEffect( ds );
		
		playButton = new Button("ゲームスタート");
		playButton.setFont(Font.font("Serif", 24));
		playButton.setOnAction(this);
		
		vb.getChildren().add(startLabel);
		vb.getChildren().add(playButton);
		vb.setAlignment(Pos.CENTER);
		
		image =new Image(getClass().getResourceAsStream("Background.jpg"));
		BackgroundSize size = new BackgroundSize(BackgroundSize.AUTO, 
				BackgroundSize.AUTO, 
		        false, 
		        false, 
		        true, 
		        true);

		borderPane.setCenter(vb);
		borderPane.setBackground(new Background(new BackgroundImage(image,
		        BackgroundRepeat.NO_REPEAT,
		        BackgroundRepeat.NO_REPEAT,
		        BackgroundPosition.CENTER,
		        size)));
		
		sc1 = new Scene(borderPane,800,800);
		stage.setScene(sc1);
		stage.setTitle("自由課題　1116190054 　岡　颯人");
		stage.show();
	}
	
	private void startApp() {
		timeline = new Timeline(new KeyFrame(
				new Duration(duration),
				new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					map.requestFocus();
					if (isRunning) {
					time -= duration / 1000.0;
					time = (int) ((1000 * time) + 0.01) / 1000.0;
					}
					jadge(level);
				    if(time==0.0){
						gameOver();
					}
					StatusLabel();
					map.paint(level);
					alert();
				}
				}
				));
				timeline.setCycleCount(Timeline.INDEFINITE);
				timeline.play();

	}
	
	@Override
	public void handle(Event event) {
	    if (tg.getSelectedToggle() ==rb1&&event.getTarget().equals(playButton1)) {
	    	GameScene(1);level=1;
		}
	    else if (tg.getSelectedToggle() ==rb2&&event.getTarget().equals(playButton1)) {
	    	GameScene(2);level=2;
		} 
        else if (tg.getSelectedToggle() ==rb3&&event.getTarget().equals(playButton1)) {
        	GameScene(3);level=3;
		} 
        else if(event.getTarget().equals(playButton)){
        	LevelselectScene();
        	
        }
        else if (event.getTarget().equals(playButton2)) {
        	if (isRunning) {
    			playButton2.setText(" ゲームスタート！ ");
    			isRunning=false;
    		}
    		else {
    			playButton2.setText(" 停止 ");
    			isRunning=true;
    		}
    	} 
       
        else if (event instanceof KeyEvent) {
        	if(isRunning) {
			KeyEvent e = (KeyEvent) event;
			KeyCode k = e.getCode();
			switch (k) {
			case UP:resultUP(8,level);
			//map.paint(level);
			break;
			case DOWN:resultDOWN(2,level);
			//map.paint(level);
			break;
			case LEFT:resultLEFT(4,level);
			//map.paint(level);
			break;
			case RIGHT:resultRIGHT(6,level);
			//map.paint(level);
			break;
			default:;
			}
		    }
        }
        else if (event.getTarget().equals(openItem)) {
    		FileChooser fileChooser = new FileChooser();
    		File file = fileChooser.showOpenDialog(stage);
    		if(level==1)map.setField(loadFile(file),1);
    		else if(level==2)map.setField(loadFile(file),2);
    		else if(level==3)map.setField(loadFile(file),3);
    		} 
    	
	}
	public void LevelselectScene() {
		statusLabel = new Label();
		statusLabel.setTextFill(Color.BLACK);
		statusLabel.setFont(Font.font("Serif", 24));
		
		topFlowPane1.getChildren().add(statusLabel);
		topFlowPane1.setHgap(10);
		
		DropShadow ds = new DropShadow();
	        ds.setOffsetX( 5.0f );
	        ds.setOffsetY( 5.0f );
	        ds.setColor( Color.RED );
		
		lb1 = new Label("難易度を選択してください");
		lb1.setFont(Font.font("Serif",40));
		lb1.setTextFill(Color.YELLOW);
		lb1.setEffect( ds );
		
		rb1 = new RadioButton("やさしい");
		rb1.setFont(Font.font("Serif",40));
		rb1.setTextFill(Color.YELLOW);
		rb1.setOnAction(this);
		rb1.setEffect( ds );
		
		rb2 = new RadioButton("ふつう");
		rb2.setFont(Font.font("Serif",40));
		rb2.setOnAction(this);
		rb2.setTextFill(Color.YELLOW);
		rb2.setEffect( ds );
		
		rb3 = new RadioButton("むずかしい");
		rb3.setFont(Font.font("Serif",40));
		rb3.setTextFill(Color.YELLOW);
		rb3.setOnAction(this);
		rb3.setEffect( ds );
		
		rb1.setToggleGroup(tg);
		rb2.setToggleGroup(tg);
		rb3.setToggleGroup(tg);
		
		rb1.setSelected(true);
		
		vb1.getChildren().add(lb1);
		vb1.getChildren().add(rb1);
		vb1.getChildren().add(rb2);
		vb1.getChildren().add(rb3);
		vb1.setAlignment(Pos.CENTER);
		
		playButton1 = new Button(" 開始 ");
		playButton1.setFont(Font.font("Serif", 24));
		playButton1.setOnAction(this);
		
		footerFlowPane1.getChildren().add(playButton1);
		footerFlowPane1.setAlignment(Pos.CENTER);
		footerFlowPane1.setHgap(10);
		
		borderPane1.setTop(topFlowPane1);
		borderPane1.setCenter(vb1);
		borderPane1.setBottom(footerFlowPane1);
		image =new Image(getClass().getResourceAsStream("Background.jpg"));
		BackgroundSize size = new BackgroundSize(800, 
		        800, 
		        false, 
		        false, 
		        true, 
		        true);
		
		borderPane1.setBackground(new Background(new BackgroundImage(image,
		        BackgroundRepeat.NO_REPEAT,
		        BackgroundRepeat.NO_REPEAT,
		        BackgroundPosition.CENTER,
		        size)));
		
		sc1 = new Scene(borderPane1, 800, 800);
		stage.setScene(sc1);
		stage.setTitle("自由課題　1116190054 　岡　颯人");
		stage.show();
	}
	private void alert() {
		if(time==30.0) {
			footerFlowPane2.setBackground(new Background(new BackgroundFill(Color.RED,CornerRadii.EMPTY,Insets.EMPTY)));
			Alert al=new Alert(Alert.AlertType.WARNING);
			al.setTitle("注意");
			al.getDialogPane().setHeaderText("残り時間が少ないです。");
			al.setX(800);
			al.setY(0);
			al.show();
		}
	}
	
	private void resultUP(int k,int level) {
		Avatar[][] feild=map.getField();
		int ii=0,jj=0;
		for(int i=0;i<map.mapHeight;i++) {
			for(int j=0;j<map.mapWidth;j++) {
				if(feild[i][j]==null) {
					ii=i;jj=j;
				}
			}
		}
		if(ii+1>=map.mapHeight) {
			feild[ii][jj]=null;
		}
		else {
		if(feild[ii+1][jj]instanceof Number1) {
			map.moveNumver1(k);
		}
		else if(feild[ii+1][jj]instanceof Number2) {
			map.moveNumver2(k);
		}
		else if(feild[ii+1][jj]instanceof Number3) {
			map.moveNumver3(k);
		}
		else if(feild[ii+1][jj]instanceof Number4) {
			map.moveNumver4(k);
		}
		else if(feild[ii+1][jj]instanceof Number5) {
			map.moveNumver5(k);
		}
		else if(feild[ii+1][jj]instanceof Number6) {
			map.moveNumver6(k);
		}
		else if(feild[ii+1][jj]instanceof Number7) {
			map.moveNumver7(k);
		}
		else if(feild[ii+1][jj]instanceof Number8) {
			map.moveNumver8(k);
		}
		if(level==2||level==3) {
			if(feild[ii+1][jj]instanceof Number9) {
				map.moveNumver9(k);
			}
			else if(feild[ii+1][jj]instanceof Number10) {
				map.moveNumver10(k);
			}
			else if(feild[ii+1][jj]instanceof Number11) {
				map.moveNumver11(k);
			}
			else if(feild[ii+1][jj]instanceof Number12) {
				map.moveNumver12(k);
			}
			else if(feild[ii+1][jj]instanceof Number13) {
				map.moveNumver13(k);
			}
			else if(feild[ii+1][jj]instanceof Number14) {
				map.moveNumver14(k);
			}
			else if(feild[ii+1][jj]instanceof Number15) {
				map.moveNumver15(k);
			}
		}
		if(level==3) {
			if(feild[ii+1][jj]instanceof Number16) {
				map.moveNumver16(k);
			}
			else if(feild[ii+1][jj]instanceof Number17) {
				map.moveNumver17(k);
			}
			else if(feild[ii+1][jj]instanceof Number18) {
				map.moveNumver18(k);
			}
			else if(feild[ii+1][jj]instanceof Number19) {
				map.moveNumver19(k);
			}
			else if(feild[ii+1][jj]instanceof Number20) {
				map.moveNumver20(k);
			}
			else if(feild[ii+1][jj]instanceof Number21) {
				map.moveNumver21(k);
			}
			else if(feild[ii+1][jj]instanceof Number22) {
				map.moveNumver22(k);
			}
			else if(feild[ii+1][jj]instanceof Number23) {
				map.moveNumver23(k);
			}
			else if(feild[ii+1][jj]instanceof Number24) {
				map.moveNumver24(k);
			}
		}
		}
	}
	
	private void resultDOWN(int k,int level) {
		Avatar[][] feild=map.getField();
		int ii=0,jj=0;
		for(int i=0;i<map.mapHeight;i++) {
			for(int j=0;j<map.mapWidth;j++) {
				if(feild[i][j]==null) {
					ii=i;jj=j;
				}
			}
		}
		if(ii-1<0) {
			feild[ii][jj]=null;
		}
		else {
		if(feild[ii-1][jj]instanceof Number1) {
			map.moveNumver1(k);
		}
		else if(feild[ii-1][jj]instanceof Number2) {
			map.moveNumver2(k);
		}
		else if(feild[ii-1][jj]instanceof Number3) {
			map.moveNumver3(k);
		}
		else if(feild[ii-1][jj]instanceof Number4) {
			map.moveNumver4(k);
		}
		else if(feild[ii-1][jj]instanceof Number5) {
			map.moveNumver5(k);
		}
		else if(feild[ii-1][jj]instanceof Number6) {
			map.moveNumver6(k);
		}
		else if(feild[ii-1][jj]instanceof Number7) {
			map.moveNumver7(k);
		}
		else if(feild[ii-1][jj]instanceof Number8) {
			map.moveNumver8(k);
		}
		if(level==2||level==3) {
			if(feild[ii-1][jj]instanceof Number9) {
				map.moveNumver9(k);
			}
			else if(feild[ii-1][jj]instanceof Number10) {
				map.moveNumver10(k);
			}
			else if(feild[ii-1][jj]instanceof Number11) {
				map.moveNumver11(k);
			}
			else if(feild[ii-1][jj]instanceof Number12) {
				map.moveNumver12(k);
			}
			else if(feild[ii-1][jj]instanceof Number13) {
				map.moveNumver13(k);
			}
			else if(feild[ii-1][jj]instanceof Number14) {
				map.moveNumver14(k);
			}
			else if(feild[ii-1][jj]instanceof Number15) {
				map.moveNumver15(k);
			}
		}
		if(level==3) {
			if(feild[ii-1][jj]instanceof Number16) {
				map.moveNumver16(k);
			}
			else if(feild[ii-1][jj]instanceof Number17) {
				map.moveNumver17(k);
			}
			else if(feild[ii-1][jj]instanceof Number18) {
				map.moveNumver18(k);
			}
			else if(feild[ii-1][jj]instanceof Number19) {
				map.moveNumver19(k);
			}
			else if(feild[ii-1][jj]instanceof Number20) {
				map.moveNumver20(k);
			}
			else if(feild[ii-1][jj]instanceof Number21) {
				map.moveNumver21(k);
			}
			else if(feild[ii-1][jj]instanceof Number22) {
				map.moveNumver22(k);
			}
			else if(feild[ii-1][jj]instanceof Number23) {
				map.moveNumver23(k);
			}
			else if(feild[ii-1][jj]instanceof Number24) {
				map.moveNumver24(k);
			}
		}
		}
	}
	
	private void resultLEFT(int k,int level) {
		Avatar[][] feild=map.getField();
		int ii=0,jj=0;
		for(int i=0;i<map.mapHeight;i++) {
			for(int j=0;j<map.mapWidth;j++) {
				if(feild[i][j]==null) {
					ii=i;jj=j;
				}
			}
		}
		if(jj+1>=map.mapWidth) {
			feild[ii][jj]=null;
		}
		else {
		if(feild[ii][jj+1]instanceof Number1) {
			map.moveNumver1(k);
		}
		else if(feild[ii][jj+1]instanceof Number2) {
			map.moveNumver2(k);
		}
		else if(feild[ii][jj+1]instanceof Number3) {
			map.moveNumver3(k);
		}
		else if(feild[ii][jj+1]instanceof Number4) {
			map.moveNumver4(k);
		}
		else if(feild[ii][jj+1]instanceof Number5) {
			map.moveNumver5(k);
		}
		else if(feild[ii][jj+1]instanceof Number6) {
			map.moveNumver6(k);
		}
		else if(feild[ii][jj+1]instanceof Number7) {
			map.moveNumver7(k);
		}
		else if(feild[ii][jj+1]instanceof Number8) {
			map.moveNumver8(k);
		}
		if(level==2||level==3) {
			if(feild[ii][jj+1]instanceof Number9) {
				map.moveNumver9(k);
			}
			else if(feild[ii][jj+1]instanceof Number10) {
				map.moveNumver10(k);
			}
			else if(feild[ii][jj+1]instanceof Number11) {
				map.moveNumver11(k);
			}
			else if(feild[ii][jj+1]instanceof Number12) {
				map.moveNumver12(k);
			}
			else if(feild[ii][jj+1]instanceof Number13) {
				map.moveNumver13(k);
			}
			else if(feild[ii][jj+1]instanceof Number14) {
				map.moveNumver14(k);
			}
			else if(feild[ii][jj+1]instanceof Number15) {
				map.moveNumver15(k);
			}
		}
		if(level==3) {
			if(feild[ii][jj+1]instanceof Number16) {
				map.moveNumver16(k);
			}
			else if(feild[ii][jj+1]instanceof Number17) {
				map.moveNumver17(k);
			}
			else if(feild[ii][jj+1]instanceof Number18) {
				map.moveNumver18(k);
			}
			else if(feild[ii][jj+1]instanceof Number19) {
				map.moveNumver19(k);
			}
			else if(feild[ii][jj+1]instanceof Number20) {
				map.moveNumver20(k);
			}
			else if(feild[ii][jj+1]instanceof Number21) {
				map.moveNumver21(k);
			}
			else if(feild[ii][jj+1]instanceof Number22) {
				map.moveNumver22(k);
			}
			else if(feild[ii][jj+1]instanceof Number23) {
				map.moveNumver23(k);
			}
			else if(feild[ii][jj+1]instanceof Number24) {
				map.moveNumver24(k);
			}
		}
		}
	}
	
	private void resultRIGHT(int k,int level) {
		Avatar[][] feild=map.getField();
		int ii=0,jj=0;
		for(int i=0;i<map.mapHeight;i++) {
			for(int j=0;j<map.mapWidth;j++) {
				if(feild[i][j]==null) {
					ii=i;jj=j;
				}
			}
		}
		if(jj-1<0) {
			feild[ii][jj]=null;
		}
		else {
		if(feild[ii][jj-1]instanceof Number1) {
			map.moveNumver1(k);
		}
		else if(feild[ii][jj-1]instanceof Number2) {
			map.moveNumver2(k);
		}
		else if(feild[ii][jj-1]instanceof Number3) {
			map.moveNumver3(k);
		}
		else if(feild[ii][jj-1]instanceof Number4) {
			map.moveNumver4(k);
		}
		else if(feild[ii][jj-1]instanceof Number5) {
			map.moveNumver5(k);
		}
		else if(feild[ii][jj-1]instanceof Number6) {
			map.moveNumver6(k);
		}
		else if(feild[ii][jj-1]instanceof Number7) {
			map.moveNumver7(k);
		}
		else if(feild[ii][jj-1]instanceof Number8) {
			map.moveNumver8(k);
		}
		if(level==2||level==3) {
			if(feild[ii][jj-1]instanceof Number9) {
				map.moveNumver9(k);
			}
			else if(feild[ii][jj-1]instanceof Number10) {
				map.moveNumver10(k);
			}
			else if(feild[ii][jj-1]instanceof Number11) {
				map.moveNumver11(k);
			}
			else if(feild[ii][jj-1]instanceof Number12) {
				map.moveNumver12(k);
			}
			else if(feild[ii][jj-1]instanceof Number13) {
				map.moveNumver13(k);
			}
			else if(feild[ii][jj-1]instanceof Number14) {
				map.moveNumver14(k);
			}
			else if(feild[ii][jj-1]instanceof Number15) {
				map.moveNumver15(k);
			}
		}
		if(level==3) {
			if(feild[ii][jj-1]instanceof Number16) {
				map.moveNumver16(k);
			}
			else if(feild[ii][jj-1]instanceof Number17) {
				map.moveNumver17(k);
			}
			else if(feild[ii][jj-1]instanceof Number18) {
				map.moveNumver18(k);
			}
			else if(feild[ii][jj-1]instanceof Number19) {
				map.moveNumver19(k);
			}
			else if(feild[ii][jj-1]instanceof Number20) {
				map.moveNumver20(k);
			}
			else if(feild[ii][jj-1]instanceof Number21) {
				map.moveNumver21(k);
			}
			else if(feild[ii][jj-1]instanceof Number22) {
				map.moveNumver22(k);
			}
			else if(feild[ii][jj-1]instanceof Number23) {
				map.moveNumver23(k);
			}
			else if(feild[ii][jj-1]instanceof Number24) {
				map.moveNumver24(k);
			}
		}
		}
	}
	
	private void GameScene(int i) {
		//画面の消去
		Window window=sc1.getWindow();
    	window.hide();
		if(i==1) {
			map = new Map(3, 3, 200,1);
		    map.setGameEndListener(this);
		}
		else if(i==2) {
			map = new Map(4, 4, 150,2);
			map.setGameEndListener(this);
		}
		else if(i==3) {
			map = new Map(5, 5, 120,3);
			map.setGameEndListener(this);
		}
		//画面の生成
		Menu menu = new Menu("ファイル");
		menuBar.getMenus().add(menu);
		
		menu.getItems().add(openItem);
		menu.getItems().add(saveItem);
		openItem.setOnAction(this);
		saveItem.setOnAction(this);
    	statusLabel = new Label();
		statusLabel.setTextFill(Color.BLACK);
		statusLabel.setFont(Font.font("Serif", 24));
		topFlowPane2.getChildren().add(menuBar);
		topFlowPane2.getChildren().add(statusLabel);
		topFlowPane2.setHgap(10);
		playButton2 = new Button(" ゲームスタート！ ");
		playButton2.setFont(Font.font("Serif", 24));
		playButton2.setOnAction(this);
		
		footerFlowPane2.getChildren().add(playButton2);
		footerFlowPane2.setAlignment(Pos.CENTER);
		footerFlowPane2.setHgap(10);
		borderPane2.setTop(topFlowPane2);
		borderPane2.setCenter(map);
		borderPane2.setBottom(footerFlowPane2);
		image =new Image(getClass().getResourceAsStream("Background.jpg"));
		BackgroundSize size = new BackgroundSize(800, 
		        800, 
		        false, 
		        false, 
		        true, 
		        true);
		borderPane2.setBackground(new Background(new BackgroundImage(image,
		        BackgroundRepeat.NO_REPEAT,
		        BackgroundRepeat.NO_REPEAT,
		        BackgroundPosition.CENTER,
		        size)));
		
		sc2 = new Scene(borderPane2, map.getWidth()+100, map.getHeight()+200);
		sc2.setOnKeyPressed(this);
		stage.setScene(sc2);
		stage.setTitle("自由課題　1116190054 　岡　颯人");
		stage.show();
		map.paint(level);
		StatusLabel();
		startApp();
	}

	private void StatusLabel() {
		String str = "　〔" +time + "〕秒　" ;
				statusLabel.setText(str);
				statusLabel.setTextFill(Color.RED);
	}
	
	private Avatar[][] loadFile(File file) {
		Avatar[][] field = new Avatar[map.mapHeight][map.mapWidth];

		for (int y = 0; y < map.mapHeight; y++) {
			for (int x = 0; x < map.mapWidth; x++) {
				field[y][x] = null;
				}
		}
		int x = 0;
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			String line;
			int y = 0;
			while ((line = br.readLine()) != null) {
				String[] ss = line.split(" ");
				for (x = 0; x < ss.length; x++) {
					String s = ss[x];
					switch (s) {
					case "1":
						field[y][x] = new Number1(new Point(x, y));
						break;
					case "2":
						field[y][x] = new Number2(new Point(x, y));
						break;
					case "3":
						field[y][x] = new Number3(new Point(x, y));
						break;
					case "4":
						field[y][x] = new Number4(new Point(x, y));
						break;
					case "5":
						field[y][x] = new Number5(new Point(x, y));
						break;
					case "6":
						field[y][x] = new Number6(new Point(x, y));
						break;
					case "7":
						field[y][x] = new Number7(new Point(x, y));
						break;
					case "8":
						field[y][x] = new Number8(new Point(x, y));
						break;
					case "9":
						field[y][x] = new Number9(new Point(x, y));
						break;
					case "10":
						field[y][x] = new Number10(new Point(x, y));
						break;
					case "11":
						field[y][x] = new Number11(new Point(x, y));
						break;
					case "12":
						field[y][x] = new Number12(new Point(x, y));
						break;
					case "13":
						field[y][x] = new Number13(new Point(x, y));
						break;
					case "14":
						field[y][x] = new Number14(new Point(x, y));
						break;
					case "15":
						field[y][x] = new Number15(new Point(x, y));
						break;
					case "16":
						field[y][x] = new Number16(new Point(x, y));
						break;
					case "17":
						field[y][x] = new Number17(new Point(x, y));
						break;
					case "18":
						field[y][x] = new Number18(new Point(x, y));
						break;
					case "19":
						field[y][x] = new Number19(new Point(x, y));
						break;
					case "20":
						field[y][x] = new Number20(new Point(x, y));
						break;
					case "21":
						field[y][x] = new Number21(new Point(x, y));
						break;
					case "22":
						field[y][x] = new Number22(new Point(x, y));
						break;
					case "23":
						field[y][x] = new Number23(new Point(x, y));
						break;
					case "24":
						field[y][x] = new Number24(new Point(x, y));
						break;	
				}
				}
				System.out.println(line);
				y++;
			
			}
			br.close();
			if (validField(field, y, x)) {
				//playButton2.setText("（" + file.getName() + "）を開きました．");
			return field;
			} 
			else {
			//gameLabel.setText("ロード失敗！");
			//System.out.println(x+" "+y+" "+field.length+" "+field[0].length);
		
		}
		} catch (FileNotFoundException e) {
		//gameLabel.setText("ロード失敗！");
		} catch (IOException e) {
		e.printStackTrace();
		//gameLabel.setText("ロード失敗！");
		}
		return null;

	}
	
	private boolean validField(Avatar[][] field, int y, int x) {
		// map size
		if (field.length > 0 && field.length != y) return false;
		if (field[0].length > 0 && field[0].length != x) return false;
		return true;
	}
	
	private void jadge(int level) {
		Avatar[][] feild=map.getField();
		if(level==1) {
			if(feild[0][0]instanceof Number1&&
		   feild[0][1]instanceof Number2&&
		   feild[0][2]instanceof Number3&&
		   feild[1][0]instanceof Number4&&
		   feild[1][1]instanceof Number5&&
		   feild[1][2]instanceof Number6&&
		   feild[2][0]instanceof Number7&&
		   feild[2][1]instanceof Number8) {
			gameClear();
		}
		}
		if(level==2) {
			if(feild[0][0]instanceof Number1&&
			   feild[0][1]instanceof Number2&&
			   feild[0][2]instanceof Number3&&
			   feild[0][3]instanceof Number4&&
			   feild[1][0]instanceof Number5&&
			   feild[1][1]instanceof Number6&&
			   feild[1][2]instanceof Number7&&
			   feild[1][3]instanceof Number8&&
			   feild[2][0]instanceof Number9&&
			   feild[2][1]instanceof Number10&&
			   feild[2][2]instanceof Number11&&
			   feild[2][3]instanceof Number12&&
			   feild[3][0]instanceof Number13&&
			   feild[3][1]instanceof Number14&&
			   feild[3][2]instanceof Number15) {
				gameClear();
			}
		}
		if(level==3) {
			if(feild[0][0]instanceof Number1&&
			   feild[0][1]instanceof Number2&&
			   feild[0][2]instanceof Number3&&
			   feild[0][3]instanceof Number4&&
			   feild[0][4]instanceof Number5&&
			   feild[1][0]instanceof Number6&&
			   feild[1][1]instanceof Number7&&
			   feild[1][2]instanceof Number8&&
			   feild[1][3]instanceof Number9&&
			   feild[1][4]instanceof Number10&&
			   feild[2][0]instanceof Number11&&
			   feild[2][1]instanceof Number12&&
			   feild[2][2]instanceof Number13&&
			   feild[2][3]instanceof Number14&&
			   feild[2][4]instanceof Number15&&
			   feild[3][0]instanceof Number16&&
			   feild[3][1]instanceof Number17&&
			   feild[3][2]instanceof Number18&&
			   feild[3][3]instanceof Number19&&
			   feild[3][4]instanceof Number20&&
			   feild[4][0]instanceof Number21&&
			   feild[4][1]instanceof Number22&&
			   feild[4][2]instanceof Number23&&
			   feild[4][3]instanceof Number24) {
				gameClear();
			}
		}
	}
	
	@Override
	public void gameClear() {
		lb2 = new Label();
		lb2.setFont(Font.font("Serif",50));
		lb2.setText("ゲームクリア");
		lb2.setTextFill(Color.RED);
		lb3 = new Label();
		lb3.setFont(Font.font("Serif",50));
		lb3.setText("クリアタイムは"+(float)(100.0-time)+"秒");
		lb3.setTextFill(Color.RED);
		vb2.getChildren().add(lb2);
		vb2.getChildren().add(lb3);
		vb2.setAlignment(Pos.CENTER);
		borderPane2.setCenter(vb2);
		timeline.stop();
	}
	
	@Override
	public void gameOver() {
		lb2 = new Label();
		lb2.setFont(Font.font("Serif",50));
		lb2.setText("ゲームオーバー");
		lb2.setTextFill(Color.RED);
		borderPane2.setCenter(lb2);
		timeline.stop();
	}
}
