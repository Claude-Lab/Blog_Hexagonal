package fr.lusseau.claude.infrastructure.mapper;

import fr.lusseau.claude.domain.model.User;
import fr.lusseau.claude.infrastructure.dto.UserDTO;
import fr.lusseau.claude.infrastructure.utils.annotation.LogAudited;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @author Claude Lusseau
 * @project site_perso
 * @package fr.lusseau.claude.infrastructure.mapper
 * @date 17/08/2022
 */
@LogAudited
@Mapper
public interface IUserMapper {

    IUserMapper INSTANCE = Mappers.getMapper( IUserMapper.class );

    UserDTO entityToDTO(User user);

    List<UserDTO> entitiesToDTOS(List<User> users);

    User dtoToEntity(UserDTO userDTO);

    List<User> dtosToEntities(List<UserDTO> userDTOS);

}
