package com.repo.dynamodb;

import javax.enterprise.context.Dependent;
import javax.ws.rs.Produces;

public class Config {

    @Produces
    @Dependent
    public <T> CrudRepository<T> getCrudRepo() {
        return new CrudRepositoryImplementation<>();
    }
}
