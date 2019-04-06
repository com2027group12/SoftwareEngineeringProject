package com2027.toolbox.group12.toolbox;

import android.net.Uri;

import java.util.ArrayList;

/**
 * Author: Dennis Ocaka
 *
 * Created at: 03/04/2019
 * Updated at: 05/04/2019
 *
 * The class represents a Tool with all the definable parameters
 */
public class Tool {

    /* The ID of the tool */
    private long tool_ID;
    /* The ID of the owner of the tool */
    private long owner_ID;
    /* The Name of the tool */
    private String toolName;
    /* A description about the tool */
    private String description;
    /* Pay by: Hour, Day, Week*/
    private PayRate payRate;
    /* The price of the tool */
    private double price;
    /* The rating of the tool */
    private int rating;
    /* The listing status of the tool */
    private boolean available;
    /* An image of the tool */
    private Uri image_profile_picture;
    /* A list of all the images for a tool */
    private ArrayList<Uri> images;

    /*
     * Default constructor
     */
    public Tool(){
        super();
    }

    /*
     * Parameterized constructor used when a user adds a new tool to the system
     */
    public Tool(long owner_ID, String toolName, String description, double price, PayRate payRate, ArrayList<Uri> images){
        super();

        this.owner_ID = owner_ID;
        this.toolName = toolName;
        this.description = description;
        this.payRate = payRate;
        this.price = price;
        this.images = images;
    }

    /*
     * Overloaded Parameterized constructor used when displaying a tool in the list
     */
    public Tool(String toolName, PayRate payRate, double price, int rating, Uri image_profile_picture){
        super();

        this.toolName = toolName;
        this.payRate = payRate;
        this.price = price;
        this.rating = rating;
        this.image_profile_picture = image_profile_picture;
    }

    /* Getters for ALL defined Fields */

    public long getTool_ID() {
        return tool_ID;
    }

    public long getOwner_ID() {
        return owner_ID;
    }

    public String getToolName() {
        return toolName;
    }

    public String getDescription() {
        return description;
    }

    public PayRate getPayRate() { return payRate; }

    public double getPrice() {
        return price;
    }

    public int getRating() {
        return rating;
    }

    public boolean getAvailability() {
        return available;
    }


    public Uri getImage_profile_picture() {return image_profile_picture;}

    public ArrayList<Uri> getImages() { return  images; }


    /* Setters for All defined Fields Except ID's */

    public void setToolName(String toolName) {
        this.toolName = toolName;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public void setAvailability(boolean status) {
        this.available = status;
    }

    public void setImage_profile_picture(Uri image_profile_picture) {
        this.image_profile_picture = image_profile_picture;
    }

    public void setImages(ArrayList<Uri> images) {
        this.images = images;
    }
}
