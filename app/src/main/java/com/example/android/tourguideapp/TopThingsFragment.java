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
public class TopThingsFragment extends Fragment {

    @Override
    public void onStop() {
        super.onStop();
    }

    public TopThingsFragment() {
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
        elements.add(new Element(context.getString(R.string.top_things_name_fighting_goats), context.getString(R.string.top_things_description_fighting_goats), R.drawable.top_things_fighting_goats));
        elements.add(new Element(context.getString(R.string.top_things_name_fara), context.getString(R.string.top_things_description_fara), R.drawable.top_things_fara_church));
        elements.add(new Element(context.getString(R.string.top_things_name_old_market_square), context.getString(R.string.top_things_description_old_market_square), R.drawable.top_things_old_market_square));
        elements.add(new Element(context.getString(R.string.top_things_name_porta_posnania), context.getString(R.string.top_things_description_porta_posnania), R.drawable.top_things_porta_posnania));
        elements.add(new Element(context.getString(R.string.top_things_name_botanical_gardens), context.getString(R.string.top_things_description_botanical_gardens), R.drawable.top_things_botanical_gardens));
        elements.add(new Element(context.getString(R.string.top_things_name_malta_lake), context.getString(R.string.top_things_description_malta_lake), R.drawable.top_things_malta_lake));
        elements.add(new Element(context.getString(R.string.top_things_name_cathedral), context.getString(R.string.top_things_description_cathedral), R.drawable.top_things_cathedral));
        elements.add(new Element(context.getString(R.string.top_things_name_palm_house), context.getString(R.string.top_things_description_palm_house), R.drawable.top_things_palm_house));
        elements.add(new Element(context.getString(R.string.top_things_name_lech_brewery_tour), context.getString(R.string.top_things_description_lech_brewery_tour), R.drawable.top_things_lech_brewery_tour));
        elements.add(new Element(context.getString(R.string.top_things_name_maltese_thermas), context.getString(R.string.top_things_description_maltese_thermas), R.drawable.top_things_maltese_thermas));
        elements.add(new Element(context.getString(R.string.top_things_name_new_zoo), context.getString(R.string.top_things_description_new_zoo), R.drawable.top_things_new_zoo));

        // Create an {@link ElementAdapter}, whose data source is a list of {@link Element}s. The
        // adapter knows how to create list items for each item in the list.
        ElementAdapter adapter = new ElementAdapter(context, elements, R.color.category_top_things);

        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // info_list.xml layout file.
        ListView listView = (ListView) rootView.findViewById(R.id.list);

        // Make the {@link ListView} use the {@link ElementAdapter} we created above, so that the
        // {@link ListView} will display list items for each {@link Element} in the list.
        listView.setAdapter(adapter);

        // Set a click listener to expand the list item if it is clicked
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