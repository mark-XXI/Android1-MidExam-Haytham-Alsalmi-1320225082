package com.example.mid_exam_haytham_alsalmi_1320225082;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ArtworkDetailsActivity extends AppCompatActivity {

    private String websiteUrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_artwork_details);

        // Connect XML views
        TextView detailTitle = findViewById(R.id.detailTitle);
        TextView detailArtist = findViewById(R.id.detailArtist);
        TextView detailYear = findViewById(R.id.detailYear);

        Button visitWebsiteButton =
                findViewById(R.id.visitWebsiteButton);

        Button backButton =
                findViewById(R.id.backButton);

        // Apply custom button backgrounds
        visitWebsiteButton.setBackgroundTintList(null);
        backButton.setBackgroundTintList(null);

        visitWebsiteButton.setBackgroundResource(
                R.drawable.bg_button_enabled
        );

        backButton.setBackgroundResource(
                R.drawable.bg_button_enabled
        );

        // Set button text colors
        visitWebsiteButton.setTextColor(
                android.graphics.Color.WHITE
        );

        backButton.setTextColor(
                android.graphics.Color.WHITE
        );

        // Receive data from MainActivity
        Intent intent = getIntent();

        String title = intent.getStringExtra("ARTWORK_TITLE");
        String artist = intent.getStringExtra("ARTWORK_ARTIST");
        int year = intent.getIntExtra("ARTWORK_YEAR", 0);

        websiteUrl = intent.getStringExtra("ARTWORK_URL");

        // Display received information
        detailTitle.setText(title);
        detailArtist.setText(artist);
        detailYear.setText(String.valueOf(year));

        // Open external website using Implicit Intent
        visitWebsiteButton.setOnClickListener(v -> {

            if (websiteUrl != null && !websiteUrl.isEmpty()) {

                Intent browserIntent = new Intent(
                        Intent.ACTION_VIEW,
                        Uri.parse(websiteUrl)
                );

                startActivity(browserIntent);
            }
        });

        // Return to MainActivity
        backButton.setOnClickListener(v -> finish());
    }
}
