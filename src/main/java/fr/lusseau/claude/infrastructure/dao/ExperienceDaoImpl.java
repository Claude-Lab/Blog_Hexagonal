package fr.lusseau.claude.infrastructure.dao;

import fr.lusseau.claude.application.dao.IExperienceDao;
import fr.lusseau.claude.infrastructure.dao.exception.DaoException;
import fr.lusseau.claude.infrastructure.dto.ExperienceDTO;
import fr.lusseau.claude.infrastructure.factory.FactoryService;
import fr.lusseau.claude.infrastructure.utils.annotation.LogAudited;

import javax.inject.Named;
import java.util.List;

/**
 * @author Claude Lusseau
 * @project site_perso
 * @package fr.lusseau.claude.infrastructure.dao
 * @date 15/08/2022
 */
@Named("ExperienceDaoImpl")
@LogAudited
public class ExperienceDaoImpl extends ArticleDaoImpl<ExperienceDTO> implements IExperienceDao {

    public ExperienceDaoImpl(FactoryService factoryService) {
        super(factoryService);
    }

    @Override
    public Long createArticle(ExperienceDTO article) throws DaoException {
        return null;
    }

    @Override
    public Long edit(ExperienceDTO article) throws DaoException {
        return null;
    }

    @Override
    public Boolean remove(ExperienceDTO article) throws DaoException {
        return null;
    }

    @Override
    public ExperienceDTO findArticle(Long id) throws DaoException {
        return null;
    }

    @Override
    public List<ExperienceDTO> findAllArticles() throws DaoException {
        return null;
    }
}
