package fiuba.algo3.aoe.Ubicables.Unidades.EstadoUnidad.Aldeano;

import fiuba.algo3.aoe.Jugadores.Jugador;
import fiuba.algo3.aoe.Mapa.Mapa;
import fiuba.algo3.aoe.Ubicables.Direccion.Direccionable;
import fiuba.algo3.aoe.Ubicables.Edificios.Edificio;
import fiuba.algo3.aoe.Ubicables.Unidades.Aldeano;

public class EstadoReparando implements IEstadoUnidadAldeano {


    @Override
    public Edificio construir(Aldeano unAldeano, Edificio unEdificio) {
        return null; //TODO
    }

    @Override
    public Boolean puedoConstruirOReparar() {
        return false;
    }

    @Override
    public void mover(Aldeano aldeano, Mapa mapa, Direccionable direccion) {

    }



    @Override
    public Boolean podesMoverte() {
        return false;
    }

    @Override
    public void pasarTurno(Aldeano aldeano, Jugador unJugador){

    }
}
