package model;

import android.provider.ContactsContract;

public class User {

    private String userName;
    private String email ;

    private ContactsContract.CommonDataKinds.Photo profilePicture;


    public User(String userName, String email) {
        this.userName = userName;
        this.email = email;
    }

    public User(String userName, String email, ContactsContract.CommonDataKinds.Photo profilePicture) {
        this.userName = userName;
        this.email = email;
        this.profilePicture = profilePicture;
    }

    public String getUserName() {
        return this.userName;
    }

    public String getEmail() {
        return this.email;
    }

    public void setProfilePicture(ContactsContract.CommonDataKinds.Photo profilePicture) {
        this.profilePicture = profilePicture;
    }
}
