package fr.lusseau.claude.infrastructure.dao;

import fr.lusseau.claude.application.dao.IEducationDao;
import fr.lusseau.claude.infrastructure.dao.exception.DaoException;
import fr.lusseau.claude.infrastructure.entity.EducationEntity;
import fr.lusseau.claude.infrastructure.factory.FactoryService;

import java.util.List;

/**
 * @author Claude Lusseau
 * @project site_perso
 * @package fr.lusseau.claude.infrastructure.dao
 * @date 15/08/2022
 */
public class EducationDaoImpl extends ArticleDaoImpl<EducationEntity> implements IEducationDao {

    public EducationDaoImpl(FactoryService factoryService) {
        super(factoryService);
    }

    @Override
    public Long createArticle(EducationEntity article) throws DaoException {
        return null;
    }

    @Override
    public Long edit(EducationEntity article) throws DaoException {
        return null;
    }

    @Override
    public Boolean remove(EducationEntity article) throws DaoException {
        return null;
    }

    @Override
    public EducationEntity findArticle(Long id) throws DaoException {
        return null;
    }

    @Override
    public List<EducationEntity> findAllArticles() throws DaoException {
        return null;
    }
}