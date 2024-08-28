package br.com.sistema.cmd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;



public class SelectItemManuscrito {

	public static void main(String[] args) {
		try {
			//Open up Connection with Database
			Connection conexao = ConnectionFactory.createConnection();
			
		
			//Create variable to searches register in the database
			String id;
			
			
			//ID will Receive the Value typed by the user
			id = JOptionPane.showInputDialog("Digite o ID do Manuscrito: ");
			
			//Create the SQL to extract the data from Database
			String sql;
			
			sql = "select * from manuscrito where id = " + id + ";";
			
			//Under Line to do the text in Database
			//System.out.println(sql);
			
			//Prepare to receive the data
			PreparedStatement cmd = conexao.prepareStatement(sql);
			
			//Execute Command
			ResultSet resultado = cmd.executeQuery();
			
			//Create variable 
			String manuscritos;
			manuscritos = "<<Manuscritos Encontrados>>\n";
			while(resultado.next()) {
				manuscritos += " - ID: " + resultado.getInt("id")
				+ "\n - Titulo: " + resultado.getString("titulo")
				+ "\n - Autor: " + resultado.getString("autor")
				+ "\n";	
			}
			
			JOptionPane.showMessageDialog(null, manuscritos);
			conexao.close();
			
		} catch (Exception e) {
			e.printStackTrace();
			
			
			
			
			
		}

	}

}
