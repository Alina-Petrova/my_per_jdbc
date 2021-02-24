/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.solo1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author tss
 */
public class App {
    
    private static final String DB_URL = "jdbc:mariadb://localhost:3306/argomenti_opinioni";
    private static final String DB_USR = "tss";
    private static final String DB_PWD = "ghiglieno";
    private static final String SQL_QUERY = "select u.nome, u.cognome, a.titolo_arg, c.commento from utenti u join commenti c on u.id_utenti=c.id_user "
            + "join argomenti a on a.id_arg=c.id_arg";
    
    public static void main(String[] args) {
        try (
             Connection cn = DriverManager
                        .getConnection(App.DB_URL, App.DB_USR, App.DB_PWD);       
            Statement cmd = cn.createStatement();
            ResultSet rs = cmd.executeQuery(SQL_QUERY);
       ){ 
            while (rs.next()) {
                System.out.println(String.format("nome: %s, cognome: %s, argomento: %s \n commento: %s\n",
                rs.getString("u.nome"), rs.getString("u.cognome"), rs.getString("a.titolo_arg"), rs.getString("c.commento")));
                    }  
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }    
}
