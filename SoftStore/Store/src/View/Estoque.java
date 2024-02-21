package View;

import Conexao.conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Ledilson
 */
public class Estoque extends javax.swing.JInternalFrame {

    public Estoque() {
        initComponents();
        carregaTabela();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tbEstoque = new javax.swing.JTable();

        setClosable(true);

        tbEstoque.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Descrição", "Quantidade", "Preço"
            }
        ));
        jScrollPane1.setViewportView(tbEstoque);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 695, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 372, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 26, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
 private void tamanhoTabela() {
        //Defini o tamanho da tabela
        tbEstoque.getColumnModel().getColumn(0).setPreferredWidth(100);
        tbEstoque.getColumnModel().getColumn(1).setPreferredWidth(200);
    }

    private void carregaTabela() {
        DefaultTableModel modelo = (DefaultTableModel) tbEstoque.getModel();
        modelo.setNumRows(0);

        tamanhoTabela();
        // Configurar a tabela como não editável
        tbEstoque.setDefaultEditor(Object.class, null);

        try {
            Connection con = conexao.getConnection();
            PreparedStatement pstm;
            ResultSet rs;

            pstm = con.prepareCall("SELECT id, datahora, descricao,quantidade,precounitario,porcentagem,precovenda From cadastroproduto;");
            rs = pstm.executeQuery();

            NumberFormat currencyPrecoVenda = NumberFormat.getCurrencyInstance();

            while (rs.next()) {

                modelo.addRow(new Object[]{
                    rs.getString("descricao"),
                    rs.getString("quantidade"),
                    currencyPrecoVenda.format(rs.getDouble("precovenda")),});
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao carregar a tabela de dados: " + e, "ERRO", JOptionPane.ERROR_MESSAGE);

        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbEstoque;
    // End of variables declaration//GEN-END:variables
}
