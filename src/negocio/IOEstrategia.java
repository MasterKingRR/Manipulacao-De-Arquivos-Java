package negocio;

import entidades.Produto;

import java.io.File;
import java.util.List;

//ESTRATEGIA DE ENTRADA E SAIDA
public interface IOEstrategia {

    public List<Produto> listar(File arquivo);

    public boolean escrever(List<Produto> produtos, File arquivoOutput);
}
