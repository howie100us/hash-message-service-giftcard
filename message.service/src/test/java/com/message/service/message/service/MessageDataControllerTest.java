package com.message.service.message.service;

import com.message.service.message.service.controller.MessageDataController;
import com.message.service.message.service.dto.Messagenger;
import com.message.service.message.service.repository.MessageRepository;
import com.message.service.message.service.service.MessageService;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@Import(MessageDataController.class)
public class MessageDataControllerTest {
    @InjectMocks
    MessageDataController messageDataController;

    MessageService messageService;
    @Mock
    MessageRepository messageRepository;

    @Before
    public void setUp(){
        MockitoAnnotations.openMocks(this);
        messageService = new MessageService();

    }
    @Test
    public void testHashPost(){
        Messagenger message = new Messagenger();
        message.setMessage("test");
        message.setId("");
        messageDataController.setMessageRepository(messageRepository);
        messageDataController.setMessageService(messageService);
        messageDataController.saveMessage(message);

    }

    @Test
    public void testMessageService(){
        Messagenger message = new Messagenger();
        message.setMessage("test");
        message.setId("");
        message.setMessage("test");
        message.getId();
        messageService.saveMessageData(message.getMessage());
        MessageService.isNotNullNotEmptyNotWhiteSpaceOnlyByGuava(message.getMessage());

    }

}
