package View;

import Conexao.conexao;
import DAO.VendaDao;
import dao.ProdutoDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import jdk.nashorn.internal.ir.BreakNode;
import model.Produto;
import model.Venda;

public class VendaProduto extends javax.swing.JInternalFrame {

    public VendaProduto() {
        initComponents();
        carregaTabela();
        cbListaProduto();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbVenda = new javax.swing.JTable();
        btNovo = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        cbxProduto = new javax.swing.JComboBox<>();
        txtPrecoVenda = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtQtd = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtTotal = new javax.swing.JLabel();
        btGravar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setClosable(true);
        setTitle("Vendas");

        tbVenda.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "data hora", "descrição", "quantidade", "Preço", "total"
            }
        ));
        jScrollPane1.setViewportView(tbVenda);

        btNovo.setText("Novo");
        btNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btNovoActionPerformed(evt);
            }
        });

        jLabel1.setText("Descrição.:");

        cbxProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxProdutoActionPerformed(evt);
            }
        });

        txtPrecoVenda.setText("0.00");

        jLabel2.setText("Qtd.:");

        txtQtd.setText(" ");

        jLabel3.setText("Total.:");

        txtTotal.setText("0.00");

        btGravar.setText("Gravar");
        btGravar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btGravarActionPerformed(evt);
            }
        });

        jLabel5.setText("R$: ");

        jButton1.setText("Alterar");

        jButton2.setText("Excluir");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btNovo)
                        .addGap(18, 18, 18)
                        .addComponent(btGravar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton2)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(cbxProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                        .addComponent(txtPrecoVenda)
                        .addGap(127, 127, 127)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtQtd, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtTotal)
                        .addGap(40, 40, 40))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btNovo)
                    .addComponent(btGravar)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cbxProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPrecoVenda)
                    .addComponent(jLabel2)
                    .addComponent(txtQtd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(txtTotal)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
     private void tamanhoTabela() {
        //Defini o tamanho da tabela
        tbVenda.getColumnModel().getColumn(0).setPreferredWidth(100);
        tbVenda.getColumnModel().getColumn(1).setPreferredWidth(200);
    }

    private void carregaTabela() {
        DefaultTableModel modelo = (DefaultTableModel) tbVenda.getModel();
        modelo.setNumRows(0);
        tamanhoTabela();
        try {
            Connection con = conexao.getConnection();
            PreparedStatement pstm;
            ResultSet rs;

            pstm = con.prepareCall("SELECT id, datahora, descricao,quantidade,precovenda,total From vendaproduto;");
            rs = pstm.executeQuery();

            NumberFormat currencyTotalVenda = NumberFormat.getCurrencyInstance();
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
                    // rs.getString("precounitario"),
                    currencyPrecoVenda.format(rs.getDouble("precovenda")),
                    currencyTotalVenda.format(rs.getDouble("total")),});

            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao carregar a tabela de dados: " + e, "ERRO", JOptionPane.ERROR_MESSAGE);

        }
    }
    private void btNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btNovoActionPerformed
        /*  ativarCampos();
        ativarBotao();
        btAlterar.setEnabled(false);
        btDelete.setEnabled(false);
        limparCampos();*/
    }//GEN-LAST:event_btNovoActionPerformed
    ArrayList<Integer> idCadastroProduto = new ArrayList<Integer>();
    ArrayList<Double> valorVendaProduto = new ArrayList<Double>();

    public void cbListaProduto() {
        //Limpar os dados antigos
        idCadastroProduto.clear();
        valorVendaProduto.clear();
        cbxProduto.removeAllItems();

        try {
            ProdutoDao dao = new ProdutoDao();
            Connection con = conexao.getConnection();
            PreparedStatement pstm;
            ResultSet rs;

            pstm = con.prepareStatement("SELECT * from cadastroproduto;");
            rs = pstm.executeQuery();
            while (rs.next()) {
                idCadastroProduto.add(rs.getInt(1));
                cbxProduto.addItem(rs.getString(3));
                valorVendaProduto.add(rs.getDouble(7));
            }
        } catch (SQLException ErroSql) {
            JOptionPane.showMessageDialog(null, "Erro ao listar dados: " + ErroSql, "ERRO", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void cbxProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxProdutoActionPerformed

        int selectIndex = cbxProduto.getSelectedIndex();

        if (selectIndex >= 0 && selectIndex < valorVendaProduto.size()) {
            double valorSelecionado = valorVendaProduto.get(selectIndex);
            txtPrecoVenda.setText(String.valueOf(valorSelecionado));
        }

    }//GEN-LAST:event_cbxProdutoActionPerformed
    private double acumuloVenda = 0.0;

    private void btGravarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btGravarActionPerformed
        VendaDao dao = new VendaDao();
        Venda a = new Venda();

        try {
            if (cbxProduto.getItemCount() > 0) {
                String descricaoSelecionada = cbxProduto.getSelectedItem().toString();
                a.setDescricao(descricaoSelecionada);

                double precoVenda = Double.parseDouble(txtPrecoVenda.getText().trim());
                a.setPrecoVenda(precoVenda);

                int quantidade = Integer.parseInt(txtQtd.getText().trim());
                a.setQuantidade(quantidade);

                // Calcula o total do item atual
                double totalVenda = quantidade * precoVenda;
                a.setTotal(totalVenda);
                acumuloVenda += totalVenda;
                DecimalFormat df = new DecimalFormat("#.##");
                String valorFormatado = df.format(acumuloVenda);
                txtTotal.setText(String.valueOf(valorFormatado));

                // Subtrai a quantidade vendida do estoque atual no banco de dados
                if (!atualizarEstoque(descricaoSelecionada, quantidade)) {
                    // Exibe mensagem de aviso se o estoque está vazio
                    JOptionPane.showMessageDialog(null, "Produto " + descricaoSelecionada + " está em falta no estoque.", "Estoque Vazio", JOptionPane.WARNING_MESSAGE);
                    return;
                }

                int opcao = JOptionPane.showConfirmDialog(this, "Pedido adicionado com sucesso. Deseja adicionar mais um pedido?", "Confirmação", JOptionPane.YES_NO_OPTION);
                // Se o usuário clicar em "Sim", apenas limpe os campos para permitir um novo pedido
                if (opcao == JOptionPane.YES_OPTION) {
                    cbxProduto.setSelectedIndex(-1);
                    txtPrecoVenda.setText("");
                    txtQtd.setText("");
                    return; // Retorna para permitir que o usuário adicione mais um pedido
                } else {
                    // Se o usuário clicar em "Não" ou fechar o diálogo, finalize o processo de venda atual
                    dao.adicionar(a);
                    carregaTabela();
                    // Limpe os campos para permitir uma nova venda
                    cbxProduto.setSelectedIndex(-1);
                    txtPrecoVenda.setText("");
                    txtQtd.setText("");
                    txtTotal.setText("");
                }
            } else {
                JOptionPane.showMessageDialog(this, "Nenhum item disponível na lista de produtos.", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Por favor, insira valores válidos para quantidade, valor e peso.", "Erro", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    
    }//GEN-LAST:event_btGravarActionPerformed

private boolean atualizarEstoque(String descricaoProduto, int quantidadeVendida) {
        try {
            Connection con = conexao.getConnection();
            PreparedStatement consultaEstoque = con.prepareStatement("SELECT quantidade FROM cadastroProduto WHERE descricao = ?");
            consultaEstoque.setString(1, descricaoProduto);
            ResultSet resultado = consultaEstoque.executeQuery();

            if (resultado.next()) {
                int quantidadeAtual = resultado.getInt("quantidade");

                if (quantidadeAtual >= quantidadeVendida) {
                    PreparedStatement pstm = con.prepareStatement("UPDATE cadastroproduto SET quantidade = quantidade - ? WHERE descricao = ?");
                    pstm.setInt(1, quantidadeVendida);
                    pstm.setString(2, descricaoProduto);
                    pstm.executeUpdate();
                    return true; // Estoque atualizado com sucesso
                } else {
                    return false; // Estoque insuficiente
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false; // Erro ao atualizar o estoque
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btGravar;
    private javax.swing.JButton btNovo;
    private javax.swing.JComboBox<String> cbxProduto;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbVenda;
    private javax.swing.JLabel txtPrecoVenda;
    private javax.swing.JTextField txtQtd;
    private javax.swing.JLabel txtTotal;
    // End of variables declaration//GEN-END:variables
}
