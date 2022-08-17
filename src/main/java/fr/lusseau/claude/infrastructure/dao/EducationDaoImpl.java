package fr.lusseau.claude.infrastructure.dao;

import fr.lusseau.claude.application.dao.IEducationDao;
import fr.lusseau.claude.infrastructure.dao.exception.DaoException;
import fr.lusseau.claude.infrastructure.dto.EducationDTO;
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
@Named("EducationDaoImpl")
@LogAudited
public class EducationDaoImpl extends ArticleDaoImpl<EducationDTO> implements IEducationDao {

    public EducationDaoImpl(FactoryService factoryService) {
        super(factoryService);
    }

    @Override
    public Long createArticle(EducationDTO article) throws DaoException {
        return null;
    }

    @Override
    public Long edit(EducationDTO article) throws DaoException {
        return null;
    }

    @Override
    public Boolean remove(EducationDTO article) throws DaoException {
        return null;
    }

    @Override
    public EducationDTO findArticle(Long id) throws DaoException {
        return null;
    }

    @Override
    public List<EducationDTO> findAllArticles() throws DaoException {
        return null;
    }
}