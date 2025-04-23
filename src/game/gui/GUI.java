package game.gui;

import game.engine.*;
import game.engine.lanes.*;
import game.engine.titans.*;
import game.engine.base.*;

import java.awt.Desktop.Action;
import java.io.*;
import java.util.*;
import java.util.stream.*;

import javafx.animation.*;
import javafx.application.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.image.*;
import javafx.scene.input.*;
import javafx.scene.layout.*;
import javafx.scene.media.*;
import javafx.scene.paint.*;
import javafx.scene.shape.*;
import javafx.stage.*;
import javafx.util.Duration;

public class GUI extends Application implements EventHandler<ActionEvent> {
	private GridPane grid;
	private StackPane root;
	private AnchorPane anchor;
	private Pane pane;
	private Stage primaryStage;

	private Battle battle;
	private Lane lane;
	private Wall wall;

	private VBox gameStatusBox;
	private Label scoreLabel;
	private Label turnLabel;
	private Label phaseLabel;
	private Label resourcesLabel;
	private Label lanesLabel;
	private Label WallLabel1;
	private Label WallLabel2;
	private Label WallLabel3;
	private Label WallLabel4;
	private Label WallLabel5;
	
	Pane titanPane = new Pane();
	ImageView titanView;

	public int selectedDifficulty;

	Image pureImage = new Image("pureTitan.png");
	Image abnormalImage = new Image("abnormalTitan.png");
	Image armoredImage = new Image("armoredTitan.png");
	Image colossalImage = new Image("colossalTitan.png");

	ImageView pureView = new ImageView(pureImage);
	ImageView abnormalView = new ImageView(abnormalImage);
	ImageView armoredView = new ImageView(armoredImage);
	ImageView colossalView = new ImageView(colossalImage);
	
	Image loss1HardImage = new Image("loss1Hard.png");
	Image loss2HardImage = new Image("loss2Hard.png");
	Image loss3HardImage = new Image("loss3Hard.png");
	Image loss4HardImage = new Image("loss4Hard.png");
	Image loss5HardImage = new Image("loss5Hard.png");
	
	ImageView loss1HardView = new ImageView(loss1HardImage);
	ImageView loss2HardView = new ImageView(loss2HardImage);
	ImageView loss3HardView = new ImageView(loss3HardImage);
	ImageView loss4HardView = new ImageView(loss4HardImage);
	ImageView loss5HardView = new ImageView(loss5HardImage);
	
	Image LaneOverLayEasy = new Image("LanesOverlay.png");
	ImageView LaneOverlayViewEasy = new ImageView(LaneOverLayEasy);
	
	
	
	Image LaneOverLayHard = new Image("LanesOverlay - Copy.png");
	ImageView LaneOverlayViewHard = new ImageView(LaneOverLayHard);

	public GridPane gameGrid;
	public GridPane gameGridAlly;

	ArrayList<Button> titanbuttons = new ArrayList<Button>();

	@Override
	public void start(Stage primaryStage) {
		primaryStage.setTitle("Attack On Titan: Utopia");
		primaryStage.setMaximized(true);
		grid = new GridPane();
		grid.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		root = new StackPane(grid);
		StackPane root = new StackPane(grid);
		Rectangle2D screenBounds = Screen.getPrimary().getVisualBounds();
		Scene scene = new Scene(root, screenBounds.getWidth(), screenBounds.getHeight());

		primaryStage.setScene(scene);
		primaryStage.show();
		this.primaryStage = primaryStage;

		Button startButton = createButton("Start Game");
		Button Balabizo = createButton("Balabizo");
		Button HowToPlay = createButton("How To Play");
		Button Exit = createButton("Exit");

		pureView.setFitHeight(15);
		pureView.setFitWidth(15);

		pureView.resize(15, 15);

		String defaultButtontyle = "-fx-font-size: 26px;";

		startButton.setStyle(defaultButtontyle);

		Balabizo.setStyle(defaultButtontyle);
		HowToPlay.setStyle(defaultButtontyle);
		Exit.setStyle(defaultButtontyle);
		
		/*
		 * startButton.setOnMouseEntered(e -> { // Specify the path to the audio file
		 * String audioFilePath =
		 * "file:///C:/Users/karim/Downloads/Start%20game%20Audio.mp3";
		 * 
		 * // Create a Media object Media audioFile = new Media(audioFilePath);
		 * 
		 * // Create a MediaPlayer object and play the audio MediaPlayer mediaPlayer =
		 * new MediaPlayer(audioFile); mediaPlayer.play(); });
		 * 
		 * Exit.setOnMouseEntered(e -> { // Specify the path to the audio file String
		 * audioFilePath =
		 * "ElevenLabs_2024-05-03T14_22_45_Ethan_pre_s50_sb75_se0_b_m2%20.mp3";
		 * 
		 * // Create a Media object Media audioFile = new Media(audioFilePath);
		 * 
		 * // Create a MediaPlayer object and play the audio MediaPlayer mediaPlayer =
		 * new MediaPlayer(audioFile); mediaPlayer.play(); });
		 * 
		 * HowToPlay.setOnMouseEntered(e -> { // Specify the path to the audio file
		 * String audioFilePath =
		 * "file:///C:/Users/karim/Downloads/ElevenLabs_2024-05-13T09_27_14_Ethan_pre_s50_sb75_se0_b_m2.mp3";
		 * 
		 * // Create a Media object Media audioFile = new Media(audioFilePath);
		 * 
		 * // Create a MediaPlayer object and play the audio MediaPlayer mediaPlayer =
		 * new MediaPlayer(audioFile); mediaPlayer.play(); });
		 * 
		 * Balabizo.setOnMouseEntered(e -> { // Specify the path to the audio file
		 * String audioFilePath =
		 * "file:///C:/Users/karim/Downloads/ElevenLabs_2024-05-03T14_18_12_Ethan_pre_s50_sb75_se0_b_m2%20(2).mp3";
		 * 
		 * // Create a Media object Media audioFile = new Media(audioFilePath);
		 * 
		 * // Create a MediaPlayer object and play the audio MediaPlayer mediaPlayer =
		 * new MediaPlayer(audioFile); mediaPlayer.play(); });
		 */
		 

		Balabizo.setTextFill(Color.GREEN);

		Exit.setBackground(new Background(new BackgroundFill(Color.DARKSEAGREEN, CornerRadii.EMPTY, Insets.EMPTY)));

		Image image = new Image("wallpaperflare.com_wallpaper.jpg");
		BackgroundImage backgroundImage = new BackgroundImage(image, BackgroundRepeat.NO_REPEAT,
				BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,
				new BackgroundSize(1, 1, true, true, false, false));
		grid.setBackground(new Background(backgroundImage));

		grid.add(startButton, 0, 0);
		grid.add(Balabizo, 0, 1);
		grid.add(HowToPlay, 0, 2);
		grid.add(Exit, 0, 3);

		HowToPlay.setOnAction(e -> showHowToPlayWindow());
		Balabizo.setOnAction(e -> displayBalabizoWindow());
		startButton.setOnAction(e -> startingGame());
		Exit.setOnAction(e -> Platform.exit());

		grid.setPadding(new Insets(55, 5, 55, 55));
	}

	public Button createButton(String buttonText) {
		Button button = new Button(buttonText);
		button.setPrefSize(250, 60);
		button.setTextFill(Color.BLACK);
		grid.setHgap(20);
		grid.setVgap(20);
		return button;
	}

	public HBox placeUIComponents() {
		HBox view = new HBox();
		view.getChildren().addAll(grid);
		return view;
	}

	private void displayBalabizoWindow() {
		Stage balabizoStage = new Stage();
		balabizoStage.setTitle("Balabizo");

		Button balabizoButton = new Button("Balabizo");
		VBox vbox = new VBox(new Label("Balabizo"), balabizoButton);
		vbox.setAlignment(Pos.CENTER);
		vbox.setPadding(new Insets(15));

		balabizoButton.setOnAction(e -> balabizoStage.close());

		Scene scene = new Scene(vbox, 300, 200);
		balabizoStage.setScene(scene);

		balabizoStage.show();
	}

	private void showHowToPlayWindow() {
		Stage howToPlayStage = new Stage();

		howToPlayStage.setTitle("How To Play");

		Label howToPlayLabel = new Label(
				"This is a tower defence game, players’ main goal is protect their lane walls from the\n"
						+ "approaching titans by buying weapons into the lanes to attack the titans present in it.\n\n\n\n"
						+ "" + "there are a total of 4 titans, Pure, Abnormal, Armored, Colossal\n"
						+ "Pure Titan: HP:100\n " + "            Damage:15\n" + "            Height:15\n"
						+ "            Speed:10\n" + "            Resources when killed: 10\n"
						+ "            Danger Contribution: 1");
		howToPlayLabel.setWrapText(true);
		howToPlayLabel.setTextFill(Color.WHITE);

		VBox vbox = new VBox(howToPlayLabel);
		vbox.setBackground(new Background(new BackgroundFill(Color.DARKGOLDENROD, CornerRadii.EMPTY, Insets.EMPTY)));
		vbox.setAlignment(Pos.CENTER);
		vbox.setPadding(new Insets(15));

		Scene howToPlayScene = new Scene(vbox, 500, 200);
		howToPlayStage.setScene(howToPlayScene);
		howToPlayStage.show();
	}

	private void startingGame() {
		grid.getChildren().clear();
		grid.setBackground(new Background(new BackgroundFill(Color.BLACK, CornerRadii.EMPTY, Insets.EMPTY)));

		// Create a Rectangle that covers the entire GridPane and make it larger
		Rectangle rect = new Rectangle(grid.getWidth() + 200, grid.getHeight() + 200);
		rect.setFill(Color.BLACK);

		Label gameLabel = new Label("Starting Game...");
		gameLabel.setWrapText(true);
		gameLabel.setStyle("-fx-font-size: 36px;");
		gameLabel.setTextFill(Color.WHITE);

		grid.add(gameLabel, 0, 0);
		grid.setAlignment(Pos.CENTER);

		// Add the Rectangle to the root StackPane after the GridPane
		// root.getChildren().add(rect);

		FadeTransition fadeOutTransition = new FadeTransition(Duration.seconds(0.1), rect);
		fadeOutTransition.setFromValue(0.0);
		fadeOutTransition.setToValue(1.0);
		fadeOutTransition.setOnFinished(e -> {
			PauseTransition pause = new PauseTransition(Duration.seconds(0.1));
			pause.setOnFinished(e2 -> {
				FadeTransition fadeInTransition = new FadeTransition(Duration.seconds(0.2), gameLabel);
				fadeInTransition.setFromValue(0.0);
				fadeInTransition.setToValue(1.0);
				fadeInTransition.setOnFinished(e3 -> {
					FadeTransition fadeOutTransition2 = new FadeTransition(Duration.seconds(0.2), gameLabel);
					fadeOutTransition2.setFromValue(1.0);
					fadeOutTransition2.setToValue(0.0);
					fadeOutTransition2.setOnFinished(e4 -> {
						selectDifficulty(); // Call selectDifficulty after the fade out transition has completed
					});
					fadeOutTransition2.play();
				});
				fadeInTransition.play();
			});
			pause.play();
		});
		fadeOutTransition.play();
	}

	private void selectDifficulty() {
		grid.getChildren().clear();
		grid.setBackground(new Background(new BackgroundFill(Color.BLACK, CornerRadii.EMPTY, Insets.EMPTY)));

		Label difficultyLabel = new Label("Select Difficulty");
		difficultyLabel.setStyle("-fx-font-size: 36px;");
		difficultyLabel.setTextFill(Color.WHITE);

		Button easyButton = createButton("Easy");
		Button hardButton = createButton("Hard");

		easyButton.setOnAction(e -> {
			selectedDifficulty = 1;
			instructions();
		});

		hardButton.setOnAction(e -> {
			selectedDifficulty = 2;
			instructions();
		});

		Label easyExplanation = new Label("You start out with 250 resources and only 3 lanes are used(not working)");
		easyExplanation.setStyle("-fx-font-size:24px;");
		easyExplanation.setTextFill(Color.GREEN);

		Label hardExplanation = new Label("You start out with 125 resources with 5 lanes");
		hardExplanation.setStyle("-fx-font-size:24px;");
		hardExplanation.setTextFill(Color.RED);

		grid.add(difficultyLabel, 0, 0);
		grid.add(easyButton, 0, 1);
		grid.add(hardButton, 0, 2);
		grid.add(easyExplanation, 1, 1);
		grid.add(hardExplanation, 1, 2);

		grid.setAlignment(Pos.CENTER);

	}

	public void instructions() {
		grid.getChildren().clear();

		Image instructimg = new Image("inst.png");
		BackgroundImage instructImage = new BackgroundImage(instructimg, BackgroundRepeat.NO_REPEAT,
				BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,
				new BackgroundSize(1, 1, true, true, false, false));
		grid.setBackground(new Background(instructImage));

		Button continueButton = createButton("I know what I am doing, let's go!");
		continueButton.setOnAction(e -> {
			if (selectedDifficulty == 1) {
				grid.getChildren().clear();
				System.out.println(selectedDifficulty);
				doEasy();
			} else
				grid.getChildren().clear();
			System.out.println(selectedDifficulty);
			doHard();
		});

		grid.add(continueButton, 0, 11);
		grid.setAlignment(Pos.CENTER);
	}

	public GUI() {
		scoreLabel = new Label();
		turnLabel = new Label();
		phaseLabel = new Label();
		resourcesLabel = new Label();
		lanesLabel = new Label();

		WallLabel1 = new Label();
		WallLabel2 = new Label();
		WallLabel3 = new Label();
		WallLabel4 = new Label();
		WallLabel5 = new Label();

		gameStatusBox = new VBox(scoreLabel, turnLabel, phaseLabel, resourcesLabel, lanesLabel);
		gameStatusBox.setAlignment(Pos.TOP_LEFT);
		gameStatusBox.setSpacing(10);
	}

	public void updateGameStatus() {
		String style = "-fx-font-size: 20px; -fx-font-weight: bold;";

		scoreLabel.setText("Current Score: " + battle.getScore());
		scoreLabel.setStyle(style);

		turnLabel.setText("Current Turn: " + battle.getNumberOfTurns());
		turnLabel.setStyle(style);

		phaseLabel.setText("Current Phase: " + battle.getBattlePhase());
		phaseLabel.setStyle(style);

		resourcesLabel.setText("Current Resources: " + battle.getResourcesGathered());
		resourcesLabel.setStyle(style);

		lanesLabel.setText("Available Lanes: " + battle.getLanes().size());
		lanesLabel.setStyle(style);

		Lane lane1 = battle.getOriginalLanes().get(0);
		Wall wall1 = lane1.getLaneWall();
		int wall1Health = wall1.getCurrentHealth();
		int wall1DangerLevel = lane1.getDangerLevel();

		WallLabel1.setText("Wall health:\n" + wall1Health + "\nDanger Level: " + wall1DangerLevel);
		WallLabel1.setLayoutX(300);
		WallLabel1.setLayoutY(200);
		WallLabel1.setStyle("-fx-font-size:16px;");
		WallLabel1.setTextFill(Color.LIGHTGOLDENRODYELLOW);

		Lane lane2 = battle.getOriginalLanes().get(1);
		Wall wall2 = lane2.getLaneWall();
		int wall2Health = wall2.getCurrentHealth();
		int wall2DangerLevel = lane2.getDangerLevel();

		WallLabel2.setText("Wall health:\n" + wall2Health + "\nDanger Level: " + wall2DangerLevel);
		WallLabel2.setLayoutX(300);
		WallLabel2.setLayoutY(310);
		WallLabel2.setStyle("-fx-font-size:16px;");
		WallLabel2.setTextFill(Color.LIGHTGOLDENRODYELLOW);

		Lane lane3 = battle.getOriginalLanes().get(2);
		Wall wall3 = lane3.getLaneWall();
		int wall3Health = wall3.getCurrentHealth();
		int wall3DangerLevel = lane3.getDangerLevel();

		WallLabel3.setText("Wall health:\n" + wall3Health + "\nDanger Level: " + wall3DangerLevel);
		WallLabel3.setLayoutX(300);
		WallLabel3.setLayoutY(420);
		WallLabel3.setStyle("-fx-font-size:16px;");
		WallLabel3.setTextFill(Color.LIGHTGOLDENRODYELLOW);
		
		
		Pane wallHealthpane = new Pane();


		loss1HardView.setLayoutX(0);
		loss1HardView.setLayoutY(210);
		loss1HardView.setFitWidth(1050);
		loss1HardView.setFitHeight(100);
		
		loss2HardView.setLayoutX(0);
		loss2HardView.setLayoutY(310);
		loss2HardView.setFitWidth(1050);
		loss2HardView.setFitHeight(100);
		
		loss3HardView.setLayoutX(0);
		loss3HardView.setLayoutY(410);
		loss3HardView.setFitWidth(1050);
		loss3HardView.setFitHeight(100);
		
		loss4HardView.setLayoutX(0);
		loss4HardView.setLayoutY(510);
		loss4HardView.setFitWidth(1050);
		loss4HardView.setFitHeight(100);
		
		loss5HardView.setLayoutX(0);
		loss5HardView.setLayoutY(610);
		loss5HardView.setFitWidth(1050);
		loss5HardView.setFitHeight(100);
		
		if(selectedDifficulty == 2) {
			
			
			
			Lane lane4 = battle.getOriginalLanes().get(3);
			Wall wall4 = lane4.getLaneWall();
			
			Lane lane5 = battle.getOriginalLanes().get(4);
			Wall wall5 = lane5.getLaneWall();
			
			int wall4Health = wall4.getCurrentHealth();
			int wall4DangerLevel = lane4.getDangerLevel();

			WallLabel4.setText("Wall health:\n" + wall4Health + "\nDanger Level: " + wall4DangerLevel);
			WallLabel4.setLayoutX(300);
			WallLabel4.setLayoutY(520);
			WallLabel4.setStyle("-fx-font-size:16px;");
			WallLabel4.setTextFill(Color.LIGHTGOLDENRODYELLOW);

			int wall5Health = wall5.getCurrentHealth();
			int wall5DangerLevel = lane5.getDangerLevel();

			WallLabel5.setText("Wall health:\n" + wall5Health + "\nDanger Level: " + wall5DangerLevel);
			WallLabel5.setLayoutX(300);
			WallLabel5.setLayoutY(640);
			WallLabel5.setStyle("-fx-font-size:16px;");
			WallLabel5.setTextFill(Color.LIGHTGOLDENRODYELLOW);
			
			wallHealthpane.getChildren().clear();
			wallHealthpane.getChildren().addAll(WallLabel1, WallLabel2, WallLabel3, WallLabel4, WallLabel5);
			//grid.getChildren().add(wallHealthpane);
			
			Pane lossPane = new Pane();
			PriorityQueue<Lane> l = this.battle.getLanes();
			for (Lane lane : l) {
				if(lane1.isLaneLost() || selectedDifficulty == 1) 
					lossPane.getChildren().add(loss1HardView);
				if(lane2.isLaneLost()) 
					lossPane.getChildren().add(loss2HardView);
				if(lane3.isLaneLost())
					lossPane.getChildren().add(loss3HardView);
				if(lane4.isLaneLost()) 
					lossPane.getChildren().add(loss4HardView);				
				if(lane5.isLaneLost() || selectedDifficulty == 1) 
					lossPane.getChildren().add(loss5HardView);
				}
			
			Pane LaneOverlayPane = new Pane();
			
			LaneOverlayViewHard.setLayoutX(400);
			LaneOverlayViewHard.setLayoutY(200);
		    
			LaneOverlayViewHard.setFitWidth(650);
			LaneOverlayViewHard.setFitHeight(500);
		    
		    LaneOverlayPane.getChildren().add(LaneOverlayViewHard);
		    
		    grid.getChildren().addAll(LaneOverlayPane,lossPane, wallHealthpane);
	}
		if(selectedDifficulty == 1) {
		    wallHealthpane.getChildren().clear();
		    
		    WallLabel1.setLayoutY(310);
		    WallLabel2.setLayoutY(420);
		    WallLabel3.setLayoutY(520);
		    
		    wallHealthpane.getChildren().addAll(WallLabel1, WallLabel2, WallLabel3);
		    //grid.getChildren().add(wallHealthpane);

		    Pane lossPane = new Pane();
		    if(lane1.isLaneLost() || selectedDifficulty == 1) 
		        lossPane.getChildren().add(loss1HardView);
		    if(lane2.isLaneLost()) 
		        lossPane.getChildren().add(loss2HardView);
		    if(lane3.isLaneLost())
		        lossPane.getChildren().add(loss3HardView);
		    lossPane.getChildren().add(loss5HardView);
		    
		    Pane LaneOverlayPane = new Pane();
		    
		    LaneOverlayViewEasy.setLayoutX(360);
			LaneOverlayViewEasy.setLayoutY(320);
		    
		    LaneOverlayViewEasy.setFitWidth(690);
		    LaneOverlayViewEasy.setFitHeight(280);
		    
		    LaneOverlayPane.getChildren().add(LaneOverlayViewEasy);
		    
		    grid.getChildren().addAll(LaneOverlayPane,lossPane, wallHealthpane);
		}
		
		Image backgroundImage = new Image("TOPPPP.png");
		BackgroundImage background = new BackgroundImage(backgroundImage, BackgroundRepeat.NO_REPEAT,
				BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);

		gameStatusBox.setBackground(new Background(background));
		gameStatusBox.setPadding(new Insets(0, 0, 0, 20)); // Adjust the last parameter as needed
	}


	private GridPane createGameGrid() {
		gameGrid = new GridPane();
		gameGrid.setAlignment(Pos.CENTER);

		updateGameStatus();

		if (selectedDifficulty == 2) {
			gameGrid.setHgap(10);
			gameGrid.setVgap(10);

			for (int i = 0; i < 5; i++) {
				for (int j = 0; j < 9; j++) {
					Rectangle cell = new Rectangle(52.0, 90.0, Color.TRANSPARENT);
					cell.setStroke(Color.TRANSPARENT);
					gameGrid.add(cell, j, i);
				}
			}

			gameGrid.setTranslateX(-40.0);
			gameGrid.setTranslateY(65.0);
		}

		else {
			gameGrid.setHgap(10);
			gameGrid.setVgap(10);

			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 9; j++) {
					Rectangle cell = new Rectangle(52.0, 90.0, Color.TRANSPARENT);
					cell.setStroke(Color.TRANSPARENT);
					gameGrid.add(cell, j, i);
				}
			}

			gameGrid.setTranslateX(-60.0);
			gameGrid.setTranslateY(65.0);
		}
		return gameGrid;
	}

	private GridPane createGameGridAlly() {
		gameGridAlly = new GridPane();
		gameGridAlly.setAlignment(Pos.CENTER);

		updateGameStatus();

		if (selectedDifficulty == 2) {
			gameGridAlly.setHgap(10);
			gameGridAlly.setVgap(10);

			for (int i = 0; i < 5; i++) {
				for (int j = 0; j < 5; j++) {
					Rectangle cellAlly = new Rectangle(52.0, 90.0, Color.TRANSPARENT);
					cellAlly.setStroke(Color.TRANSPARENT);
					gameGridAlly.add(cellAlly, j, i);
				}
			}

			gameGridAlly.setTranslateX(-550.0);
			gameGridAlly.setTranslateY(65.0);
		}

		else {
			gameGridAlly.setHgap(10);
			gameGridAlly.setVgap(10);

			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 10; j++) {
					Rectangle cellAlly = new Rectangle(52.0, 90.0, Color.TRANSPARENT);
					cellAlly.setStroke(Color.TRANSPARENT);
					gameGridAlly.add(cellAlly, j, i);
				}
			}

			gameGridAlly.setTranslateX(-60.0);
			gameGridAlly.setTranslateY(65.0);
		}

		return gameGridAlly;
	}
	
	private void doEasy() {
		try {
			battle = new Battle(1, 0, 150, 3, 250); // yapyap
			grid.getChildren().clear();
			this.updateGameStatus();
		} catch (IOException var8) {
			var8.printStackTrace();
		}

		ImageView easyLanes = new ImageView("battleBG - Copy (5).png");
		easyLanes.setFitWidth(this.grid.getWidth());
		easyLanes.setFitHeight(this.grid.getHeight());
		this.grid.getChildren().clear();
		this.grid.getChildren().add(easyLanes);
		GridPane gameGrid = this.createGameGrid();
		GridPane gameGridAlly = this.createGameGridAlly();
		this.grid.getChildren().add(gameGrid);
		this.grid.getChildren().add(gameGridAlly);
		this.grid.add(this.gameStatusBox, 0, 0);

		Button passTurnButton = this.createButton("Pass Turn(press P)");
		grid.add(passTurnButton, 10, 10);

		passTurnButton.setOnKeyPressed((e) -> {
			if (e.getCode() == KeyCode.P) {
				loseCondition();
				battle.isGameOver();
				this.battle.passTurn();
				grid.getChildren().remove(titanPane);
				this.updateGameStatus();
				this.updateTitans();

				TitanBuutons titanButtons = new TitanBuutons();

				Button pureTitanButton = titanButtons.getPureTitanButton();
				Button colossalTitanButton = titanButtons.getColossalTitanButton();
				Button abnormalTitanButton = titanButtons.getAbnormalTitanButton();
				Button armouredTitanButton = titanButtons.getArmouredTitanButton();

				List<Button> titanButtonsList = Arrays.asList(pureTitanButton, colossalTitanButton, abnormalTitanButton,
						armouredTitanButton);

				for (Button titanButton : titanButtonsList) {
					titanButton.setVisible(true); // Make the buttons visible when passTurnButton is clicked
				}
			}
		});


		VBox vboxPassTurn = new VBox(passTurnButton);
		vboxPassTurn.setAlignment(Pos.BOTTOM_RIGHT);
		vboxPassTurn.setPadding(new Insets(15, 15, 15, 15));
		this.grid.getChildren().add(vboxPassTurn);

		TitanBuutons titanButtons = new TitanBuutons();
		VBox vbox = new VBox();
		vbox.getChildren().addAll(titanButtons.getPureTitanButton(), titanButtons.getColossalTitanButton(),
				titanButtons.getAbnormalTitanButton(), titanButtons.getArmouredTitanButton());
		vbox.setAlignment(Pos.CENTER);

		grid.add(vbox, 0, 0);

		// Make the Titan buttons not visible at the beginning
		titanButtons.getPureTitanButton().setVisible(false);
		titanButtons.getColossalTitanButton().setVisible(false);
		titanButtons.getAbnormalTitanButton().setVisible(false);
		titanButtons.getArmouredTitanButton().setVisible(false);

		WeoponShopButton weaponShopButton = new WeoponShopButton(grid, gameStatusBox, battle);
	}

	private void doHard() {
		try {
			battle = new Battle(1, 0, 100, 5, 125); // yapyap
			grid.getChildren().clear();
			this.updateGameStatus();
		} catch (IOException var8) {
			var8.printStackTrace();
		}

		ImageView hardView = new ImageView("Lanes - Copy.png");
		hardView.setFitWidth(this.grid.getWidth());
		hardView.setFitHeight(this.grid.getHeight());
		hardView.setLayoutX(-200.0);
		this.grid.getChildren().clear();
		this.grid.getChildren().add(hardView);
		GridPane gameGrid = this.createGameGrid();
		GridPane gameGridAlly = this.createGameGridAlly();
		this.grid.getChildren().add(gameGrid);
		this.grid.getChildren().add(gameGridAlly);
		this.grid.add(this.gameStatusBox, 0, 0);

		Button passTurnButton = this.createButton("Pass Turn(press P)");
		grid.add(passTurnButton, 10, 10);

		passTurnButton.setOnKeyPressed((e) -> {
			if (e.getCode() == KeyCode.P) {
				loseCondition();
				battle.isGameOver();
				this.battle.passTurn();
				grid.getChildren().remove(titanPane);
				this.updateGameStatus();
				this.updateTitans();

				TitanBuutons titanButtons = new TitanBuutons();

				Button pureTitanButton = titanButtons.getPureTitanButton();
				Button colossalTitanButton = titanButtons.getColossalTitanButton();
				Button abnormalTitanButton = titanButtons.getAbnormalTitanButton();
				Button armouredTitanButton = titanButtons.getArmouredTitanButton();

				List<Button> titanButtonsList = Arrays.asList(pureTitanButton, colossalTitanButton, abnormalTitanButton,
						armouredTitanButton);

				for (Button titanButton : titanButtonsList) {
					titanButton.setVisible(true); // Make the buttons visible when passTurnButton is clicked
				}
			}
		});
		
		VBox vboxPassTurn = new VBox(passTurnButton);
		vboxPassTurn.setAlignment(Pos.BOTTOM_RIGHT); // yapyap
		vboxPassTurn.setPadding(new Insets(15, 15, 15, 15));
		this.grid.getChildren().add(vboxPassTurn);

		TitanBuutons titanButtons = new TitanBuutons();
		VBox vbox = new VBox();
		vbox.getChildren().addAll(titanButtons.getPureTitanButton(), titanButtons.getColossalTitanButton(),
				titanButtons.getAbnormalTitanButton(), titanButtons.getArmouredTitanButton());
		vbox.setAlignment(Pos.CENTER);

		grid.add(vbox, 0, 0);

		// Make the Titan buttons not visible at the beginning
		titanButtons.getPureTitanButton().setVisible(false);
		titanButtons.getColossalTitanButton().setVisible(false);
		titanButtons.getAbnormalTitanButton().setVisible(false);
		titanButtons.getArmouredTitanButton().setVisible(false);

		WeoponShopButton weaponShopButton = new WeoponShopButton(grid, gameStatusBox, battle);
	}

	private void updateTitans() {
	    List<Lane> lanes = this.battle.getOriginalLanes();
	    titanPane.getChildren().clear();
	    int i = 0;
	    for (Lane lane : lanes) {
	        if(lane.isLaneLost())
	            continue;
	        for (Titan titan : lane.getTitans()) {
	            if (titan instanceof PureTitan) {
	                titanView = new ImageView(pureImage);
	                titanView.setFitHeight(25);
	                titanView.setFitWidth(30);
	            } else if (titan instanceof AbnormalTitan) {
	                titanView = new ImageView(abnormalImage);
	                titanView.setFitHeight(16.6);
	                titanView.setFitWidth(30);
	            } else if (titan instanceof ArmoredTitan) {
	                titanView = new ImageView(armoredImage);
	                titanView.setFitHeight(25);
	                titanView.setFitWidth(30);
	            } else if (titan instanceof ColossalTitan) {
	                titanView = new ImageView(colossalImage);
	                titanView.setFitHeight(100);
	                titanView.setFitWidth(80);
	            } else {
	                throw new IllegalArgumentException("Unknown Titan type");
	            }

	            AnchorPane titanPane = new AnchorPane();

	            if (titan instanceof ColossalTitan) {
	                titanView.setLayoutX(440 - titan.getDistance() * -5.5); // Adjust the multiplier as needed
	                titanView.setLayoutY(200 + i * 100); // Adjust the multiplier as needed
	            } else {
	                titanView.setLayoutX(440 - titan.getDistance() * -5.5); // Adjust the multiplier as needed
	                titanView.setLayoutY(275 + i * 100); // Adjust the multiplier as needed
	            }

	            if(titan.isDefeated()) {
	                grid.getChildren().remove(titanView);
	                titanPane.getChildren().remove(titanView);
	            }
	            grid.getChildren().remove(titanView);
	            titanPane.getChildren().remove(titanView);
	            titanPane.getChildren().clear();
	            titanPane.getChildren().add(titanView);
	            grid.getChildren().add(titanPane);
	        }
	        i++;
	    }
	}

	/*
	 * private void updateTitans() { PriorityQueue<Lane> l= this.battle.getLanes();
	 * int i=0; gameGrid.getChildren().removeAll(this.titanbuttons); for(Lane lane:
	 * l) {
	 * 
	 * // Pure 15 // Abnormal 10 // Armored 15 // Colossal 60
	 * 
	 * 
	 * for(Titan titan: lane.getTitans()) { TitanBuutons b= new TitanBuutons();
	 * if(titan instanceof PureTitan) { //change image accordingly Button
	 * titanbutton
	 * =b.createButton("file:///C:/Users/karim/Downloads/Pure%20titan.jpeg");
	 * titanbutton.setText(""+i); //
	 * System.out.println(""+i+" "+titan.getDistance());
	 * gameGrid.add(titanbutton,(titan.getDistance()/11),i);
	 * this.titanbuttons.add(titanbutton); if(titan.isDefeated()) {
	 * grid.getChildren().remove(titanbutton); } } else if (titan instanceof
	 * AbnormalTitan) { Button titanbutton
	 * =b.createButton("file:///C:/Users/karim/Downloads/Pure%20titan.jpeg");
	 * titanbutton.setText(""+i); //
	 * System.out.println(""+i+" "+titan.getDistance());
	 * gameGrid.add(titanbutton,(titan.getDistance()/11),i);
	 * this.titanbuttons.add(titanbutton); if(titan.isDefeated()) {
	 * grid.getChildren().remove(titanbutton); } } else if (titan instanceof
	 * ArmoredTitan) { Button titanbutton
	 * =b.createButton("file:///C:/Users/karim/Downloads/Pure%20titan.jpeg");
	 * titanbutton.setText(""+i); //
	 * System.out.println(""+i+" "+titan.getDistance());
	 * gameGrid.add(titanbutton,(titan.getDistance()/11),i);
	 * this.titanbuttons.add(titanbutton); if(titan.isDefeated()) {
	 * grid.getChildren().remove(titanbutton); } } else if (titan instanceof
	 * ColossalTitan) { Button titanbutton
	 * =b.createButton("file:///C:/Users/karim/Downloads/Pure%20titan.jpeg");
	 * titanbutton.setText(""+i); //
	 * System.out.println(""+i+" "+titan.getDistance());
	 * gameGrid.add(titanbutton,(titan.getDistance()/11),i);
	 * this.titanbuttons.add(titanbutton); if(titan.isDefeated()) {
	 * grid.getChildren().remove(titanbutton); } }
	 * 
	 * 
	 * } i++; // System.out.println(); }
	 * 
	 * 
	 * }
	 */

	public int getSelectedDifficulty() {
		return selectedDifficulty;
	}

	public boolean loseCondition() {
		if (battle.isGameOver() || battle.getLanes().size() == 0) {
			gameOver();
			return true;
		}
		return false;
	}

	public void gameOver() {
		grid.getChildren().clear();
		titanPane.getChildren().clear();
		grid.setBackground(new Background(new BackgroundFill(Color.BLACK, CornerRadii.EMPTY, Insets.EMPTY)));
		
		Label gameOverLabel = new Label("Game Over!");
		gameOverLabel.setStyle("-fx-font-size: 36px;");
		gameOverLabel.setFont(javafx.scene.text.Font.font("Alleycat", 36));
		gameOverLabel.setTextFill(Color.DARKRED);
		gameOverLabel.setOpacity(0); // Start invisible

		String[] quotes = { "maybe do not use the weaker weapons that CLEARLY deal less than 10 dmg?",
				"Crazy? I was crazy once, they locked me in a room! A rubber room! A rubber room with rats...",
				"losing was statistically inevitable", "Marra wa7ed ra7 2a3ad 3ala 2ahwa we... okay sorry I will stop",
				"yk I would change the damage amounts of the Wall Spread but I may get a grade deduction",
				"Balabizo????", " ”When it comes to GIU, forget about life” -Slim Abdelnadher btw ", };
		String randomQuote = quotes[(int) (Math.random() * quotes.length)];

		Label dumbQuote = new Label(randomQuote);
		dumbQuote.setStyle("-fx-font-size: 36px;");
		dumbQuote.setTextFill(Color.LIGHTBLUE);
		dumbQuote.setOpacity(0); // Start invisible

		Label gameOverScore = new Label("   Score: " + battle.getScore());
		gameOverScore.setStyle("-fx-font-size: 36px;");
		gameOverScore.setTextFill(Color.GREEN);
		gameOverScore.setOpacity(0); // Start invisible

		Button restartButton = new Button("Restart Game");
		restartButton.setOnAction(e -> {
			try {
				start(this.primaryStage);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		VBox vbox = new VBox(10); // 10 is the vertical spacing between nodes
		vbox.getChildren().addAll(gameOverLabel, gameOverScore, dumbQuote);
		vbox.setAlignment(Pos.CENTER);

		grid.add(vbox, 0, 0);
		grid.setAlignment(Pos.CENTER);

		FadeTransition fadeInGameOverLabel = new FadeTransition(Duration.seconds(5), gameOverLabel);
		fadeInGameOverLabel.setFromValue(0.0);
		fadeInGameOverLabel.setToValue(1.0);
		fadeInGameOverLabel.play();

		FadeTransition fadeInGameOverScore = new FadeTransition(Duration.seconds(5), gameOverScore);
		fadeInGameOverScore.setFromValue(0.0);
		fadeInGameOverScore.setToValue(1.0);
		fadeInGameOverScore.play();

		PauseTransition pause = new PauseTransition(Duration.seconds(5));
		pause.setOnFinished(e -> {
			FadeTransition fadeInDumbQuote = new FadeTransition(Duration.seconds(10), dumbQuote);
			fadeInDumbQuote.setFromValue(0.0);
			fadeInDumbQuote.setToValue(1.0);
			fadeInDumbQuote.play();

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			} // TODO Auto-generated catch block

			vbox.getChildren().add(restartButton);
		});
		pause.play();
	}

	@Override
	public void handle(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
