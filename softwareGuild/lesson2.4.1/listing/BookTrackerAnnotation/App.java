package com.sg.booktrackerannotation;

import com.sg.booktrackerannotation.controller.BookController;
import com.sg.booktrackerannotation.dao.BookDao;
import com.sg.booktrackerannotation.dao.BookDaoMemoryImpl;
import com.sg.booktrackerannotation.service.BookService;
import com.sg.booktrackerannotation.ui.BookView;
import com.sg.booktrackerannotation.ui.UserIO;
import com.sg.booktrackerannotation.ui.UserIOConsoleImpl;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext();
        appContext.scan("com.sg.booktrackerannotation");
        appContext.refresh();

        BookController controller = appContext.getBean("bookController", BookController.class);
        controller.run();
    }
}
