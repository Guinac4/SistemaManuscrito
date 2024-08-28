package br.com.sistema.cmd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

public class SelectManuscrito {

	public static void main(String[] args) {
		try {
			Connection conexao = ConnectionFactory.createConnection();
			
			//Create the SQL to Extract data
			String sql = "select * from manuscrito";
			
			//Creating the command
			PreparedStatement cmd = conexao.prepareStatement(sql);
			
			//Executing the command
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
