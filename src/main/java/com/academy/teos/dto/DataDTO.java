package com.academy.teos.dto;

import javax.persistence.Column;

/**
 * @author: Kelheor
 */
public class DataDTO {

    private String id;

    private byte[] data;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

}
