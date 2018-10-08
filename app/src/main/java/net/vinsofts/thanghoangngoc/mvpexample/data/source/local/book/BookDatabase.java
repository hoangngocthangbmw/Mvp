package net.vinsofts.thanghoangngoc.mvpexample.data.source.local.book;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import net.vinsofts.thanghoangngoc.mvpexample.data.model.Book;

@Database(entities = {Book.class}, version = 1)
public abstract class BookDatabase extends RoomDatabase {

    public abstract BookDao userDAO();

    private static BookDatabase mBookDatabase;

    public static BookDatabase getInstance(Context context) {
        if (null == mBookDatabase) {
            mBookDatabase = buildDatabaseInstance(context);
        }
        return mBookDatabase;
    }

    private static BookDatabase buildDatabaseInstance(Context context) {
        return Room.databaseBuilder(context,
                BookDatabase.class,
                "books").build();
    }

    public void cleanUp() {
        mBookDatabase = null;
    }

}