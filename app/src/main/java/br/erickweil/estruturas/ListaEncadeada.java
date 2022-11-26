/**
 *  Esta classe implementa uma lista encadeada
 *  Basicamente cada nó contém um valor e aponta para o próximo
 */

 package br.erickweil.estruturas;
 
public class ListaEncadeada {

    /**
     * Define um único nó ou elemento, que contém um valor int e aponta para outro nó (que pode ser null)
     */
    public static class No {
        /** Valor salvo neste nó */
        public int valor;
        /** Referência ao próximo */
        public No proximo;

        public No(int valor) {
            this.valor = valor;
        }
    }

    public No inicio;
    
    // Jaina
    public int set(int indice, int valor){
        int cont=0;
        No atual = inicio;
        while (atual!=null) {
            if (indice == cont) {
                System.out.println("Atual: " + atual.valor+"\nTrocando por: "+ valor);
                int antigo = atual.valor;
                atual.valor = valor;
                return antigo;
            } else {
                atual = atual.proximo;
            }
            cont+=1;
        }
        return 0;
    }

    /** Adiciona um nó no final da lista
    *  1. Criar um novo nó com o valor informado
    *  2. Fazer o último nó da lista apontar
    *    para o novo nó
    *  2.1 Encontrar o último nó
    *  2.2 Fazer o último apontar ao novo
    */
    public void add(int valor)
    {
        // Criar novo nó
        No novo = new No(valor);
        
        // Encontrar último
        if(inicio == null)
        {
            // situação lista vazia
            inicio = novo;
        }
        else
        {
            No ultimo = inicio;
            while(ultimo.proximo != null)
            {
                ultimo = ultimo.proximo;
            }
            ultimo.proximo = novo;
        }
        
    }

    // Este método permite intercalar um nó desde a posição 1 até a posição lista.length
    public void add(int index, int valor){
        // Criar novos nós
        No atual = this.inicio;
        No novo = new No(valor);
        
        /* Não é possível acrescentar um nó na posição 0
        * Como ainda não há método que retorne o tamanho da lista, não é possível limitar o 
        * valor máximo da variável index, porém, empiricamente, é sabido que é possível acrescentar elementos até
        * a posição lista.length
        */
        if(index > 0){
            int controle = 2; // Foi utilizado este valor para que a variável atual tenha atribuído o nó anterior ao nó de índice index

            while(atual != null && index >= controle){
                atual = atual.proximo;
                controle++;
            }
            No deslocado = atual.proximo;
            atual.proximo = novo;
            novo.proximo = deslocado;
        }
    }

    /**
     * Atravessa cada elemento da lista, escrevendo-os na tela
     */
    public void exibirLista()
    {
        No atual = inicio;
        int i = 0;
        while(atual != null)
        {
            System.out.println(i+":\t"+atual.valor);
            atual = atual.proximo;
            i++;
        }
    }

    public boolean isEmpty(){
        if (inicio == null) {
            return true;            
        }
        else{
            return false;
        }
        

    }

    /**
     * Inserts all of the elements in the specified collection into this list, 
     * starting at the specified position.
    */
    boolean	addAll(int indice, ListaEncadeada novaLista)
    {
        // 1. Encontrar elemento que aponta pra o elemento na posição especificada
        int k = 0;
        No atual = inicio;
        while(k < indice-1)
        {
            atual = atual.proximo;
            k++;
        }
        
        // 2. Encontrar fim da nova lista
        No fimNovaLista = novaLista.inicio;
        while(fimNovaLista.proximo != null)
        {
            fimNovaLista = fimNovaLista.proximo;
        }

        // 3. Fazer fim da nova lista apontar para próximo do elemento 
        fimNovaLista.proximo = atual.proximo;

        // 4. Próximo do elemento apontar para início da nova lista
        atual.proximo = novaLista.inicio;

        // Ainda não fiz...
        return true;
    }
    // int removeFirst() - Remove o primeiro elemento da lista, além de remover da lista retorna o seu valor
	// int removeLast() - Remove o último elemento da lista, além de remover da lista retorna o seu valor
	// int remove(int indice) - Remove o elemento da lista na posição especificada, retornando o seu valor

    // remove elemento do começo da lista
    public int removeFirst(){
        int saveFirstValue = inicio.valor; // valor inicial
        inicio = inicio.proximo;
        return saveFirstValue;
    }


    // preciso verificar que o meu newNo.prox.prox seja null,
    // fazendo com que eu trave a lista no meu penultimo
    // remove o ultimo elemento da lista
    public int removeLast(){
        
        // criei outra instância no qual eu percorro e pego o ultimo
        No gettingThelast = inicio;
        while(gettingThelast.proximo != null){
            gettingThelast = gettingThelast.proximo;
        }
        int value = gettingThelast.valor;


        // se eu mudo meu second last eu consigo mudar o meu inicio
        // pois os dois apontam para a mesma referência
        No second_last = inicio;
        while(second_last.proximo.proximo != null){
            second_last = second_last.proximo;
        }

        second_last.proximo = null;
        // inicio.proximo = newNo;

        return value;
    }

    public int countList(){
        No atual = inicio;
        int count = 0;
        while(atual != null)
        {
            atual = atual.proximo;
            count++;
        }
        return count;
    }

    public void removeById(int id){
        
        // trata de posições que nao estão na lista
        if(id >= countList() || id < 0){
            throw new Error("Elemento fora do range da lista");
        }

        No removing;

        // trata se o elemento é o primeiro da lista
        if(id == 0){
            // removing aponta para o começo da lista
            removing = inicio;
            
            // recebe o segundo elemento da lista (objeto)
            inicio = inicio.proximo;

            System.out.println("o valor retirado foi: "+removing.valor);
        }else{
            No aux = inicio;
            
            for(int j = 0; j < id-1; j++){
                aux = aux.proximo;
            }
            
            removing = aux.proximo;

            // primeiro deve verificar se ele é o ultimo elemento
            // e apontar ele pra null
            if(id == countList() - 1){
                aux.proximo = null;
            }else{
                aux.proximo = aux.proximo.proximo;
            }

        }
        
    }


    /** Percorre a lista para encontrar o elemento no índice */

    public int get(int indice){
        No atual = this.inicio;
        for (int i = 0; i < indice; i++){
            if(atual != null)
                atual = atual.proximo;
        }

        try{
            return atual.valor;
        }catch(NullPointerException nul){
            System.out.println("O índice não possui elementos");
        }finally {
            return 0;
        }
    }

    /**
     * Método principal, usado aqui para testar a minha implementação da ListaEncadeada
     */
    public static void main(String[] args) {
        ListaEncadeada lista = new ListaEncadeada();
        lista.isEmpty();
        System.out.println(lista.isEmpty());
        lista.add(-1);
        lista.add(-3);
        lista.add(-5);
        lista.add(-7);
        lista.add(100);
        lista.add(200);
        lista.add(300);
        lista.add(400);
        lista.add(500);
        lista.add(600);
        lista.add(700);
        System.out.println(lista.isEmpty());
        lista.isEmpty();
        lista.add(11, 69);

        System.out.println("Após addAll:");
        lista.exibirLista();

        System.out.println(lista.get(20));
    }
}
