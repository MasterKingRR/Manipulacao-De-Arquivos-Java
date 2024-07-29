package negocio;

public class EstrategiaNaoDefinidaException extends RuntimeException{
    public EstrategiaNaoDefinidaException(){
        super("Estrategia nao foi definida");
    }
}
