package com.ppol.atm.integration.impl;

import com.ppol.atm.integration.api.model.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.integration.annotation.Router;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.stereotype.Component;

/**
 * Routes JPG to one channel and PNG to another.
 */
@Component
public class ImageTypeRouter {

    private static final Logger LOG = LoggerFactory.getLogger(ImageTypeRouter.class);
    @Autowired
    @Qualifier("jpgChannel")
    private MessageChannel jpgChannel;

    @Autowired
    @Qualifier("pngChannel")
    private MessageChannel pngChannel;

    @Router
    public MessageChannel route(final Message<Document> message) {
        String contentType = message.getPayload().getContentType();
        MessageChannel targetChannel;
        if ("image/jpeg".equals(contentType)) {
            LOG.info(
                String.format(
                    "Message [%s] routed to [jpgChannel] channel", message.getHeaders().getId()
                )
            );
            targetChannel = jpgChannel;
        } else {
            LOG.info(
                String.format(
                    "Message [%s] routed to [pngChannel] channel", message.getHeaders().getId()
                )
            );
            targetChannel = pngChannel;
        }
        return targetChannel;
    }
}
