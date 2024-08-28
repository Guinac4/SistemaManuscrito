package br.com.sistema.cmd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;


public class CreateManuscrito {

	public static void main(String[] args) {
		try {
			
			//CreateManuscrito createmanuscrito = new CreateManuscrito();
			
			
			//Import the class with the database
			Connection conexao = ConnectionFactory.createConnection();	
			//Import the class of transition with data in SQL
			Manuscrito manuscrito = new Manuscrito();
			
			//Send the data to class Manuscrito
			manuscrito.setTitulo(JOptionPane.showInputDialog("Entre com o Título do Manuscrito"));
			manuscrito.setAutor(JOptionPane.showInputDialog("Entre com o nome do Autor do Manuscrito"));
			
			
			//Create the SQL for set data into the database
			String sql = "insert into manuscrito (titulo, autor)" + "values (?,?)";
			

			//Creating a command to pass the SQL
			PreparedStatement cmd = conexao.prepareStatement(sql);
			cmd.setString(1, manuscrito.getTitulo());
			cmd.setString(2, manuscrito.getAutor());
			
			//SQL Command Execution 
			cmd.execute();
			JOptionPane.showMessageDialog(null, "Manuscrito inserido com sucesso");
			cmd.close();
			
			
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Falha na Conexão Dimaizi");
			
		}
		
		
		
		

	}

}
//System.out.print("insert into manuscrito (manuscrito, autor)\" + \"values ('" +manuscrito.getTitulo()+"','"+manuscrito.getAutor()
//JOptionPane.showMessageDialog(null, manuscrito.getTitulo());