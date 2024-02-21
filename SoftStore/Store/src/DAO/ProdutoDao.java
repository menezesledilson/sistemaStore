package  dao;
 
import Conexao.conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.Produto;

public class ProdutoDao {

    public void adicionar(Produto produto) {

        Connection con = conexao.getConnection();
        PreparedStatement pstm = null;

        try {
            pstm = con.prepareStatement("INSERT INTO cadastroproduto(descricao, quantidade, precounitario, porcentagem, precovenda) VALUES (?, ?, ?, ?, ?)");
            pstm.setString(1, produto.getDescricao());
            pstm.setInt(2, produto.getQuantidade());
            pstm.setDouble(3, produto.getPrecoUnitario());
            pstm.setDouble(4, produto.getPorcentagem());
            pstm.setDouble(5, produto.getPrecoVenda());

            pstm.execute();
            JOptionPane.showMessageDialog(null, "Adicionado com sucesso.", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao adicionar no banco: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        } finally {
            conexao.closeConnection(con, pstm);
        }
    }

    public void alterar(Produto produto) {

        Connection con = conexao.getConnection();
        PreparedStatement pstm = null;
        try {

            pstm = con.prepareStatement("UPDATE cadastroproduto SET descricao = ?, quantidade = ?, precounitario = ?, porcentagem = ?, precovenda = ? WHERE id = ?");
            pstm.setString(1, produto.getDescricao());
            pstm.setInt(2, produto.getQuantidade());
            pstm.setDouble(3, produto.getPrecoUnitario());
            pstm.setDouble(4, produto.getPorcentagem());
            pstm.setDouble(5, produto.getPrecoVenda());
            pstm.setLong(6, produto.getId());

            pstm.executeUpdate();
            JOptionPane.showMessageDialog(null, "Atualizado com sucesso.", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao alterar: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        } finally {
            conexao.closeConnection(con, pstm);
        }
    }

    public void remover(Produto produto) {
        Connection con = conexao.getConnection();
        PreparedStatement pstm = null;
        try {

            pstm = con.prepareStatement("DELETE FROM cadastroproduto WHERE id = ?");
            pstm.setLong(1, produto.getId());
            pstm.executeUpdate();
            JOptionPane.showMessageDialog(null, "Removido com sucesso.", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao remover: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        } finally {
            conexao.closeConnection(con, pstm);
        }
    }

    public List<Produto> listarProduto() {
        List<Produto> listaProduto = new ArrayList<>();
        Connection con = conexao.getConnection();

        PreparedStatement pstm = null;
        ResultSet rs = null;

        try {
            pstm = con.prepareStatement("SELECT id, descricao, quantidade, precounitario, porcentagem, precovenda FROM cadastroproduto");
            rs = pstm.executeQuery();
            while (rs.next()) {
                Produto listaProdutos = new Produto();

                listaProdutos.setId(rs.getLong("id"));
                listaProdutos.setDescricao(rs.getString("descricao"));
                listaProdutos.setQuantidade(rs.getInt("quantidade"));
                listaProdutos.setPrecoUnitario(rs.getDouble("precounitario"));
                listaProdutos.setPorcentagem(rs.getDouble("porcentagem"));
                listaProdutos.setPrecoVenda(rs.getDouble("precovenda"));
                listaProduto.add(listaProdutos);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao listar dados: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        } finally {
            conexao.closeConnection(con, pstm, rs);
        }

        return listaProduto;
    }
}
