package com.ppol.atm.integration.impl;

import com.ppol.atm.integration.api.DocumentService;
import com.ppol.atm.integration.api.model.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.stereotype.Component;

@Component
public class DocumentServiceImpl implements DocumentService {

    @Autowired
    @Qualifier("documentInChannel")
    private MessageChannel channel;

    @Override
    public void process(final Document document) {
        this.channel.send(new GenericMessage<>(document));
    }
}
