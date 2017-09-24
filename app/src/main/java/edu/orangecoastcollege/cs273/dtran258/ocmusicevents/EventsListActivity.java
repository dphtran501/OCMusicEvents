package edu.orangecoastcollege.cs273.dtran258.ocmusicevents;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * This activity displays a list of musical artists who will perform at music events in Orange
 * County. Clicking on a list item will launch <code>EventDetailsActivity</code>, which will display
 * information about the event performed by the musical artist in the list item clicked.
 *
 * @author Derek Tran
 * @version 1.0
 * @since September 21, 2017
 */
public class EventsListActivity extends ListActivity
{

    /**
     * Initializes <code>EventListActivity</code> by inflating its UI.
     *
     * @param savedInstanceState Bundle containing the data it recently supplied in
     *                           onSaveInstanceState(Bundle) if activity was reinitialized after
     *                           being previously shut down. Otherwise it is null.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        // Content has already been set for ListActivity
        //setContentView(R.layout.activity_events_list);

        // Define a built-in list adaptor for this ListActivity:
        setListAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, MusicEvent.titles));
    }

    /**
     * Launches <code>EventDetailsActivity</code> when list item is clicked. Information about
     * artist and event corresponding to list item that was clicked will be sent to aforementioned
     * activity.
     * @param l The <code>ListView</code> where the click happened.
     * @param v The <code>View</code> that was clicked within the <code>ListView</code>.
     * @param position The position of the <code>View</code> in the list.
     * @param id The row id of the item that was clicked.
     */
    @Override
    protected void onListItemClick(ListView l, View v, int position, long id)
    {
        // Use the position in the list to look up in the titles array
        String title = MusicEvent.titles[position];
        String details = MusicEvent.details[position];

        // Create an Intent to go to the DetailsActivity with title and details sent
        Intent detailsIntent = new Intent(this, EventDetailsActivity.class);
        detailsIntent.putExtra("title", title);
        detailsIntent.putExtra("details", details);
        startActivity(detailsIntent);
    }
}
