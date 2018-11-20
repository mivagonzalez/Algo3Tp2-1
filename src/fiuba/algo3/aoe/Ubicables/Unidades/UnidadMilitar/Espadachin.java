package fiuba.algo3.aoe.Ubicables.Unidades.UnidadMilitar;

import fiuba.algo3.aoe.Jugadores.Jugador;
import fiuba.algo3.aoe.Mapa.Mapa;
import fiuba.algo3.aoe.Ubicables.Direccion.Direccionable;
import fiuba.algo3.aoe.Ubicables.Unidades.EstadoUnidad.Militar.EstadoLibre;
import fiuba.algo3.aoe.Ubicables.Unidades.UnidadMovilMilitar;
import fiuba.algo3.aoe.Ubicables.posicion.Posicion;

public class Espadachin extends UnidadMovilMilitar {

    public Espadachin(  ){

        this.vidaActual = 100;
        this.vidaMaxima = 100;
        this.costo = 50;
        this.danioEdificio = 15;
        this.danioUnidad = 25;
        this.distanciaAtaque = 1;
        this.estadoUnidad = new EstadoLibre();
    }

    @Override
    public void huboUnCambioDeTurno(Jugador unJugador) {

    }

    @Override  //TODO REVISAR ESTO POR QUE ESTA REPETIDO EN OTROS LADOS Y ALGO TENES QUE HACER SI NO SE PUEDE MOVER
    public void mover(Mapa mapa, Direccionable direccion) {
        Posicion destino = this.obtenerPosicionDeAvance(direccion);
        if (mapa.puedoColocar(destino,this.tamanio)) {
            mapa.moverElemento(this, destino);

        }
    }
}
