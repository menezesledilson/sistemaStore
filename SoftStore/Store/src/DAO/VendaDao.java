package DAO;

import Conexao.conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.Venda;

/**
 *
 * @author Ledilson
 */
public class VendaDao {

    public void adicionar(Venda venda) {
        Connection con = conexao.getConnection();
        PreparedStatement pstm = null;

        try {
            pstm = con.prepareStatement("INSERT INTO vendaproduto(descricao,quantidade,precovenda,total) values (?,?,?,? );");
            pstm.setString(1, venda.getDescricao());
            pstm.setInt(2, venda.getQuantidade());
            pstm.setDouble(3, venda.getPrecoVenda());
            pstm.setDouble(4, venda.getTotal());
            pstm.execute();
            JOptionPane.showMessageDialog(null, "Adicionado com sucesso.", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao adicionar no banco: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        } finally {
            conexao.closeConnection(con, pstm);
        }
    }

    public void alterar(Venda venda) {
        Connection con = conexao.getConnection();
        PreparedStatement pstm = null;
        try {
            pstm = con.prepareStatement("UPDATE  vendaproduto SET descricao = ?, quantidade =?, precovenda =?, total=? WHERE = id ");
            pstm.setString(1, venda.getDescricao());
            pstm.setInt(2, venda.getQuantidade());
            pstm.setDouble(3, venda.getPrecoVenda());
            pstm.setDouble(4, venda.getTotal());
            pstm.setLong(5, venda.getId());

            pstm.executeUpdate();

            JOptionPane.showMessageDialog(null, "Atualizado com sucesso.", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao alterar: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        } finally {
            conexao.closeConnection(con, pstm);
        }
    }

    public void remover(Venda venda) {
        Connection con = conexao.getConnection();
        PreparedStatement pstm = null;
        try {

            pstm = con.prepareStatement("DELETE FROM vendaproduto WHERE id = ?");
            pstm.setLong(1, venda.getId());
            pstm.executeUpdate();
            JOptionPane.showMessageDialog(null, "Removido com sucesso.", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao remover: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        } finally {
            conexao.closeConnection(con, pstm);
        }
    }

    public List<Venda> listarVendas() {
        List<Venda> listaVenda = new ArrayList<>();
        Connection con = conexao.getConnection();
        PreparedStatement pstm = null;
        ResultSet rs = null;
        try {
            pstm = con.prepareStatement("SELECT id, descricao, quantidade,precovenda, total FROM vendaproduto");
            rs = pstm.executeQuery();
            while (rs.next()) {
                Venda listaVendas = new Venda();

                listaVendas.setId(rs.getLong("id"));
                listaVendas.setDescricao(rs.getString("descricao"));
                listaVendas.setQuantidade(rs.getInt("quantidade"));
                listaVendas.setPrecoVenda(rs.getDouble("precovenda"));
                listaVendas.setTotal(rs.getDouble("total"));
                listaVenda.add(listaVendas);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao listar dados: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        } finally {
            conexao.closeConnection(con, pstm, rs);
        }
        return listaVenda;
    }

}
