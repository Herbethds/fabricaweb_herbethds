package br.com.fabricadeprogamador.persistencia.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.fabricadeprogamador.persistencia.entidade.Usuario;

public class UsuarioDAO {
	private Connection con = ConexaoFactory.getConnection();

	public void cadastrar(Usuario usu) {
		String sql = "insert into usuario (nome, login, senha) values (?, ?, ?)";
		// Caso não queira usar o .close pode usar essa sintaxe try
		// (PreparedStatement preparador = con.prepa...(sql)){}
		try {
			PreparedStatement preparador = con.prepareStatement(sql);
			preparador.setString(1, usu.getNome()); // Substitui o ? pelo dado
													// do usuário.
			preparador.setString(2, usu.getLogin());
			preparador.setString(3, usu.getSenha());

			preparador.execute(); // Executando o comando sql no banco.
			preparador.close(); // Fechando o objeto preparador.
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void alterar(Usuario usu) {
		String sql = "update usuario set nome=?, login=?, senha=? where id=?";

		try {
			PreparedStatement preparador = con.prepareStatement(sql);
			preparador.setString(1, usu.getNome()); // Substitui o ? pelo dado do usuário.
			preparador.setString(2, usu.getLogin());
			preparador.setString(3, usu.getSenha());
			preparador.setInt(4, usu.getId());

			preparador.execute(); // Executando o comando sql no banco.
			preparador.close(); // Fechando o objeto preparador.
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}

	}

	public void excluir(Usuario usu) {
		String sql = "delete from usuario where id=?";

		try {
			PreparedStatement preparador = con.prepareStatement(sql);
			preparador.setInt(1, usu.getId());

			preparador.execute(); // Executando o comando sql no banco.
			preparador.close(); // Fechando o objeto preparador.
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}

		
	}

}