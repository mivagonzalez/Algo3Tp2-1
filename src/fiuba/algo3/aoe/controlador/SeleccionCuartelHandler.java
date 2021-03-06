package fiuba.algo3.aoe.controlador;

import fiuba.algo3.aoe.modelo.Ubicables.Edificios.Cuartel;
import fiuba.algo3.aoe.modelo.Ubicables.posicion.Cuadrante.Cuadrante;
import fiuba.algo3.aoe.modelo.Ubicables.posicion.Posicion;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import fiuba.algo3.aoe.vista.ContenedorPrincipal;
import fiuba.algo3.aoe.vista.MapaVistaControlador;
import fiuba.algo3.aoe.vista.MenuInferior;

public class SeleccionCuartelHandler implements EventHandler<MouseEvent> {
    private Cuartel cuartel;

    public SeleccionCuartelHandler(Cuartel cuartel){this.cuartel=cuartel;}

    public void handle(MouseEvent event) {
        MouseButton button = event.getButton();
        if (button == MouseButton.SECONDARY) { //Observar
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Observar Cuartel");
            Posicion posicion = cuartel.getPosicion();
            String casillerosOcupados = "Posicion ocupada por casilleros: \n";
            for (Cuadrante cuadrante : posicion.getCasilleros()) {
                casillerosOcupados += "Casillero: (X: " + cuadrante.getX() + " Y:" + cuadrante.getY() + " )\n";
            }
            alert.setHeaderText("Cuartel ");
            alert.setContentText(casillerosOcupados +
                    "Vida actual: " + cuartel.getVidaActual() + "\nCosto: " + cuartel.getCosto());
            alert.showAndWait();
        }else if ("Mover" == MenuInferior.getSelecOpciones().getSelectionModel().getSelectedItem().toString()) {

            MenuInferior.getLog().appendText("\nCuartel no puede moverse");
        }else if ("Crear Edificio" == MenuInferior.getSelecOpciones().getSelectionModel().getSelectedItem().toString()) {

            MenuInferior.getLog().appendText("\nCuartel ya esta creado");
        }else if("Crear Unidad" == MenuInferior.getSelecOpciones().getSelectionModel().getSelectedItem().toString()){
            MapaVistaControlador.seleccionarCuartel(cuartel);
            MenuInferior.getLog().appendText("\nCuartel Seleccionado");
        }else if("Atacar" == MenuInferior.getSelecOpciones().getSelectionModel().getSelectedItem().toString()){
            if(!MapaVistaControlador.tengoAlgunaUnidadSeleccionada()){
                MenuInferior.getLog().appendText("\n Primero seleccione una unidad Atacante y luego el blanco nuevamente");
                MapaVistaControlador.desSeleccionarEdificio();
                MapaVistaControlador.desSeleccionarUnidades();
            }else if(MapaVistaControlador.tengoAldeanoSeleccionado()){
                MenuInferior.getLog().appendText("\n Aldeano no puede atacar, seleccione blanco y atacante nuevamente");
                MapaVistaControlador.desSeleccionarEdificio();
                MapaVistaControlador.desSeleccionarUnidades();
            }else if (MapaVistaControlador.tengoEspadachinSeleccionado() && ContenedorPrincipal.getJuego().getJugadorActual().esMio(MapaVistaControlador.getEspadachinSeleccionado()) &&
                    !ContenedorPrincipal.getJuego().getJugadorActual().esMio(cuartel) && MapaVistaControlador.getEspadachinSeleccionado().getPosicion().distancia(cuartel.getPosicion()) < 2 && MapaVistaControlador.getEspadachinSeleccionado().estasDisponible()){
                MenuInferior.getLog().appendText("\n Atacando cuartel con espadachin");
                MapaVistaControlador.getEspadachinSeleccionado().atacar(cuartel, ContenedorPrincipal.getJuego().getJugadorActual(),ContenedorPrincipal.getJuego().getJugadorInactivo(),MapaVistaControlador.getMapa());
                MapaVistaControlador.desSeleccionarEdificio();
                MapaVistaControlador.desSeleccionarUnidades();

            }else if (MapaVistaControlador.tengoArqueroSeleccionado() && ContenedorPrincipal.getJuego().getJugadorActual().esMio(MapaVistaControlador.getArqueroSeleccionado()) &&
                    !ContenedorPrincipal.getJuego().getJugadorActual().esMio(cuartel) && MapaVistaControlador.getArqueroSeleccionado().getPosicion().distancia(cuartel.getPosicion()) < 4 && MapaVistaControlador.getArqueroSeleccionado().estasDisponible()){
                MenuInferior.getLog().appendText("\n Atacando cuartel con arquero");
                MapaVistaControlador.getArqueroSeleccionado().atacar(cuartel, ContenedorPrincipal.getJuego().getJugadorActual(),ContenedorPrincipal.getJuego().getJugadorInactivo(),MapaVistaControlador.getMapa());
                MapaVistaControlador.desSeleccionarEdificio();
                MapaVistaControlador.desSeleccionarUnidades();
            }else{
                MenuInferior.getLog().appendText("\nEl blanco seleccionado no puede ser atacado por esta Unidad, seleccione nuevamente atacante y blanco");
                MapaVistaControlador.desSeleccionarEdificio();
                MapaVistaControlador.desSeleccionarUnidades();
            }
        }else if("Reparar" == MenuInferior.getSelecOpciones().getSelectionModel().getSelectedItem().toString()){
            if(!MapaVistaControlador.tengoAldeanoSeleccionado()){
                MenuInferior.getLog().appendText("\n Primero debe seleccionar el aldeano para reparar,realice nuevamente la seleccion de unidad y edificio");
                MapaVistaControlador.desSeleccionarEdificio();
                MapaVistaControlador.desSeleccionarUnidades();
            }else if(MapaVistaControlador.tengoAldeanoSeleccionado() && !ContenedorPrincipal.getJuego().getJugadorActual().esMio(MapaVistaControlador.getAldeanoSeleccionado())){
                MenuInferior.getLog().appendText("\nEl aldeano seleccionado no es tuyo");
                MapaVistaControlador.desSeleccionarEdificio();
                MapaVistaControlador.desSeleccionarUnidades();
            }else if(MapaVistaControlador.tengoAldeanoSeleccionado() && !ContenedorPrincipal.getJuego().getJugadorActual().esMio(cuartel) && ContenedorPrincipal.getJuego().getJugadorActual().esMio(MapaVistaControlador.getAldeanoSeleccionado())){
                MenuInferior.getLog().appendText("\nEl cuartel seleccionada no es tuya");
                MapaVistaControlador.desSeleccionarEdificio();
                MapaVistaControlador.desSeleccionarUnidades();
            }else if(MapaVistaControlador.tengoAldeanoSeleccionado() && ContenedorPrincipal.getJuego().getJugadorActual().esMio(cuartel) && ContenedorPrincipal.getJuego().getJugadorActual().esMio(MapaVistaControlador.getAldeanoSeleccionado())){
                if(!MapaVistaControlador.getAldeanoSeleccionado().estasDisponible()){
                    MenuInferior.getLog().appendText("\nEl aldeano seleccionado esta ocupado este turno,repita seleccion");
                    MapaVistaControlador.desSeleccionarEdificio();
                    MapaVistaControlador.desSeleccionarUnidades();
                }else{
                    MapaVistaControlador.getAldeanoSeleccionado().reparar(cuartel,ContenedorPrincipal.getJuego().getJugadorActual());
                    MenuInferior.getLog().appendText("\nReparando cuartel");
                }
            }
        }else{
            MenuInferior.getLog().appendText("\n Elija una accion, y las piezas correctas nuevamente");
            MapaVistaControlador.desSeleccionarEdificio();
            MapaVistaControlador.desSeleccionarUnidades();
            MapaVistaControlador.desSeleccionarUnidadParaCrear();
            MapaVistaControlador.desSeleccionarPosicion();
        }

    }
}
