
package view;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Main extends Application {
    static Stage palco;
    
    public static Scene sceneCadCliente;
   public static Scene sceneLista ;
   public static Scene scenePrincipal;
   
  
    @Override
    public void start(Stage stage) throws IOException {
        palco=stage;
        
        Parent root = FXMLLoader.load(getClass().getResource("FXMLMenu.fxml"));       
        Parent cadCliente = FXMLLoader.load(getClass().getResource("FXMLCadCliente2.fxml"));
        Parent listaCliente = FXMLLoader.load(getClass().getResource("FXMLListar.fxml"));
        
         scenePrincipal = new Scene(root, 600, 400);
         sceneCadCliente = new Scene(cadCliente, 600, 400);
         sceneLista = new Scene(listaCliente, 600, 400);
        
         stage.setTitle("Caderno de Contas");
         stage.setScene(scenePrincipal);
         stage.setResizable(false);
         stage.show();
        
            }
     

    public static void main(String[] args) {
        launch(args);
    }
    public static void trocaTela(String op){
        switch(op){
            case "menu":
                 palco.setTitle("Caderno de Contas");
                 palco.setScene(scenePrincipal);
            break;
            case "cadastror":
                 palco.setTitle("Cadastro de Clientes");
                 palco.setScene(sceneCadCliente);
            break;
            case "lista":
                 palco.setTitle("Lista de Clientes");
                 palco.setScene(sceneLista);
            break;
        }
    }
    
}
