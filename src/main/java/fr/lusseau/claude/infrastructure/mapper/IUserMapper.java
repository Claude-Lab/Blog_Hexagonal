package fr.lusseau.claude.infrastructure.mapper;

import fr.lusseau.claude.domain.model.User;
import fr.lusseau.claude.infrastructure.dto.UserDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import javax.inject.Named;
import java.util.List;

/**
 * @author Claude Lusseau
 * @project site_perso
 * @package fr.lusseau.claude.infrastructure.mapper
 * @date 18/08/2022
 */
@Mapper
@Named
public interface IUserMapper {

    IUserMapper INSTANCE = Mappers.getMapper(IUserMapper.class);

    @Mapping(target = "withId", source = "id")
    @Mapping(target = "withEmail", source = "email")
    @Mapping(target = "withPassword", source = "password")
    @Mapping(target = "withFirstName", source = "firstName")
    @Mapping(target = "withLastName", source = "lastName")
    @Mapping(target = "withRole", source = "role")
    User userDtoToUser(UserDTO userDTO);

    @Mapping(target = "withId", source = "id")
    @Mapping(target = "withEmail", source = "email")
    @Mapping(target = "withPassword", source = "password")
    @Mapping(target = "withFirstName", source = "firstName")
    @Mapping(target = "withLastName", source = "lastName")
    @Mapping(target = "withRole", source = "role")
    UserDTO userToUserDto(User user);

    @Mapping(target = "withId", source = "withId")
    @Mapping(target = "withEmail", source = "withEmail")
    @Mapping(target = "withPassword", source = "withPassword")
    @Mapping(target = "withFirstName", source = "withFirstName")
    @Mapping(target = "withLastName", source = "withLastName")
    @Mapping(target = "withRole", source = "withRole")
    List<User> userDtoListToUserList(List<UserDTO> userDTOList);

    @Mapping(target = "withId", source = "withId")
    @Mapping(target = "withEmail", source = "withEmail")
    @Mapping(target = "withPassword", source = "withPassword")
    @Mapping(target = "withFirstName", source = "withFirstName")
    @Mapping(target = "withLastName", source = "withLastName")
    @Mapping(target = "withRole", source = "withRole")
    List<UserDTO> userListToUserDtoList(List<User> users);
}
