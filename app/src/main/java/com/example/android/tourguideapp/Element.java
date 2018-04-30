package com.example.android.tourguideapp;

/**
 * {@link Element} represents an element in the particular guide category
 * It contains a name, a description and an image for that element
 */
public class Element {

    /**
     * Element name
     */
    private String elementName;

    /**
     * Element description
     */
    private String elementDescription;

    /**
     * Constant value that represents no image was provided for this element
     */
    private static final int NO_IMAGE_PROVIDED = -1;

    /**
     * Image resource ID for the element
     */
    private int imageResourceId = NO_IMAGE_PROVIDED;

    /**
     * Create a new Element object.
     *
     * @param elementName        is the name of the element
     * @param elementDescription is the description of the element
     */
    public Element(String elementName, String elementDescription) {
        this.elementName = elementName;
        this.elementDescription = elementDescription;
    }

    /**
     * Create a new Element object.
     *
     * @param elementName        is the name of the element
     * @param elementDescription is the description of the element
     * @param imageResourceId    is the drawable resource ID for the image associated with the element
     */
    public Element(String elementName, String elementDescription, int imageResourceId) {
        this.elementName = elementName;
        this.elementDescription = elementDescription;
        this.imageResourceId = imageResourceId;
    }

    /**
     * Get the name of the element
     */
    public String getName() {
        return this.elementName;
    }

    /**
     * Get the description of the element
     */
    public String getDescription() {
        return this.elementDescription;
    }

    /**
     * Return the image resource ID of the element
     */
    public int getImageResourceId() {
        return this.imageResourceId;
    }

    /**
     * Returns whether or not there is an image for this element
     */
    public boolean hasImage() {
        return this.imageResourceId != NO_IMAGE_PROVIDED;
    }
}