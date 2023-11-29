package aula25_grafos;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Aula25_grafos {
    
    public static void main(String[] args) {
        Grafo<String> grafo = new Grafo<String>();
        grafo.adicionarVertice("João");
        grafo.adicionarVertice("Lorenzo");
        grafo.adicionarVertice("Creuza");
        grafo.adicionarVertice("Créber");
        
        grafo.adicionarAresta(2.0, "João", "Lorenzo");
        grafo.adicionarAresta(3.0, "Lorenzo", "Créber");
        grafo.adicionarAresta(1.0, "Créber", "Creuza");
        grafo.adicionarAresta(1.0, "Creuza", "João");

        
        //grafo.getVertice("João");
        //Vertice dado = grafo.getVertice("João");
       //ArrayList<Aresta> saida = dado.getArestasSaida();
       
        System.out.println(grafo.temCiclo());
       
       
    }
    
}
