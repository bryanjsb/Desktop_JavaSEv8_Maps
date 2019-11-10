package logica.repartidor;

import logica.graphs.Floyd.camino;

public class repartidor {

    String identificador;
    camino caminoRepartidor;

    public repartidor(String identificador, camino caminoRepartidor) {
        this.identificador = identificador;
        this.caminoRepartidor = caminoRepartidor;
    }

    public repartidor() {
        this.identificador = "";
        this.caminoRepartidor = new camino();
    }

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public camino getCaminoRepartidor() {
        return caminoRepartidor;
    }

    public void setCaminoRepartidor(camino caminoRepartidor) {
        this.caminoRepartidor = caminoRepartidor;
    }

    @Override
    public String toString() {
        return "repartidor{" + "identificador=" + identificador + ", caminoRepartidor=" + caminoRepartidor + '}';
    }

}
