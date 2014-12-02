package com.ppol.atm.integration.impl;

import com.google.common.collect.ImmutableSet;
import com.ppol.atm.integration.api.model.Document;
import java.util.Set;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

/**
 * Pass only PNG and JPG images
 */
@Component
public class TypeFilter {

    private static final Logger LOG = LoggerFactory.getLogger(TypeFilter.class);

    private static final Set<String> TYPES =
        ImmutableSet.of("image/jpeg", "image/png");

    public boolean accept(Message<?> message) {
        if (message.getPayload() instanceof Document) {
            Document doc = (Document) message.getPayload();
            if (TYPES.contains(doc.getContentType())) {
                LOG.info(
                    String.format(
                        "Message [%s] pass the filter", message.getHeaders().getId()
                    )
                );
                return true;
            }
        }
        LOG.info(
            String.format(
                "Message [%s] didn't pass the filter", message.getHeaders().getId()
            )
        );
        return false;
    }

    public static void main(String[] args) {
        System.out.println(System.getProperty("java.io.tmpdir"));
    }
}
