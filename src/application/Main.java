package application;
	
import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application {
	
	//cria stage,scene e arquivo staticos para manipulacao no controlador
	public static Stage stage;
	public static Scene cenaTelaInicial;
	public static Scene vendas;
	public static Scene historico;
	public static Scene estoque;
	public static Scene adicionar;
	public static Scene adicionarAoEstoque;
  

	@Override
	public void start(Stage primaryStage) throws IOException {
		
		Pane telaInicial = FXMLLoader.load(getClass().getResource("TelaInicial.fxml"));
		Pane telaEstoque = FXMLLoader.load(getClass().getResource("Estoque.fxml"));
		Pane telaHistorico = FXMLLoader.load(getClass().getResource("Historico.fxml"));
		Pane telaVendas = FXMLLoader.load(getClass().getResource("Vendas.fxml"));
		Pane telaAdicionar =  FXMLLoader.load(getClass().getResource("TelaAdicionarTipo.fxml")); 
		Pane telaAdicionarAoEstoque = FXMLLoader.load(getClass().getResource("AdicionarAoEstoque.fxml"));
		cenaTelaInicial = new Scene(telaInicial);
		vendas = new Scene(telaVendas);
		historico = new Scene(telaHistorico);
		estoque = new Scene(telaEstoque);
		adicionar = new Scene(telaAdicionar);
		adicionarAoEstoque = new Scene(telaAdicionarAoEstoque);
		stage = primaryStage;
		stage.setTitle("Aphrodite");
		stage.setScene(cenaTelaInicial);
		stage.setResizable(false);
		stage.show();
		stage.getIcons().add(new Image(getClass().getResourceAsStream("/images/icone.png")));
	}

	public static void main(String[] args) {
		launch(args);
	}
}
