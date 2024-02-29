package testes;

import connection.ConexaoBD;
import connection.ConnectionFactory;

public class TesteConexao {

public static void main(String[] args) {
		
		ConexaoBD conecta = new ConexaoBD();
		conecta.conexao();
		
	}
}
