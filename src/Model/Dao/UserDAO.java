/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Dao;

import Connection.ConnectionFactory;
import Model.Bean.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class UserDAO {
    public void create(User us){
     Connection con = ConnectionFactory.getConnection();
     PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("INSERT INTO tb_user (nm_user, cd_senha)VALUES(?,?)");
            stmt.setString(1,us.getNmuser());
            stmt.setString(2,us.getCdsenha());
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro"+ex);
        }finally{
        ConnectionFactory.closeConnection(con, stmt);     
        }
      
}
public ResultSet autUser(User us){
     Connection con = ConnectionFactory.getConnection();
     PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("SELECT * FROM tb_user WHERE nm_user = ? AND cd_senha = ?");
            stmt.setString(1,us.getNmuser());
            stmt.setString(2,us.getCdsenha());
            
           ResultSet rslt = stmt.executeQuery();            
           return rslt;
           
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro" +ex);
            ConnectionFactory.closeConnection(con, stmt);
            return null;
        }//finally{
        //ConnectionFactory.closeConnection(con, stmt);     
        //}
      
}

}
