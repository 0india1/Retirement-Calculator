import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.*;
import javafx.stage.Stage;

/*
 * This class is the GUI where the user would be able to input the age, savings, contribution and target
 * @author India Green
 */
public class Project1 extends Application {

    Stage stage;
    Scene scene;
    public static void main(String[] args){ launch(args);}

    @Override
    public void start(Stage primary){
        stage = primary;

        HBox hbox = new HBox();

        hbox.setAlignment(Pos.CENTER);
        hbox.setAlignment(Pos.TOP_CENTER);

        Text title = new Text("Retirement Calculator");

        title.setFont(Font.font("Arial", 30));

        hbox.getChildren().add(title);

        BorderPane border = new BorderPane();

        border.setTop(hbox);

        scene = new Scene(border, 500, 500);

        stage.setScene(scene);
        stage.show();

        GridPane grid = new GridPane();

        grid.setMaxSize(250,200);

        // sets spacing
        grid.setVgap(10);
        grid.setHgap(10);

        Label age = new Label("Enter age: ");
        GridPane.setConstraints(age, 0, 0);

        final TextField ageText = new TextField();
        GridPane.setConstraints(ageText, 1, 0);

        Label savings = new Label("Enter savings: ");
        GridPane.setConstraints(savings, 0, 1);

        TextField savingsText = new TextField();
        GridPane.setConstraints(savingsText, 1, 1);

        Label contribution = new Label("Enter contribution: ");
        GridPane.setConstraints(contribution, 0, 2);

        TextField contribText = new TextField();
        GridPane.setConstraints(contribText, 1, 2);

        Label target = new Label("Enter target: ");
        GridPane.setConstraints(target, 0, 3);

        TextField targetText = new TextField();
        GridPane.setConstraints(targetText, 1, 3);

        Button add = new Button("Enter");
        GridPane.setConstraints(add, 1, 4);

        grid.getChildren().addAll(age, ageText, savings, savingsText, contribution, contribText, target, targetText, add);

        border.setCenter(grid);

        add.setOnAction((e -> {
               String ageS = ageText.getText();
               int num = Integer.parseInt(ageS);

               String savings2 = savingsText.getText();
               double savings3 = Double.parseDouble(savings2);

               String contribT = contribText.getText();
               double contrib = Double.parseDouble(contribT);

               String target2 = targetText.getText();
               double target3 = Double.parseDouble(target2);

            Project1Driver.windowDis(num, savings3, contrib, target3);
        }));


    }
}
