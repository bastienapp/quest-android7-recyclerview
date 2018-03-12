package fr.wcs.blablawild;

/**
 * Created by bastienwcs on 06/03/18.
 */

abstract class VehicleAbstract {

    private String brand;
    private String model;

    String getBrand() {
        return brand;
    }

    void setBrand(String brand) {
        this.brand = brand;
    }

    String getModel() {
        return model;
    }

    void setModel(String model) {
        this.model = model;
    }

    abstract String getDescription();
}
