package br.com.sistema.cmd;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.swing.JOptionPane;

public class DeleteManuscrito {

	public static void main(String[] args) {
		try {
			
			//Open up Connection with Database
			Connection conexao = ConnectionFactory.createConnection();
			JOptionPane.showMessageDialog(null, "Conexão aberta com Sucesso");
			
			
			Manuscrito manuscrito = new Manuscrito();
			
			manuscrito.setId(JOptionPane.showInputDialog("Entre com o ID"));

			//Create the SQL for delete data from database
			String sql = "delete from manuscrito where id = ?;";
			
			System.out.println(sql);
			
			
			//Creating a command to pass the SQL
			PreparedStatement cmd = conexao.prepareStatement(sql);
			
			
			cmd.setString(1, manuscrito.getId());
			cmd.execute();
			
			JOptionPane.showMessageDialog(null, "Registro Deletado com Sucesso");
			
			
			
			
			
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
			
			
			
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		

	}

}
