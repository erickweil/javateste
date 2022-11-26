package br.erickweil.estruturas;

public class TabelaHash {
    public static class TabelaEntrada {
        String chave;
        int valor;

        public TabelaEntrada(String chave, int valor) {
            this.chave = chave;
            this.valor = valor;
        }
    }

    public TabelaEntrada[] tabela;
    public TabelaHash(int capacidade)
    {
        tabela = new TabelaEntrada[capacidade];
    }

    public void put(String chave, int valor)
    {
        int hash = Math.abs(chave.hashCode());
        int indice = hash % tabela.length;

        // Encontrar a chave ou o próximo vazio
        TabelaEntrada entrada = tabela[indice];
        while(entrada != null) { 
            if(entrada.chave.equals(chave))
                break;
            
            indice++;
            entrada = tabela[indice];
        }

        tabela[indice] = new TabelaEntrada(chave,valor);
    }

    public void print()
    {
        for(int i=0;i<tabela.length;i++)
        {
            TabelaEntrada entrada = tabela[i];
            
            System.out.println(i+": "+(entrada == null ? "null" : entrada.chave+" --> "+entrada.valor));
        }
    }
}