package game.gui;

import game.engine.*;
import game.engine.exceptions.*;
import game.engine.lanes.*;

import java.util.*;

import javafx.geometry.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.control.Alert.*;
import javafx.scene.image.*;
import javafx.scene.layout.*;

public class WeoponShopButton extends GUI{
    private GridPane grid;
    private Button weaponShopButton;
    private VBox gameStatusBox;
    private Battle battle;
    private ImageView imageView;
    private List<Node> originalGridChildren;
    private Runnable onExitShop;
    private GUI gui;
    
    public static int laneNumber;
    public static int piercingCount;
    public static int SniperCount;
    public static int wallSpreadCount;
    public static int wallTrapCount;

    Alert alert = new Alert(AlertType.ERROR);

    public WeoponShopButton(GridPane grid, VBox gameStatusBox, Battle battle) {
        this.grid = grid;
        this.gameStatusBox = gameStatusBox;
        this.battle = battle;
        this.gui = gui;
        createWeaponShopButton();
    }

    private void createWeaponShopButton() {
        weaponShopButton = new Button("Weapon Shop");
        weaponShopButton.setPrefSize(200, 50); // Set the preferred width and height of the button
        weaponShopButton.setStyle("-fx-font-weight: bold;"); // Make the text bold
        HBox hbox = new HBox(new Node[]{weaponShopButton});
        hbox.setAlignment(Pos.TOP_RIGHT); // Position the button at the top right of the screen
        //VBox vbox = new VBox(new Node[]{weaponShopButton});
        //vbox.setAlignment(Pos.TOP_RIGHT); // Position the button at the bottom right of the screen
        this.grid.add(hbox, 0, 0);
        //this.grid.add(vbox, 0, 0);
        weaponShopButton.setOnAction((e) -> {
            // Store the original state of the grid
            originalGridChildren = new ArrayList<>(this.grid.getChildren());
            String imagePath = "noexit.png";
            Image image1 = new Image(imagePath);
            imageView = new ImageView(image1);
            imageView.setFitWidth(this.grid.getWidth());
            imageView.setFitHeight(this.grid.getHeight());
            Button buyButton1 = createButton("Buy1", 250, 455, 0, this::buy1);
            Button buyButton2 = createButton("Buy2", 530, 450, 0, this::buy2);
            Button buyButton3 = createButton("Buy3", 900, 450, 0, this::buy3);
            Button buyButton4 = createButton("Buy4", 1170, 450, 0, this::buy4);
            Button exitButton = createButton("Exit Shop", 666, 620, 1, this::exitShop);
            this.grid.getChildren().clear();
            this.grid.getChildren().add(imageView);
            Pane pane = new Pane(buyButton1, buyButton2, buyButton3, buyButton4, exitButton);
            this.grid.getChildren().add(pane);
        });
    }

    private Button createButton(String text, double layoutX, double layoutY, double opacity, Runnable action) {
        Button button = new Button(text);
        button.setPrefSize(150.0, 70.0);
        button.setLayoutX(layoutX);
        button.setLayoutY(layoutY);
        button.setOpacity(opacity);
        button.setOnAction(e -> action.run());
        return button;
    }

    private Lane getLaneFromUser() {
        PriorityQueue<Lane> lanesQueue = battle.getLanes();
        List<Lane> lanes = new ArrayList<>(lanesQueue);
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Lane Number");
        dialog.setHeaderText("Enter the lane number where you want to place the weapon:");
        Optional<String> result = dialog.showAndWait();
        if (result.isPresent()) {
            try {
                int laneNumber = Integer.parseInt(result.get());
                if (laneNumber >= 1 && laneNumber <= lanes.size()) {
                    Lane selectedLane = lanes.get(laneNumber - 1);
                    if (selectedLane.isLaneLost()) {
                        System.out.println("The selected lane is lost. Please select a different lane.");
                        showAlert("Lane Lost", "The selected lane is lost. Please select a different lane.");
                        return null;
                    } else 
                        return selectedLane;
                } else 
                    System.out.println("Invalid lane number. Please enter a number between 1 and " + lanes.size());
                    showAlert("Invalid Lane Number", "Invalid lane number. Please enter a number between 1 and " + lanes.size());
            } catch (NumberFormatException e) {System.out.println("Invalid input. Please enter a number.");
            alert.setContentText(e.getMessage());
            }
        }
        return null;
    }

    private void buy1() {
        try {
            Lane selectedLane = getLaneFromUser();
            if (selectedLane != null) {
                battle.purchaseWeapon(1, selectedLane);
                piercingCount++;
                exitShop();
            }
        } catch (InsufficientResourcesException | InvalidLaneException e) {
            System.out.println(e.getMessage());
            alert.setTitle("Error Dialog");
            alert.setHeaderText(null);
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }
    }

    private void buy2() {
        try {
            Lane selectedLane = getLaneFromUser();
            if (selectedLane != null) {
                battle.purchaseWeapon(2, selectedLane);
                SniperCount++;
                exitShop();
                gui.updateGameStatus();
            }
        } catch (InsufficientResourcesException | InvalidLaneException e) {
            System.out.println(e.getMessage());
            alert.setTitle("Error Dialog");
            alert.setHeaderText(null);
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        
        }
    }

    private void buy3() {
        try {
            Lane selectedLane = getLaneFromUser();
            if (selectedLane != null) {
                battle.purchaseWeapon(3, selectedLane);
                wallSpreadCount++;
                exitShop();
                gui.updateGameStatus();
            }
        } catch (InsufficientResourcesException | InvalidLaneException e) {
            System.out.println(e.getMessage());
            alert.setTitle("Error Dialog");
            alert.setHeaderText(null);
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }
    }

    private void buy4() {
        try {
            Lane selectedLane = getLaneFromUser();
            if (selectedLane != null) {
                battle.purchaseWeapon(4, selectedLane);
                wallTrapCount++;
                exitShop();
                gui.updateGameStatus();
            }
        } catch (InsufficientResourcesException | InvalidLaneException e) {
            System.out.println(e.getMessage());
            alert.setTitle("Error Dialog");
            alert.setHeaderText(null);
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }
    }

    private void exitShop() {
    	this.grid.getChildren().setAll(originalGridChildren);
    	gui.updateGameStatus();
    }
    
    private void showAlert(String title, String message) {
        alert.setAlertType(AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    public Button getWeaponShopButton() {
        return weaponShopButton;
    }
}