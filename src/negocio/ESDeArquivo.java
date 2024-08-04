package negocio;

import entidades.Produto;

import java.io.File;
import java.util.List;

public class ESDeArquivo {

    private IOEstrategia io;
    
    public ESDeArquivo(){

    }
    public ESDeArquivo(IOEstrategia io){
        this.io = io;
    }

    public List<Produto> listar(File arquivo){
        if(this.io == null)
            throw new EstrategiaNaoDefinidaException();
        return io.listar(arquivo);
    }

    //method overload
    public List<Produto> listar(IOEstrategia io, File arquivo){
        return io.listar(arquivo);
    }

    public boolean escrever(List<Produto> produtos, File output){
        if(this.io == null)
            throw new EstrategiaNaoDefinidaException();
        return io.escrever(produtos,output);
    }

    //method overload
    public boolean escrever(IOEstrategia io, List<Produto> produtos,File arquivoOutput){
        return io.escrever(produtos,arquivoOutput);
    }

    public void setLeitor(IOEstrategia io){
        this.io = io;
    }

}
