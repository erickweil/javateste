package br.erickweil;

import br.erickweil.estruturas.TabelaHash;

public class Inicio {
    public static void main(String[] args) {
        TabelaHash tabela = new TabelaHash(10);

        tabela.put("Erick", 1);
        tabela.put("Maria", 2);
        tabela.put("João", 3);
        tabela.put("João", 4);

        tabela.print();
    }
    

}


