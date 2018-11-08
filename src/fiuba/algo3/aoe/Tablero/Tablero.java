package fiuba.algo3.aoe.Tablero;


import Ubicables.Unidades.movimiento.Direccion;
import fiuba.algo3.aoe.Ubicable.Ubicable;

import java.util.*;


public class Tablero {

    private ArrayList<Ubicable> tablero;

    private int ancho;
    private int alto;


    public Tablero (int anchoMaximo, int altoMaximo){

        //TODO validar el tamanio minimo, negativos, etc
      tablero = new ArrayList<>();
      ancho = anchoMaximo;
      alto = altoMaximo;
     // this.inicializarTablero ();

    }

    public boolean puerdoColocar (Posicion unaPosicion){return false;}
    public void colocar (Ubicable unElemento){}
    public void remover (Posicion unaPosicion) {}
    public void mover (Posicion origen, Direccion direccion){}

/*
    private void inicializarTablero (){

        tablero = new HashMap<>(ancho*alto);
        Casillero unaCasillero;
        Posicion unCasillero;

        for (int i = 1; i <= this.ancho; ++i) {

            for (int j = 1; j <= this.alto; ++j) {
                unaCasillero = new Casillero(i,j);
                unCasillero = new Posicion();

                tablero.put(unaCasillero,unCasillero);

                //System.out.println(i+","+j);
            }
        }
    }


    private boolean existeCasillero (Casillero unaPosicion){
        return tablero.containsKey(unaPosicion);
    }

    private Posicion getCasillero (Casillero unaPosicion)
    {
        if ( !existeCasillero(unaPosicion)) {throw new FueraDeTableroException();}
        return tablero.get(unaPosicion);
    }

    public void agregar(Ubicable unObjeto, Casillero posicion, Dimension unTamanio) {

      Posicion casillero = this.getCasillero(posicion);
      casillero.colocar(unObjeto);

    }

    public Boolean puedoColocar(Casillero unaPosicion, Dimension tamanioObjeto) {

        if (this.existeCasillero(unaPosicion)){
            return  this.getCasillero(unaPosicion).estaVacio();
        }
        return false;
    }


    private Ubicable sacar(Casillero unaPosicion, Dimension tamanioObjeto) {

        return this.getCasillero(unaPosicion).quitar();
    }

    public void retirar(Casillero unaPosicion, Dimension tamanioObjeto) {

        sacar(unaPosicion, tamanioObjeto);
    }

    //esto antes de sacar tiene que ver si va a poder colocar
    public void mover(Casillero posicionOrigen, Casillero posicionDestino) {

        Dimension tamanio = new Dimension(1,1);

        Ubicable elemento = sacar(posicionOrigen,tamanio);
        agregar(elemento,posicionDestino,tamanio);

    }
    */
}
