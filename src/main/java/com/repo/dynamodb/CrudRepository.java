package com.repo.dynamodb;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBQueryExpression;

import java.util.Set;


/**
 * Used for CRUD operations
 *
 * @param <T> Entity to query
 */
public interface CrudRepository<T> {

    void save(T t);

    void delete(T t);

    Set<T> findByMapOfKeyValues(T t);

    Set<T> query(T t, DynamoDBQueryExpression<T> dynamoDBQueryExpression);
}
