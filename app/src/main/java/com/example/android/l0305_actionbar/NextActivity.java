package com.example.android.l0305_actionbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class NextActivity extends AppCompatActivity {

    // Holds the current level of this activity
    private int level;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next);

        // Get this activity level from the incoming Intent.
        level = getIntent().getIntExtra(Utils.LEVEL, Utils.DEFAULT_LEVEL);

        // Set the title of the activity according to its level
        setTitle(getString(R.string.level, level));
    }

    /*
        This method is executed when the activity is created to populate the ActionBar with actions
    */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Generate the Menu object from the XML resource file
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    /*
        This method is executed when any action from the ActionBar is selected
    */
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        // Determine the action to take place according to the Id of the action selected
        switch (item.getItemId()) {

            // Launch the activity for the next level
            case R.id.mNext:
                // Generate the required Intent
                final Intent intent =
                        new Intent(NextActivity.this, NextActivity.class);
                // Add level+1 as parameter
                intent.putExtra(Utils.LEVEL, level + 1);
                // Start the new activity
                startActivity(intent);
                return true;

            // Show a message displaying the current level
            case R.id.mWhere:
                Toast.makeText(
                        NextActivity.this,
                        getString(R.string.here, level),
                        Toast.LENGTH_SHORT).show();
                return true;

        }
        // If none of the custom actions was selected, let the system deal with it
        return super.onOptionsItemSelected(item);
    }
}
