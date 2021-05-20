/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebafvc;

import java.util.Optional;
import java.util.function.UnaryOperator;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.control.TextFormatter.Change;
import javafx.util.converter.IntegerStringConverter;

/**
 *
 * @author oscarmelo
 */
public class Controller {
    
    private Persona persona = null;
    private TextField textNombre;
    private TextField textEdad;
    private TextField textSexo;
    private TextField textPeso;
    private TextField textAltura;
    private Button btn;

    
    public Controller(TextField textNombre
                     ,TextField textEdad
                     ,TextField textSexo
                     ,TextField textPeso
                     ,TextField textAltura
                     ,Button btn){
        this.textAltura = textAltura;
        this.textEdad = textEdad;
        this.textNombre = textNombre;
        this.textPeso = textPeso;
        this.textSexo = textSexo;
        this.btn = btn;
    }
    
    public void crearAcciones(){
        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                persona = new Persona(textNombre.getText(), Integer.parseInt(textEdad.getText()), null, textSexo.getText().charAt(0), Integer.parseInt(textPeso.getText()), Float.parseFloat(textAltura.getText()));
                if(persona.comprobarSexo()){
                    generarAlerta("Datos IMC",generarResultado(),Alert.AlertType.INFORMATION,0);
                }else{
                    generarAlerta("Error en datos","El sexo debe ser H o M",Alert.AlertType.ERROR,1);
                }
            }
        });
    }
    
    public String generarResultado(){
        return "Nombre: "+persona.getNombre()+ "\n" +
                                     "Edad: "+ persona.getEdad() +", "+ generarTextoEdad() +"\n"+
                                     "Sexo: "+ generarTextoSexo() +"\n"+
                                     "Peso(kg): " + persona.getPeso() +"\n"+
                                     "Altura(m): " + persona.getAltura() + "\n"+
                                     "NSS: "+ persona.getNSS()+"\n"+
                                     "IMC: "+ determinarIMC();
    }
    
    public String generarTextoEdad(){
        String textoEdad = "Menor de edad";
        if(persona.esMayorEdad()){
            textoEdad = "Mayor de edad";
        }
        return textoEdad;
    }
    
    public String generarTextoSexo(){
        String textoSexo = "Mujer";
        if(persona.getSexo()=='H'){
                    textoSexo = "Hombre";
        }
        return textoSexo;
    }
    
    public String determinarIMC(){
        String textoIMC = "";
        int imc = persona.calcularIMC();
        if(imc<0){
            textoIMC = "Falta de peso";
        }else if(imc==0){
            textoIMC = "Peso normal";
        }else if(imc>0){
            textoIMC = "Sobrepeso";
        }
        return textoIMC;
    }
    
    public void generarAlerta(String titulo, String texto, Alert.AlertType tipo, int accion){
        Alert alert = new Alert(tipo);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(texto);
        Optional<ButtonType> result = alert.showAndWait();
        ButtonType button = result.orElse(ButtonType.CANCEL);
        if (button == ButtonType.OK) {
            if(accion==1){
                textSexo.requestFocus();
            }else{
                limpiarFormulario();
            }
        } else {
            if(accion==1){
                textSexo.requestFocus();
            }else{
                limpiarFormulario();
            }
        }
    }
    
    public void limpiarFormulario(){
        textNombre.setText("");
        textAltura.setText("");
        textEdad.setText("");
        textPeso.setText("");
        textSexo.setText("");
        textNombre.requestFocus();
    }
    
}
