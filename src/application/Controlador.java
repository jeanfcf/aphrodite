package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Scanner;

import Aphrodite.Peca;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class Controlador implements Initializable {

	private static boolean flagIniciar;

	private CurrencyField cur = new CurrencyField(new Locale("pt", "BR"));
	private CurrencyField cur1 = new CurrencyField(new Locale("pt", "BR"));

	private File arquivo2 = new File("historico.txt");
	private File arquivo3 = new File("estoque.txt");
	private File arquivo4 = new File("modelos.txt");
	private File arquivo5 = new File("cores.txt");
	private File arquivo6 = new File("tamanhos.txt");

	private static ObservableList<Peca> obsPecas;

	@FXML
	private AnchorPane telaInicial;

	@FXML
	private AnchorPane telaVendas = new AnchorPane();

	@FXML
	private AnchorPane telaAdicionarTipo;

	@FXML
	private AnchorPane telaHistorico;

	@FXML
	private AnchorPane telaEstoque;

	@FXML
	private AnchorPane telaAdicionarAoEstoque = new AnchorPane();

	@FXML
	private ScrollPane scrollPaneHistorico;

	@FXML
	private ListView<Peca> listHistorico = new ListView<>();

	@FXML
	private Button btnVendas;

	@FXML
	private Button btnHistorico;

	@FXML
	private Button btnEstoque;

	@FXML
	private Button btnCancelarVendas;

	@FXML
	private Button btnVender;

	@FXML
	private Button btnAdicionarTipoConfirma;

	@FXML
	private Button btnCancelarAdicionarTipo;

	@FXML
	private Button btnVoltar;

	@FXML
	private Button btnAdicionarAoEstoque;

	@FXML
	private Button btnAdicionarTipo;

	@FXML
	private Button btnAdicionarAoEstoqueConfirma;

	@FXML
	private Button btnCancelarAdicionarAoEstoque;

	@FXML
	private Button btnIniciar;

	@FXML
	private Button btnAdicionarLabelEstoque;

	@FXML
	private Button btnDiminuirLabelEstoque;

	@FXML
	private ComboBox<Peca> cbModeloVendas;

	@FXML
	private ComboBox<Peca> cbTamanhoVendas;

	@FXML
	private ComboBox<Peca> cbCorVendas;

	@FXML
	private ComboBox<Peca> cbModeloAdicionarAoEstoque;

	@FXML
	private ComboBox<Peca> cbTamanhoAdicionarAoEstoque;

	@FXML
	private ComboBox<Peca> cbCorAdicionarAoEstoque;

	@FXML
	private DatePicker dateVendas = new DatePicker();

	@FXML
	private DatePicker dateAdicionarAoEstoque = new DatePicker();

	@FXML
	private TextField txtAdicionar;

	@FXML
	private MenuButton menuEscolha;

	@FXML
	private MenuItem menuCor;

	@FXML
	private MenuItem menuTamanho;

	@FXML
	private MenuItem menuModelo;

	@FXML
	private Label lblPrecoVendas;

	@FXML
	private Label lblPrecoAdicionarAoEstoque;

	@FXML
	private Label lblQuantidadeEstoqueTitulo;

	@FXML
	private Label lblQuantidadeEstoque;

	@FXML
	private Label lblQuantidadeVendasTitulo;

	@FXML
	private Button btnAdicionarLabelVendas;

	@FXML
	private Button btnDiminuirLabelVendas;

	@FXML
	private Label lblQuantidadeVendas;

	@FXML
	private Button btnAtualizar;

	@FXML
	private Button btnAtualizarEstoque;

	@FXML
	private ListView<Peca> listEstoque = new ListView<>();
	
    @FXML
    private Label lblSaldo;
// criei botao de atualizar pois nao sei atualizar em tempo real 
	@FXML
	void aBtAtualizarEstoque(ActionEvent event) throws IOException {
		leEstoque();
	}

	@FXML
	void aBtAtualizar(ActionEvent event) throws IOException, ParseException {
		leHistorico();
	}

	@FXML
	void aBtEstoque(ActionEvent event) throws IOException {
		if (!arquivo2.exists()) {
			arquivo2.createNewFile();
		}
		if (!arquivo3.exists()) {
			arquivo3.createNewFile();
		}
		if (!arquivo4.exists()) {
			arquivo4.createNewFile();
		}
		if (!arquivo5.exists()) {
			arquivo5.createNewFile();
		}
		if (!arquivo6.exists()) {
			arquivo6.createNewFile();
		}
		Main.stage.setScene(Main.estoque);
		flagIniciar = false;
	}

	@FXML
	void aBtHistorico(ActionEvent event) throws IOException {
		if (!arquivo2.exists()) {
			arquivo2.createNewFile();
		}
		if (!arquivo3.exists()) {
			arquivo3.createNewFile();
		}
		if (!arquivo4.exists()) {
			arquivo4.createNewFile();
		}
		if (!arquivo5.exists()) {
			arquivo5.createNewFile();
		}
		if (!arquivo6.exists()) {
			arquivo6.createNewFile();
		}

		Main.stage.setScene(Main.historico);
	}

	@FXML
	void aBtVendas(ActionEvent event) throws IOException {

		// Usando esta property você pode ver as mudanças no valor do textfield

		if (!arquivo2.exists()) {
			arquivo2.createNewFile();
		}
		if (!arquivo3.exists()) {
			arquivo3.createNewFile();
		}
		if (!arquivo4.exists()) {
			arquivo4.createNewFile();
		}
		if (!arquivo5.exists()) {
			arquivo5.createNewFile();
		}
		if (!arquivo6.exists()) {
			arquivo6.createNewFile();
		}
		flagIniciar = true;
		Main.stage.setScene(Main.vendas);
	}
// criei botao iniciar porque nao sabia carregar o combo box ao entrar na tela
	@FXML
	void aBtIniciar(ActionEvent event) throws IOException {
		if (flagIniciar) {
			btnIniciar.setVisible(false);
			cbTamanhoVendas.setVisible(true);
			cbModeloVendas.setVisible(true);
			cbCorVendas.setVisible(true);
			dateVendas.setVisible(true);
			btnCancelarVendas.setVisible(true);
			btnVender.setVisible(true);
			lblPrecoVendas.setVisible(true);
			lblQuantidadeVendas.setVisible(true);
			lblQuantidadeVendasTitulo.setVisible(true);
			btnAdicionarLabelVendas.setVisible(true);
			btnDiminuirLabelVendas.setVisible(true);
			cur.setVisible(true);
			leArquivo("tamanhos.txt", 1);
			leArquivo("modelos.txt", 3);
			leArquivo("cores.txt", 5);

		} else {
			btnIniciar.setVisible(false);
			cbTamanhoAdicionarAoEstoque.setVisible(true);
			cbModeloAdicionarAoEstoque.setVisible(true);
			cbCorAdicionarAoEstoque.setVisible(true);
			dateAdicionarAoEstoque.setVisible(true);
			btnCancelarAdicionarAoEstoque.setVisible(true);
			btnAdicionarAoEstoqueConfirma.setVisible(true);
			lblPrecoAdicionarAoEstoque.setVisible(true);
			lblQuantidadeEstoque.setVisible(true);
			lblQuantidadeEstoqueTitulo.setVisible(true);
			btnAdicionarLabelEstoque.setVisible(true);
			btnDiminuirLabelEstoque.setVisible(true);
			cur1.setVisible(true);
			leArquivo("tamanhos.txt", 2);
			leArquivo("modelos.txt", 4);
			leArquivo("cores.txt", 6);
		}
	}

	@FXML
	void aBtCancelarVendas(ActionEvent event) {
		btnIniciar.setVisible(true);
		cbTamanhoVendas.setVisible(false);
		cbModeloVendas.setVisible(false);
		cbCorVendas.setVisible(false);
		dateVendas.setVisible(false);
		btnCancelarVendas.setVisible(false);
		btnVender.setVisible(false);
		lblPrecoVendas.setVisible(false);
		lblQuantidadeVendas.setVisible(false);
		lblQuantidadeVendasTitulo.setVisible(false);
		btnAdicionarLabelVendas.setVisible(false);
		btnDiminuirLabelVendas.setVisible(false);
		lblQuantidadeVendas.setText("1");
		cur.setVisible(false);
		cur.setText("R$ 0,00");
		dateVendas.setValue(LocalDate.now());
		obsPecas.clear();
		Main.stage.setScene(Main.cenaTelaInicial);
	}

	@FXML
	void aBtVender(ActionEvent event) throws IOException {
		LocalDate ld = dateVendas.getValue();
		try {

			for (int i = 0; i < Integer.parseInt(lblQuantidadeVendas.getText()); i++) {

				if (verificaEstoque(cbModeloVendas.getValue().toString(), cbTamanhoVendas.getValue().toString(),
						cbCorVendas.getValue().toString())) {
					retiraEstoque(arquivo3,cbModeloVendas.getValue().toString(), cbTamanhoVendas.getValue().toString(),
							cbCorVendas.getValue().toString());
					salvar(arquivo2,
							"\n" + "Vendeu do estoque:      " + cbModeloVendas.getValue() + " "
									+ cbTamanhoVendas.getValue() + " " + cbCorVendas.getValue() + " +*" + cur.getText()
									+ " " + ld.toString());
				} else {
					Alert dialogoInfo = new Alert(Alert.AlertType.INFORMATION);

					dialogoInfo.setTitle("Erro!");
					dialogoInfo.setHeaderText("Esta peca nao existe mais no seu estoque.");
					dialogoInfo.setContentText("Pecas vendidas com sucesso: " + i);
					dialogoInfo.showAndWait();

					if (!dialogoInfo.isShowing()) {
						btnIniciar.setVisible(true);
						cbTamanhoVendas.setVisible(false);
						cbModeloVendas.setVisible(false);
						cbCorVendas.setVisible(false);
						dateVendas.setVisible(false);
						btnCancelarVendas.setVisible(false);
						btnVender.setVisible(false);
						lblPrecoVendas.setVisible(false);
						lblQuantidadeVendas.setVisible(false);
						lblQuantidadeVendasTitulo.setVisible(false);
						btnAdicionarLabelVendas.setVisible(false);
						btnDiminuirLabelVendas.setVisible(false);
						lblQuantidadeVendas.setText("1");
						cur.setVisible(false);
						cur.setText("R$ 0,00");
						dateVendas.setValue(LocalDate.now());
						obsPecas.clear();
						Main.stage.setScene(Main.cenaTelaInicial);
					}

					return;
				}
			}
			

			Alert dialogoInfo = new Alert(Alert.AlertType.INFORMATION);

			dialogoInfo.setTitle("Sucesso");
			dialogoInfo.setHeaderText("Peca(s) vendida(s)");
			dialogoInfo.setContentText("Feche esta janela.");
			dialogoInfo.showAndWait();
			if (!dialogoInfo.isShowing()) {
				btnIniciar.setVisible(true);
				cbTamanhoVendas.setVisible(false);
				cbModeloVendas.setVisible(false);
				cbCorVendas.setVisible(false);
				dateVendas.setVisible(false);
				btnCancelarVendas.setVisible(false);
				btnVender.setVisible(false);
				lblPrecoVendas.setVisible(false);
				lblQuantidadeVendas.setVisible(false);
				lblQuantidadeVendasTitulo.setVisible(false);
				btnAdicionarLabelVendas.setVisible(false);
				btnDiminuirLabelVendas.setVisible(false);
				lblQuantidadeVendas.setText("1");
				cur.setVisible(false);
				cur.setText("R$ 0,00");
				dateVendas.setValue(LocalDate.now());
				obsPecas.clear();
				Main.stage.setScene(Main.cenaTelaInicial);
			}
		} catch (NullPointerException e) {
			Alert dialogoInfo = new Alert(Alert.AlertType.INFORMATION);

			dialogoInfo.setTitle("Erro!");
			dialogoInfo.setHeaderText("Faltam dados.");
			dialogoInfo.setContentText("Por favor, preencha todos os campos corretamente.");
			dialogoInfo.showAndWait();

		}
	}
	

	@FXML
	void aBtAdicionarAoEstoque(ActionEvent event) {
		Main.stage.setScene(Main.adicionarAoEstoque);
	}

	@FXML
	void aBtAdicionarTipo(ActionEvent event) {
		Main.stage.setScene(Main.adicionar);
	}

	@FXML
	void aBtVoltar(ActionEvent event) {
		Main.stage.setScene(Main.cenaTelaInicial);
	}

	@FXML
	void aMcor(ActionEvent event) {
		menuEscolha.setText("COR");
	}

	@FXML
	void aMmodelo(ActionEvent event) {
		menuEscolha.setText("MODELO");
	}

	@FXML
	void aMtamanho(ActionEvent event) {
		menuEscolha.setText("TAMANHO");
	}

	@FXML
	void aBtAdicionarTipoConfirma(ActionEvent event) throws IOException {
		if (menuEscolha.getText().equals("Escolha") || txtAdicionar.getText().equals("")
				|| txtAdicionar.getText().length() > 10 || !percorreString(txtAdicionar.getText().toLowerCase())) {
			Alert dialogoInfo = new Alert(Alert.AlertType.INFORMATION);

			dialogoInfo.setTitle("Erro!");
			dialogoInfo.setHeaderText("Escolha ou texto não informados corretamente.");
			dialogoInfo.setContentText("Por favor, preencha todos os campos corretamente.");
			dialogoInfo.showAndWait();

		} else if (menuEscolha.getText().equals("COR")) {
			if(!primeiraLinha(arquivo5))
			salvar(arquivo5, "\n" + preencheString(txtAdicionar.getText()));
			else salvar(arquivo5, preencheString(txtAdicionar.getText()));
			menuEscolha.setText("Escolha");
			txtAdicionar.setText("");
			Main.stage.setScene(Main.estoque);

		} else if (menuEscolha.getText().equals("MODELO")) {
			if(!primeiraLinha(arquivo4))
				salvar(arquivo4, "\n" + preencheString(txtAdicionar.getText()));
				else salvar(arquivo4, preencheString(txtAdicionar.getText()));
			txtAdicionar.setText("");
			menuEscolha.setText("Escolha");
			Main.stage.setScene(Main.estoque);
		} else if (menuEscolha.getText().equals("TAMANHO")) {
			if(!primeiraLinha(arquivo6))
				salvar(arquivo6, "\n" + preencheString(txtAdicionar.getText()));
				else salvar(arquivo6, preencheString(txtAdicionar.getText()));
			menuEscolha.setText("Escolha");
			txtAdicionar.setText("");
			Main.stage.setScene(Main.estoque);
		}
	}

	@FXML
	void aBtCancelarAdicionarTipo(ActionEvent event) {
		menuEscolha.setText("Escolha");
		txtAdicionar.setText("");
		Main.stage.setScene(Main.estoque);
	}

	@FXML
	void aBtAdicionarAoEstoqueConfirma(ActionEvent event) throws IOException {

		boolean flag = false;
		for (int i = 0; i < (Integer.parseInt(lblQuantidadeEstoque.getText())); i++) {
			if (cbModeloAdicionarAoEstoque.getValue() == (null) || cbTamanhoAdicionarAoEstoque.getValue() == (null)
					|| cbCorAdicionarAoEstoque.getValue() == (null) || cur1.getText().isEmpty()) {
				Alert dialogoInfo = new Alert(Alert.AlertType.INFORMATION);

				dialogoInfo.setTitle("Erro!");
				dialogoInfo.setHeaderText("Faltam dados.");
				dialogoInfo.setContentText("Por favor, preencha todos os campos corretamente.");
				dialogoInfo.showAndWait();
				break;

			}
			LocalDate ld = dateAdicionarAoEstoque.getValue();
			if(!primeiraLinha(arquivo2)) {
			salvar(arquivo2,
					"\n" + "Comprou para o estoque: " + cbModeloAdicionarAoEstoque.getValue() + " "
							+ cbTamanhoAdicionarAoEstoque.getValue() + " " + cbCorAdicionarAoEstoque.getValue() + " -*"
							+ cur1.getText() + " " + ld.toString());
			}else {
				salvar(arquivo2,
						"Comprou para o estoque: " + cbModeloAdicionarAoEstoque.getValue() + " "
								+ cbTamanhoAdicionarAoEstoque.getValue() + " " + cbCorAdicionarAoEstoque.getValue() + " -*"
								+ cur1.getText() + " " + ld.toString());
			}
			if(!primeiraLinha(arquivo3))
			salvar(arquivo3, "\n" + cbModeloAdicionarAoEstoque.getValue() + " " + cbTamanhoAdicionarAoEstoque.getValue()
					+ " " + cbCorAdicionarAoEstoque.getValue());
			else salvar(arquivo3, cbModeloAdicionarAoEstoque.getValue() + " " + cbTamanhoAdicionarAoEstoque.getValue()
			+ " " + cbCorAdicionarAoEstoque.getValue());
			flag = true;

		}

		if (flag) {
			btnIniciar.setVisible(true);
			cbTamanhoAdicionarAoEstoque.setVisible(false);
			cbModeloAdicionarAoEstoque.setVisible(false);
			cbCorAdicionarAoEstoque.setVisible(false);
			dateAdicionarAoEstoque.setVisible(false);
			btnCancelarAdicionarAoEstoque.setVisible(false);
			btnAdicionarAoEstoqueConfirma.setVisible(false);
			lblPrecoAdicionarAoEstoque.setVisible(false);
			lblQuantidadeEstoque.setVisible(false);
			lblQuantidadeEstoqueTitulo.setVisible(false);
			btnAdicionarLabelEstoque.setVisible(false);
			btnDiminuirLabelEstoque.setVisible(false);
			lblQuantidadeEstoque.setText("1");
			cur1.setVisible(false);
			dateAdicionarAoEstoque.setValue(LocalDate.now());
			cur1.setText("R$ 0,00");
			obsPecas.clear();
			Main.stage.setScene(Main.estoque);
		}

	}

	@FXML
	void aBtCancelarAdicionarAoEstoque(ActionEvent event) {
		btnIniciar.setVisible(true);
		cbTamanhoAdicionarAoEstoque.setVisible(false);
		cbModeloAdicionarAoEstoque.setVisible(false);
		cbCorAdicionarAoEstoque.setVisible(false);
		dateAdicionarAoEstoque.setVisible(false);
		btnCancelarAdicionarAoEstoque.setVisible(false);
		btnAdicionarAoEstoqueConfirma.setVisible(false);
		lblPrecoAdicionarAoEstoque.setVisible(false);
		lblQuantidadeEstoque.setVisible(false);
		lblQuantidadeEstoqueTitulo.setVisible(false);
		btnAdicionarLabelEstoque.setVisible(false);
		btnDiminuirLabelEstoque.setVisible(false);
		lblQuantidadeEstoque.setText("1");
		cur1.setVisible(false);
		dateAdicionarAoEstoque.setValue(LocalDate.now());
		cur1.setText("R$ 0,00");
		obsPecas.clear();

		Main.stage.setScene(Main.estoque);
	}

	@FXML
	void aBtDiminuirLabelEstoque(ActionEvent event) {
		diminuiLabelQuantidade(Integer.parseInt(lblQuantidadeEstoque.getText()), true);
	}

	@FXML
	void aBtAumentarLabelEstoque(ActionEvent event) {
		aumentaLabelQuantidade(Integer.parseInt(lblQuantidadeEstoque.getText()), true);
	}

	@FXML
	void aBtAdicionarLabelVendas(ActionEvent event) {
		aumentaLabelQuantidade(Integer.parseInt(lblQuantidadeVendas.getText()), false);
	}

	@FXML
	void aBtDiminuirLabelVendas(ActionEvent event) {
		diminuiLabelQuantidade(Integer.parseInt(lblQuantidadeVendas.getText()), false);
	}

	public boolean percorreString(String string) {
		for (int i = 0; i < string.length(); i++) {
			if (string.charAt(i) < 97 || string.charAt(i) > 122) {
				return false;
			}
		}
		return true;
	}

	public void salvar(File arquivo, String texto) throws IOException {

		FileWriter fw = new FileWriter(arquivo.getAbsoluteFile(), true);
		BufferedWriter bw = new BufferedWriter(fw);

		bw.write(texto);
		bw.close();

	}
//le o arquivo e volta como e coloca numa obsvervable lista para o combo box
	public void leArquivo(String arquivo, int id) throws IOException {
		String linha;
		ArrayList<Peca> jean = new ArrayList<>();
		FileReader ler = new FileReader(arquivo);
		BufferedReader leitor = new BufferedReader(ler);
		while ((linha = leitor.readLine()) != null) {
			jean.add(new Peca(linha));
		}
		obsPecas = FXCollections.observableArrayList(jean);
		if (id == 1) {
			cbTamanhoVendas.setItems(obsPecas);
		} else if (id == 3) {
			cbModeloVendas.setItems(obsPecas);
		} else if (id == 5) {
			cbCorVendas.setItems(obsPecas);
		} else if (id == 2) {
			cbTamanhoAdicionarAoEstoque.setItems(obsPecas);
		} else if (id == 4) {
			cbModeloAdicionarAoEstoque.setItems(obsPecas);
		} else if (id == 6) {
			cbCorAdicionarAoEstoque.setItems(obsPecas);
		}
		leitor.close();
		ler.close();
	}
// ele le o arquivo porem tira faz a contagem e tira os repetidos para aparecer no estoque
	public void leEstoque() throws IOException {

		String linha;
		ArrayList<Peca> jean = new ArrayList<>();
		List<String> lista   = new ArrayList<>();
		FileReader ler = new FileReader("estoque.txt");
		BufferedReader leitor = new BufferedReader(ler);
		Map<String,Integer> qtde = new HashMap<>();
		while ((linha = leitor.readLine()) != null) {
			lista.add(linha);
			
		}
        for(String item : lista){
            if(qtde.containsKey(item)){ // se existe
                Integer n = qtde.get(item);
                qtde.put(item, n+1); // incrementa
            }else{
                qtde.put(item,1); // senao é 1
            }
        }
        
		for (int i = 0; i < lista.size(); i++) {
			Object a = lista.get(i);

					for (int j = i+1; j < lista.size(); j++) {
						Object b = lista.get(j);
						if (a.equals(b)) {
							lista.remove(j);
							j--;
						}
					}
				}

        int j  = 0;
		for (String string : lista) {
			jean.add(new Peca(string + " quantidade : " + qtde.get(lista.get(j))));
			j++;
		}
		obsPecas = FXCollections.observableArrayList(jean);
		listEstoque.setItems(obsPecas);
		leitor.close();
		ler.close();

	}

// corta a string do historico e soma os precos para formar o saldo	
	public double retiraPreco(List<Peca> pecas) {
		
		ArrayList<Double> jean = new ArrayList<>();
		double soma = 0;
		for (Peca peca : pecas) {
			for (int i = 0; i < 11; i++) {
				peca.setPeca(peca.getPeca().substring(0,peca.getPeca().length()-1));
			}
			peca.setPeca(peca.getPeca()+"*");
		}
		
		for (Peca peca : pecas) {
			String[] a;
			a = peca.getPeca().split("\\*");
			if(a[0].endsWith("-")) {
				peca.setPeca("-"+a[1].substring(3,a[1].length()));
				System.out.println(peca.getPeca());
				peca.setPeca(peca.getPeca().replaceAll("\\.","").replace(",","."));
				System.out.println(peca.getPeca()+"aqui");
//				while( !peca.getPeca().endsWith("0") || !peca.getPeca().endsWith("1") || !peca.getPeca().endsWith("2") || !peca.getPeca().endsWith("3") || !peca.getPeca().endsWith("4") || !peca.getPeca().endsWith("5") || !peca.getPeca().endsWith("6") || !peca.getPeca().endsWith("7") || !peca.getPeca().endsWith("8") || !peca.getPeca().endsWith("8")|| !peca.getPeca().endsWith("9")) {
//					peca.setPeca(peca.getPeca().substring(0,peca.getPeca().length()-1));
//				}
	
			}else {
				peca.setPeca("+"+a[1].substring(3,a[1].length()));
				peca.setPeca(peca.getPeca().replaceAll("\\.","").replace(",","."));
				System.out.println(peca.getPeca()+"aqui");
			}
		}
		

		for (Peca peca : pecas) {
			jean.add(Double.parseDouble(peca.getPeca()));
		}
		
		for (Double double1 : jean) {
			soma+= double1;
		}
		
		return soma;
	}
// corta a string do historico na data e ordena por data
	public List<Peca> ordenaData(List<Peca> historico) throws ParseException {

		ArrayList<Date> jean = new ArrayList<>();
		ArrayList<Peca> joao = new ArrayList<>();
		List<Peca> retorno = new ArrayList<>();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");
		List<String> lista = new ArrayList<>();
		Map<String, Integer> qtde = new HashMap<>();

		for (Peca peca : historico) {
			jean.add(sdf.parse(peca.getPeca().substring(peca.getPeca().length() - 10, peca.getPeca().length())));
		}

		Collections.sort(jean);
		Collections.reverse(jean);

		for (Peca peca : historico) {
			joao.add(new Peca(peca.getPeca()));
		}

		for (Date date : jean) {
			for (int i = 0; i < joao.size(); i++) {

				if (sdf.format(date).equals(joao.get(i).getPeca().substring(joao.get(i).getPeca().length() - 10,
						joao.get(i).getPeca().length()))) {
					retorno.add(new Peca(joao.get(i).getPeca().substring(0, joao.get(i).getPeca().length() - 10)
							+ " Data : " + sdf1.format(sdf.parse(joao.get(i).getPeca()
									.substring(joao.get(i).getPeca().length() - 10, joao.get(i).getPeca().length())))));
					joao.remove(i);
					break;
				}
			}
		}

		for (Peca peca : retorno) {
			lista.add(peca.getPeca());
		}
		for (String item : lista) {
			if (qtde.containsKey(item)) { // se existe
				Integer n = qtde.get(item);
				qtde.put(item, n + 1); // incrementa
			} else {
				qtde.put(item, 1); // senao é 1
			}
		}

		for (int i = 0; i < lista.size(); i++) {
			Object a = lista.get(i);

			for (int j = i + 1; j < lista.size(); j++) {
				Object b = lista.get(j);
				if (a.equals(b)) {
					lista.remove(j);
					j--;
				}
			}
		}
		retorno.clear();
		int j = 0;
		for (String string : lista) {
			retorno.add(new Peca(string + " Quantidade : " + qtde.get(lista.get(j))));
			j++;
		}
		Collections.sort(retorno);
		return retorno;
	}
	
	
	

// le o historico poe em ordem 	
	public void leHistorico() throws IOException, ParseException {
		String linha;
		ArrayList<Peca> jean = new ArrayList<>();
		ArrayList<Peca> jean1 = new ArrayList<>();
		FileReader ler = new FileReader("historico.txt");
		BufferedReader leitor = new BufferedReader(ler);
		DecimalFormat df = new DecimalFormat("#,###.00");
		while ((linha = leitor.readLine()) != null) {
			jean.add(new Peca(linha));
		}
		for (Peca peca : jean) {
			jean1.add(new Peca(peca.getPeca().replace("*","")));
		}
		lblSaldo.setText("Saldo: "+df.format(retiraPreco(jean)));
		obsPecas = FXCollections.observableArrayList(ordenaData(jean1));

		listHistorico.setItems(obsPecas);

		leitor.close();
		ler.close();
	}

	public void aumentaLabelQuantidade(int numero, boolean flag) {
		if (numero == 1000) {
			return;
		}
		if (flag) {
			lblQuantidadeEstoque.setText(Integer.toString(++numero));
		} else {
			lblQuantidadeVendas.setText(Integer.toString(++numero));
		}
	}

	public void diminuiLabelQuantidade(int numero, boolean flag) {
		if (numero == 1) {
			return;
		}
		if (flag) {
			lblQuantidadeEstoque.setText(Integer.toString(--numero));
		} else {
			lblQuantidadeVendas.setText(Integer.toString(--numero));
		}
	}

	public String preencheString(String string) {

		int temp;
		char c = ' ';

		// se a string for menor que o espaco delimitado, ocorre o preenchimento
		if (string.length() <= 10) {
			temp = string.length();
			for (int i = temp; i < 10; i++) {
				string = string + c;
			}
		}

		return string;
	}

	
	public boolean primeiraLinha(File arquivo) throws IOException {
		String linha;
		ArrayList<Peca> jean = new ArrayList<>();
		FileReader ler = new FileReader(arquivo);
		BufferedReader leitor = new BufferedReader(ler);
		while ((linha = leitor.readLine()) != null) {
			jean.add(new Peca(linha));
		}
		
		leitor.close();
		ler.close();
		
		if(jean.size() == 0) {
			return true;
		}else {
			return false;
		}
	}
	
	// peguei o cur da internet e na sua utilizacao precisa colocar no initialize
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		cur.amountProperty().addListener(new ChangeListener<Number>() {

			@Override
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
				System.out.println(newValue.doubleValue());
			}
		});
		cur1.amountProperty().addListener(new ChangeListener<Number>() {

			@Override
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
				System.out.println(newValue.doubleValue());
			}
		});
		cur.setLayoutX(379);
		cur.setLayoutY(326);
		cur.setVisible(false);
		cur1.setLayoutX(379);
		cur1.setLayoutY(326);
		cur1.setVisible(false);
		telaVendas.getChildren().add(cur);
		telaAdicionarAoEstoque.getChildren().add(cur1);
		dateVendas.setValue(LocalDate.now());
		dateAdicionarAoEstoque.setValue(LocalDate.now());
	}
// verifica se tem o produto no estoque
	public boolean verificaEstoque(String modelo, String tamanho, String cor) throws IOException {

		String linha;
		String format = modelo + " " + tamanho + " " + cor;
		FileReader leram = new FileReader("estoque.txt");
		BufferedReader leitora = new BufferedReader(leram);

		while ((linha = leitora.readLine()) != null) {
			if (linha.equals(format)) {
				leram.close();
				leitora.close();
				return true;
			}
		}

		leram.close();
		leitora.close();

		return false;
	}
	public void retiraEstoque(File f,String modelo, String tamanho, String cor) throws IOException {
		
		ArrayList<String> jean = new ArrayList<>();
        File nf = new File("temporario.tmp");
        FileWriter fw = null;
        Scanner s = null;

        try {
            fw = new FileWriter(nf);
            s = new Scanner(f);

            while (s.hasNextLine()) {
            	jean.add(s.nextLine());                
            }
            
            for (int i = 0 ; i<jean.size() ; i++) {
    			if((modelo + " " + tamanho + " " + cor).equals(jean.get(i))) {
    				jean.remove(i);
    				break;
    			}
    		}
    		
            for (int i = 0 ; i<jean.size() ; i++) {
    			if( i == 0) {
    				 try {
    	                    fw.write(jean.get(i));
    	                } catch (IOException e) {
    	                    e.printStackTrace();
    	                }
    			}else {
    				 try {
    	                    fw.write("\n"+jean.get(i));
    	                } catch (IOException e) {
    	                    e.printStackTrace();
    	                }
    			}
    		}
            
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fw.close();
                s.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        f.delete();
        nf.renameTo(f);
}


	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
