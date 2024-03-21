import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class DVDCollectionApp2  extends Application {
    private DVDCollection model;
    public DVDCollectionApp2() {
        model = DVDCollection.example1();
    }
    public void start(Stage primaryStage) {
        Pane  aPane = new Pane();


        // Create the labels
        Label label1 = new Label("DVDs");
        label1.relocate(10, 10);
        label1.setPrefSize(40, 20);
        Label label2 = new Label("Title");
        label2.relocate(10, 202);
        label2.setPrefSize(40, 20);
        Label label3 = new Label("Year");
        label3.relocate(10, 242);
        label3.setPrefSize(40, 20);
        Label label4 = new Label("Length");
        label4.relocate(120, 242);
        label4.setPrefSize(40, 20);

        // Create the TextFields
        TextField tField = new TextField();
        tField.relocate(50, 200);
        tField.setPrefSize(500, 30);
        TextField yField = new TextField();
        yField.relocate(50, 240);
        yField.setPrefSize(55, 30);
        TextField lField = new TextField();
        lField.relocate(180, 240);
        lField.setPrefSize(45, 30);


        // Create the lists
        ListView<DVD>    tList = new ListView<DVD>();
        tList.relocate(10, 40);
        tList.setPrefSize(540, 150);
        tList.setItems(FXCollections.observableArrayList(model.getDVDList()));

        ListView<String> yList = new ListView<String>();
        String[] years = {"1978", "2002", "1968", "1999"};
        yList.setItems(FXCollections.observableArrayList(years));

        // Create the buttons
        DVDButtonPane buttonPane = new DVDButtonPane();
        buttonPane.relocate(250,240);

        //event handling
        buttonPane.getAddButton().setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent actionEvent) {
                String title = tField.getText();
                int year = Integer.parseInt(yField.getText());
                int length = Integer.parseInt(lField.getText());
                model.add(new DVD(title, year, length));
                tList.setItems(FXCollections.observableArrayList(model.getDVDList()));
                }

            });
        buttonPane.getRemoveButton().setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent actionEvent) {
                model.remove(tList.getSelectionModel().getSelectedItem().getTitle());
                tList.getItems().remove(tList.getSelectionModel().getSelectedItem());
                }
            });
        tList.setOnMousePressed(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent mouseEvent) {
                // Add your code here
                if(mouseEvent != null){
                    tField.setText(tList.getSelectionModel().getSelectedItem().getTitle());
                    yField.setText(""+tList.getSelectionModel().getSelectedItem().getYear());
                    lField.setText(""+tList.getSelectionModel().getSelectedItem().getDuration());
                }
            }
        });

            aPane.getChildren().addAll(label1,label2,label3,label4,tField,yField,lField,tList,buttonPane);
        primaryStage.setTitle("My DVD Collection"); // Set title of window
        primaryStage.setScene(new Scene(aPane, 560, 280)); // Set size of window
        primaryStage.setResizable(false);
        primaryStage.show();



    }
    public static void main(String[] args) {
        launch(args);
    }
}
