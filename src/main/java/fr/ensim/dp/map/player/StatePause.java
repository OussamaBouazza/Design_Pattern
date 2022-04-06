package fr.ensim.dp.map.player;

public class StatePause implements IStatePlayer{
    @Override
    public void play(IPlayer player) {
        player.firechangeState(new StatePlay());
    }

    @Override
    public void stop(IPlayer player) {
        new IllegalStateException();
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
        new IllegalStateException();
    }
}
