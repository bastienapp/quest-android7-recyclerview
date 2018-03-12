package fr.wcs.blablawild;

import java.util.Locale;

/**
 * Created by bastienwcs on 06/03/18.
 */

public class VehicleBoat extends VehicleAbstract {

    private int hours;

    public VehicleBoat(String brand, String model, int hours) {
        setBrand(brand);
        setModel(model);
        this.hours = hours;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    @Override
    String getDescription() {
        return String.format(Locale.ENGLISH,"%s, %s, %d", getBrand(), getModel(), getHours());
    }
}
