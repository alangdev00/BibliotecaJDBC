/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.bibliotecajdbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
/**
 *
 * @author alan
 */
public class BibliotecaJDBC {

    public static void main(String[] args) throws SQLException {
        try(Connection conexao = Conexao.conectar())
        {
            System.out.println("Conectado");
            String sql = "SELECT * FROM livro";

            Statement comando = conexao.createStatement();

            ResultSet resultado = comando.executeQuery(sql);

            while (resultado.next()) {

                int id = resultado.getInt("id");
                String titulo = resultado.getString("titulo");
                String autor = resultado.getString("autor");
                int ano = resultado.getInt("ano");

                System.out.println(
                        id + " | " +
                        titulo + " | " +
                        autor + " | " +
                        ano
                );
            }
        }
        catch(SQLException e)
        {
            System.out.println("Erro ao conectar:");
            e.printStackTrace();
        }
    }
}
