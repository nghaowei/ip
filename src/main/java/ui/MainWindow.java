package ui;

import java.util.Objects;

import app.GenieWeenie;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

/**
 * Controller for the main GUI.
 */
public class MainWindow extends AnchorPane {
    @FXML
    private ScrollPane scrollPane;
    @FXML
    private VBox dialogContainer;
    @FXML
    private TextField userInput;
    @FXML
    private Button sendButton;

    private GenieWeenie genie;

    private final Image userImage;
    private final Image genieImage;

    {
        userImage = new Image(Objects.requireNonNull(this.getClass().getResourceAsStream("/images/alaadin.jpg")));
        genieImage = new Image(Objects.requireNonNull(this.getClass().getResourceAsStream("/images/genie.jpg")));
    }

    @FXML
    public void initialize() {
        scrollPane.vvalueProperty().bind(dialogContainer.heightProperty());
    }

    /** Injects the Duke instance */
    public void setPepe(GenieWeenie genie) {
        this.genie = genie;
    }

    /**
     * Creates two dialog boxes, one echoing user input and the other containing Duke's reply and then appends them to
     * the dialog container. Clears the user input after processing.
     */
    @FXML
    private void handleUserInput() {
        String input = userInput.getText();

        if (input.isEmpty()) {
            // Optionally show a warning or just ignore
            return; // do nothing if input is empty
        } else {
            String response = genie.getResponse(input);
            String commandType = genie.getCommandType();
            dialogContainer.getChildren().addAll(
                    DialogBox.getUserDialog(input, userImage),
                    DialogBox.getGenieDialog(response, genieImage, commandType)
            );
            userInput.clear();

            // If the user types "bye", close the window after 3 seconds
            if (input.equalsIgnoreCase("bye")) {
                javafx.animation.PauseTransition delay = new javafx
                        .animation.PauseTransition(javafx.util.Duration.seconds(3));
                delay.setOnFinished(event -> {
                    // Get the current stage and close it
                    javafx.stage.Stage stage = (javafx.stage.Stage) dialogContainer.getScene().getWindow();
                    stage.close();
                });
                delay.play();
            }
        }
    }
}
