package fr.wcs.blablawild;

import java.util.Date;

/**
 * Created by bastienwcs on 12/03/18.
 */

public class ItineraryModel {

    private String departure;
    private String destination;
    private String firstname;
    private String lastname;
    private Date date;
    private int price;

    public ItineraryModel(String departure, String destination, String firstname, String lastname, Date date, int price) {
        this.departure = departure;
        this.destination = destination;
        this.firstname = firstname;
        this.lastname = lastname;
        this.date = date;
        this.price = price;
    }

    public String getDeparture() {
        return departure;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}