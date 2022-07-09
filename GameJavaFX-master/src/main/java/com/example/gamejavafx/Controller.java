package com.example.gamejavafx;

import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.paint.Color;
import javafx.util.Duration;

import java.io.IOException;
import java.util.*;

public class Controller {

    private javafx.stage.Stage stage;
    private Scene scene;
    private Parent root;
    private int buttonClick = 0;
    public ArrayList<Integer> list = new ArrayList<Integer>(Arrays.asList(0,0,0,0,0,0,0,0,0));
    public ArrayList<Integer> listOfGenerated = new ArrayList<Integer>(Arrays.asList(0,0,0,0,0,0,0,0,0));
    public ArrayList<Integer> list2 = new ArrayList<Integer>(Arrays.asList(0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0));
    public ArrayList<Integer> listOfGenerated2 = new ArrayList<Integer>(Arrays.asList(0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0));
    public ArrayList<Integer> elements = new ArrayList<Integer>();
    public ArrayList<Integer> result = new ArrayList<Integer>();

    public ArrayList<Button> buttons;

    @FXML
    private Button button;
    @FXML
    private Button button1;
    @FXML
    private Button button2;
    @FXML
    private Button button3;
    @FXML
    private Button button4;
    @FXML
    private Button button5;
    @FXML
    private Button button6;
    @FXML
    private Button button7;
    @FXML
    private Button button8;
    @FXML
    private Button button9;
    @FXML
    private Button button99;
    @FXML
    private Button button10;
    @FXML
    private Button button11;
    @FXML
    private Button button12;
    @FXML
    private Button button13;
    @FXML
    private Button button14;
    @FXML
    private Button button15;
    @FXML
    private Button button16;



    public void startGame(ActionEvent e) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("Stage1.fxml"));
        stage = (javafx.stage.Stage)((Node)e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();


    }
    public void clickButton(ActionEvent e) {
        String buttonName = (e.getSource().toString()).replaceAll("\\D+","");
        System.out.println("numer przycisku: " +  buttonName);
        button = (Button) e.getSource();
        System.out.println("licznik przed: " + buttonClick);
        buttonClick = list.get(Integer.parseInt(buttonName)-1);
        System.out.println("WZIECIE 1: " + buttonClick);
        buttonClick += 1;
        System.out.println("WZIECIE 2: " + buttonClick);
        buttonClick = buttonClick % 2;
        System.out.println("licznik po: " + buttonClick);
        list.set(Integer.parseInt(buttonName)-1,buttonClick);
        System.out.println("----------");


        if (list.get(Integer.parseInt(buttonName)-1) == 0) {
            button.setBackground(Background.fill(Color.WHITE));
        } else {
            button.setBackground(Background.fill(Color.GREY));
        }

    }
    //////////////////////////////////////////////////////////////////////////////////////////////////
    //////////////////////////////////////////ROUND 1/////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////////////////////////////
    public void start1() throws InterruptedException {

        for (int i = 0; i < 9; i++) {
            elements.add(i);
        }
        Collections.shuffle(elements);
        for (int i = 0; i < 3; i++) {
            result.add(elements.get(i));
        }
        System.out.println(result);
        buttons = new ArrayList<Button>();
        buttons.add(button1);
        buttons.add(button2);
        buttons.add(button3);
        buttons.add(button4);
        buttons.add(button5);
        buttons.add(button6);
        buttons.add(button7);
        buttons.add(button8);
        buttons.add(button9);
        System.out.println(buttons);

        for (int i = 0; i < result.size(); i++) {
            buttons.get(result.get(i)).setBackground(Background.fill(Color.GRAY));
            listOfGenerated.set(result.get(i), 1);
        }
        PauseTransition pause = new PauseTransition(
                Duration.seconds(2));
        pause.setOnFinished(event -> {
            for (int i = 0; i < result.size(); i++) {
                buttons.get(result.get(i)).setBackground(Background.fill(Color.LIGHTGRAY));
            }
        });
        pause.play();
    }
    public void check1(ActionEvent e) throws InterruptedException, IOException {
        System.out.println(list);
        System.out.println(listOfGenerated);
        if (list.equals(listOfGenerated)){
            for(int i=0; i < result.size(); i++){
                buttons.get(result.get(i)).setBackground(Background.fill(Color.GREEN));
                listOfGenerated.set(result.get(i),1);
            }
            button99.setDisable(false);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setContentText("Congratulations!!!\n You can start next level!");
            alert.showAndWait();
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Stage2.fxml")));
            stage = (javafx.stage.Stage)((Node)e.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

        }
        else{
            for(int i=0; i < result.size(); i++){
                buttons.get(result.get(i)).setBackground(Background.fill(Color.RED));
                listOfGenerated.set(result.get(i),1);
            }
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setContentText("Unfortunately you made mistake! Try one more time!");
            alert.showAndWait();

            PauseTransition pause = new PauseTransition(
                    Duration.seconds(3));
            pause.setOnFinished(event -> {
                Parent root = null;
                try {
                    root = FXMLLoader.load(getClass().getResource("StartScene.fxml"));
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                stage = (javafx.stage.Stage)((Node)e.getSource()).getScene().getWindow();
                scene = new Scene(root);
                stage.setScene(scene);

                stage.show();
            });
            pause.play();



        }
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////
    //////////////////////////////////////////ROUND 2/////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////////////////////////////
    public void start2() throws InterruptedException {

        for (int i = 0; i < 9; i++) {
            elements.add(i);
        }
        Collections.shuffle(elements);
        for (int i = 0; i < 4; i++) {
            result.add(elements.get(i));
        }
        System.out.println(result);
        buttons = new ArrayList<Button>();
        buttons.add(button1);
        buttons.add(button2);
        buttons.add(button3);
        buttons.add(button4);
        buttons.add(button5);
        buttons.add(button6);
        buttons.add(button7);
        buttons.add(button8);
        buttons.add(button9);
        System.out.println(buttons);

        for (int i = 0; i < result.size(); i++) {
            buttons.get(result.get(i)).setBackground(Background.fill(Color.GRAY));
            listOfGenerated.set(result.get(i), 1);
        }
        PauseTransition pause = new PauseTransition(
                Duration.seconds(2));
        pause.setOnFinished(event -> {
            for (int i = 0; i < result.size(); i++) {
                buttons.get(result.get(i)).setBackground(Background.fill(Color.LIGHTGRAY));
            }
        });
        pause.play();
    }
    public void check2(ActionEvent e) throws InterruptedException, IOException {
        System.out.println(list);
        System.out.println(listOfGenerated);
        if (list.equals(listOfGenerated)){
            for(int i=0; i < result.size(); i++){
                buttons.get(result.get(i)).setBackground(Background.fill(Color.GREEN));
                listOfGenerated.set(result.get(i),1);
            }
            button99.setDisable(false);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setContentText("Congratulations!!!\n You can start next level!");
            alert.showAndWait();
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Stage3.fxml")));
            stage = (javafx.stage.Stage)((Node)e.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

        }
        else{
            for(int i=0; i < result.size(); i++){
                buttons.get(result.get(i)).setBackground(Background.fill(Color.RED));
                listOfGenerated.set(result.get(i),1);
            }
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setContentText("Unfortunately you made mistake! Try one more time!");
            alert.showAndWait();

            PauseTransition pause = new PauseTransition(
                    Duration.seconds(3));
            pause.setOnFinished(event -> {
                Parent root = null;
                try {
                    root = FXMLLoader.load(getClass().getResource("StartScene.fxml"));
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                stage = (javafx.stage.Stage)((Node)e.getSource()).getScene().getWindow();
                scene = new Scene(root);
                stage.setScene(scene);

                stage.show();
            });
            pause.play();



        }
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////
    //////////////////////////////////////////ROUND 3/////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////////////////////////////
    public void start3() throws InterruptedException {

        for (int i = 0; i < 16; i++) {
            elements.add(i);
        }
        Collections.shuffle(elements);
        for (int i = 0; i < 5; i++) {
            result.add(elements.get(i));
        }
        System.out.println(result);
        buttons = new ArrayList<Button>();
        buttons.add(button1);
        buttons.add(button2);
        buttons.add(button3);
        buttons.add(button4);
        buttons.add(button5);
        buttons.add(button6);
        buttons.add(button7);
        buttons.add(button8);
        buttons.add(button9);
        buttons.add(button10);
        buttons.add(button11);
        buttons.add(button12);
        buttons.add(button13);
        buttons.add(button14);
        buttons.add(button15);
        buttons.add(button16);
        System.out.println(buttons);

        for (int i = 0; i < result.size(); i++) {
            buttons.get(result.get(i)).setBackground(Background.fill(Color.GRAY));
            listOfGenerated2.set(result.get(i), 1);
        }
        PauseTransition pause = new PauseTransition(
                Duration.seconds(2));
        pause.setOnFinished(event -> {
            for (int i = 0; i < result.size(); i++) {
                buttons.get(result.get(i)).setBackground(Background.fill(Color.LIGHTGRAY));
            }
        });
        pause.play();
    }
    public void check3(ActionEvent e) throws InterruptedException, IOException {
        System.out.println(list);
        System.out.println(listOfGenerated);
        if (list2.equals(listOfGenerated)){
            for(int i=0; i < result.size(); i++){
                buttons.get(result.get(i)).setBackground(Background.fill(Color.GREEN));
                listOfGenerated2.set(result.get(i),1);
            }
            button99.setDisable(false);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setContentText("Congratulations!!!\n You can start next level!");
            alert.showAndWait();
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Stage4.fxml")));
            stage = (javafx.stage.Stage)((Node)e.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

        }
        else{
            for(int i=0; i < result.size(); i++){
                buttons.get(result.get(i)).setBackground(Background.fill(Color.RED));
                listOfGenerated2.set(result.get(i),1);
            }
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setContentText("Unfortunately you made mistake! Try one more time!");
            alert.showAndWait();

            PauseTransition pause = new PauseTransition(
                    Duration.seconds(3));
            pause.setOnFinished(event -> {
                Parent root = null;
                try {
                    root = FXMLLoader.load(getClass().getResource("StartScene.fxml"));
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                stage = (javafx.stage.Stage)((Node)e.getSource()).getScene().getWindow();
                scene = new Scene(root);
                stage.setScene(scene);

                stage.show();
            });
            pause.play();



        }
    }
}

