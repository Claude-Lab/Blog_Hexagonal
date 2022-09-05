package fr.lusseau.claude.application.usecase.impl;

import fr.lusseau.claude.application.usecase.ICrudUserUseCase;
import fr.lusseau.claude.domain.model.User;
import fr.lusseau.claude.domain.validator.UserValidator;
import fr.lusseau.claude.infrastructure.entity.UserEntity;
import fr.lusseau.claude.infrastructure.factory.FactoryService;
import fr.lusseau.claude.infrastructure.mapper.IUserMapper;
import fr.lusseau.claude.infrastructure.utils.annotation.LogAudited;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.Collections;
import java.util.List;

/**
 * @author Claude Lusseau
 * @project site_perso
 * @package fr.lusseau.claude.application.usecase.impl
 * @date 29/08/2022
 */
@Named
@LogAudited
public class CrudUserUseCase implements ICrudUserUseCase {

    private final FactoryService factoryService;

    @Inject
    public CrudUserUseCase(FactoryService factoryService) {
        this.factoryService = factoryService;
    }

    @Override
    public User create(User user) {
        UserEntity userEntity = IUserMapper.INSTANCE.userToUserDto(user);
        factoryService.getDaoFactory().getUserDao().create(userEntity);
        if (userEntity.getId() == null) {
            return null;
        }
        return IUserMapper.INSTANCE.userDtoToUser(userEntity);
    }

    @Override
    public User getOne(Long id) {
        UserEntity userEntity = factoryService.getDaoFactory().getUserDao().getOne(id);
        if (userEntity == null) {
            return null;
        }
        return IUserMapper.INSTANCE.userDtoToUser(userEntity);
    }


    @Override
    public List<User> getAll() {
        List<UserEntity> userEntities = factoryService.getDaoFactory().getUserDao().getAll();
        if (userEntities.isEmpty()) {
            return Collections.emptyList();
        }
        return IUserMapper.INSTANCE.userDtoListToUserList(userEntities);
    }

    @Override
    public void update(User user) {
        UserValidator.validateUser(user);
        UserEntity userEntity = IUserMapper.INSTANCE.userToUserDto(user);
        factoryService.getDaoFactory().getUserDao().update(userEntity);
    }

    @Override
    public void remove(User user) {
        factoryService.getDaoFactory().getUserDao().remove(IUserMapper.INSTANCE.userToUserDto(user));
    }
}
