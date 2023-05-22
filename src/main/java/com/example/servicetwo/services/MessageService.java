package com.example.servicetwo.services;

import com.example.servicetwo.entites.Message;
import com.example.servicetwo.entites.Status;
import com.example.servicetwo.repositorys.MessageRepository;
import com.example.servicetwo.repositorys.StatusRepository;
import lombok.extern.log4j.Log4j;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Log4j2
@Service
public class MessageService {

    private final StatusRepository statusRepository;
    private final MessageRepository messageRepository;

    @Autowired
    public MessageService(StatusRepository statusRepository, MessageRepository messageRepository) {
        this.statusRepository = statusRepository;
        this.messageRepository = messageRepository;
    }

    public List<Status> getAllRegisteredServices() {
        log.info("Получение информации обо всех зарегистрированых сервиах");
        return statusRepository.findAll();
    }

    public List<Long> getServiceIdsWithActivityStatus() {
        log.info("Получения id всех активных сервисов");
        return statusRepository.getServiceIdsWithActivityStatus();
    }

    public Optional<List<Message>> getMessageById(Long id) {
        if (statusRepository.existsById(id)) {
            log.info("Получение информации о сервисе id: {}", id);
            return Optional.of(messageRepository.findMessageByServiceId_ServiceId(id));
        } else return Optional.empty();
    }

    public void deleteServiceById(Long id) {
        if (statusRepository.existsById(id)) {
            log.info("Удадения сервиса id: {}", id);
            statusRepository.deleteById(id);
        }
    }

    public void deleteMessageById(Long id) {
        if (messageRepository.existsById(id)) {
            log.info("Удадения сообщения id: {}", id);
            messageRepository.findById(id);
        }
    }

    public void putMessage(Message message) {
        if (!statusRepository.existsById(message.getServiceId().getServiceId())) {
            log.info("Добавление сообщения для сервиса с id: {}", message.getServiceId().getServiceId());
            messageRepository.save(message);
        }
    }
}
