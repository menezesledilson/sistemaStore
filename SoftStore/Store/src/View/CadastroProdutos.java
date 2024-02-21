package View;

import Conexao.conexao;
import dao.ProdutoDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Cliente;
import model.Produto;

public class CadastroProdutos extends javax.swing.JInternalFrame {

    public CadastroProdutos() {
        initComponents();
        carregaTabela();
        desativarCampos();
        desativarBotao();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btNovo = new javax.swing.JButton();
        btGravar = new javax.swing.JButton();
        btAlterar = new javax.swing.JButton();
        btDelete = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbProduto = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtDescricao = new javax.swing.JTextField();
        txtQtd = new javax.swing.JTextField();
        txtPrecoUnitario = new javax.swing.JTextField();
        txtVenda = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtPorcento = new javax.swing.JTextField();

        setClosable(true);

        btNovo.setText("Novo");
        btNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btNovoActionPerformed(evt);
            }
        });

        btGravar.setText("Gravar");
        btGravar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btGravarActionPerformed(evt);
            }
        });

        btAlterar.setText("Alterar");
        btAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAlterarActionPerformed(evt);
            }
        });

        btDelete.setText("Delete");
        btDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btDeleteActionPerformed(evt);
            }
        });

        tbProduto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Data hora", "Descrição", "Qtd", "Preço unitário", "Porcentagem", "Preço venda"
            }
        ));
        tbProduto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbProdutoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbProduto);

        jLabel1.setText("Descrição.:");

        jLabel2.setText("Qtd.:");

        jLabel3.setText("Preço unitário.:");

        jLabel4.setText("Preço venda.:");

        txtDescricao.setText(" ");

        jLabel5.setText("Porcento.:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btNovo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btGravar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btAlterar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btDelete))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtQtd, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(txtPrecoUnitario, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtPorcento, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(67, Short.MAX_VALUE))
            .addComponent(jScrollPane1)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btNovo)
                    .addComponent(btGravar)
                    .addComponent(btAlterar)
                    .addComponent(btDelete))
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(txtQtd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(txtPrecoUnitario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(txtVenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(txtPorcento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 312, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
private void desativarCampos() {
        txtDescricao.setEnabled(false);
        txtPorcento.setEnabled(false);
        txtPrecoUnitario.setEnabled(false);
        txtQtd.setEnabled(false);
        txtVenda.setEnabled(false);
    }

    private void ativarCampos() {
        txtDescricao.setEnabled(true);
        txtPorcento.setEnabled(true);
        txtPrecoUnitario.setEnabled(true);
        txtQtd.setEnabled(true);

    }

    private void desativarBotao() {
        btGravar.setEnabled(false);
        btAlterar.setEnabled(false);
        btDelete.setEnabled(false);
    }

    private void ativarBotao() {
        btGravar.setEnabled(true);
    }

    private void limparCampos() {
        txtDescricao.setText("");
        txtPorcento.setText("");
        txtPrecoUnitario.setText("");
        txtQtd.setText("");
        txtVenda.setText("");
    }
    private void btNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btNovoActionPerformed
        ativarCampos();
        ativarBotao();
        btAlterar.setEnabled(false);
        btDelete.setEnabled(false);
        limparCampos();
    }//GEN-LAST:event_btNovoActionPerformed

    private void btGravarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btGravarActionPerformed
        Produto a = new Produto();
        ProdutoDao dao = new ProdutoDao();

        a.setDescricao(txtDescricao.getText());
        a.setQuantidade(Integer.parseInt(txtQtd.getText()));

        String PrecoUnitario = txtPrecoUnitario.getText().trim().replace(",", ".");
        a.setPrecoUnitario(Double.parseDouble(PrecoUnitario));

        String Porcento = txtPorcento.getText().trim().replace(",", ".");
        a.setPorcentagem(Double.parseDouble(Porcento));

        double valorDaVenda = (((a.getPorcentagem() / 100) * a.getPrecoUnitario()) + a.getPrecoUnitario());

        a.setPrecoVenda(valorDaVenda);

        dao.adicionar(a);
        carregaTabela();
        desativarCampos();
        btGravar.setEnabled(false);
    }//GEN-LAST:event_btGravarActionPerformed
    private void tamanhoTabela() {
        //Defini o tamanho da tabela
        tbProduto.getColumnModel().getColumn(0).setPreferredWidth(100);
        tbProduto.getColumnModel().getColumn(1).setPreferredWidth(200);
    }

    private void carregaTabela() {
        DefaultTableModel modelo = (DefaultTableModel) tbProduto.getModel();
        modelo.setNumRows(0);
        tamanhoTabela();
        try {
            Connection con = conexao.getConnection();
            PreparedStatement pstm;
            ResultSet rs;

            pstm = con.prepareCall("SELECT id, datahora, descricao,quantidade,precounitario,porcentagem,precovenda From cadastroproduto;");
            rs = pstm.executeQuery();

            NumberFormat currencyPrecoUnitario = NumberFormat.getCurrencyInstance();
            NumberFormat currencyPrecoVenda = NumberFormat.getCurrencyInstance();

            while (rs.next()) {

                Timestamp dataHora = rs.getTimestamp("datahora");
                // Formatar a data e hora para o formato brasileiro
                SimpleDateFormat formatoBrasileiro = new SimpleDateFormat("dd/MM/yyyy HH:mm");
                String dataHoraFormatada = formatoBrasileiro.format(dataHora);

                modelo.addRow(new Object[]{
                    //rs.getString("datahora"),
                    dataHoraFormatada,
                    rs.getString("descricao"),
                    rs.getString("quantidade"),
                    currencyPrecoUnitario.format(rs.getDouble("precounitario")),
                    // rs.getString("precounitario"),
                    rs.getString("porcentagem"),
                    //    rs.getString("precovenda")
                    currencyPrecoVenda.format(rs.getDouble("precovenda")),});

            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao carregar a tabela de dados: " + e, "ERRO", JOptionPane.ERROR_MESSAGE);

        }
    }

    private void btAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAlterarActionPerformed
        Produto a = new Produto();
        ProdutoDao dao = new ProdutoDao();

        int index = tbProduto.getSelectedRow();
        a = dao.listarProduto().get(index);

        switch (JOptionPane.showConfirmDialog(null,
                " [--ALTERAÇÃO DE DADOS--] \n Dado Atual"
                + "\n Descrição: " + a.getDescricao()
                + "\n Quantidade: " + a.getQuantidade()
                + "\n Preço Unidade: " + a.getPrecoUnitario()
                + "\n Porcentagem: " + a.getPorcentagem()
                + "\n Preço Venda: " + a.getPrecoVenda()
                + "\n Será alterado "
                + "\n Descrição: " + txtDescricao.getText()
                + "\n Quantidade: " + txtQtd.getText()
                + "\n Preço Unidade: " + txtPrecoUnitario.getText()
                + "\n Porcentagem: " + txtPorcento.getText()
                + "\n Preço Venda: " + txtVenda.getText()
                + "\n Deseja realmente fazer alteração?",
                "Alteração de dados.", JOptionPane.YES_NO_OPTION)) {
            case 0:
                a.setDescricao(txtDescricao.getText());
                a.setQuantidade(Integer.parseInt(txtQtd.getText()));

                String PrecoUnitario = txtPrecoUnitario.getText().trim().replace(",", ".");
                a.setPrecoUnitario(Double.parseDouble(PrecoUnitario));

                String Porcento = txtPorcento.getText().trim().replace(",", ".");
                a.setPorcentagem(Double.parseDouble(Porcento));

                String Venda = txtVenda.getText().trim().replace(",", ".");
                a.setPrecoVenda(Double.parseDouble(Venda));
                dao.alterar(a);
                carregaTabela();
                btAlterar.setEnabled(false);
                desativarCampos();
                break;
            case 1:
                JOptionPane.showMessageDialog(null, "Nenhuma alteração foi feita.",
                        "AVISO", JOptionPane.INFORMATION_MESSAGE);
                break;
        }
    }//GEN-LAST:event_btAlterarActionPerformed

    private void btDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btDeleteActionPerformed
        Produto a = new Produto();
        ProdutoDao dao = new ProdutoDao();

        int index = tbProduto.getSelectedRow();

        a = dao.listarProduto().get(index);

        switch (JOptionPane.showConfirmDialog(null, "Deseja excluir a Informação ? \n "
                + "\n Descrição: " + a.getDescricao()
                + "\n Quantidade: " + a.getQuantidade()
                + "\n Preço Unidade: " + a.getPrecoUnitario()
                + "\n Porcentagem: " + a.getPorcentagem()
                + "\n Preço Venda: " + a.getPrecoVenda(),
                "Confirmação ", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE)) {
            case 0:
                dao.remover(a);
                carregaTabela();
                btDelete.setEnabled(false);
                break;
            case 1:
                JOptionPane.showMessageDialog(null, "Nehuma exclusão foi feita.", "AVISO", JOptionPane.INFORMATION_MESSAGE);
                break;
        }
    }//GEN-LAST:event_btDeleteActionPerformed

    private void tbProdutoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbProdutoMouseClicked
        Produto a = new Produto();
        ProdutoDao dao = new ProdutoDao();
        int index = tbProduto.getSelectedRow();
        a = dao.listarProduto().get(index);

        txtDescricao.setText(a.getDescricao());
        txtQtd.setText(Integer.toString(a.getQuantidade()));
        txtPorcento.setText(Double.toString(a.getPorcentagem()));
        txtPrecoUnitario.setText(Double.toString(a.getPrecoUnitario()));
        txtVenda.setText(Double.toString(a.getPrecoVenda()));

        btAlterar.setEnabled(true);
        btDelete.setEnabled(true);

        ativarCampos();

    }//GEN-LAST:event_tbProdutoMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAlterar;
    private javax.swing.JButton btDelete;
    private javax.swing.JButton btGravar;
    private javax.swing.JButton btNovo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbProduto;
    private javax.swing.JTextField txtDescricao;
    private javax.swing.JTextField txtPorcento;
    private javax.swing.JTextField txtPrecoUnitario;
    private javax.swing.JTextField txtQtd;
    private javax.swing.JTextField txtVenda;
    // End of variables declaration//GEN-END:variables
}
