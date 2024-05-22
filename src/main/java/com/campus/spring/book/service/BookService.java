package com.campus.spring.book.service;

import com.campus.spring.book.entity.BookEntity;
import org.springframework.stereotype.Service;

import java.util.*;

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
    public BookEntity create(String title, String description){
        BookEntity book = new BookEntity();
        book.setID(bookStorage.size());
        book.setTitle(title);
        book.setDescription(description);
        bookStorage.add(book);
        return book;
    }

    public Optional<BookEntity> edit(BookEntity book){
        Optional<BookEntity> bookEntityOptional = byId(book.getID());
        if (bookEntityOptional.isEmpty()) {
            return Optional.empty();
        } else {
            BookEntity oldBook = bookEntityOptional.get();
            oldBook.setTitle(book.getTitle());
            oldBook.setDescription(book.getDescription());
            return Optional.of(oldBook);
        }
    }
    public Boolean delete(Integer id){
        Optional<BookEntity> bookEntityOptional = byId(id);
        if (bookEntityOptional.isEmpty()) {
            return false;
        } else {
            bookStorage.remove(bookEntityOptional.get());
            return true;
        }
    }
    public Optional<BookEntity> editPart(Integer id, Map<String, String> fields){
        Optional<BookEntity> bookEntityOptional = byId(id);
        if (bookEntityOptional.isEmpty()) return Optional.empty();
        BookEntity oldBook = bookEntityOptional.get();
        for (String key : fields.keySet()){
            switch (key){
                case "title" -> oldBook.setTitle(fields.get(key));
                case "description" -> oldBook.setDescription(fields.get(key));
            }
        }
        return Optional.of(oldBook);
    }
}
