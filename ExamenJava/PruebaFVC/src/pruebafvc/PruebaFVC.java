/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebafvc;

import java.util.Optional;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author oscarmelo
 */
public class PruebaFVC extends Application {
    
    Controller controller = null;
    
    @Override
    public void start(Stage primaryStage) {
        
        
        Button btn = new Button();
        btn.setText("Calcular IMC");
        HBox boxNombre = new HBox();
        Label labelNombre = new Label("Nombre: ");
        labelNombre.setMinWidth(90);
        TextField textNombre = new TextField();
        boxNombre.getChildren().addAll(labelNombre,textNombre);
        boxNombre.setAlignment(Pos.CENTER);
        
        HBox boxEdad = new HBox();
        Label labelEdad = new Label("Edad: ");
        labelEdad.setMinWidth(90);
        TextField textEdad = new TextField();
        boxEdad.getChildren().addAll(labelEdad,textEdad);
        boxEdad.setAlignment(Pos.CENTER);
        
        HBox boxSexo = new HBox();
        Label labelSexo = new Label("Sexo (H o F): ");
        labelSexo.setMinWidth(90);
        TextField textSexo = new TextField();
        boxSexo.getChildren().addAll(labelSexo,textSexo);
        boxSexo.setAlignment(Pos.CENTER);
        
        HBox boxPeso = new HBox();
        Label labelPeso = new Label("Peso (Kg): ");
        labelPeso.setMinWidth(90);
        TextField textPeso = new TextField();
        boxPeso.getChildren().addAll(labelPeso,textPeso);
        boxPeso.setAlignment(Pos.CENTER);
        
        HBox boxAltura = new HBox();
        Label labelAltura = new Label("Altura (m): ");
        labelAltura.setMinWidth(90);
        TextField textAltura = new TextField();
        boxAltura.getChildren().addAll(labelAltura,textAltura);
        boxAltura.setAlignment(Pos.CENTER);
        
        
        VBox boxPrincipal = new VBox();
        boxPrincipal.getChildren().addAll(boxNombre,boxEdad,boxSexo,boxPeso,boxAltura,btn);
        boxPrincipal.setSpacing(5);
        boxPrincipal.setAlignment(Pos.CENTER);
        
        controller = new Controller(textNombre, textEdad, textSexo, textPeso, textAltura, btn);
        controller.crearAcciones();
        
        
        StackPane root = new StackPane();
        root.getChildren().add(boxPrincipal);
        
        Scene scene = new Scene(root, 300, 250);
        
        primaryStage.setTitle("Calculadora IMC");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
        
    }
    

    
}
