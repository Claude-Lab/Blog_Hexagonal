package fr.lusseau.claude.infrastructure.dao;

import fr.lusseau.claude.application.dao.IExperienceDao;
import fr.lusseau.claude.infrastructure.dao.exception.DaoException;
import fr.lusseau.claude.infrastructure.entity.ExperienceEntity;
import fr.lusseau.claude.infrastructure.factory.FactoryService;

import java.util.List;

/**
 * @author Claude Lusseau
 * @project site_perso
 * @package fr.lusseau.claude.infrastructure.dao
 * @date 15/08/2022
 */
public class ExperienceDaoImpl extends ArticleDaoImpl<ExperienceEntity> implements IExperienceDao {

    public ExperienceDaoImpl(FactoryService factoryService) {
        super(factoryService);
    }

    @Override
    public Long createArticle(ExperienceEntity article) throws DaoException {
        return null;
    }

    @Override
    public Long edit(ExperienceEntity article) throws DaoException {
        return null;
    }

    @Override
    public Boolean remove(ExperienceEntity article) throws DaoException {
        return null;
    }

    @Override
    public ExperienceEntity findArticle(Long id) throws DaoException {
        return null;
    }

    @Override
    public List<ExperienceEntity> findAllArticles() throws DaoException {
        return null;
    }
}
