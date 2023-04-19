package com.sapient.publicis.nipa.ew.order.adapter.dynamodbupgraded.repository;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBQueryExpression;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.repo.dynamodb.CrudRepository;
import com.sapient.publicis.nipa.ew.order.adapter.dynamodbupgraded.ElectricVehicleBattery;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@ApplicationScoped
public class ElectricVehicleBatteryRepository {

    @Inject
    CrudRepository<ElectricVehicleBattery> electricVehicleBatteryCrudRepository;


    public Set<ElectricVehicleBattery> retrieveListOfElectricVehicleBatteriesUsingParameters(){
    Map<String, AttributeValue> mapOfKeyValues = new HashMap<>();
    mapOfKeyValues.put(":id",new AttributeValue().withS("develop_es10332"));
        DynamoDBQueryExpression<ElectricVehicleBattery> queryExpression = new DynamoDBQueryExpression<ElectricVehicleBattery>()
                .withKeyConditionExpression("ew_id = :id").withExpressionAttributeValues(mapOfKeyValues);
    return electricVehicleBatteryCrudRepository.query(new ElectricVehicleBattery(),queryExpression);
    }

}
