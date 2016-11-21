package lvsandroid.trainingparcelerlib;

/*
A must have to pass object between activities, 10 times faster than serialize / deserialize
https://github.com/codepath/android_guides/wiki/Using-Parceler
http://parceler.org/

Although creating Android Parcelables is usually at least 10x faster than using Serializable,
creating Parcelable objects requires creating a lot of boilerplate code in defining exactly
he stream of data that should be serialized and deserialized as documented in this section.
While there are IDE plugins to help facilitate the creating of these objects, another option is to
leverage a third-party library called Parceler that will help automate this work. Underneath the
surface this library generates the necessary wrapper classes for you at compile time automatically,
saving you the repetitive steps required for leveraging the performance benefits of Parcelables.

== Using with ORM libraries ==

Some ORM libraries require extending the Java object with fields that Parceler is unable to
serialize or deserialize. In these cases, you should limit what fields should be analyzed in the
inheritance using the @Parcel(analyze={}) decorator:

@Parcel(analyze={User.class})   // add Parceler annotation here
public class User extends BaseModel {
}
DBFlow
Realm.IO
 */

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import org.parceler.Parcels;

public class MainActivity extends AppCompatActivity {
    private Button btnStartOtherActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnStartOtherActivity = (Button)findViewById(R.id.btnOtherActivity);
        btnStartOtherActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                User user = new User("John", "Doe");
                Intent intent = new Intent(getApplicationContext(), OtherActivity.class);
                intent.putExtra("user", Parcels.wrap(user));
                startActivity(intent);
            }
        });

    }
}
