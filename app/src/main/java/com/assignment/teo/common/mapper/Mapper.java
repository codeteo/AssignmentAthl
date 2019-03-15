package com.assignment.teo.common.mapper;

/**
 * Helps to transform items from data layer to domain. All mappers should
 * implement this contract.
 *
 * @param <T> takes
 * @param <R> returns
 */

public interface Mapper<T, R> {

    /**
     * Transform a {@link T} into an {@link R}.
     *
     * @param t  Object to be transformed.
     * @return R Object to return.
     */
    R transform(T t);

}
