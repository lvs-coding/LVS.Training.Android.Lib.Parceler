package lvsandroid.trainingparcelerlib;

import org.parceler.Parcel;

import java.io.Serializable;

/**
 * Created by Laurent on 11/21/2016.
 */

//== Without Parceler ==
//public class User implements Serializable {
//    private String firstName;
//    private String lastName;
//
//    public User(String firstName, String lastName) {
//        this.firstName = firstName;
//        this.lastName = lastName;
//    }
//}

//== With Parceler ==
@Parcel
public class User {
    // fields must be public
    String firstName;
    String lastName;

    // empty constructor needed by the Parceler library
    public User() {
    }

    public User(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
}