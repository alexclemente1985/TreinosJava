package br.com.treinaweb.agenda.fx;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

import br.com.treinaweb.agenda.entidades.Contato;
import br.com.treinaweb.agenda.repositorio.impl.ContatoRepositorio;
import br.com.treinaweb.agenda.repositorio.impl.ContatoRepositorioJdbc;
import br.com.treinaweb.agenda.repositorios.interfaces.AgendaRepositorio;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class MainController implements Initializable {

	@FXML
	private TableView<Contato> tabelaContatos;

	@FXML
	private Button botaoInserir;

	@FXML
	private Button botaoAlterar;

	@FXML
	private Button botaoExcluir;

	@FXML
	private TextField txfNome;

	@FXML
	private TextField txfIdade;

	@FXML
	private TextField txfTelefone;

	@FXML
	private Button botaoSalvar;

	@FXML
	private Button botaoCancelar;

	private Boolean isInsert;

	private Contato contatoSelecionado;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		this.tabelaContatos.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);

		habilitarEdicaoAgenda(false);

		this.tabelaContatos.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Contato>() {

			@Override
			public void changed(ObservableValue<? extends Contato> observable, Contato oldValue, Contato newValue) {
				if (newValue != null) {
					txfNome.setText(newValue.getNome());
					txfIdade.setText(String.valueOf(newValue.getIdade()));
					txfTelefone.setText(newValue.getTelefone());

					contatoSelecionado = newValue;
				}

			}
		});
		carregarTabelaContatos();

	}

	public void botaoInserir_Action() {

		this.isInsert = true;

		this.txfNome.setText("");
		this.txfIdade.setText("");
		this.txfTelefone.setText("");

		habilitarEdicaoAgenda(true);
	}

	public void botaoAlterar_Action() {

		habilitarEdicaoAgenda(true);

		this.isInsert = false;

		this.txfNome.setText(this.contatoSelecionado.getNome());
		this.txfIdade.setText(Integer.toString(this.contatoSelecionado.getIdade()));
		this.txfTelefone.setText(this.contatoSelecionado.getTelefone());

	}

	public void botaoExcluir_Action() throws IOException, SQLException {

		Alert confirmacao = new Alert(AlertType.CONFIRMATION);
		confirmacao.setTitle("Confirmação");
		confirmacao.setHeaderText("Confirmação da exclusão do contato");
		confirmacao.setContentText("Deseja realmente excluir este contato?");

		Optional<ButtonType> resultadoConfirmacao = confirmacao.showAndWait();

		if (resultadoConfirmacao.isPresent() && resultadoConfirmacao.get() == ButtonType.OK) {

			AgendaRepositorio<Contato> repositorioContato = new ContatoRepositorio();

			contatoSelecionado.setNome(txfNome.getText().toString());
			contatoSelecionado.setIdade(Integer.parseInt(txfIdade.getText()));
			contatoSelecionado.setTelefone(txfTelefone.getText().toString());

			repositorioContato.excluir(this.contatoSelecionado);
			carregarTabelaContatos();
			this.tabelaContatos.getSelectionModel().selectFirst();

		}

	}

	public void botaoCancelar_Action() {
		habilitarEdicaoAgenda(false);
		this.tabelaContatos.getSelectionModel().selectFirst();
	}

	public void botaoSalvar_Action() {
		// AgendaRepositorio<Contato> repositorioContato = new ContatoRepositorio();

		try {
			AgendaRepositorio<Contato> repositorioContato = new ContatoRepositorioJdbc();
			Contato contato = new Contato();
			contato.setNome(txfNome.getText());
			contato.setIdade(Integer.parseInt(txfIdade.getText()));
			contato.setTelefone(txfTelefone.getText());

			if (this.isInsert) {
				repositorioContato.inserir(contato);
			} else {
				repositorioContato.atualizar(contato);
			}

			habilitarEdicaoAgenda(false);
			carregarTabelaContatos();
			this.tabelaContatos.getSelectionModel().selectFirst();
		} catch (Exception e) {
			Alert msg = new Alert(AlertType.ERROR);
			msg.setTitle("Erro!");
			msg.setHeaderText("Erro no banco de dados");
			msg.setContentText("Houve um erro ao obter a lista de contatos: " + e.getMessage());
			msg.showAndWait();
		}
	}

	private void carregarTabelaContatos() {
		// AgendaRepositorio<Contato> repositorioContato = new ContatoRepositorio();
		try {
			AgendaRepositorio<Contato> repositorioContato = new ContatoRepositorioJdbc();
			List<Contato> contatos = repositorioContato.selecionar();

			/*
			 * if (contatos.isEmpty()) { Contato contato = new Contato();
			 * contato.setNome("Teste"); contato.setIdade(0); contato.setTelefone("123456");
			 * contatos.add(contato); }
			 */

			ObservableList<Contato> contatosObservableList = FXCollections.observableArrayList(contatos);
			this.tabelaContatos.getItems().setAll(contatosObservableList);
		} catch (Exception e) {
			Alert msg = new Alert(AlertType.ERROR);
			msg.setTitle("Erro!");
			msg.setHeaderText("Erro no banco de dados");
			msg.setContentText("Houve um erro ao obter a lista de contatos: " + e.getMessage());
			msg.showAndWait();
		}
	}

	private void habilitarEdicaoAgenda(Boolean edicaoOk) {

		this.txfNome.setDisable(!edicaoOk);
		this.txfIdade.setDisable(!edicaoOk);
		this.txfTelefone.setDisable(!edicaoOk);
		this.botaoSalvar.setDisable(!edicaoOk);
		this.botaoCancelar.setDisable(!edicaoOk);

		this.botaoInserir.setDisable(edicaoOk);
		this.botaoAlterar.setDisable(edicaoOk);
		this.botaoExcluir.setDisable(edicaoOk);
		this.tabelaContatos.setDisable(edicaoOk);

	}

}
