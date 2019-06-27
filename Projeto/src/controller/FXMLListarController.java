
package controller;

import dao.ClienteDAO;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.Cliente;
import view.Main;


public class FXMLListarController implements Initializable {
    @FXML private TableColumn<Cliente, String> colNome;
    @FXML private TableColumn<Cliente, String> colTel;
    @FXML private TableView<Cliente> tabela;
    @FXML private TableColumn<Cliente, Integer> colCasa;
    @FXML private TableColumn<Cliente, String> colEndereço;
    ClienteDAO dao = new ClienteDAO();

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }  
     @FXML
    public void excluir(){        
        Cliente cliente = new Cliente();
        cliente = tabela.getSelectionModel().getSelectedItem();        
        if(cliente != null){            
            if(dao.excluir(cliente.getCasa())){
                Alert alert = new Alert(Alert.AlertType.WARNING);            
                alert.setTitle("Cliente excluído");
                alert.setHeaderText("Exclusão de Clientes");
                alert.setContentText("Dados excluidos com sucesso");
                alert.showAndWait();
                mostrarTabela();
            }else{
                System.out.println("Erro ao excluir");
            }                             
        }else{
            Alert alert = new Alert(Alert.AlertType.WARNING);            
            alert.setTitle("Exclusão");
            alert.setHeaderText("Cabeçalho do alerta");
            alert.setContentText("Selecione o cliente que você deseja excluir");
            alert.show();
        }        
    }

    public void VisualizarTabela(){
        colNome.setCellValueFactory(new PropertyValueFactory<>("cliente"));
        colTel.setCellValueFactory(new PropertyValueFactory<>("telefone"));
        colCasa.setCellValueFactory(new PropertyValueFactory<>("endereco"));   
        colEndereço.setCellValueFactory(new PropertyValueFactory<>("residencia"));   
        tabela.setItems(listaClientes());
    }
    public ObservableList<Cliente> listaClientes(){
        List<Cliente> lista =  dao.pesquisarAll();
        return FXCollections.observableArrayList(lista);        
    }
    
    @FXML
    public void alterar() throws IOException{
        Cliente cliente = tabela.getSelectionModel().getSelectedItem();
        if(cliente != null){
            boolean buttonConfirmaClick = showTela(cliente);
            if(buttonConfirmaClick){                
                dao.editar(cliente);
                mostrarTabela();
            }            
        }else{
            Alert alert = new Alert(Alert.AlertType.WARNING);            
            alert.setTitle("Alterar Cliente");
            alert.setHeaderText("Cabeçalho do alerta");
            alert.setContentText("Selecione o cliente que você deseja alterar");
            alert.show();
        }           
    }

    private boolean showTela(Cliente cliente)throws IOException{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(FXMLEditClienteController.class.getResource("/view/FXMLEditCliente.fxml"));
        AnchorPane pagina = (AnchorPane) loader.load();        
        Stage dialogStage = new Stage();
        dialogStage.setTitle("Atualizar Cliente");
        Scene scener = new Scene(pagina);
        dialogStage.setScene(scener);
        
        FXMLEditClienteController alterarController = loader.getController();
        alterarController.setStage(dialogStage);
        alterarController.setCliente(cliente);
        dialogStage.showAndWait();
        return alterarController.isBtnSalvar();
    }
    
    public void voltar(){
        Main.trocaTela("menu");
    }

    private void mostrarTabela() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    

}

    
    
