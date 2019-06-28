package br.com.treinaweb.agenda.repositorio.impl;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.treinaweb.agenda.entidades.Contato;
import br.com.treinaweb.agenda.factories.JDBCConnectionFactory;
import br.com.treinaweb.agenda.repositorios.interfaces.AgendaRepositorio;

public class ContatoRepositorioJdbc implements AgendaRepositorio<Contato> {

	@Override
	public List<Contato> selecionar() throws SQLException, IOException {
		// Connection connection = null;

		List<Contato> contatos = new ArrayList<Contato>();

		// para versões mais antigas do java, existia a obrigação de forçar o processo
		// de carga dos drivers com o método abaixo (jdbc <= 4)
		// Class.forName("com.mysql.jdbc.Driver");

		// try {
		// try-with-resouces: possui close() implícito
		/// REGRA DE USO: somente utilizado se o recurso implementar direta ou
		// indiretamente o método close()
		try (Connection connection = JDBCConnectionFactory.createConnection()) {
			// Conexão com o data volume container Docker que possui o MySQL rodando
			// DRIVER:BANCO://HOST:PORTA/DATABASE
			// connection =
			// DriverManager.getConnection("jdbc:mysql://192.168.99.100:3307/agenda",
			// "root", "password");

			// Properties props = new Properties();

			// ponteiro para o arquivo com as propriedades / getClass -> retorna o ambiente
			// de execução do momento da instância

			/*
			 * InputStream is =
			 * this.getClass().getClassLoader().getResourceAsStream("application.properties"
			 * );
			 * 
			 * if (is == null) { throw new
			 * FileNotFoundException("O arquivo de configuração do banco de dados não foi encontrado."
			 * ); }
			 * 
			 * props.load(is); connection =
			 * DriverManager.getConnection(props.getProperty("urlConnection"),
			 * props.getProperty("userConnection"), props.getProperty("password"));
			 */
			// Statement: permite a conexão com o banco de dados (permite disparar comando
			// sql)

			// connection = JDBCConnectionFactory.createConnection();

			Statement command = connection.createStatement();

			// ResultSet: permite capturar o resultado da query executada
			ResultSet rs = command.executeQuery("select * from contatos");

			while (rs.next()) {
				Contato contato = new Contato();
				// Sobrecarga do método getInt que permite obter o valor inteiro a partir do
				// nome da coluna
				contato.setId(rs.getInt("id"));
				contato.setIdade(rs.getInt("idade"));
				contato.setNome(rs.getString("nome"));
				contato.setTelefone(rs.getString("telefone"));

				contatos.add(contato);
			}

		}
		/*
		 * finally { if (connection != null) { connection.close(); }
		 * 
		 * }
		 */
		return contatos;
	}

	@Override
	public void inserir(Contato entidade) throws IOException, SQLException {
		Connection connection = null;

		try {
			connection = JDBCConnectionFactory.createConnection();
			PreparedStatement command = connection
					.prepareStatement("insert into contatos(nome,idade,telefone) values(?,?,?)");
			command.setString(1, entidade.getNome());
			command.setInt(2, entidade.getIdade());
			command.setString(3, entidade.getTelefone());

			command.execute();

		} finally {
			if (connection != null) {
				connection.close();
			}
		}

	}

	@Override
	public void atualizar(Contato entidade) throws IOException, SQLException{
		try (Connection conexao = JDBCConnectionFactory.createConnection()){
			PreparedStatement comando = conexao.prepareStatement("update contatos set nome=?,idade=?,telefone=? where id=?");
			comando.setString(1, entidade.getNome());
			comando.setInt(2, entidade.getIdade());
			comando.setString(3, entidade.getTelefone());
			comando.setInt(4, entidade.getId());
			
			comando.execute();
		}

	}

	@Override
	public void excluir(Contato entidade) throws IOException, SQLException{
		try(Connection conexao = JDBCConnectionFactory.createConnection()){
				PreparedStatement comando = conexao.prepareStatement("delete from contatos where id=?");
				comando.setInt(1, entidade.getId());
				comando.execute();
		}
	}

}
