package fr.ensim.dp.map.player;

public class StateForward implements IStatePlayer{
    @Override
    public void play(IPlayer player) {
        new IllegalStateException();
    }

    @Override
    public void stop(IPlayer player) {
        player.firechangeState(new StateStop());
    }

    @Override
    public void pause(IPlayer player) {
        new IllegalStateException();
    }

    @Override
    public void forward(IPlayer player) {
        new IllegalStateException();
    }

    @Override
    public void backward(IPlayer player) {
        player.firechangeState(new StateBackward());
    }
}
