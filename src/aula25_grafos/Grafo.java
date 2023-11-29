package aula25_grafos;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Grafo<TIPO> {
    private ArrayList<Vertice<TIPO>> vertices;
    private ArrayList<Aresta<TIPO>> arestas;
    
    public Grafo(){
        this.vertices = new ArrayList<Vertice<TIPO>>();
        this.arestas = new ArrayList<Aresta<TIPO>>();
    }
    
    public void adicionarVertice(TIPO dado){
        Vertice<TIPO> novoVertice = new Vertice<TIPO>(dado);
        this.vertices.add(novoVertice);
    }
    
    public void adicionarAresta(Double peso, TIPO dadoInicio, TIPO dadoFim){
        Vertice<TIPO> inicio = this.getVertice(dadoInicio);
        Vertice<TIPO> fim = this.getVertice(dadoFim);
        Aresta<TIPO> aresta = new Aresta<TIPO>(peso, inicio, fim);
        inicio.adicionarArestaSaida(aresta);
        this.arestas.add(aresta);
    }
    
    public Vertice<TIPO> getVertice(TIPO dado){
        Vertice<TIPO> vertice = null;
        for(int i=0; i < this.vertices.size(); i++){
            if (this.vertices.get(i).getDado().equals(dado)){
                vertice = this.vertices.get(i);
                break;
            }
        }
        return vertice;
    }
    
     public boolean temCiclo() {
        List<Vertice<TIPO>> pilhaRecursao = new ArrayList<>();

        for (Vertice<TIPO> vertice : vertices) {
            if (temCicloRecursivo(vertice, new ArrayList<>(), pilhaRecursao)) { 
                return true;
            }
        }

        return false;
    }

    private boolean temCicloRecursivo(Vertice<TIPO> vertice, List<Vertice<TIPO>> visitados, List<Vertice<TIPO>> pilhaRecursao) {
        if (pilhaRecursao.contains(vertice)) {
            // Se o vértice já está na pilha de recursão, então há um ciclo
            return true;
        }

        if (visitados.contains(vertice)) {
            // Se o vértice já foi visitado, não há necessidade de explorá-lo novamente
            return false;
        }

        // Marca o vértice como visitado e o adiciona à pilha de recursão
        visitados.add(vertice);
        pilhaRecursao.add(vertice);

        // Explora os vizinhos do vértice
        for (Aresta<TIPO> aresta : vertice.getArestasSaida()) {
            Vertice<TIPO> vizinho = aresta.getFim();
            if (temCicloRecursivo(vizinho, visitados, pilhaRecursao)) {
                return true;
            }
        }

        // Remove o vértice da pilha de recursão após explorar todos os seus vizinhos
        pilhaRecursao.remove(vertice);

        return false;
    }
}
