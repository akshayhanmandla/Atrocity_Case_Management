package com.testexample.atrocity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.TextView;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Feedbackui extends AppCompatActivity {
    EditText ram;
    TextView ratingDisplayTextView;
    Button submitButton;
    RatingBar ratingRatingBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedbackui);
        ram=(EditText)findViewById(R.id.ram);
        ratingRatingBar = (RatingBar) findViewById(R.id.rating_rating_bar);
        submitButton = (Button) findViewById(R.id.submit_button);
        ratingDisplayTextView = (TextView) findViewById(R.id.rating_display_text_View);
        ratingDisplayTextView.setText("Your rating is: " + ratingRatingBar.getRating());
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ratingDisplayTextView.setText("Your rating is: " + ratingRatingBar.getRating());
                FirebaseDatabase database=FirebaseDatabase.getInstance();
                DatabaseReference ref=database.getInstance().getReference("users");
                ref.child(ram.getText().toString()).child("rating").setValue(ratingRatingBar.getRating());
            }
        });
    }
}