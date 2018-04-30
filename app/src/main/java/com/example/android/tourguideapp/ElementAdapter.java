package com.example.android.tourguideapp;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * {@link ElementAdapter} is an {@link ArrayAdapter} that can provide the layout for each list item
 * based on a data source, which is a list of {@link Element} objects.
 */
public class ElementAdapter extends ArrayAdapter<Element> {

    /**
     * Resource ID for the background color for this list of elements
     */
    private int colorResourceId;

    /**
     * Create a new {@link ElementAdapter} object.
     *
     * @param context         is the current context (i.e. Activity) that the adapter is being created in.
     * @param elements        is the list of {@link Element}s to be displayed.
     * @param colorResourceId is the resource ID for the background color for this list of elements
     */
    public ElementAdapter(Context context, ArrayList<Element> elements, int colorResourceId) {
        super(context, 0, elements);
        this.colorResourceId = colorResourceId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if an existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        // Get the {@link Element} object located at this position in the list
        Element currentElement = getItem(position);

        // Find the TextView in the list_item.xml layout with the ID of the name text view.
        TextView nameTextView = (TextView) listItemView.findViewById(R.id.name);
        // Get the name from the currentElement object and set this text on
        // the name TextView.
        nameTextView.setText(currentElement.getName());

        // Find the TextView in the list_item.xml layout with the ID of the description text view.
        TextView descriptionView = (TextView) listItemView.findViewById(R.id.description);
        // Get the description from the currentElement object and set this text on
        // the description TextView.
        descriptionView.setText(currentElement.getDescription());

        // Find the ImageView in the list_item.xml layout with the ID of image.
        ImageView imageView = (ImageView) listItemView.findViewById(R.id.image);
        // Check if an image is provided for this element or not
        if (currentElement.hasImage()) {
            // If an image is available, display the provided image based on the resource ID
            imageView.setImageResource(currentElement.getImageResourceId());
            // Make sure the view is visible
            imageView.setVisibility(View.VISIBLE);
        } else {
            // Otherwise hide the ImageView (set visibility to GONE)
            imageView.setVisibility(View.GONE);
        }

        // Set the theme color for the list item
        View listItem = listItemView.findViewById(R.id.list_item);
        // Find the color that the resource ID maps to
        int color = ContextCompat.getColor(getContext(), this.colorResourceId);
        // Set the background color of the list item View
        listItem.setBackgroundColor(color);

        // Return the whole list item layout (containing 2 TextViews) so that it can be shown in
        // the ListView.
        return listItemView;
    }
}