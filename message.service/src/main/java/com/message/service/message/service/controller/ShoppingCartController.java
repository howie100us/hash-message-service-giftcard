package com.message.service.message.service.controller;

import com.message.service.message.service.dto.ShoppingCart;
import com.message.service.message.service.service.ShoppingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.stream.events.Characters;
import java.util.ArrayList;
import java.util.List;

import static com.message.service.message.service.service.MessageService.isNotNullNotEmptyNotWhiteSpaceOnlyByGuava;

@RestController
@RequestMapping(path ="/api")
public class ShoppingCartController {

    private ShoppingService shoppingService;

    @Autowired
    public void setShoppingService(ShoppingService shoppingService) {
        this.shoppingService = shoppingService;
    }

    @GetMapping("/shop/cart/{balance}/{file}")
    public List<String> getGiftList(@PathVariable(name = "balance") int balance,
                                          @PathVariable(name= "file") String file){

     String path    = ShoppingService.formatPath(file);
        ShoppingCart shoppingCart = new ShoppingCart();
        List<String> itemList = null;
        // verify input
        if(isNotNullNotEmptyNotWhiteSpaceOnlyByGuava(path) && balance >0) {
            itemList= shoppingService.saveShoppintCart(path,balance);
        }else{
            // return error messages in list
            itemList.add("Incorrect path entered OR you have ZERO balance ");
        }
        return itemList;
    }


}
