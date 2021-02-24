/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.solo1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author tss
 */
public class Insert_libro {
    private String titolo;
    private String autore;
    private int num_pagine;

    public Insert_libro(String titolo, String autore, int num_pagine) {
        try {
            /*this.titolo = titolo;
            this.autore = autore;
            this.num_pagine = num_pagine;*/
            Connection con = DriverManager 
                    .getConnection(App_creative.DB_URL, App_creative.DB_USR, App_creative.DB_PWD);
            Statement st = con.createStatement();
            PreparedStatement insert = con.prepareStatement("insert into libri (titolo, autore, num_pagine)values (?, ?, ?)");
            insert.setString(1, titolo);
            insert.setString(2, autore);
            insert.setInt(3, num_pagine);
            insert.executeUpdate();
            con.close();
            st.close();            
        } catch (SQLException ex) {
            Logger.getLogger(Insert_libro.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
    
    
    
    
}
