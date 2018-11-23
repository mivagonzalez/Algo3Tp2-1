package fiuba.algo3.aoe.Ubicables.Unidades;

import fiuba.algo3.aoe.Jugadores.Manipulable;
import fiuba.algo3.aoe.Mapa.Mapa;
import fiuba.algo3.aoe.Ubicables.Atacante;
import fiuba.algo3.aoe.Ubicables.Direccion.Direccionable;
import fiuba.algo3.aoe.Ubicables.posicion.Posicion;

public abstract class UnidadMovil implements Manipulable {
    private final int TAMANIO = 1;
    protected Posicion posicion;
    protected int vidaMaxima;
    protected int costo;
    protected int vidaActual;
    protected int tamanio = TAMANIO;



    public int getVidaMaxima(){
        return this.vidaMaxima;
    }
    public int getVidaActual(){
        return this.vidaActual;
    }
    public void disminuirVida( int vida){
        this.vidaActual -= vida;
    }
    public void serAtacadoPor(Atacante unAtacante) {
        this.disminuirVida(unAtacante.getDanioUnidad());
    }

    public int getTamanio(){
        return this.tamanio;
    }

    public int getCosto(){
        return this.costo;
    }

    public Posicion getPosicion() {
        if (this.posicion==null){throw new UnidadSinPosicionException();}
        return this.posicion;
    }

    public void colocarEn(Posicion posicion){
        this.posicion = posicion;
    }

    public Posicion obtenerPosicionDeAvance( Direccionable direccionable ){

        return this.getPosicion().calcularPosicionSiguiente(direccionable);


    }



    //TODO si no se puede mover por que la posicion esta ocupada, deberia responder algo!
    public abstract  void mover(Mapa mapa, Direccionable direccion);

    public abstract  boolean estasDisponible();








}