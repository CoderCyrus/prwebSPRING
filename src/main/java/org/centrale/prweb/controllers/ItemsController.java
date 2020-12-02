/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.centrale.prweb.controllers;

import java.util.List;
import java.util.Optional;
import javax.servlet.http.HttpServletRequest;
import org.centrale.prweb.items.Category;
import org.centrale.prweb.items.Item;
import org.centrale.prweb.repositories.CategoryRepository;
import org.centrale.prweb.repositories.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author muruowang
 */
// Request handling method
@Controller
public class ItemsController {

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @RequestMapping(value = "delete.do", method = RequestMethod.GET)
    public ModelAndView deleteGet() {
        return new ModelAndView("index");
    }

    // POST method 
    @RequestMapping(value = "delete.do", method = RequestMethod.POST)
    public ModelAndView deletePost(HttpServletRequest request) {
        String idStr = request.getParameter("id");
        if (idStr != null) {
            int id = Integer.parseInt(idStr);
            Optional<Item> item = itemRepository.findById(id);
            if (item.isPresent()) {
                itemRepository.delete(item.get());
                return buildAuctions();
            }
        }
        return buildAuctions();
    }

    public ModelAndView buildAuctions() {
        ModelAndView returned;
        List<Item> listItem = itemRepository.findAll();
        List<Category> listCategory = categoryRepository.findAll();
        returned = new ModelAndView("auctions");
        returned.addObject("listItems", listItem);
        returned.addObject("listCategories",listCategory);
        return returned;
    }

    @RequestMapping(value = "add.do", method = RequestMethod.POST)
    public ModelAndView addPost(@ModelAttribute("Item") Item newItem,@ModelAttribute("Category") Category newCategory) {
        itemRepository.save(newItem);
        categoryRepository.save(newCategory);
        return buildAuctions();
    }

}
