package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.Cliente;

public class ClienteDAO {
    Connection con = null;
    public ClienteDAO(){
        con = ConexaoFx.getConnection();
    }
    
    public List<Cliente> pesquisarAll(){
        Connection con = ConexaoFx.getConnection();
        List<Cliente> lista = new ArrayList<>();
        try {            
            PreparedStatement ps = con.prepareStatement("SELECT * FROM anot");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Cliente cliente = new Cliente();
                cliente.setNome(rs.getString("cliente"));
                cliente.setTel(rs.getString("telefone"));
                cliente.setEndereço(rs.getString("endereco"));
                cliente.setCasa(rs.getInt("residencia"));
                lista.add(cliente);                
            }
            return lista;
        } catch (Exception e) {
        }
        return null;
    }
    
    public void pesquisar(int numero){}
   
    public String salvar(Cliente cliente){
   Connection con = ConexaoFx.getConnection();
        try {
            String sql = "INSERT INTO anot(cliente, telefone, endereco, residencia) VALUES (?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, cliente.getNome());
            ps.setString(2, cliente.getTel());
            ps.setInt(3, cliente.getCasa());
            ps.setString(4, cliente.getEndereço());
         if(ps.executeUpdate() != 0){
                return "Cadastrado com sucesso";
            }else{
                return "Erro ao cadastrar";
            }
        } catch (Exception e) {
            return "Deu erro";
        }
    }
    
     public boolean excluir(int casa){
        try {
            String sql = "DELETE FROM anot WHERE endereco = '"+casa+"'";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.execute();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
     
     public void editar(Cliente cliente){
        try {
            String sql = "UPDATE anot SET cliente = ?, telefone = ?, residencia = ? WHERE endereco = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, cliente.getNome());
            ps.setString(2, cliente.getTel());
            ps.setInt(3, cliente.getCasa());
             ps.setString(4, cliente.getEndereço());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
 }  
