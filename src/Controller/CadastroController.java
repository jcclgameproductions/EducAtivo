/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.event.*;
import com.jfoenix.controls.JFXButton;
import Model.Dao.UserDAO;
import Model.Bean.User;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author jcfla
 */
public class CadastroController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    @FXML
    public JFXTextField tuser;
    @FXML
    public JFXPasswordField tsenha;
    @FXML
    public JFXButton btn_cad;
    private Stage stage;
    
    public UserDAO usd = new UserDAO();
    public User us = new User();
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
    }    
    public void clickcad(ActionEvent e) {
        String p = tuser.getText();
        String c = tsenha.getText();
        //int ps;
        //ps = Integer.parseInt(c);

        us.setCdsenha(c);
        us.setNmuser(p);
        usd.create(us);
    }
}
