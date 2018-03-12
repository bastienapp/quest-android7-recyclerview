package fr.wcs.blablawild;

import java.util.Locale;

/**
 * Created by bastienwcs on 06/03/18.
 */

public class VehicleCar extends VehicleAbstract {

    private int kilometers;

    public VehicleCar(String brand, String model, int kilometers) {
        setBrand(brand);
        setModel(model);
        this.kilometers = kilometers;
    }

    public int getKilometers() {
        return kilometers;
    }

    public void setKilometers(int kilometers) {
        this.kilometers = kilometers;
    }

    @Override
    String getDescription() {
        return String.format(Locale.ENGLISH,"%s, %s, %d", getBrand(), getModel(), getKilometers());
    }
}
