package br.com.fabricadeprogamador;

import br.com.fabricadeprogamador.persistencia.entidade.Usuario;
import br.com.fabricadeprogamador.persistencia.jdbc.UsuarioDAO;

public class TestUsuarioDAO {

	public static void main(String[] args) {
		// Criando o usuário
		testCadastrar();
	}

	public static void testCadastrar() {
		Usuario usu = new Usuario();
		usu.setNome("Joana");
		usu.setLogin("ddd");
		usu.setSenha("258");

		UsuarioDAO usuDAO = new UsuarioDAO();
		usuDAO.cadastrar(usu);

		System.out.println("Cadastrado com sucesso");

	}
	
	public static void testAlterar() {
		Usuario usu = new Usuario();
		usu.setId(5);
		usu.setNome("Maria");
		usu.setLogin("mane");
		usu.setSenha("222");

		UsuarioDAO usuDAO = new UsuarioDAO();
		usuDAO.alterar(usu);

		System.out.println("Alterado com sucesso");

	}
	
	public static void testExcluir() {
		Usuario usu = new Usuario();
		usu.setId(5);
		
		UsuarioDAO usuDAO = new UsuarioDAO();
		usuDAO.excluir(usu);

		System.out.println("Excluido com sucesso");

	}
	
}