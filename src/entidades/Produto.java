package entidades;

import java.math.BigDecimal;

public class Produto {
    private String nome;
    private BigDecimal preco;
    private Long quantidade;

    public Produto(String nome, BigDecimal preco, Long quantidade) {
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    public BigDecimal getTotal(){
        return preco.multiply(BigDecimal.valueOf(quantidade));
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public Long getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Long quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public String toString(){
        return String.format("{Nome: %s,\nPreco: %s,\nQuantidade: %s}",this.nome,this.preco,this.quantidade);
    }

    public static class ProdutoBuilder{
        public BigDecimal preco;
        public Long quantidade;
        public String nome;

        public ProdutoBuilder preco(BigDecimal preco){
            this.preco = preco;
            return this;
        }
        public ProdutoBuilder preco(String preco){
            this.preco = new BigDecimal(preco);
            return this;
        }
        public ProdutoBuilder nome(String nome){
            this.nome = nome;
            return this;
        }
        public ProdutoBuilder quantidade(String quantidade){
            this.quantidade = Long.valueOf(quantidade);
            return this;
        }
        public Produto build(){
            return new Produto(this.nome,this.preco,this.quantidade);
        }
    }
}
