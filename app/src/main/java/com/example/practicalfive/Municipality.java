package com.example.practicalfive;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Municipality extends AppCompatActivity {

    public static final String EXTRA_MUNICIPALITY = "municipality";
    private String website;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_municipality);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        TextProcessor processor = new TextProcessor();
        String name = processor.processMunicipality(
                getIntent().getStringExtra(EXTRA_MUNICIPALITY));
        if (name == null) {
            Toast.makeText(this, R.string.missing_city, Toast.LENGTH_SHORT).show();
            finish();
            return;
        }

        showMunicipality(name);
    }

    private void showMunicipality(String name) {
        int textIndex;
        int imageId;
        int colourId;

        if (name.equals("Beijing")) {
            textIndex = 0;
            imageId = R.drawable.beijing;
            colourId = R.color.municipality_beijing;
            website = getString(R.string.url_beijing);
        } else if (name.equals("Shanghai")) {
            textIndex = 1;
            imageId = R.drawable.shanghai;
            colourId = R.color.municipality_shanghai;
            website = getString(R.string.url_shanghai);
        } else if (name.equals("Chongqing")) {
            textIndex = 2;
            imageId = R.drawable.chongqing;
            colourId = R.color.municipality_chongqing;
            website = getString(R.string.url_chongqing);
        } else {
            textIndex = 3;
            imageId = R.drawable.tianjin;
            colourId = R.color.municipality_tianjin;
            website = getString(R.string.url_tianjin);
        }

        int colour = getResources().getColor(colourId, getTheme());
        int light = getResources().getColor(R.color.color_text_light, getTheme());
        int dark = getResources().getColor(R.color.color_text_dark, getTheme());
        int labelColour = light;
        if (name.equals("Chongqing")) {
            labelColour = dark;
        }

        TextView title = findViewById(R.id.municipality_name);
        ImageView image = findViewById(R.id.municipality_image);
        TextView info = findViewById(R.id.municipality_info);
        Button visitSite = findViewById(R.id.visit_site);

        title.setText(name);
        title.setBackgroundColor(colour);
        title.setTextColor(labelColour);
        image.setImageResource(imageId);
        image.setContentDescription(getString(R.string.city_image_description, name));
        info.setText(getResources().getStringArray(R.array.municipalities_array)[textIndex]);
        info.setTextColor(colour);
        if (name.equals("Chongqing")) {
            info.setBackgroundColor(dark);
        }
        visitSite.setBackgroundTintList(ColorStateList.valueOf(colour));
        visitSite.setTextColor(labelColour);
        visitSite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(website));
                try {
                    startActivity(intent);
                } catch (ActivityNotFoundException exception) {
                    Toast.makeText(Municipality.this, R.string.no_browser,
                            Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
