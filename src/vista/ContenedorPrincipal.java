package vista;


import Eventos.SeleccionDireccionHandler;
import Eventos.SeleccionUpdateHandler;
import fiuba.algo3.aoe.Juego.Juego;
import fiuba.algo3.aoe.Jugadores.Jugador;
import fiuba.algo3.aoe.Ubicables.Direccion.DireccionDerecha;
import fiuba.algo3.aoe.Ubicables.Unidades.Aldeano;
import fiuba.algo3.aoe.Ubicables.posicion.Cuadrante.Cuadrante;
import javafx.geometry.Pos;
import javafx.scene.canvas.Canvas;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.Button;

import java.awt.*;
import java.util.ArrayList;

public class ContenedorPrincipal extends BorderPane {

    BarraDeMenu menuBar;
    public static MenuInferior menuInferior;
    TableroVistaControlador vistaTablero;
    public static Juego juego;  //OJO

    Canvas canvasCentral;

    
	public ContenedorPrincipal(Stage unStage, Juego unJuego){
        final VBox vbox1=new VBox(); VBox vbox2=new VBox();
        this.setMenu(unStage,vbox1);
        this.juego = unJuego;

        this.setTablero(unJuego); //dibuja el mapa
        this.setJugadores (unJuego.getJugadorUno(),unJuego.getJugadorDos(),vbox1,vbox2); // dibujar nombres en pantalla, obtener y presentar Piezas, suscribir observadores que tiene que ser la vista



         /*
           Falta
         juego.agregarobservadores (this)     // este me va a avisar cuando el juego termina


         */
        //XXSentinela juego.suscribir(vistaTablero);
	}



    //TODO
    private void setJugadores(Jugador jugadorUno, Jugador jugadorDos,VBox vbox1,VBox vbox2) {

    	JugadorVista vistaJugador1 = new JugadorVista(vbox1,jugadorUno);
    	JugadorVista vistaJugador2 = new JugadorVista(vbox2,jugadorDos);
    	
    	vistaJugador1.dibujarJugador();
    	vistaJugador2.dibujarJugador();
    	vistaJugador1.dibujarInfoTerreno();
    	vistaJugador2.dibujarInfoBonus();
    	this.setLeft(vbox1);
    	this.setRight(vbox2);
    	vbox1.setTranslateX(20);
    	vbox2.setTranslateX(-20);

    	this.actualizarPiezas(jugadorUno,jugadorDos);
    }

    private void actualizarPiezas (Jugador jugadorUno, Jugador jugadorDos){



        //XXSentinelavalue.suscribir(vistaTablero);  aca suscribis una vista al aldeano
       /*
    	for(Aldeano value: jugadorUno.getAldeanos()){
    		vistaTablero.ubicarAldeano(value,value.getPosicion().getX(),value.getPosicion().getY());
            //XXSentinelavalue.suscribir(vistaTablero);  aca suscribis una vista al aldeano
    	}
    	for(Aldeano value: jugadorDos.getAldeanos()){
    		vistaTablero.ubicarAldeano(value,value.getPosicion().getX(),value.getPosicion().getY());
            //XXSentinela  value.suscribir(vistaTablero);
    	}
    	*/
        for(Aldeano value: jugadorUno.getAldeanos()){
            ArrayList<Cuadrante> cuadrantes= value.getPosicion().getCasilleros();
            for (Cuadrante casilla : cuadrantes ) {
                vistaTablero.ubicarAldeano(value, casilla.getX(), casilla.getY());


            }

        }

        for(Aldeano value: jugadorDos.getAldeanos()){
            ArrayList<Cuadrante> cuadrantes= value.getPosicion().getCasilleros();
            for (Cuadrante casilla : cuadrantes ) {
                vistaTablero.ubicarAldeano(value, casilla.getX(), casilla.getY());


            }

        }


        /******************************************************************************************
         *            XXSentinela*/////////

        /*
        // poner los nombres de los jugadores en pantalla DONE
        // obtener los aldeanos de cada uno y ponerlos en pantalla DONE
        // jugador.getaldeanos..........
        // subscribir los observadores
        //  aldeanos.subscribirobservador
        */


    }
    private void actualizarTablero (){

        this.vistaTablero.dibujarTablero();

    }

    public void actualizarTodo (){

	    this.actualizarTablero();
	    this.actualizarPiezas(this.juego.getJugadorUno(),this.juego.getJugadorDos());
    }

    private void setTablero(Juego unJuego) {
		// TODO Auto-generated method stub
        GridPane grid=new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setGridLinesVisible(true);
        vistaTablero = new TableroVistaControlador(unJuego,grid);
         //esto lo cambie de orden
        this.actualizarTablero();
        this.setCenter(grid);

	}

	private void setMenu(Stage stage,VBox vbox1) {
        this.menuBar = new BarraDeMenu(stage);
        this.setTop(menuBar);
        
        this.menuInferior = new MenuInferior(stage);
    	this.setBottom(menuInferior);

    	// ojo aca quizas tengamos que tener un metodo en esta clase o en otra. "dibuajarBotones" algo asi
        //fijate que se estan dibujando los botones del tablero en dibajarTablero de TableroVistaControlador
        Button derechaButton = new Button ( "Derecha" );
        SeleccionDireccionHandler seleccionDireccionHandler = new SeleccionDireccionHandler(new DireccionDerecha());

        derechaButton.setOnMouseClicked(seleccionDireccionHandler);

        vbox1.getChildren ().add ( derechaButton );


        Button actualizarButton = new Button ( "Altualizar" );
        SeleccionUpdateHandler seleccionUpdateHandler = new SeleccionUpdateHandler(this);
        actualizarButton.setOnMouseClicked(seleccionUpdateHandler);
        vbox1.getChildren ().add ( actualizarButton );

    }

}
