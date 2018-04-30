package com.example.android.tourguideapp;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class RestaurantsFragment extends Fragment {

    @Override
    public void onStop() {
        super.onStop();
    }

    public RestaurantsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        //Root view
        View rootView = inflater.inflate(R.layout.info_list, container, false);

        //Context
        Context context = getActivity();

        // Create a list of elements
        final ArrayList<Element> elements = new ArrayList<Element>();
        elements.add(new Element(context.getString(R.string.top_things_name_kyokai_sushi), context.getString(R.string.top_things_description_kyokai_sushi), R.drawable.restaurants_kyokai_sushi_bar));
        elements.add(new Element(context.getString(R.string.top_things_name_na_winklu), context.getString(R.string.top_things_description_na_winklu), R.drawable.restaurants_na_winklu));
        elements.add(new Element(context.getString(R.string.top_things_name_ratuszova), context.getString(R.string.top_things_description_ratuszova), R.drawable.restaurants_ratuszova));
        elements.add(new Element(context.getString(R.string.top_things_name_pyra_bar), context.getString(R.string.top_things_description_pyra_bar), R.drawable.restaurants_pyra_bar));
        elements.add(new Element(context.getString(R.string.top_things_name_dark_restaurant), context.getString(R.string.top_things_description_dark_restaurant), R.drawable.restaurants_dark_restaurant));
        elements.add(new Element(context.getString(R.string.top_things_name_whiskey_in_the_jar), context.getString(R.string.top_things_description_whiskey_in_the_jar), R.drawable.restaurants_whiskey_in_the_jar));
        elements.add(new Element(context.getString(R.string.top_things_name_wiejskie_jadlo), context.getString(R.string.top_things_description_wiejskie_jadlo), R.drawable.restaurants_wiejskie_jadlo));
        elements.add(new Element(context.getString(R.string.top_things_name_manekin), context.getString(R.string.top_things_description_manekin), R.drawable.restaurants_manekin));
        elements.add(new Element(context.getString(R.string.top_things_name_zielona_weranda), context.getString(R.string.top_things_description_zielona_weranda), R.drawable.restaurants_zielona_weranda));

        // Create an {@link ElementAdapter}, whose data source is a list of {@link Element}s. The
        // adapter knows how to create list items for each item in the list.
        ElementAdapter adapter = new ElementAdapter(context, elements, R.color.category_restaurants);

        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // info_list.xml layout file.
        ListView listView = (ListView) rootView.findViewById(R.id.list);

        // Make the {@link ListView} use the {@link ElementAdapter} we created above, so that the
        // {@link ListView} will display list items for each {@link Element} in the list.
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                // Get the {@link Element} object at the given position the user clicked on
                Element element = elements.get(position);

                //Description
                View description = view.findViewById(R.id.description);

                // Creating the expand animation for the item
                ExpandAnimation expandAni = new ExpandAnimation(description, 500);

                // Start the animation on the description
                description.startAnimation(expandAni);
            }
        });

        return rootView;
    }
}