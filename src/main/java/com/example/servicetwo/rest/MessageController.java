package com.example.servicetwo.rest;

import com.example.servicetwo.MessageNotFoundException;
import com.example.servicetwo.entites.Message;
import com.example.servicetwo.entites.Status;
import com.example.servicetwo.services.MessageService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/messages")
public class MessageController {

    private final MessageService messageService;

    @Autowired
    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @GetMapping()
    @Operation(summary = "Get all Services")
    public List<Status> getAllServices() {
        return messageService.getAllRegisteredServices();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get message by id")
    public List<Message> getMessageById(@PathVariable Long id) {
        return messageService.getMessageById(id).orElseThrow(()
                -> new MessageNotFoundException("Сообщение не найдено"));
    }

    @PostMapping
    @Operation(summary = "Send message")
    public void sendMessage(@RequestBody Message message) {
        messageService.putMessage(message);
    }

    @DeleteMapping("/message/{id}")
    @Operation(summary = "Delete message by id")
    public ResponseEntity<Void> deleteMessageById(@PathVariable Long id) {
        messageService.deleteMessageById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping("/getActivity")
    @Operation(summary = "Get id all activity service")
    public List<Long> getServiceIdsWithActivityStatus() {
       return messageService.getServiceIdsWithActivityStatus();
    }

    @DeleteMapping("/service/{id}")
    @Operation(summary = "Delete service by id")
    public ResponseEntity<Void> deleteServiceById(@PathVariable Long id) {
        messageService.deleteServiceById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}