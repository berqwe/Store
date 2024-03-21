import javafx.scene.control.Button;
import javafx.scene.layout.Pane;


public class DVDButtonPane extends Pane {
    private Button addButton;
    private Button removeButton;
    private Button Stats;
    public DVDButtonPane() {

        Pane innerPane = new Pane();

        addButton = new Button("Add");
        addButton.relocate(0, 0);
        addButton.setPrefSize(90, 30);
        addButton.setStyle("-fx-font: 12 arial; -fx-base: green; " + "-fx-text-fill: white;");
        addButton.setDisable(false);
        addButton.setVisible(true);

        removeButton = new Button("Delete");
        removeButton.relocate(100, 0);
        removeButton.setPrefSize(90, 30);
        removeButton.setStyle("-fx-font: 12 arial; -fx-base: red; " + "-fx-text-fill: white;");
        removeButton.setDisable(false);
        removeButton.setVisible(true);

        Stats = new Button("Stats");
        Stats.relocate(210, 0);
        Stats.setPrefSize(90, 30);
        Stats.setStyle("-fx-font: 12 arial; -fx-base: white; " + "-fx-text-fill: black;");
        Stats.setDisable(false);
        Stats.setVisible(true);

        getChildren().addAll(addButton, removeButton, Stats, innerPane);

    }
    //get methods
    public Button getRemoveButton() {
        return removeButton;
    }

    public Button getAddButton() {
        return addButton;
    }

    public Button getStats() {
        return Stats;
    }
}