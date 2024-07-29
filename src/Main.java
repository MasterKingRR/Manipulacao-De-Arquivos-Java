/*
* Objetivo
* Ler do teclado o caminho para o arquivo de texto
* Ler o arquivo de texto, que contém: nome do produto, preço e quantidade
* Escrever um arquivo de texto que contenha: nome do produto e valor total (quantidade * preço)
* */


import entidades.Produto;
import negocio.InputOuputCSV;
import negocio.ESDeArquivo;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args)  throws IOException{
        Scanner sc = new Scanner(System.in);

        System.out.println("Caminho para o arquivo: ");
        String strPath = sc.nextLine();

        File fileInput = new File(strPath);
        File fileOut = new File("output");

        if(fileInput.exists()){
            var io = new ESDeArquivo(new InputOuputCSV());
            List<Produto> produtos = io.listar(fileInput);

            if(!fileOut.exists()){
                fileOut.createNewFile();
            }

            io.escrever(produtos,fileOut);
            System.out.println(produtos);
        }else {
            System.err.println("O arquivo não existe");
        }

    }
}