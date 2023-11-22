package Model;

public class Pack {

    private String name;
    private int weight;
    private PackState state;

    public Pack(String name, int weight, PackState initialState) {
        this.name = name;
        this.weight = weight;
        this.state = initialState;
    }

    public int getWeight() {
        return weight;
    }

    public String tellState() {
        return state.tellState();
    }

    public String getName() {
        return name;
    }

    public void changeState(PackState state) {
        this.state = state;
    }

    public void deliver() {
        state.deliver();
    }
}
