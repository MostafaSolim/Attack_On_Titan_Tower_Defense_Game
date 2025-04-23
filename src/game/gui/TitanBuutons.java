package game.gui;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


public class TitanBuutons {
    private Button pureTitanButton;
    private Button colossalTitanButton;
    private Button abnormalTitanButton;
    private Button armouredTitanButton;

    public TitanBuutons() {
        this.pureTitanButton = createButton("file:///C:/Users/karim/Downloads/Pure%20titan.jpeg");
        this.colossalTitanButton = createButton("file:///C:/Users/karim/Downloads/Colossal%20titan.jpeg");
        this.abnormalTitanButton = createButton("file:///C:/Users/karim/Downloads/Abnormal%20titan.jpeg");
        this.armouredTitanButton = createButton("file:///C:/Users/karim/Downloads/armored%20titan.png");
    }
    

    public Button createButton(String imagePath) {
        Image image = new Image(imagePath);
        ImageView imageView = new ImageView(image);
        imageView.setFitWidth(15);
        imageView.setFitHeight(15);
        Button button = new Button();
        button.setGraphic(imageView);
        return button;
    }

	    public Button getPureTitanButton() {
	        return pureTitanButton;
	    }

	    public Button getColossalTitanButton() {
	        return colossalTitanButton;
	    }

	    public Button getAbnormalTitanButton() {
	        return abnormalTitanButton;
	    }

	    public Button getArmouredTitanButton() {
	        return armouredTitanButton;
	    }
	}



