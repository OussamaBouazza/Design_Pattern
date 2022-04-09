package fr.ensim.dp.map.player;

import junit.framework.TestCase;
import org.junit.jupiter.api.Assertions;


public class PlayerTest extends TestCase {
    Player player = new Player();

    //teste toute les combinaisons pour l'état play
    public void testPlay() {
        player.firechangeState(new StatePlay());        //initialise le player à l'état "play"
        Assertions.assertThrows(IllegalStateException.class, ()-> player.play());

        player.pause();
        Assertions.assertInstanceOf(StatePause.class, player.getState());

        player.play();      //remet l'état du player à play
        player.stop();
        Assertions.assertInstanceOf(StateStop.class, player.getState());

        player.play();      //remet l'état du player à play
        player.backward();
        Assertions.assertInstanceOf(StateBackward.class, player.getState());

        player.firechangeState(new StatePlay());    //remet l'état du player à play
        player.forward();
        Assertions.assertInstanceOf(StateForward.class, player.getState());

    }


    //teste toute les combinaisons pour l'état stop
    public void testStop() {
        player.firechangeState(new StateStop());

        Assertions.assertThrows(IllegalStateException.class, ()-> player.stop());
        Assertions.assertThrows(IllegalStateException.class, ()-> player.forward());
        Assertions.assertThrows(IllegalStateException.class, ()-> player.backward());
        Assertions.assertThrows(IllegalStateException.class, ()-> player.pause());

        player.play();
        Assertions.assertInstanceOf(StatePlay.class, player.getState());
    }

    //teste toute les combinaisons pour l'état pause
    public void testPause() {
        player.firechangeState(new StatePause());   //initialise le player à l'état "pause"

        player.play();
        Assertions.assertInstanceOf(StatePlay.class, player.getState());

        player.pause();     //remet à l'état "pause"
        Assertions.assertThrows(IllegalStateException.class, ()-> player.pause());
        Assertions.assertThrows(IllegalStateException.class, ()-> player.stop());
        Assertions.assertThrows(IllegalStateException.class, ()-> player.forward());
        Assertions.assertThrows(IllegalStateException.class, ()-> player.backward());
    }

    //teste toute les combinaisons pour l'état forward
    public void testForward() {
        player.firechangeState(new StateForward()); //initialise le player à l'état "forward"

        player.backward();
        Assertions.assertInstanceOf(StateBackward.class, player.getState());

        player.forward();       //remet à l'état "forward"
        player.stop();
        Assertions.assertInstanceOf(StateStop.class, player.getState());

        player.firechangeState(new StateForward());     //remet à l'état "forward"
        Assertions.assertThrows(IllegalStateException.class, ()-> player.play());
        Assertions.assertThrows(IllegalStateException.class, ()-> player.pause());
        Assertions.assertThrows(IllegalStateException.class, ()-> player.forward());


    }

    //teste toute les combinaisons pour l'état backward
    public void testBackward() {
        player.firechangeState(new StateBackward());        //initialise le player à l'état "backward"

        player.forward();
        Assertions.assertInstanceOf(StateForward.class, player.getState());

        player.backward();      //remet à l'état "backward"
        player.stop();
        Assertions.assertInstanceOf(StateStop.class, player.getState());

        player.firechangeState(new StateBackward());        //remet à l'état "backward"
        Assertions.assertThrows(IllegalStateException.class, ()-> player.play());
        Assertions.assertThrows(IllegalStateException.class, ()-> player.pause());
        Assertions.assertThrows(IllegalStateException.class, ()-> player.backward());

    }

    //teste la fonction permettant de changer l'état du player
    public void testFirechangeState() {
       player.firechangeState(new StateStop());
       Assertions.assertInstanceOf(StateStop.class, player.getState());

       player.firechangeState(new StatePause());
       Assertions.assertInstanceOf(StatePause.class, player.getState());

        player.firechangeState(new StatePlay());
        Assertions.assertInstanceOf(StatePlay.class, player.getState());

        player.firechangeState(new StateForward());
        Assertions.assertInstanceOf(StateForward.class, player.getState());

        player.firechangeState(new StateBackward());
        Assertions.assertInstanceOf(StateBackward.class, player.getState());
    }
}