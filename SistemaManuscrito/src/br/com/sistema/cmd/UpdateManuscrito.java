package br.com.sistema.cmd;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.swing.JOptionPane;

public class UpdateManuscrito {

	public static void main(String[] args) {
		try {
			//Open up Connection with Database
			Connection conexao = ConnectionFactory.createConnection();
			
			
			//Save the variables the data who are insert in Database
			
			//Import the class of transition with data in SQL
			Manuscrito manuscrito = new Manuscrito();
			
			//Send the data to class Manuscrito
			
			manuscrito.setId(JOptionPane.showInputDialog("Entre com o ID a ser Alterado"));
			manuscrito.setTitulo(JOptionPane.showInputDialog("Entre com o Título do Manuscrito"));
			manuscrito.setAutor(JOptionPane.showInputDialog("Entre com o nome do Autor do Manuscrito"));
			
			//Create the SQL for set data into the database
			String sql = "update manuscrito set titulo = ?, autor = ? where id = ?;";
					
					
					
			//+ "titulo = '" + manuscrito.getTitulo() + "' "
			//+ "autor = '" + manuscrito.getAutor() + "' "
			//+ "where id = '" + manuscrito.getId() + ";";
			//Update manuscrito set titulo = 'manuscrito.getTitulo()' and 
			//autor = 'manuscrito.getAutor()'
			//where where id = 'manuscrito.getId()';
			
			System.out.println(sql);
			
			//Creating a command to pass the SQL
			PreparedStatement cmd = conexao.prepareStatement(sql);
			

			cmd.setString(1, manuscrito.getTitulo());
			cmd.setString(2, manuscrito.getAutor());
			cmd.setString(3, manuscrito.getId());
			
			cmd.executeUpdate();
			
			JOptionPane.showMessageDialog(null, "Dado Atualizado com Sucess");
			
			cmd.close();
				
		} catch (Exception e) {
			e.printStackTrace();
			
			
		}

		
		
		
		
		
		
		
		
		
	}

}
