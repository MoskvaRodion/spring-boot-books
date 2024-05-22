package com.campus.spring.book.service;

import com.campus.spring.book.entity.BookEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class BookService {
    static List<BookEntity> bookStorage = new ArrayList<>();

    public BookService() {
        fillStore();
    }

    private void fillStore(){
        Random random = new Random();
        for (int i = 0; i < 100; i++) {
            BookEntity book = new BookEntity();
            book.setID(i);
            book.setTitle("Book " + random.nextInt(100,999));
            book.setDescription("Description " + i);
            bookStorage.add(book);
        }
    }
    public List<BookEntity> all(){
        return bookStorage;
    }
    public Optional<BookEntity> byId(Integer id){
        return bookStorage.stream().filter(bookEntity -> bookEntity.getID().equals(id)).findFirst();
    }
}
