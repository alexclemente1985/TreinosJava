package br.com.treinaweb.agenda.repositorios.interfaces;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public interface AgendaRepositorio<T> {
	
	List<T> selecionar() throws SQLException, FileNotFoundException, IOException;
	void inserir(T entidade) throws IOException, SQLException;
	void atualizar(T entidade) throws IOException, SQLException;
	void excluir(T entidade) throws IOException, SQLException;
	
}
