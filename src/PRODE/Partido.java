package PRODE;

public class Partido {
    private Equipo equipo1;
    private Equipo equipo2;
    private int goles1;
    private int goles2;
    private ResultadoEnum resultado;

    public Partido(Equipo e1, Equipo e2){
        equipo1=e1;
        equipo2=e2;
    }

    public void setGoles1(int goles1) {

        this.goles1 = goles1;
    }

    public void setGoles2(int goles2) {

        this.goles2 = goles2;
    }

    public void setResultado(){ //compara la cantidad de goles y establece el resultado como un enum
        if (goles1>goles2)
            resultado = ResultadoEnum.ganaEquipo1;
        else if (goles1<goles2)
            resultado = ResultadoEnum.ganaEquipo2;
        else
            resultado = ResultadoEnum.empate;
    }

    public ResultadoEnum getResultado() {
        return resultado;
    }

    public String getEquipo1() {
        return equipo1.getNombre();
    }

    public String getEquipo2() {
        return equipo2.getNombre();
    }
}

