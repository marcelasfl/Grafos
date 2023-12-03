package aula25_grafos;

import java.util.ArrayList;

public class Vertice<TIPO> {
    private TIPO dado;
    private ArrayList<Aresta<TIPO>> arestasSaida;
    
    public Vertice(TIPO valor){
        this.dado = valor;
        this.arestasSaida = new ArrayList<Aresta<TIPO>>();
    }

    public TIPO getDado() {
        return dado;
    }

    public void setDado(TIPO dado) {
        this.dado = dado;
    }
    
    
    public void adicionarArestaSaida(Aresta<TIPO> aresta){
        this.arestasSaida.add(aresta);
    }


    public ArrayList<Aresta<TIPO>> getArestasSaida() {
        return arestasSaida;
    }
    
    
    
}
