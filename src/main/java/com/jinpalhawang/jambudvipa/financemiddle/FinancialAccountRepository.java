package com.jinpalhawang.jambudvipa.financemiddle;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "financialaccounts", path = "financialaccounts")
public interface FinancialAccountRepository extends MongoRepository<FinancialAccount, String> {

  public FinancialAccount findByName(@Param("name") String name);

}
