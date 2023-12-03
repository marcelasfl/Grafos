package aula25_grafos;

public class Aula25_grafos {
    
    //classe main de teste, inserção de vértices e arestas
    public static void main(String[] args) {
        Grafo<String> grafo = new Grafo<String>();
        grafo.adicionarVertice("1");
        grafo.adicionarVertice("2");
        grafo.adicionarVertice("3");
        grafo.adicionarVertice("4");
        grafo.adicionarVertice("5");
        grafo.adicionarVertice("6");
        grafo.adicionarVertice("7");
        grafo.adicionarVertice("8");
        grafo.adicionarVertice("10");


        
        grafo.adicionarAresta("1", "4");
        grafo.adicionarAresta("1", "5");
        grafo.adicionarAresta("2", "5");
        grafo.adicionarAresta("4", "5");
        grafo.adicionarAresta("4", "7");
        grafo.adicionarAresta("6", "7");
        grafo.adicionarAresta("6", "8");
        grafo.adicionarAresta("8", "10");
        grafo.adicionarAresta("7", "10");
        grafo.adicionarAresta("3", "6");
        grafo.adicionarAresta("5", "3");


        //prints do grafo, função de verificação de ciclo e a ordenação topológica
        System.out.println("Grupo: Hanna Leticia, Isabella Bissoli, Marcela Starling e Victor Oliveira");

        System.out.println("-----Informações do grafo escolhido----");
        grafo.imprimirGrafo();
        
        System.out.println("O grafo é:" + grafo.temCiclo());
        if (grafo.temCiclo()) {
            System.out.println("Não dá para fazer ordenação, pois é um grafo cíclico"); }
        else{
            System.out.println("Uma possível ordenação topológica é:" +  grafo.ordenacaoTopologica());
        }
       
    }
    
}
