package com.ppol.atm.integration.api;

import com.ppol.atm.integration.api.model.Document;

/**
 * Manages uploaded documents
 */
public interface DocumentService {

    void process(final Document document);
}
