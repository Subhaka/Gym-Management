package com.company;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class GUI extends Application {
    MyGymManager gymManager = new MyGymManager();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Stage stage = new Stage();

        VBox img = new VBox();
        img.setLayoutX(20);
        img.setLayoutY(20);
        img.setId("logo");
        img.setMinSize(50, 100);
        Label lbl = new Label("GYM MANAGEMENT");
        lbl.setLayoutX(420);
        lbl.setLayoutY(50);
        lbl.setId("lbl");

        TextField txtsearch = new TextField();
        txtsearch.setPromptText("Search....");
        txtsearch.setLayoutX(760);
        txtsearch.setLayoutY(20);


        TableView<DefaultMember> tableView = new TableView<>();
        tableView.setId("table-view");
        TableColumn<DefaultMember, String> membership_id = new TableColumn<>("Membership Id");
        membership_id.setCellValueFactory(new PropertyValueFactory<>("membershipNo"));
        membership_id.setMinWidth(90);

        TableColumn<DefaultMember, String> name = new TableColumn<>("Name");
        name.setCellValueFactory(new PropertyValueFactory<>("name"));
        name.setMinWidth(100);


        TableColumn<DefaultMember, String> membership_type = new TableColumn<>("Membership Type");
        membership_type.setCellValueFactory(new PropertyValueFactory<>("memberType"));
        membership_type.setMinWidth(50);

        TableColumn<DefaultMember, Date> date = new TableColumn<>("Date");
        date.setCellValueFactory(new PropertyValueFactory<>("date"));
        date.setMinWidth(50);


        TableColumn<DefaultMember, String> school = new TableColumn<>(" School Name");
        school.setCellValueFactory(new PropertyValueFactory<>("schoolName"));
        school.setMinWidth(60);

        TableColumn<DefaultMember, Integer> age = new TableColumn<>("Age");
        age.setCellValueFactory(new PropertyValueFactory<>("age"));
        age.setMinWidth(50);


        ObservableList<DefaultMember> viewContent = FXCollections.observableArrayList();
        for (DefaultMember member : gymManager.getMembers()) {
            viewContent.add(member);

        }

        tableView.getColumns().addAll(membership_id, name, membership_type, date, school, age);


        tableView.setItems(viewContent);
        tableView.setLayoutX(150);
        tableView.setLayoutY(100);


        tableView.setPrefSize(730, 400);
        FilteredList<DefaultMember> datalist = new FilteredList<>(viewContent, b -> true);  // getting all records in observable list into filtered arraylist
        txtsearch.textProperty().addListener((observable, oldValue, newValue) -> {
            datalist.setPredicate(member -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                String lowercase = newValue.toLowerCase();
                if (member.getName().toLowerCase().indexOf(lowercase) != -1) {
                    return true;                                                        //searching for records using mambership number or name
//                } else if (member.getMembershipNo().indexOf(lowercase) != -1) {
//                    return true;
                } else return false;
            });
        });
        SortedList<DefaultMember> sortlist = new SortedList<>(datalist);  //converting record in filtered list to sorted list
        sortlist.comparatorProperty().bind(tableView.comparatorProperty());
        tableView.setItems(sortlist);





        Pane pane=new Pane();
        pane.setId("pane");
        pane.getChildren().addAll(tableView,lbl,img,txtsearch);

        Scene scene=new Scene(pane);
        scene.getStylesheets().addAll(this.getClass().getResource("stylesheet.css").toExternalForm());
        stage.setScene(scene);
        primaryStage.setTitle("Football League Manager");
        primaryStage.setScene(scene);
        primaryStage.setMinWidth(1000);
        primaryStage.setMinHeight(680);
        primaryStage.setMaxWidth(1000);
        primaryStage.setMaxHeight(680);
        primaryStage.show();

        }
        }
