package com.adsima.spring.database.repository;

import java.io.Serializable;
import java.util.Optional;

public interface CRUDRepository<K extends Serializable, E> {
    Optional<E> findById(K id);

    void delete(E e);
}
