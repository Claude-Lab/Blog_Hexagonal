package fr.lusseau.claude.infrastructure.mapper.impl;

import fr.lusseau.claude.domain.model.User;
import fr.lusseau.claude.infrastructure.dto.UserDTO;
import fr.lusseau.claude.infrastructure.mapper.IUserMapper;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Claude Lusseau
 * @project site_perso
 * @package fr.lusseau.claude.infrastructure.mapper.impl
 * @date 17/08/2022
 */
public class UserMapperImpl implements IUserMapper {

    @Override
    public UserDTO entityToDTO(User user) {
        if (user == null) {
            return null;
        }
        return UserDTO
                .builder()
                .withId(user.getId())
                .withEmail(user.getEmail())
                .withFirstname(user.getFirstName())
                .withLastname(user.getLastName())
                .withPassword(user.getPassword())
                .withRole(user.getRole())
                .build();
    }

    @Override
    public User dtoToEntity(UserDTO userDTO) {
        if (userDTO == null) {
            return null;
        }
        return User
                .builder()
                .withId(userDTO.getId())
                .withEmail(userDTO.getEmail())
                .withFirstname(userDTO.getFirstName())
                .withLastname(userDTO.getLastName())
                .withPassword(userDTO.getPassword())
                .withRole(userDTO.getRole())
                .build();
    }


    @Override
    public List<UserDTO> entitiesToDTOS(List<User> users) {
        return users.stream().map(this::entityToDTO).collect(Collectors.toList());
    }

    @Override
    public List<User> dtosToEntities(List<UserDTO> userDTOS) {
        return userDTOS.stream().map(this::dtoToEntity).collect(Collectors.toList());
    }
}
