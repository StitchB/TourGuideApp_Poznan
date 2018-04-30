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
public class MuseumsFragment extends Fragment {

    @Override
    public void onStop() {
        super.onStop();
    }

    public MuseumsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        //Root view
        View rootView = inflater.inflate(R.layout.info_list, container, false);

        //Context
        Context context = getActivity();

        // Create a list of guide elements
        final ArrayList<Element> elements = new ArrayList<Element>();
        elements.add(new Element(context.getString(R.string.top_things_name_national_museum), context.getString(R.string.top_things_description_national_museum), R.drawable.museums_national_museum));
        elements.add(new Element(context.getString(R.string.top_things_name_archaeological_museum), context.getString(R.string.top_things_description_archaeological_museum), R.drawable.museums_archaeological_museum));
        elements.add(new Element(context.getString(R.string.top_things_name_museum_of_musical_instruments), context.getString(R.string.top_things_description_museum_of_musical_instruments), R.drawable.museums_museum_of_musical_instruments));
        elements.add(new Element(context.getString(R.string.top_things_name_genius_loci), context.getString(R.string.top_things_description_genius_loci), R.drawable.museums_genius_loci_archaeological_park));
        elements.add(new Element(context.getString(R.string.top_things_name_historical_museum), context.getString(R.string.top_things_description_historical_museum), R.drawable.museums_historical_museum));
        elements.add(new Element(context.getString(R.string.top_things_name_armored_weaponry_museum), context.getString(R.string.top_things_description_armored_weaponry_museum), R.drawable.museums_armored_weaponry_museum));

        // Create an {@link ElementAdapter}, whose data source is a list of {@link Element}s. The
        // adapter knows how to create list items for each item in the list.
        ElementAdapter adapter = new ElementAdapter(context, elements, R.color.category_museums);

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