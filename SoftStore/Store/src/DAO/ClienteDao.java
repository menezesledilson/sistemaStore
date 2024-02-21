package dao;
 
import Conexao.conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.Cliente;

/**
 *
 * @author Ledilson
 */
public class ClienteDao {

    public void create(Cliente cliente) {

        Connection con = conexao.getConnection();
        PreparedStatement pstm = null;

        try {
            pstm = con.prepareStatement("INSERT INTO cadastrocliente(nome,cel)values (?,?);");
            pstm.setString(1, cliente.getNome());
            pstm.setString(2, cliente.getCelular());

            pstm.execute();
            JOptionPane.showMessageDialog(null, "Adicionado com sucesso.", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao adicionar no banco.", "Erro", JOptionPane.ERROR_MESSAGE);
        } finally {
            conexao.closeConnection(con, pstm);
        }
    }

    public void update(Cliente cliente) {

        Connection con = conexao.getConnection();
        PreparedStatement pstm = null;
        try {
            pstm = con.prepareStatement("UPDATE cadastrocliente SET nome = ?, cel = ?  WHERE id = ?;");
            pstm.setString(1, cliente.getNome());
            pstm.setString(2, cliente.getCelular());
            pstm.setLong(3, cliente.getId());

            pstm.executeUpdate();
            JOptionPane.showMessageDialog(null, "Atualizado com sucesso.", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao alterar" + e, "Erro", JOptionPane.ERROR_MESSAGE);
        } finally {
            conexao.closeConnection(con, pstm);
        }
    }

    public void delete(Cliente cliente) {
        Connection con = conexao.getConnection();
        PreparedStatement pstm = null;
        try {

            pstm = con.prepareStatement("DELETE FROM cadastrocliente WHERE id = ?");
            pstm.setLong(1, cliente.getId());
            pstm.executeUpdate();
            JOptionPane.showMessageDialog(null, "Removido com sucesso.", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, "Erro ao Remover:" + e, "Erro", JOptionPane.ERROR_MESSAGE);
        } finally {
            conexao.closeConnection(con, pstm);
        }
    }

    public List<Cliente> listarCliente() {
        List<Cliente> listaCliente = new ArrayList<>();
        Connection con = conexao.getConnection();

        PreparedStatement pstm = null;
        ResultSet rs = null;

        try {
            pstm = con.prepareStatement("SELECT id, nome, cel From cadastrocliente;");
            rs = pstm.executeQuery();
            while (rs.next()) {
                Cliente listaClientes = new Cliente();
                
                listaClientes.setId(rs.getLong("id"));
                listaClientes.setNome(rs.getString("nome"));
                listaClientes.setCelular(rs.getString("cel"));

                listaCliente.add(listaClientes);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao listar dados: " + e, "EERRO", JOptionPane.ERROR_MESSAGE);
        } finally {
            conexao.closeConnection(con, pstm, rs);
        }

        return listaCliente;
    }
}
