package edu.orangecoastcollege.cs273.dtran258.ocmusicevents;

import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;

/**
 * This activity displays information about an artist and the event he/she is performing at. The
 * information is specified by which list item was clicked in <code>EventsListActivity</code>.
 *
 * @author Derek Tran
 * @version 1.0
 * @since September 21, 2017
 */
public class EventDetailsActivity extends AppCompatActivity
{

    /**
     * Initializes <code>EventDetailsActivity</code> by inflating its UI.
     *
     * @param savedInstanceState Bundle containing the data it recently supplied in
     *                           onSaveInstanceState(Bundle) if activity was reinitialized after
     *                           being previously shut down. Otherwise it is null.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_details);

        // Get the data out of the Intent
        Intent intent = getIntent();
        String title = intent.getStringExtra("title");
        String details = intent.getStringExtra("details");

        // Create references to the text views
        TextView titleTextView = (TextView) findViewById(R.id.eventTitleTextView);
        TextView detailsTextView = (TextView) findViewById(R.id.eventDetailsTextView);
        ImageView eventImageView = (ImageView) findViewById(R.id.eventImageView);

        // Set the text of the text views
        titleTextView.setText(title);
        detailsTextView.setText(details);

        // Use the Asset Manager to retrieve a file (image)
        AssetManager am = getAssets();
        String imageFileName = title.replace(" ", "") + ".jpeg";
        // Use AssetManager to open a stream to the file name
        try
        {
            InputStream stream = am.open(imageFileName);
            Drawable image = Drawable.createFromStream(stream, title);
            eventImageView.setImageDrawable(image);
        }
        catch (IOException e)
        {
            Log.e("OC Music Events", "Error loading image: " + imageFileName);
        }

    }

    /**
     * Terminates this activity and returns to <code>EventsListActivity</code>.
     * @param v The <code>View</code> that called this method.
     */
    public void goBackToList(View v)
    {
        // Terminates the current activity (terminates the details activity)
        finish();
    }
}
