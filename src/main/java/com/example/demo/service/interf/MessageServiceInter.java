package com.example.demo.service.interf;

import com.example.demo.entity.Message;

import java.util.List;

public interface MessageServiceInter {

    Message saveMessage(Message message);

    List<Message> getAllMessages();
}
