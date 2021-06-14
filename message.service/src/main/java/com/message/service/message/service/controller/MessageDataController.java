package com.message.service.message.service.controller;

import com.message.service.message.service.dto.MessageResponse;
import com.message.service.message.service.dto.Messagenger;
import com.message.service.message.service.repository.MessageRepository;
import com.message.service.message.service.service.MessageService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

import static com.message.service.message.service.service.MessageService.isNotNullNotEmptyNotWhiteSpaceOnlyByGuava;


@RestController
@RequestMapping(path="/api")
public class MessageDataController {

    private MessageService messageService;
    @Autowired
    public void setMessageService(MessageService messageService) {
        this.messageService = messageService;
    }

    private MessageRepository messageRepository;
    @Autowired
    public void setMessageRepository(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    @GetMapping("/messages/{id}")
    public String getMessage(@PathVariable(name="id") String id ){
        JSONObject json = new JSONObject();
        Optional<Messagenger> message = null;
        Messagenger result = null;
        // validate input
        if(!isNotNullNotEmptyNotWhiteSpaceOnlyByGuava(id)){
            json.put("err_msg","400 BAD Request");
            return json.toString();
        }
        else {
            message = messageRepository.findById(id);
            if(!message.isPresent()){
                json.put("err_msg","404 NOT FOUND");
                return json.toString();
            }else{// extract values from optional
                result =  message.get();
                json.put("message",result.getMessage());
            }

        }
        return json.toString();

    }


        @PostMapping(path = "/messages", produces = { "application/json"})
        public MessageResponse saveMessage(@RequestBody Messagenger message) {
        JSONObject json = new JSONObject();
        String result = null;
        MessageResponse response = new MessageResponse();

        // validate input
        if(!isNotNullNotEmptyNotWhiteSpaceOnlyByGuava(message.getMessage())){
         response.setDigest("400 BAD Request");
         return response;
        }
        else{
            // convert message to hash hex
         result = messageService.saveMessageData(message.getMessage());
            message.setId(result);
            //save message and hash hex tp h2 DB
         messageRepository.save(message);
         response.setDigest(result);

        }

        return response;

    }
}
