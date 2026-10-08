/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bibliotecajdbc;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.ArrayList;
/**
 *
 * @author alan
 */
public class DAOLivro {
    public static void adicionar(Livro livro) throws SQLException
    {
    try(Connection conexao= Conexao.conectar())
    {
        String sql="INSERT INTO livro (titulo, autor, ano) VALUES (?, ?, ?)";
    PreparedStatement comando= conexao.prepareStatement(sql);
    comando.setString(1, livro.getTitulo());
    comando.setString(2, livro.getAutor());
    comando.setInt(3, livro.getAno());
    comando.executeUpdate();
    System.out.println("Bem sucedido!");
    }
    catch(Exception e)
    {
    e.printStackTrace();
    }
    }
    public static List<Livro> listar() throws SQLException
    {
    try(Connection conexao=Conexao.conectar())
    {
        String sql="SELECT * FROM livro";
    PreparedStatement comando = conexao.prepareStatement(sql);
        ResultSet resultado = comando.executeQuery();
    ArrayList<Livro> livros= new ArrayList<>();
    while(resultado.next())
    {
    Livro livro = new Livro();

livro.setId(resultado.getInt("id"));
livro.setTitulo(resultado.getString("titulo"));
livro.setAutor(resultado.getString("autor"));
livro.setAno(resultado.getInt("ano"));

livros.add(livro);
    }
    return livros;
    }
    }
    
}
