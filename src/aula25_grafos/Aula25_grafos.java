package aula25_grafos;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Aula25_grafos {
    
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


        
        grafo.adicionarAresta(2.0, "1", "4");
        grafo.adicionarAresta(3.0, "1", "5");
        grafo.adicionarAresta(1.0, "2", "5");
        grafo.adicionarAresta(1.0, "4", "5");
        grafo.adicionarAresta(1.0, "4", "7");
        grafo.adicionarAresta(1.0, "6", "7");
        grafo.adicionarAresta(1.0, "6", "8");
        grafo.adicionarAresta(1.0, "8", "10");
        grafo.adicionarAresta(1.0, "7", "10");
        grafo.adicionarAresta(1.0, "3", "6");
        grafo.adicionarAresta(1.0, "5", "3");


        
        System.out.println("-----Informações do grafo escolhido----");
        grafo.imprimirGrafo();
        
        System.out.println("O grafo é:" + grafo.temCiclo());
        if (grafo.temCiclo()) {
            System.out.println("Não dá para fazer, pois é um grafo cíclico"); }
        else{
            System.out.println("Uma possível ordenação topológica é:" +  grafo.ordenacaoTopologica());
        }
       
    }
    
}
