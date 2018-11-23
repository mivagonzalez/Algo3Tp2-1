package fiuba.algo3.aoe.Ubicables.Unidades.EstadoUnidad.Aldeano;

import fiuba.algo3.aoe.Jugadores.Jugador;
import fiuba.algo3.aoe.Mapa.Mapa;
import fiuba.algo3.aoe.Ubicables.Direccion.Direccionable;
import fiuba.algo3.aoe.Ubicables.Edificios.Edificio;
import fiuba.algo3.aoe.Ubicables.Unidades.Aldeano;
import fiuba.algo3.aoe.Ubicables.Unidades.AldeanoOcupadoException;

public class EstadoReparando implements IEstadoUnidadAldeano {

//private Edificio edificioEnReparacion;

        public EstadoReparando(Aldeano aldeano, Edificio unEdificio){
            unEdificio.repararCon(aldeano);

        }

    @Override
    public void construir(Aldeano unAldeano, Edificio unEdificio) {
        throw new AldeanoOcupadoException();
    }

    @Override
    public void mover(Aldeano aldeano, Mapa mapa, Direccionable direccion) {
        throw new AldeanoOcupadoException();
    }

    @Override
    public boolean estasDisponible() {
        return false;
    }

/*
    @Override
    public Boolean podesMoverte() {
        return false;
    }
*/
    @Override
    public void reparar(Aldeano unidad, Edificio unEdificio) {
        throw new AldeanoOcupadoException();
    }


    @Override
    public void pasarTurno(Aldeano aldeano, Jugador unJugador){
        //no hacer nada
    }
}
