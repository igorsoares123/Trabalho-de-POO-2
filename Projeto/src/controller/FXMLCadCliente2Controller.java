package controller;

import dao.ClienteDAO;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import model.Cliente;
import view.Main;

public class FXMLCadCliente2Controller implements Initializable {
    
    @FXML
    private TextField txtNome;

    @FXML
    private TextField txtTel;
    
    @FXML
    private TextField txtCasa;

    @FXML
    private TextField txtEndereço;

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }   
    
   public void salvar(ActionEvent event) {
       ClienteDAO dao = new ClienteDAO();
        Cliente cliente = new Cliente();
        cliente.setNome(txtNome.getText());
        cliente.setTel(txtTel.getText());
        cliente.setCasa(Integer.parseInt(txtCasa.getText()));
        cliente.setEndereço(txtEndereço.getText());
              
         Alert alert = new Alert(Alert.AlertType.INFORMATION);
         alert.setHeaderText("Cadastro de Cliente");
         alert.setContentText(dao.salvar(cliente));
         alert.show();
         Main.trocaTela("menu");
    }
     public void limpaCampos(){
        txtNome.setText("");
        txtTel.setText("");
        txtCasa.setText("");
        txtEndereço.setText("");
    }
}
