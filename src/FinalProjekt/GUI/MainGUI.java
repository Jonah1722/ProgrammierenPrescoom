package FinalProjekt.GUI;

import FinalProjekt.chapters.Story;
import FinalProjekt.item_stuff.Inventory;
import FinalProjekt.item_stuff.Item;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.PauseTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.List;

public class MainGUI extends Application {

    private StackPane root = new StackPane();
    private List<Button> itemButtons;
    private VBox buttonLayout;
    private ScrollPane scrollPane;
    private Inventory playerInventory = new Inventory();
    private boolean isInventoryOpen = false;
    public static TextField textField = new TextField();

    public static void setTypingText(String text, Color color) {
        MainGUI.typingText.setText(text);
        MainGUI.typingText.setFill(color);
    }

    private static Text typingText = new Text();
    private static Text typingTextBefore = new Text();
    Button inventoryButton = new Button("Open Inventory");

    public static void setBackgroundImageNum(int backgroundImageNum) {
        MainGUI.backgroundImageNum = backgroundImageNum;
    }

    public static int backgroundImageNum;

    public static void setKeyboardImageNumber(int keyboardImageNumber) {
        MainGUI.keyboardImageNumber = keyboardImageNumber;
    }

    public static int keyboardImageNumber = 0;

    public static Button inventoryBookButton = new Button("Book");

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage primaryStage) {
        // Set the title of the window
        primaryStage.setTitle("Prescoom");

        // Load the background image
        Image backgroundImageStart = new Image("FinalProjekt/images/start1.png");
        Image backgroundImageChapter0 = new Image("FinalProjekt/images/blackPic.png");
        Image backgroundImageChapter1P1 = new Image("FinalProjekt/images/books.jpg");
        Image backgroundImage = new Image("FinalProjekt/images/background.jpg");
        Image backgroundImageOpenBook = new Image("FinalProjekt/images/openBook.png");

        Image[] backgroundImages = {backgroundImageStart, backgroundImageChapter0, backgroundImageChapter1P1, backgroundImage, backgroundImageOpenBook};

        Image keyboardIconImage = new Image("FinalProjekt/images/keyboardWhite.png");
        Image keyboardIconImageBlack = new Image("FinalProjekt/images/keyboard.png");
        Image[] keyboardImages = {keyboardIconImage, keyboardIconImageBlack};
        ImageView backgroundImageView = new ImageView(backgroundImages[0]);

        // Create an ImageView to display the background image

        // Create ImageViews
        Image inventoryIconImage = new Image("FinalProjekt/images/inventory2.png");
        ImageView inventoryIconImageView = new ImageView(inventoryIconImage);
        inventoryIconImageView.setFitWidth(30);
        inventoryIconImageView.setFitHeight(30);


        ImageView keyboardIconImageView = new ImageView(keyboardImages[keyboardImageNumber]);
        keyboardIconImageView.setFitWidth(30);
        keyboardIconImageView.setFitHeight(30);

        Image startButtonImage = new Image("FinalProjekt/images/startButton.png");
        ImageView startButtonImageView = new ImageView(startButtonImage);
        startButtonImageView.setFitHeight(600);
        startButtonImageView.setFitWidth(800);

        Image startButtonImage2 = new Image("FinalProjekt/images/startButton.png");
        ImageView startButtonImageView2 = new ImageView(startButtonImage2);
        startButtonImageView.setFitHeight(600);
        startButtonImageView.setFitWidth(800);

        Image inventoryBookImage = new Image("FinalProjekt/images/startButton.png");
        ImageView inventoryBookImageView3 = new ImageView(inventoryBookImage);
        startButtonImageView.setFitHeight(600);
        startButtonImageView.setFitWidth(800);

        //createButtons
        Button continueButton = new Button("Weiter");
        Button continueButtonOnce = new Button("Weiter");
        Button startButton = new Button("Start");
        Button textFieldToggleButton = new Button("Toggle Text Field");

        continueButtonOnce.setGraphic(startButtonImageView2);
        continueButtonOnce.setStyle("-fx-background-color: transparent;");
        continueButtonOnce.setPrefSize(800, 600);
        continueButtonOnce.setText(null);
        continueButtonOnce.setVisible(false);

        continueButton.setVisible(false);

        startButton.setGraphic(startButtonImageView);
        startButton.setStyle("-fx-background-color: transparent;");
        startButton.setPrefSize(800, 600);
        startButton.setTranslateX(-170);
        startButton.setText(null);
        startButton.setVisible(true);

        inventoryButton.setGraphic(inventoryIconImageView);
        inventoryButton.setStyle("-fx-background-color: transparent;");
        inventoryButton.setPrefSize(30, 30);
        inventoryButton.setText(null);
        inventoryButton.setVisible(false);
        inventoryButton.setOnAction(event -> toggleInventory());

        inventoryBookButton.setGraphic(inventoryBookImageView3);
        inventoryBookButton.setStyle("-fx-background-color: transparent;");
        inventoryBookButton.setPrefSize(800, 600);
        inventoryBookButton.setText(null);
        inventoryBookButton.setVisible(false);
        inventoryBookButton.setOnAction(event -> addItemToInventory(1, "book"));

        textField.setVisible(false);
        textField.setTranslateY(400);

        textFieldToggleButton.setGraphic(keyboardIconImageView);
        textFieldToggleButton.setStyle("-fx-background-color: transparent;");
        textFieldToggleButton.setPrefSize(30, 30);
        textFieldToggleButton.setText(null);
        textFieldToggleButton.setVisible(false);
        textFieldToggleButton.setOnAction(event -> {
            textField.setVisible(!textField.isVisible());
            if (textField.isVisible()) {
                textField.requestFocus(); // Setzt den Fokus auf das Textfeld, damit der Benutzer direkt eingeben kann
            }
        });
        // Add the button click event handler
        startButton.setOnAction(event -> {
            // Show the Inventory Button
            startButton.setVisible(false);
            backgroundImageView.setImage(backgroundImages[1]);
            Story.storyWay();
            Animation typingAnimationBeginning = createTypingAnimation(typingText, 80, 740);
            StackPane.setAlignment(typingText, Pos.CENTER);
            typingAnimationBeginning.setOnFinished(animationEvent -> {
                PauseTransition delay = new PauseTransition(Duration.seconds(2));
                delay.setOnFinished(event1 -> {
                    continueButtonOnce.setVisible(true);
                });
                delay.play();
            });
            typingAnimationBeginning.play();
        });

        continueButtonOnce.setOnAction(event -> {
            root.getChildren().remove(typingText);
            continueButtonOnce.setVisible(false);
            Story.storyWay();
            Animation typingAnimation = createTypingAnimation(typingText, 15, 900);
            StackPane.setAlignment(typingText, Pos.CENTER);
            typingAnimation.setOnFinished(animationEvent -> {
                PauseTransition delay = new PauseTransition(Duration.seconds(1));
                delay.setOnFinished(event1 -> {
                    continueButton.setVisible(true);
                });
                delay.play();
            });
            typingAnimation.play();
        });


        continueButton.setOnAction(event -> {
            typingTextBefore = typingText;
            keyboardIconImageView.setImage(keyboardImages[keyboardImageNumber]);
            root.getChildren().remove(typingTextBefore);
            Story.storyWay();
            Animation typingAnimation = createTypingAnimation(typingText, 15, 900);
            typingAnimation.play();
            inventoryButton.setVisible(true);
            textFieldToggleButton.setVisible(true);
            backgroundImageView.setImage(backgroundImages[backgroundImageNum]);
        });

        // Create a root layout (a simple StackPane in this case)
        root.getChildren().addAll(backgroundImageView, startButton, continueButton, textFieldToggleButton, textField, continueButtonOnce, inventoryBookButton);
        // Position the new button
        StackPane.setAlignment(startButton, Pos.CENTER);
        StackPane.setAlignment(continueButtonOnce, Pos.BOTTOM_CENTER);
        StackPane.setAlignment(continueButton, Pos.BOTTOM_RIGHT);
        StackPane.setAlignment(textFieldToggleButton, Pos.TOP_RIGHT);
        StackPane.setAlignment(inventoryBookButton, Pos.CENTER_LEFT);

        // Bind the size of the backgroundImageView to the size of the root layout
        backgroundImageView.fitWidthProperty().bind(root.widthProperty());
        backgroundImageView.fitHeightProperty().bind(root.heightProperty());

        // Create a Scene with the root layout and set its dimensions
        Scene scene = new Scene(root, 1800, 1000);

        // Set the Scene for the primary stage (window)
        primaryStage.setScene(scene);

        // Show the window
        primaryStage.show();
    }

    // Erstellen Sie die Tippanimation für einen gegebenen Text
    private Animation createTypingAnimation(Text text, int delayBetweenLetters, int wrappingWidth) {
        final int delayMillis = delayBetweenLetters; // Verzögerung zwischen Buchstaben in Millisekunden
        text.setFont(Font.font(24));
        text.setFill(text.getFill());
        text.setWrappingWidth(wrappingWidth);


        root.getChildren().add(text);

        StringBuilder animatedText = new StringBuilder();

        Timeline timeline = new Timeline();
        for (int i = 0; i < text.getText().length(); i++) {
            char character = text.getText().charAt(i);

            KeyFrame keyFrame = new KeyFrame(Duration.millis(i * delayMillis), event -> {
                animatedText.append(character);
                text.setText(animatedText.toString());
            });

            timeline.getKeyFrames().add(keyFrame);
        }

        timeline.setOnFinished(event -> {
        });

        return timeline;
    }

    private void toggleInventory() {
        if (isInventoryOpen) {
            // close inventory
            buttonLayout.getChildren().removeAll(itemButtons);
        } else {
            // open inventory
            createItemButtons();
        }
        isInventoryOpen = !isInventoryOpen; // Den Zustand des Inventars umkehren
    }

    private void addItemToInventory(int itemNum, String itemName) {
        root.getChildren().add(createButtonLayout(inventoryButton));
    }

    // Helper method to create a layout for the item buttons in the left bottom corner
    private VBox createButtonLayout(Button inventoryButton) {
        itemButtons = new ArrayList<>();

        // Create a VBox to hold the item buttons
        buttonLayout = new VBox(10); // Spacing between buttons (you can adjust this value as needed)
        buttonLayout.setStyle("-fx-alignment: top-left;");

        // Create a ScrollPane to make the VBox scrollable
        scrollPane = new ScrollPane();
        scrollPane.setContent(buttonLayout);
        scrollPane.setFitToWidth(true);

        // Set the visibility of the ScrollPane initially to false (hide it)
        scrollPane.setVisible(false);

        // Set the action for the inventory button to toggle the visibility of the ScrollPane
        inventoryButton.setOnAction(event -> {
            if (!scrollPane.isVisible()) {
                createItemButtons(); // Create the item buttons only when the inventory is opened
            } else {
                buttonLayout.getChildren().removeAll(itemButtons); // Remove the existing item buttons when the inventory is closed
                itemButtons.clear(); // Clear the list of item buttons
            }
            scrollPane.setVisible(!scrollPane.isVisible());
        });

        buttonLayout.getChildren().addAll(inventoryButton);
        return buttonLayout;
    }

    // Helper method to create the item buttons and add them to the button layout
    private void createItemButtons() {
        List<Item> items = Story.inventory.getPlayerInventory();

        for (Item item : items) {
            Button itemButton = new Button(item.getName());
            itemButton.setOnAction(event -> {
                System.out.println(item.getName());
            });
            itemButtons.add(itemButton);
        }
        buttonLayout.getChildren().addAll(itemButtons);
    }

    // Helper method to create some dummy items (replace with your real data)
    private void createAndAddDummyItemsToInventory() {
        Item swordItem = new Item(1, "Sword", playerInventory);
        playerInventory.addItem(swordItem);

        Item potionItem = new Item(2, "Potion", playerInventory);
        playerInventory.addItem(potionItem);
    }

}
