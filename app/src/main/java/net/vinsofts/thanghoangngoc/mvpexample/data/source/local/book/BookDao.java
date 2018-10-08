package net.vinsofts.thanghoangngoc.mvpexample.data.source.local.book;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import net.vinsofts.thanghoangngoc.mvpexample.data.model.Book;

import java.util.List;

@Dao
public interface BookDao {

    @Insert
    void insert(Book book);

    @Query("SELECT * FROM books  ORDER BY name ASC")
    List<Book> getAllBooks();
}
