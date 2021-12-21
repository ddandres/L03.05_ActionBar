/*
 * Copyright (c) 2019. David de Andrés and Juan Carlos Ruiz, DISCA - UPV, Development of apps for mobile devices.
 */

package labs.dadm.l0305_actionbar;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Set the title of the activity according to its level
        setTitle(R.string.main_title);

        findViewById(R.id.bNext).setOnClickListener(v -> nextLevel());
    }

    // This method will be executed when the Button is clicked.
    // It will launch a new activity to get to the next (first) level.
    private void nextLevel() {
        // Generate the required Intent
        final Intent intent =
                new Intent(MainActivity.this, NextActivity.class);
        // Add level 1 as parameter
        intent.putExtra(Utils.LEVEL, Utils.DEFAULT_LEVEL);
        // Start the new activity
        startActivity(intent);

    }

}
