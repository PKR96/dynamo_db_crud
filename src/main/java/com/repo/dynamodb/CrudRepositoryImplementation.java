package com.repo.dynamodb;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapperConfig;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBQueryExpression;

import java.util.HashSet;
import java.util.Set;

class CrudRepositoryImplementation<T> implements CrudRepository<T> {
    private T t;

    private final DynamoDBMapper mapper = new DynamoDBMapper(AmazonDynamoDBClientBuilder.standard().build());

    @Override
    public void save(T t) {
        mapper.save(t);
    }

    @Override
    public void delete(T t){
    mapper.delete(t);
    }

    @Override
    public Set<T> findByMapOfKeyValues(T t) {
        DynamoDBQueryExpression<T> queryExpression = new DynamoDBQueryExpression<T>()
                .withHashKeyValues(t);
        return new HashSet<>(mapper.query((Class<T>) t.getClass(), queryExpression));
    }

    @Override
    public Set<T> query(T t, DynamoDBQueryExpression<T> dynamoDBQueryExpression) {
        return new HashSet<>(mapper.query((Class<T>) t.getClass(), dynamoDBQueryExpression, DynamoDBMapperConfig.builder().build()));
    }
}
