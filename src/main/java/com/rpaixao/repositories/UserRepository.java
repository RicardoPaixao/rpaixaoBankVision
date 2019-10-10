package com.rpaixao.repositories;

import com.rpaixao.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "users", path="users")
public interface UserRepository extends MongoRepository<User, String> {

    public User findByCorreo(String correo);
    public User findByDocumento(@Param("documento") String documento);   
}
