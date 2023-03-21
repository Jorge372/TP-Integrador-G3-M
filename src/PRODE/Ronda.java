package PRODE;

import java.util.ArrayList;

public class Ronda {

    private ArrayList <Partido> partidos;
    private ArrayList <Pronostico> pronosticos;

    public Ronda (){
        partidos = new ArrayList<>();
        pronosticos = new ArrayList<>();
    }
    public void setEncuentro (Partido partido, Pronostico pronostico){
        partidos.add(partido);
        pronosticos.add(pronostico);
    }

    public int getPuntos(){
        int puntos=0;
        for (int i =0;i<partidos.size();i++){
            if (partidos.get(i).getResultado().equals(pronosticos.get(i).getResultado()))
                puntos++;
        }
        return puntos;
    }
}
