package fiuba.algo3.aoe.Ubicables.Unidades.UnidadMilitar;

import fiuba.algo3.aoe.Jugadores.Jugador;
import fiuba.algo3.aoe.Mapa.Mapa;
import fiuba.algo3.aoe.Ubicables.Direccion.Direccionable;
import fiuba.algo3.aoe.Ubicables.Unidades.EstadoUnidad.Militar.EstadoEsperandoParaAtacar;
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
        this.estadoUnidad = new EstadoEsperandoParaAtacar();
    }

    @Override
    public void huboUnCambioDeTurno(Jugador unJugador) {

    }
}
