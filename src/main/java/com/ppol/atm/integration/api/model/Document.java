package com.ppol.atm.integration.api.model;

import java.util.Arrays;
import org.apache.commons.lang3.ArrayUtils;

public class Document {

    private final String name;
    private final byte[] content;
    private final String contentType;

    public Document(final String name, final byte[] content, final String contentType) {
        this.name = name;
        this.content = ArrayUtils.clone(content);
        this.contentType = contentType;
    }

    public String getName() {
        return name;
    }

    public byte[] getContent() {
        return ArrayUtils.clone(content);
    }

    public String getContentType() {
        return contentType;
    }

    @Override
    public String toString() {
        return "Document{" +
            "name='" + name + '\'' +
            ", contentType='" + contentType + '\'' +
            '}';
    }
}
