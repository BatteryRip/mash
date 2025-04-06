package com.example.demo1;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class General {
    public static void page(String fxmlString, int v, int v1, String title) {
        FXMLLoader mpFxmlLoader = new FXMLLoader(General.class.getResource(fxmlString));
        Scene mpScene = null;
        try {
            mpScene = new Scene(mpFxmlLoader.load(), v, v1);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Stage mpStage = new Stage();
        mpStage.setTitle(title);
        mpStage.setResizable(false);
        mpStage.setScene(mpScene);
        mpStage.show();
    }
}
