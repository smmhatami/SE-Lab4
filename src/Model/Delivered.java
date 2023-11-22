package Model;

public class Delivered implements PackState {
    private Pack pack;
    @Override
    public String tellState() {
        return "delivered";
    }

    @Override
    public Pack getPack() {
        return pack;
    }

    @Override
    public void setPack(Pack pack) {
        this.pack = pack;
    }

    @Override
    public void deliver() {
        pack.changeState(new Delivered());
    }
}
