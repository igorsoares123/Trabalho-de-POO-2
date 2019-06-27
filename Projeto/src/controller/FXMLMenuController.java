package controller;

import javafx.fxml.FXML;
import javafx.scene.control.MenuItem;
import view.Main;

public class FXMLMenuController{
    
  
   @FXML
    private MenuItem menuItemListaClientes;

    @FXML
    private MenuItem menuItemCadCliente;
    
     @FXML
    void cadastrar() {
        Main.trocaTela("cadastror");
    }

    @FXML
    void listar() {
        Main.trocaTela("lista");
    }
    
}
