package application;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

public class ViewController implements Initializable{

    @FXML
    private JFXTextField felhasznalonev;

    @FXML
    private JFXPasswordField jelszo;
    
    @FXML
    private JFXCheckBox checked;

    @FXML
    void belepes(ActionEvent event) {
    	System.out.println("Felhasználónév: " + felhasznalonev.getText());
    	System.out.println("Jelszó: " + jelszo.getText());
    	System.out.println("Bejelentkezve marad? : " + ((checked.isSelected()) ? "Igen" : "Nem"));
    }

	@Override
	public void initialize(URL url, ResourceBundle rb) {

		
	}

}
