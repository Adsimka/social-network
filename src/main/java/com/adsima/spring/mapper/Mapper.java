package com.adsima.spring.mapper;

public interface Mapper<F, T> {
    T map(F object);
}
