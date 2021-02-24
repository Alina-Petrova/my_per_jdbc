/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.solo1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author tss
 */
public class CreateNewTable {

    private String create_query;

    CreateNewTable(String q) {

        create_query =q;
        
        try {            
            Connection con = DriverManager.getConnection(App_creative.DB_URL, App_creative.DB_USR, App_creative.DB_PWD);
            Statement st = con.createStatement();
            st.executeUpdate(create_query);
            con.close();
            st.close();            
        } catch (SQLException ex) {
            Logger.getLogger(CreateNewTable.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
}
