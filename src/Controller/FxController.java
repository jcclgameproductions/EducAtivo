package Controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.event.*;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import com.jfoenix.controls.JFXButton;
import Model.Dao.UserDAO;
import Model.Bean.User;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javax.swing.JOptionPane;

public class FxController implements Initializable {

    @FXML
    public TextField usertf;
    @FXML
    public PasswordField passpf;
    @FXML
    public JFXButton btnlg;
    @FXML
    public JFXButton btncd;
    private Stage stage;
              

    public UserDAO usd = new UserDAO();
    public User us = new User();

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    public void btncd(ActionEvent e) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/View//Cadastro.fxml"));
       
       stage = (Stage)((Node)e.getSource()).getScene().getWindow();
       Scene scene = new Scene(root);
       //stage.initStyle(StageStyle.UNDECORATED);
       stage.setResizable(true);
       stage.setScene(scene);
       stage.show();
    }

    public void btnlg(ActionEvent e) throws IOException {
        try {
            String p = usertf.getText();
            String c = passpf.getText();

            us.setCdsenha(c);
            us.setNmuser(p);
            ResultSet rslt = usd.autUser(us);

            if (rslt.next()) {
                JOptionPane.showMessageDialog(null, "Conexão estabelecida");
             
       Parent root = FXMLLoader.load(getClass().getResource("/View//sistema.fxml"));
       
       stage = (Stage)((Node)e.getSource()).getScene().getWindow();
       Scene scene = new Scene(root);
       //stage.initStyle(StageStyle.UNDECORATED);
       stage.setResizable(true);
       stage.setScene(scene);
       stage.show();

            } else {
                JOptionPane.showMessageDialog(null, "Nome ou senha invalidos" + rslt);
            }
        } catch (SQLException ex) {
            Logger.getLogger(FxController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
