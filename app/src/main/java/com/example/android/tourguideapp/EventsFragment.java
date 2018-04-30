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
public class EventsFragment extends Fragment {

    @Override
    public void onStop() {
        super.onStop();
    }

    public EventsFragment() {
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
        elements.add(new Element(context.getString(R.string.top_things_name_night_of_museums), context.getString(R.string.top_things_description_night_of_museums), R.drawable.events_night_of_museums));
        elements.add(new Element(context.getString(R.string.top_things_name_air_show), context.getString(R.string.top_things_description_air_show), R.drawable.events_air_show));
        elements.add(new Element(context.getString(R.string.top_things_name_poznan_motor_show), context.getString(R.string.top_things_description_poznan_motor_show), R.drawable.events_poznan_motor_show));
        elements.add(new Element(context.getString(R.string.top_things_name_pyrkon), context.getString(R.string.top_things_description_pyrkon), R.drawable.events_pyrkon));
        elements.add(new Element(context.getString(R.string.top_things_name_cavaliada), context.getString(R.string.top_things_description_cavaliada), R.drawable.events_cavaliada));
        elements.add(new Element(context.getString(R.string.top_things_name_poznan_game_arena), context.getString(R.string.top_things_description_poznan_game_arena), R.drawable.events_poznan_game_arena));

        // Create an {@link ElementAdapter}, whose data source is a list of {@link Element}s. The
        // adapter knows how to create list items for each item in the list.
        ElementAdapter adapter = new ElementAdapter(context, elements, R.color.category_events);

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