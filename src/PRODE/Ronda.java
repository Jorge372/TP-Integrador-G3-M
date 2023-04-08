package PRODE;

import java.util.ArrayList;

public class Ronda {

    private ArrayList <Partido> partidos;

    public Ronda (){
        partidos = new ArrayList<>();
    }

    public void setPartidos(ArrayList<Partido> partidos) {
        this.partidos = partidos;
    }

    //le pasamos como parametro la lista de los pronosticos de la persona y va comparando los resultados de cada uno de los partidos por medio de los enum
    public int getPuntos(ArrayList<Pronostico> pronosticos){
        int puntos=0;
        for (int i =0;i<partidos.size();i++){
            if (partidos.get(i).getResultado().equals(pronosticos.get(i).getResultado()))
                puntos++;
        }
        return puntos;
    }
}
