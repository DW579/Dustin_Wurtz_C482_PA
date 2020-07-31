package Model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class InHouse extends Part {
    private final IntegerProperty machineId;

    public InHouse(int id, String name, double price, int stock, int min, int max, int machineId) {
        super(id, name, price, stock, min, max);
        this.machineId = new SimpleIntegerProperty(machineId);
    }

    public int getMachineId() {
        return machineId.get();
    }

    public void setMachineId(int id) {
        this.machineId.set(id);
    }
}
