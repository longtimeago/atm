package com.ppol.atm.integration.impl;

import com.ppol.atm.integration.api.model.Document;
import org.springframework.stereotype.Component;

/**
 * Converts Document to file.
 */
@Component
public class FileOutputHandler {

    public byte[] handleDocument(Document document) {
        return document.getContent();
    }
}
