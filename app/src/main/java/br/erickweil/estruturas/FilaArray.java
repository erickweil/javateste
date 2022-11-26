package br.erickweil.estruturas;

public class FilaArray {
    public String[] lista;
    public int inicio;
    public int fim;
    public int tamanho;

    public FilaArray(int maximo)
    {
        lista = new String[maximo];
        inicio = 0;
        fim = 0;
        tamanho = 0;
    }

    public boolean isEmpty()
    {
        return tamanho == 0;
    }

    public int size() {
        return tamanho;
    }

    public void enqueue(String valor) throws Exception
    {
        if(tamanho >= lista.length)
        {
            throw new Exception("Lista na capacidade máxima:"+lista.length);
        }

        lista[fim] = valor;
        fim = (fim + 1) % lista.length;
        tamanho++;
    }

    public String dequeue() throws Exception
    {
        if(isEmpty())
        {
            throw new Exception("Fila vazia");
        }
        String temp = lista[inicio];
        lista[inicio] = null;
        inicio = (inicio + 1) % lista.length;
        tamanho--;
        return temp;
    }

    public void explain()
    {
        /*
            0:A -- inicio
            1:B
            2:C
            3:null  -- fim
            4:null

        */
        for(int i=0;i<lista.length;i++)
        {
            System.out.print(i+":");
            System.out.print(lista[i]);
            if(inicio == i)
            System.out.print(" --inicio");
            if(fim == i)
            System.out.print(" --fim");

            
            System.out.println();
        }
    }
}