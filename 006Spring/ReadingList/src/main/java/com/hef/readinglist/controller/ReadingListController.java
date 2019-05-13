package com.hef.readinglist.controller;

import com.hef.readinglist.dao.ReadingListRepository;
import com.hef.readinglist.domain.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.List;
import java.util.logging.Logger;

/**
 * @Date 2019-05-06
 * @Author lifei
 */
@Component
@RequestMapping(value = {"/readingList"})
@ConfigurationProperties(prefix = "tobao")
public class ReadingListController {

    private static final Logger logger = Logger.getLogger("com.hef.readinglist.controller.ReadingListController");
    @Autowired
    private ReadingListRepository readingListRepository;

    private String associateId;

    @RequestMapping(value = "/{reader}", method = RequestMethod.GET)
    public String readersBooks(@PathVariable("reader") String reader, Model model){
        System.out.println("associateId: " + associateId);
        List<Book> readingList = readingListRepository.findByReader(reader);
        if (readingList != null){
            model.addAttribute("books", readingList);
        }
        return "readingList";
    }

    @RequestMapping(value = "/{reader}", method = RequestMethod.POST)
    public String addToReadingList(@PathVariable("reader") String reader, Book book){
        book.setReader(reader);
        readingListRepository.save(book);
        return "redirect:/readingList/{reader}";
    }


    public void setAssociateId(String associateId) {
        this.associateId = associateId;
    }
}
