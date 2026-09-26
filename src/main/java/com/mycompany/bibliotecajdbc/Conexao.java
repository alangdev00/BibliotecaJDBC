/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bibliotecajdbc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author alan
 */
public class Conexao {
    public static final String URL =  "jdbc:mysql://127.0.0.1:3306/biblioteca";
    public static final String USUARIO= "root";
    public static final String SENHA= "Senha";

    public static Connection conectar() throws SQLException
    {
    return DriverManager.getConnection(URL, USUARIO, SENHA);
    }
}
