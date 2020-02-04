package org.apache.cayenne.example.model;

import org.apache.cayenne.example.model.auto._Painting;

public class Painting extends _Painting {

    private static final long serialVersionUID = 1L;

    @Override
    public String toString() {
        return "Painting{" +
                "paintingTitle='" + paintingTitle + '\'' +
                ", objectId=" + objectId +
                '}';
    }
}
