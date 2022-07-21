package com.khaind.microservices.account.mapper;

import com.khaind.microservices.account.dto.UserDTO;
import com.khaind.microservices.account.entity.UserEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDTO toDTO(UserEntity entity);

    UserEntity toEntity(UserDTO dto);

    List<UserEntity> toEntities(List<UserDTO> dtos);

    List<UserDTO> toDTOs(List<UserEntity> entities);
}
