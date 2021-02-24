/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.solo1;

/**
 *
 * @author tss
 */
public class App_creative {
  
public static final String DB_URL = "jdbc:mariadb://localhost:3306/per_jdbc";
public static final String DB_USR = "tss";
public static final String DB_PWD = "ghiglieno";  
    
    public static void main(String[] args) {

            
        new CreateNewTable("create table if not exists  libri (id_libro int, titolo varchar(50), autore varchar(50), num_pagine int)");
        new CreateNewTable("create table if not exists cibi (id_cibo int, nome varchar(50), peso float, data_scad datetime)");
        
        new Insert_libro("Anna Karenina", "Tolstoy", 350);
        
    }
    
}
