package com.example.mid_exam_haytham_alsalmi_1320225082;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import android.widget.TextView;
import android.widget.ImageView;
import android.widget.Button;
import android.content.Intent;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Artwork> artworks;
    private int currentIndex = 0;

    private TextView artworkPosition;
    private ImageView artworkImage;
    private TextView artworkTitle;
    private TextView artworkArtist;

    private Button previousButton;
    private Button nextButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        initializeArtworks();

        // Restore saved artwork position
        if (savedInstanceState != null) {
            currentIndex = savedInstanceState.getInt(
                    "CURRENT_INDEX", 0
            );
        }

        // Connect XML views
        artworkPosition = findViewById(R.id.artworkPosition);
        artworkImage = findViewById(R.id.artworkImage);
        artworkTitle = findViewById(R.id.artworkTitle);
        artworkArtist = findViewById(R.id.artworkArtist);

        previousButton = findViewById(R.id.previousButton);
        nextButton = findViewById(R.id.nextButton);

        artworkImage.setOnClickListener(v -> {

            Artwork artwork = artworks.get(currentIndex);

            Intent intent = new Intent(
                    MainActivity.this,
                    ArtworkDetailsActivity.class
            );

            intent.putExtra("ARTWORK_TITLE", artwork.getTitle());
            intent.putExtra("ARTWORK_ARTIST", artwork.getArtist());
            intent.putExtra("ARTWORK_YEAR", artwork.getYear());
            intent.putExtra("ARTWORK_URL", artwork.getWebsiteUrl());

            startActivity(intent);
        });

        // Previous button
        previousButton.setOnClickListener(v -> {
            if (currentIndex > 0) {
                currentIndex--;
                updateArtwork();
            }
        });

        // Next button
        nextButton.setOnClickListener(v -> {
            if (currentIndex < artworks.size() - 1) {
                currentIndex++;
                updateArtwork();
            }
        });

        updateArtwork();
    }


    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putInt("CURRENT_INDEX", currentIndex);
    }


    private void initializeArtworks() {

        artworks = new ArrayList<>();

        // 1. Pillars of Creation
        artworks.add(new Artwork(
                R.drawable.artwork_1,
                "Pillars of Creation",
                "Hubble Space Telescope",
                1995,
                "https://science.nasa.gov/image-detail/hubble-eaglenebula-browse/"
        ));

        // 2. Aurora Australis
        artworks.add(new Artwork(
                R.drawable.artwork_2,
                "Aurora Australis",
                "International Space Station (ISS)",
                2021,
                "https://www.nasa.gov/image-article/aurora-australis-above-southern-indian-ocean/"
        ));

        // 3. Mars' Whirling Dust Devil
        artworks.add(new Artwork(
                R.drawable.artwork_3,
                "Mars' Whirling Dust Devil",
                "Mars Reconnaissance Orbiter",
                2012,
                "https://www.jpl.nasa.gov/images/pia15545-mars-whirling-dust-devil/"
        ));

        // 4. In Saturn's Shadow
        artworks.add(new Artwork(
                R.drawable.artwork_4,
                "In Saturn's Shadow",
                "Cassini Spacecraft",
                2006,
                "https://science.nasa.gov/image-detail/pia08329-2/"
        ));

        // 5. Amazing Andromeda Galaxy
        artworks.add(new Artwork(
                R.drawable.artwork_5,
                "Amazing Andromeda Galaxy",
                "GALEX / Spitzer Space Telescopes",
                2006,
                "https://www.jpl.nasa.gov/images/pia08787-amazing-andromeda-galaxy/"
        ));

        // 6. Cosmic Cliffs - Carina Nebula
        artworks.add(new Artwork(
                R.drawable.artwork_6,
                "Cosmic Cliffs - Carina Nebula",
                "James Webb Space Telescope",
                2022,
                "https://science.nasa.gov/asset/webb/cosmic-cliffs-in-the-carina-nebula-nircam-image/"
        ));
    }



    private void updateArtwork() {

        Artwork artwork = artworks.get(currentIndex);

        // Display artwork image
        artworkImage.setImageResource(
                artwork.getImageResource()
        );

        // Display artwork information
        artworkTitle.setText(artwork.getTitle());

        artworkArtist.setText(
                artwork.getArtist() + " (" +
                        artwork.getYear() + ")"
        );

        // Update artwork position
        artworkPosition.setText(
                (currentIndex + 1) + " / " + artworks.size()
        );

        // Enable or disable navigation buttons
        previousButton.setEnabled(currentIndex > 0);

        nextButton.setEnabled(
                currentIndex < artworks.size() - 1
        );

        // Update button colors
        previousButton.setBackgroundTintList(null);
        nextButton.setBackgroundTintList(null);

        if (previousButton.isEnabled()) {
            previousButton.setBackgroundResource(
                    R.drawable.bg_button_enabled
            );
            previousButton.setTextColor(0xFFFFFFFF);
        } else {
            previousButton.setBackgroundResource(
                    R.drawable.bg_button_disabled
            );
            previousButton.setTextColor(0xFF93877E);
        }

        if (nextButton.isEnabled()) {
            nextButton.setBackgroundResource(
                    R.drawable.bg_button_enabled
            );
            nextButton.setTextColor(0xFFFFFFFF);
        } else {
            nextButton.setBackgroundResource(
                    R.drawable.bg_button_disabled
            );
            nextButton.setTextColor(0xFF93877E);
        }
    }

}