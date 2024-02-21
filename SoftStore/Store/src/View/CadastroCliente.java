/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Conexao.conexao;
import dao.ClienteDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Cliente;

/**
 *
 * @author Ledilson
 */
public class CadastroCliente extends javax.swing.JInternalFrame {

    /**
     * Creates new form Cad
     */
    public CadastroCliente() {
        initComponents();

        carregaTabela();
        desativarCampos();
        desativarBotao();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbCliente = new javax.swing.JTable();
        btNovo = new javax.swing.JButton();
        btGravar = new javax.swing.JButton();
        btAlterar = new javax.swing.JButton();
        btDelete = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtCelular = new javax.swing.JFormattedTextField();

        setClosable(true);

        tbCliente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "nome", "cel"
            }
        ));
        tbCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbClienteMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbCliente);

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

        jLabel1.setText("Nome.:");

        jLabel2.setText("Cel.:");

        try {
            txtCelular.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)# ####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCelular, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 702, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btNovo)
                    .addComponent(btGravar)
                    .addComponent(btAlterar)
                    .addComponent(btDelete))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(txtCelular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 252, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
private void desativarCampos() {
        txtNome.setEnabled(false);
        txtCelular.setEnabled(false);
    }

    private void ativarCampos() {
        txtNome.setEnabled(true);
        txtCelular.setEnabled(true);
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
        txtNome.setText("");
        txtCelular.setText("");
    }
    private void tbClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbClienteMouseClicked
        Cliente a = new Cliente();
        ClienteDao dao = new ClienteDao();
        int index = tbCliente.getSelectedRow();
        a = dao.listarCliente().get(index);

        txtNome.setText(a.getNome());
        txtCelular.setText(a.getCelular());

        btAlterar.setEnabled(true);
        btDelete.setEnabled(true);
        ativarCampos();
    }//GEN-LAST:event_tbClienteMouseClicked

    private void btNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btNovoActionPerformed
        ativarCampos();
        ativarBotao();
        btAlterar.setEnabled(false);
        btDelete.setEnabled(false);
        limparCampos();
    }//GEN-LAST:event_btNovoActionPerformed
 private void carregaTabela() {
        DefaultTableModel modelo = (DefaultTableModel) tbCliente.getModel();
        modelo.setNumRows(0);

        try {
            Connection con = conexao.getConnection();
            PreparedStatement pstm;
            ResultSet rs;

            pstm = con.prepareStatement("SELECT id,nome,cel FROM cadastrocliente;");
            rs = pstm.executeQuery();
            while (rs.next()) {
                modelo.addRow(new Object[]{
                    rs.getString("nome"),
                    rs.getString("cel"),});
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao carregar a tabela de dados: " + e, "ERRO", JOptionPane.ERROR_MESSAGE);

        }
    }

    private void btGravarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btGravarActionPerformed
        Cliente a = new Cliente();
        ClienteDao dao = new ClienteDao();
        a.setNome(txtNome.getText());
        a.setCelular(txtCelular.getText());

        dao.create(a);
        carregaTabela();
        desativarCampos();
        btGravar.setEnabled(false);
    }//GEN-LAST:event_btGravarActionPerformed

    private void btAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAlterarActionPerformed
        Cliente a = new Cliente();
        ClienteDao dao = new ClienteDao();

        int index = tbCliente.getSelectedRow();
        a = dao.listarCliente().get(index);

        switch (JOptionPane.showConfirmDialog(null,
                " [--ALTERAÇÃO DE DADOS--] \n Dado Atual"
                + "\n Nome: " + a.getNome()
                + "\n Celular: " + a.getCelular()
                + "\n Será alterado "
                + "\n Nome: " + txtNome.getText()
                + "\n Celular: " + txtCelular.getText()
                + "\n Deseja realmente fazer alteração?",
                "Alteração de dados.", JOptionPane.YES_NO_OPTION)) {
            case 0:
                a.setNome(txtNome.getText());
                a.setCelular(txtCelular.getText());
                dao.update(a);
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
        Cliente a = new Cliente();
        ClienteDao dao = new ClienteDao();

        int index = tbCliente.getSelectedRow();

        a = dao.listarCliente().get(index);

        switch (JOptionPane.showConfirmDialog(null, "Deseja excluir a Informação ? \n "
                + "\n Nome:  " + a.getNome()
                + "\n Celular: " + a.getCelular(),
                "Confirmação ", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE)) {
            case 0:
                dao.delete(a);
                carregaTabela();
                btDelete.setEnabled(false);
                break;
            case 1:
                JOptionPane.showMessageDialog(null, "Nehuma exclusão foi feita.", "AVISO", JOptionPane.INFORMATION_MESSAGE);
                break;
        }
    }//GEN-LAST:event_btDeleteActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAlterar;
    private javax.swing.JButton btDelete;
    private javax.swing.JButton btGravar;
    private javax.swing.JButton btNovo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbCliente;
    private javax.swing.JFormattedTextField txtCelular;
    private javax.swing.JTextField txtNome;
    // End of variables declaration//GEN-END:variables
}
