package br.erickweil.estruturas;

public class ListaEncadeadaAntigo {

    public int valor;
    public ListaEncadeadaAntigo prox;

    public ListaEncadeadaAntigo(int valor)
    {
        this.valor = valor;
    }

    public ListaEncadeadaAntigo adicionarNoInicio(int valor)
    {
        ListaEncadeadaAntigo novo = new ListaEncadeadaAntigo(valor);
        novo.prox = this;
        return novo;
    }

    public static void main(String[] args)
    {
        ListaEncadeadaAntigo lista = new ListaEncadeadaAntigo(77);
        
        lista = lista.adicionarNoInicio(30);
        lista = lista.adicionarNoInicio(5);

        ListaEncadeadaAntigo atual = lista;
        while(atual != null) // Só continua se não é nulo
        {
            // Escreve o valor do atual
            System.out.println(atual.valor);
            // Acessa o próximo elemento
            atual = atual.prox;
        }

    }
}