package Model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Outsourced extends Part {
    private final StringProperty companyName;

    public Outsourced(int id, String name, double price, int stock, int min, int max, String companyName) {
        super(id, name, price, stock, min, max);
        this.companyName = new SimpleStringProperty(companyName);
    }

    public String getCompanyName() {
        return companyName.get();
    }

    public void setCompanyName(String name) {
        this.companyName.set(name);
    }
}
