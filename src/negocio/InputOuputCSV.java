package negocio;

import entidades.Produto;

import java.io.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class InputOuputCSV implements IOEstrategia {
    @Override
    public List<Produto> listar(File arquivo) {

        Produto.ProdutoBuilder produto = new Produto.ProdutoBuilder();

        try(BufferedReader br = new BufferedReader(new FileReader(arquivo))){
            List<Produto> produtos = new ArrayList<>();
            String linha = br.readLine();

            while(linha != null){
                String[] partes = linha.split(";");
                String nome = partes[0];
                String preco = partes[1];
                String quantidade = partes[2];

                produtos.add(
                        produto.nome(nome)
                            .preco(preco)
                            .quantidade(quantidade)
                            .build());
                linha = br.readLine();

            }
            return produtos;
        }catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean escrever(List<Produto> produtos, File arquivoOutput) {

        try(BufferedWriter bw = new BufferedWriter(new FileWriter(arquivoOutput))){
            produtos.stream()
                    .map(InputOuputCSV::convert)
                    .forEach(line ->{
                        try{
                            bw.write(line);
                            bw.newLine();
                        }catch (IOException e){
                            throw new RuntimeException(e);
                        }
                    });
        }catch (IOException e) {
            throw new RuntimeException(e);
        }
        return true;
    }

    private static String convert(Produto produto){
        return String.format("%s;%s",produto.getNome(),
                BigDecimal.valueOf(produto.getQuantidade()).multiply(produto.getPreco()));
    }


}
