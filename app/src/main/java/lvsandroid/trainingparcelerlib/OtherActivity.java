package lvsandroid.trainingparcelerlib;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import org.parceler.Parcels;

public class OtherActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other);

        User user = Parcels.unwrap(getIntent().getParcelableExtra("user"));
        Log.d("DBG", user.firstName + " - " + user.lastName);
    }
}
