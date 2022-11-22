package com.zis.guavapay.handler.normalization;

public interface Normalizer<T> {

    T normalize(T target);
}
