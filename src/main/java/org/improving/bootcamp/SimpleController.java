package org.improving.bootcamp;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Controller
public class SimpleController {
    private BookRepository bookRepository = new BookRepository();
    @RequestMapping(value="/home", method = RequestMethod.GET) //calls to this URL will wind up at this method
    public String home(ModelMap model){
        model.put("book", new Book("",""));
        setCommonModelAttribute(model);
        return "home"; //resolve a view called "home"
    }
    //remember this was extracted from above
    private void setCommonModelAttribute(ModelMap model) {
        model.put("message", getMessage());
        model.put("name", "World");
        model.put("books", bookRepository.getBooks());
    }

    @PostMapping("/add")
    public String add(ModelMap model, @Valid @ModelAttribute("book") Book book, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            model.put("book", book);
            setCommonModelAttribute(model);
            return "home";
        }
        bookRepository.add(book);
        return "redirect:/home";

    }
    private String getMessage(){
        boolean morning = new Random().nextBoolean();
        return (morning) ? "Hello" : "Goodbye";
    }

    private List<Book> bookList(){
        List<Book> books = new ArrayList<>();
        books.add(new Book("the Great Gatsby", "F. Scott Fitzgerald"));
        books.add(new Book("Harry Potter and the order of the Phoenix", "J.K. Rawling"));
        return books;
    }

    @GetMapping("/book")
    public String book(ModelMap model, @RequestParam Integer id){
        model.put("book", bookRepository.getBooks());
        return "book";
    }

    @GetMapping("/bad")
    public String badRequest() {
        throw new RuntimeException("Something went wrong");
    }

    @GetMapping("/teapot")
    public String teapot() {
        throw new TeaPotException();
    }


}
