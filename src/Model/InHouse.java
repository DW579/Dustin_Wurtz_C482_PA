package Model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class InHouse extends Part {
    // Original code
//    private int machineId;
//
//    public InHouse(int id, String name, double price, int stock, int min, int max, int machineId) {
//        super(id, name, price, stock, min, max);
//
//        this.machineId = machineId;
//    }
//
//    public int getMachineId() {
//
//        return machineId;
//    }
//
//    public void setMachineId(int machineId) {
//
//        this.machineId = machineId;
//    }

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
