package net.vinsofts.thanghoangngoc.mvpexample.data.model;


import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;

import javax.annotation.Nullable;

@Entity(tableName = "books")
public class Book {
    @Nullable
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    private int mID;

    @ColumnInfo(name = "name")
    private String mName;

    @ColumnInfo(name = "author")
    private String mAuthor;

    @Ignore
    public Book(String mName, String mAuthor) {
        this.mName = mName;
        this.mAuthor = mAuthor;
    }

    public Book() {
    }

    public int getID() {
        return mID;
    }

    public void setID(int mID) {
        this.mID = mID;
    }

    public String getName() {
        return mName;
    }

    public void setName(String mName) {
        this.mName = mName;
    }

    public String getAuthor() {
        return mAuthor;
    }

    public void setAuthor(String mAuthor) {
        this.mAuthor = mAuthor;
    }

}
