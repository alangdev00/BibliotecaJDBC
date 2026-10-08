/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.bibliotecajdbc;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;

public class BibliotecaJDBC {

    public static void main(String[] args) throws SQLException{
    
        try(Connection conexao= Conexao.conectar())
        {
            
            
            System.out.println("Deu certo");
          
            String sql = "INSERT INTO livro (titulo, autor, ano) VALUES (?, ?, ?)";
            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setString(1, "Silmarillion");
            comando.setString(2, "J.R.R Tolkien");
            comando.setInt(3, 1977);
            comando.executeUpdate();
            
            ResultSet resultado = comando.executeQuery("SELECT * FROM livro");
            while(resultado.next())
            {
            int id = resultado.getInt("id");
            String titulo = resultado.getString("titulo");
            String autor = resultado.getString("autor");
            int ano = resultado.getInt("ano");
                System.out.println("Id: "+id+"| Titulo: "+ titulo+ "| Autor: "+autor+"| Ano: "+ano);
            }
            
            
        }
        
    }
    }
