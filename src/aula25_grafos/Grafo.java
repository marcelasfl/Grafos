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
    
    public void adicionarVertice(TIPO dado) {
        // Verifica se já existe um vértice com o mesmo dado
        if (getVertice(dado) == null) {
            Vertice<TIPO> novoVertice = new Vertice<TIPO>(dado);
            this.vertices.add(novoVertice);
        } else {
            System.out.println("Já existe um vértice com o dado " + dado);
        }
    }

    //public List<Vertice<TIPO>> imprimirVertices() {
      //  for (Vertice<TIPO> vertice : vertices) {
        //    System.out.println(vertice.getDado());
        //}
        // Retorna a lista de vértices
        //return this.vertices;
    //}
    
    public void adicionarAresta(Double peso, TIPO dadoInicio, TIPO dadoFim){
        Vertice<TIPO> inicio = this.getVertice(dadoInicio);
        Vertice<TIPO> fim = this.getVertice(dadoFim);
        Aresta<TIPO> aresta = new Aresta<TIPO>(peso, inicio, fim);
        inicio.adicionarArestaSaida(aresta);
        this.arestas.add(aresta);
    }
    
    public Vertice<TIPO> getVertice(TIPO dado){ //busca por vertice
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

        for (Vertice<TIPO> vertice : this.vertices) {
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


    public List<TIPO> ordenacaoTopologica() {
        List<Vertice<TIPO>> ordenacao = new ArrayList<>();
        List<Vertice<TIPO>> visitados = new ArrayList<>();

        for (Vertice<TIPO> vertice : this.vertices) {
            if (!visitados.contains(vertice)) {
                ordenacaoTopologicaRecursivo(vertice, visitados, ordenacao);
            }
        }

        // Criando uma lista para armazenar o resultado da ordenação topológica
        List<TIPO> resultado = new ArrayList<>();

        // Adicionando à lista
        for (int i = ordenacao.size() - 1; i >= 0; i--) {
            resultado.add(ordenacao.get(i).getDado());
        } //Revertendo a lista de ordenação e colocando os vértices do final-começo para ordenar corretamente

        

        return resultado;
    }

    private void ordenacaoTopologicaRecursivo(Vertice<TIPO> vertice, List<Vertice<TIPO>> visitados, List<Vertice<TIPO>> ordenacao) {
        visitados.add(vertice);

        for (Aresta<TIPO> aresta : vertice.getArestasSaida()) {
            Vertice<TIPO> vizinho = aresta.getFim();
            if (!visitados.contains(vizinho)) {
                ordenacaoTopologicaRecursivo(vizinho, visitados, ordenacao);
            }
        }

        // Adiciona o vértice à lista
        ordenacao.add(vertice);
    }

    // método criado apenas para verificar se o grafo está sendo construído corretamente
    public void imprimirGrafo() {
        System.out.println("Vértices:");
        for (Vertice<TIPO> vertice : this.vertices) {
            System.out.println(vertice.getDado());
        }

        System.out.println("Arestas:");
        for (Aresta<TIPO> aresta : this.arestas) {
            System.out.println(aresta.getInicio().getDado() + " -> " + aresta.getFim().getDado());
        }
    }

}



