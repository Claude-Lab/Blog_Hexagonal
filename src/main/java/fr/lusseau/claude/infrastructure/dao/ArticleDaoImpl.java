package fr.lusseau.claude.infrastructure.dao;

import fr.lusseau.claude.application.dao.IArticleDao;
import fr.lusseau.claude.infrastructure.dto.ArticleDTO;
import fr.lusseau.claude.infrastructure.factory.FactoryService;
import fr.lusseau.claude.infrastructure.utils.annotation.LogAudited;

import javax.inject.Inject;
import javax.inject.Named;

/**
 * @author Claude Lusseau
 * @project site_perso
 * @package fr.lusseau.claude.infrastructure.dao
 * @date 15/08/2022
 */
@Named("ArticleDaoImpl")
@LogAudited
public abstract class ArticleDaoImpl<T extends ArticleDTO> implements IArticleDao<T> {

    private final FactoryService factoryService;

    @Inject
    ArticleDaoImpl(FactoryService factoryService) {
        this.factoryService = factoryService;
    }
}
