package fr.ensim.dp.map.player;

import junit.framework.TestCase;

public class PlayerTest extends TestCase {
    Player player = new Player();

    public void testPlay() {
        player.firechangeState(new StatePlay());


    }

    public void testStop() {
        player.firechangeState(new StateStop());
        assertEquals(StatePlay, player.);
    }

    public void testPause() {
        player.firechangeState(new StatePause());
    }

    public void testForward() {
        player.firechangeState(new StateForward());
    }

    public void testBackward() {
        player.firechangeState(new StateBackward());
    }

    public void testFirechangeState() {
//        player.firechangeState(new ());
    }
}