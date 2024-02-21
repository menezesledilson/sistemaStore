 
package  model;
 
import java.sql.Timestamp;

/**
 *
 * @author Ledilson
 */
public class Produto {
    
    private Long id;
    private Timestamp dathora;
    private String descricao;
    private Integer quantidade;
    private Double precoUnitario;
    private Double porcentagem;
    private Double precoVenda;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Timestamp getDathora() {
        return dathora;
    }

    public void setDathora(Timestamp dathora) {
        this.dathora = dathora;
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

    public Double getPrecoUnitario() {
        return precoUnitario;
    }

    public void setPrecoUnitario(Double precoUnitario) {
        this.precoUnitario = precoUnitario;
    }

    public Double getPorcentagem() {
        return porcentagem;
    }

    public void setPorcentagem(Double porcentagem) {
        this.porcentagem = porcentagem;
    }

    public Double getPrecoVenda() {
        return precoVenda;
    }

    public void setPrecoVenda(Double precoVenda) {
        this.precoVenda = precoVenda;
    }

     

    
}
