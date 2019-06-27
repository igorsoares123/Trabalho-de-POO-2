package controller;

import dao.ClienteDAO;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Cliente;
import view.Main;

public class FXMLEditClienteController implements Initializable {
    
    @FXML
    private TextField txtCasa;

    @FXML
    private Button btEnviar;

    @FXML
    private TextField txtTel;

    @FXML
    private TextField txtNome;

    @FXML
    private TextField txtEndereço;

    @FXML
    private Button btCancelar;
     private Stage stage;
    private final boolean btnEnviar;
    Cliente cliente = new Cliente();
    private boolean btnSalvar;

    public FXMLEditClienteController() {
        this.btnEnviar = false;
    }

    @FXML
    void voltar2(ActionEvent event) {
        Main.trocaTela("lista");
    }

    @FXML
    void enviar(ActionEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }  
    
     public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public boolean isBtnSalvar() {
        return btnEnviar;
    }

    public void setBtnSalvar(boolean btnEnviar) {
        this.btnSalvar = btnEnviar;
    }
    @FXML
    void handleSalvar() {        
         ClienteDAO dao = new ClienteDAO();
        Cliente cliente = new Cliente();
        cliente.setNome(txtNome.getText());
        cliente.setTel(txtTel.getText());
        cliente.setCasa(Integer.parseInt(txtCasa.getText()));
        cliente.setEndereço(txtEndereço.getText());       
        boolean btnAtualizar = true;
        stage.close();
        
    }

    @FXML
    void handleCancelar() {
        stage.close();
    }
    
    public void setAluno(Cliente cliente){
        this.cliente = cliente;
        txtNome.setText(String.valueOf(cliente.getNome()));
        txtTel.setText(String.valueOf(cliente.getTel()));
        txtCasa.setText(String.valueOf(cliente.getCasa()));
        txtEndereço.setText(String.valueOf(cliente.getEndereço()));
     
    }

    void setCliente(Cliente cliente) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
