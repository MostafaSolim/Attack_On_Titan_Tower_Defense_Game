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

public class PassTurnButton {
    private GridPane grid;
    private Button passTurnButton;
    private VBox gameStatusBox;
    private Battle battle;
    private ImageView imageView;
    private List<Node> originalGridChildren;
    private Runnable onExitShop;
    private GUI gui;

    Alert alert = new Alert(AlertType.ERROR);

    private void createPasTurnButton() {
        passTurnButton = new Button("PassTurn");
        passTurnButton.setPrefSize(200, 50); // Set the preferred width and height of the button
        passTurnButton.setStyle("-fx-font-weight: bold;"); // Make the text bold
        HBox hbox = new HBox(new Node[]{passTurnButton});
        hbox.setAlignment(Pos.BOTTOM_RIGHT); // Position the button at the top right of the screen
        this.grid.add(hbox, -1, -1);
        //this.grid.add(vbox, 0, 0);
        passTurnButton.setOnAction((e) -> {
            // Store the original state of the grid
            originalGridChildren = new ArrayList<>(this.grid.getChildren());
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

    public Button getPassTurnButton() {
        return passTurnButton;
    }
}