package it.vscalcione.springboot.jwtsecuritydemo.converter;

import it.vscalcione.springboot.jwtsecuritydemo.entity.UserEntity;
import it.vscalcione.springboot.jwtsecuritydemo.model.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserEntity toUserEntity(User user);
    User toUserModel(UserEntity entity);
}
