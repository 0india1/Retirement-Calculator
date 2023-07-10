import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;

/*
 * This class displays the calculator table with the percentages across the top, age on the left-hand side, and the calculations in between.
 * @author India Green
 */

public class Project1Driver {

    static int age;
    static double savings;
    static double contrib;
    static double target;

    static double[] interest;

    static double[] currentSavings;

    static final int oldest = 72;

    static int ageDif = oldest - age;

    public static Age row[];

    static ObservableList<Age> data;

    /*
     * Gets the values of what would be inputted into the calculator
     * @param a = age
     * @param s = savings
     * @param c = contribution per year
     * @param t = target
     */
    public static void windowDis(int a, double s, double c, double t)
    {

        row = new Age[ageDif];
        age = a;
        savings = s;
        contrib = c;
        target = t;

        interest = new double[16];

        currentSavings = new double[ageDif];

        currentSavings[0] = savings + contrib;

        data = FXCollections.observableArrayList();

        for(int i = 1; i < ageDif; i++)
        {
            currentSavings[i] = currentSavings[i - 1] + contrib;
        }

        int ageTest = age;

        for(int i = 0; i < ageDif; i++)
        {
            interest[0] = currentSavings[i];
            interest[1] = currentSavings[i] * 1.01;
            interest[2] = currentSavings[i] * 1.02;
            interest[3] = currentSavings[i] * 1.03;
            interest[4] = currentSavings[i] * 1.04;
            interest[5] = currentSavings[i] * 1.05;
            interest[6] = currentSavings[i] * 1.06;
            interest[7] = currentSavings[i] * 1.07;
            interest[8] = currentSavings[i] * 1.08;
            interest[9] = currentSavings[i] * 1.09;
            interest[10] = currentSavings[i] * 1.10;
            interest[11] = currentSavings[i] * 1.11;
            interest[12] = currentSavings[i] * 1.12;
            interest[13] = currentSavings[i] * 1.13;
            interest[14] = currentSavings[i] * 1.14;
            interest[15] = currentSavings[i] * 1.15;

            row[i] = new Age(ageTest, interest[0], interest[1], interest[2],interest[3],interest[4],interest[5],interest[6],interest[7],
                    interest[8],interest[9],interest[10], interest[11], interest[12], interest[13],interest[14], interest[15]);

            ageTest = ageTest + 1;
        }

        for(int i=0; i < row.length; i++)
        {
            data.add(row[i]);
        }

        TableView<Age> table = new TableView<Age>();

        TableColumn ageCol= new TableColumn("Age");
        ageCol.setCellValueFactory(new PropertyValueFactory<Age, String>("age"));

        TableColumn zero= new TableColumn("0%");
        zero.setCellValueFactory(new PropertyValueFactory<Age, String>("zeroPercent"));

        TableColumn one= new TableColumn("1%");
        one.setCellValueFactory(new PropertyValueFactory<Age, String>("onePercent"));

        TableColumn two= new TableColumn("2%");
        two.setCellValueFactory(new PropertyValueFactory<Age, String>("twoPercent"));

        TableColumn three= new TableColumn("3%");
        three.setCellValueFactory(new PropertyValueFactory<Age, String>("threePercent"));

        TableColumn four= new TableColumn("4%");
        four.setCellValueFactory(new PropertyValueFactory<Age, String>("fourPercent"));

        TableColumn five= new TableColumn("5%");
        five.setCellValueFactory(new PropertyValueFactory<Age, String>("fivePercent"));

        TableColumn six= new TableColumn("6%");
        six.setCellValueFactory(new PropertyValueFactory<Age, String>("sixPercent"));

        TableColumn seven= new TableColumn("7%");
        seven.setCellValueFactory(new PropertyValueFactory<Age, String>("sevenPercent"));

        TableColumn eight= new TableColumn("8%");
        eight.setCellValueFactory(new PropertyValueFactory<Age, String>("eightPercent"));

        TableColumn nine= new TableColumn("9%");
        nine.setCellValueFactory(new PropertyValueFactory<Age, String>("ninePercent"));

        TableColumn ten= new TableColumn("10%");
        ten.setCellValueFactory(new PropertyValueFactory<Age, String>("tenPercent"));

        TableColumn eleven= new TableColumn("11%");
        eleven.setCellValueFactory(new PropertyValueFactory<Age, String>("elevenPercent"));

        TableColumn twelve= new TableColumn("12%");
        twelve.setCellValueFactory(new PropertyValueFactory<Age, String>("twelvePercent"));

        TableColumn thirteen= new TableColumn("13%");
        thirteen.setCellValueFactory(new PropertyValueFactory<Age, String>("thirteenPercent"));

        TableColumn fourteen= new TableColumn("14%");
        fourteen.setCellValueFactory(new PropertyValueFactory<Age, String>("fourteenPercent"));

        TableColumn fifteen= new TableColumn("15%");
        fifteen.setCellValueFactory(new PropertyValueFactory<Age, String>("fifteenPercent"));

        table.getColumns().addAll(ageCol, zero, one, two, three, four, five, six, seven, eight, nine, ten, eleven, twelve, thirteen, fourteen, fifteen);

        table.setItems(data);

        Stage wind = new Stage();

        // initModality makes it so you're unable to mess with the previous window if a new one is opened
        wind.initModality((Modality.APPLICATION_MODAL));
        wind.setTitle("Retirement Calculator");

        BorderPane border = new BorderPane();

        VBox vbox = new VBox();
        vbox.getChildren().add(table);

        HBox hbox = new HBox();

        Label title = new Label("Your Retirement Calculator");
        title.setFont(Font.font("Arial", 30));
        hbox.setAlignment(Pos.CENTER);

        hbox.getChildren().add(title);
        border.setTop(hbox);
        border.setCenter(vbox);

        Scene scene = new Scene(border, 1300, 500 );
        wind.setScene(scene);
        wind.show();

    }

    /*
     *
     */
    public static class Age {
        private SimpleDoubleProperty zeroPercent;
        private SimpleDoubleProperty onePercent;
        private SimpleDoubleProperty twoPercent;
        private SimpleDoubleProperty threePercent;
        private SimpleDoubleProperty fourPercent;
        private SimpleDoubleProperty fivePercent;
        private SimpleDoubleProperty sixPercent;
        private SimpleDoubleProperty sevenPercent;
        private SimpleDoubleProperty eightPercent;
        private SimpleDoubleProperty ninePercent;
        private SimpleDoubleProperty tenPercent;
        private SimpleDoubleProperty elevenPercent;
        private SimpleDoubleProperty twelvePercent;
        private SimpleDoubleProperty thirteenPercent;
        private SimpleDoubleProperty fourteenPercent;
        private SimpleDoubleProperty fifteenPercent;
        private int age;

        /*
         * The constructor class, sets values.
         */
        public Age(int a, double balance0, double balance1, double balance2, double balance3,
                   double balance4, double balance5, double balance6, double balance7,
                   double balance8, double balance9, double balance10, double balance11,
                   double balance12, double balance13, double balance14, double balance15){
            this.age = a;
            this.zeroPercent = new SimpleDoubleProperty(balance0);
            this.onePercent = new SimpleDoubleProperty(balance1);
            this.twoPercent = new SimpleDoubleProperty(balance2);
            this.threePercent = new SimpleDoubleProperty(balance3);
            this.fourPercent = new SimpleDoubleProperty(balance4);
            this.fivePercent = new SimpleDoubleProperty(balance5);
            this.sixPercent = new SimpleDoubleProperty(balance6);
            this.sevenPercent = new SimpleDoubleProperty(balance7);
            this.eightPercent = new SimpleDoubleProperty(balance8);
            this.ninePercent = new SimpleDoubleProperty(balance9);
            this.tenPercent = new SimpleDoubleProperty(balance10);
            this.elevenPercent = new SimpleDoubleProperty(balance11);
            this.twelvePercent = new SimpleDoubleProperty(balance12);
            this.thirteenPercent = new SimpleDoubleProperty(balance13);
            this.fourteenPercent = new SimpleDoubleProperty(balance14);
            this.fifteenPercent = new SimpleDoubleProperty((balance15));
        }

        /*
         * These methods are the getters and setters.
         */
        public int getAge() {
            return age;
        }

        public void setAge(){
            this.age = age;
        }

        public double getZeroPercent() {
            return zeroPercent.get();
        }

        public DoubleProperty zeroPercentProperty() {
            return zeroPercent;
        }

        public void setZeroPercent(double zeroPercent) {
            this.zeroPercent.set(zeroPercent);
        }

        public double getOnePercent() {
            return onePercent.get();
        }

        public DoubleProperty onePercentProperty() {
            return onePercent;
        }

        public void setOnePercent(double onePercent) {
            this.onePercent.set(onePercent);
        }

        public double getTwoPercent() {
            return twoPercent.get();
        }

        public DoubleProperty twoPercentProperty() {
            return twoPercent;
        }

        public void setTwoPercent(double twoPercent) {
            this.twoPercent.set(twoPercent);
        }

        public double getThreePercent() {
            return threePercent.get();
        }

        public DoubleProperty threePercentProperty() {
            return threePercent;
        }

        public void setThreePercent(double threePercent) {
            this.threePercent.set(threePercent);
        }

        public double getFourPercent() {
            return fourPercent.get();
        }

        public DoubleProperty fourPercentProperty() {
            return fourPercent;
        }

        public void setFourPercent(double fourPercent) {
            this.fourPercent.set(fourPercent);
        }

        public double getFivePercent() {
            return fivePercent.get();
        }

        public DoubleProperty fivePercentProperty() {
            return fivePercent;
        }

        public void setFivePercent(double fivePercent) {
            this.fivePercent.set(fivePercent);
        }

        public double getSixPercent() {
            return sixPercent.get();
        }

        public DoubleProperty sixPercentProperty() {
            return sixPercent;
        }

        public void setSixPercent(double sixPercent) {
            this.sixPercent.set(sixPercent);
        }

        public double getSevenPercent() {
            return sevenPercent.get();
        }

        public DoubleProperty sevenPercentProperty() {
            return sevenPercent;
        }

        public void setSevenPercent(double sevenPercent) {
            this.sevenPercent.set(sevenPercent);
        }

        public double getEightPercent() {
            return eightPercent.get();
        }

        public DoubleProperty eightPercentProperty() {
            return eightPercent;
        }

        public void setEightPercent(double eightPercent) {
            this.eightPercent.set(eightPercent);
        }

        public double getNinePercent() {
            return ninePercent.get();
        }

        public DoubleProperty ninePercentProperty() {
            return ninePercent;
        }

        public void setNinePercent(double ninePercent) {
            this.ninePercent.set(ninePercent);
        }

        public double getTenPercent() {
            return tenPercent.get();
        }

        public DoubleProperty tenPercentProperty() {
            return tenPercent;
        }

        public void setTenPercent(double tenPercent) {
            this.tenPercent.set(tenPercent);
        }

        public double getElevenPercent() {
            return elevenPercent.get();
        }

        public DoubleProperty elevenPercentProperty() {
            return elevenPercent;
        }

        public void setElevenPercent(double elevenPercent) {
            this.elevenPercent.set(elevenPercent);
        }

        public double getTwelvePercent() {
            return twelvePercent.get();
        }

        public DoubleProperty twelvePercentProperty() {
            return twelvePercent;
        }

        public void setTwelvePercent(double twelvePercent) {
            this.twelvePercent.set(twelvePercent);
        }

        public double getThirteenPercent() {
            return thirteenPercent.get();
        }

        public DoubleProperty thirteenPercentProperty() {
            return thirteenPercent;
        }

        public void setThirteenPercent(double thirteenPercent) {
            this.thirteenPercent.set(thirteenPercent);
        }

        public double getFourteenPercent() {
            return fourteenPercent.get();
        }

        public DoubleProperty fourteenPercentProperty() {
            return fourteenPercent;
        }

        public void setFourteenPercent(double fourteenPercent) {
            this.fourteenPercent.set(fourteenPercent);
        }

        public double getFifteenPercent() {
            return fifteenPercent.get();
        }

        public DoubleProperty fifteenPercentProperty() {
            return fifteenPercent;
        }

        public void setFifteenPercent(double fifteenPercent) {
            this.fifteenPercent.set(fifteenPercent);
        }
    }


}
