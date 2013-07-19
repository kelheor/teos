package com.academy.teos.entity;

import java.io.Serializable;

/**
 * @author: Руслан
 */
public interface BaseEntity<T extends Serializable>  {

    public T getId();
}
