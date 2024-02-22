package model;

import java.sql.Timestamp;

/**
 *
 * @author Ledilson
 */
public class Venda {

    private Long id;
    private Timestamp datahora;
    private String descricao;
    private Integer quantidade;
    private Double precoVenda;
    private Double total;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Timestamp getDatahora() {
        return datahora;
    }

    public void setDatahora(Timestamp datahora) {
        this.datahora = datahora;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Double getPrecoVenda() {
        return precoVenda;
    }

    public void setPrecoVenda(Double precoVenda) {
        this.precoVenda = precoVenda;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

   
}
