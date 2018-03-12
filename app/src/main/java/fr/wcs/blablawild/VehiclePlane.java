package fr.wcs.blablawild;

import java.util.Locale;

/**
 * Created by bastienwcs on 06/03/18.
 */

public class VehiclePlane extends VehicleAbstract {

    private int speed;

    public VehiclePlane(String brand, String model, int speed) {
        setBrand(brand);
        setModel(model);
        this.speed = speed;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    @Override
    String getDescription() {
        return String.format(Locale.ENGLISH,"%s, %s, %d", getBrand(), getModel(), getSpeed());
    }
}
