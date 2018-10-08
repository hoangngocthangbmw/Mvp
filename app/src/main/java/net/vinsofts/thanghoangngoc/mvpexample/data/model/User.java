package net.vinsofts.thanghoangngoc.mvpexample.data.model;

public class User {
    private String mName;
    private String mEmail;

    public User() {
    }

    public User(String mName, String mEmail) {
        this.mName = mName;
        this.mEmail = mEmail;
    }

    public String getName() {
        return mName;
    }

    public void setName(String mName) {
        this.mName = mName;
    }

    public String getEmail() {
        return mEmail;
    }

    public void setEmail(String mEmail) {
        this.mEmail = mEmail;
    }
}
