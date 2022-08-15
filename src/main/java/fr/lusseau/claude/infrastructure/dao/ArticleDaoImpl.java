package fr.lusseau.claude.infrastructure.dao;

import fr.lusseau.claude.application.dao.IArticleDao;
import fr.lusseau.claude.infrastructure.entity.ArticleEntity;
import fr.lusseau.claude.infrastructure.factory.FactoryService;

import javax.inject.Inject;

/**
 * @author Claude Lusseau
 * @project site_perso
 * @package fr.lusseau.claude.infrastructure.dao
 * @date 15/08/2022
 */
public abstract class ArticleDaoImpl<T extends ArticleEntity> implements IArticleDao<T> {

    private FactoryService factoryService;

    @Inject
    public ArticleDaoImpl(FactoryService factoryService) {
        this.factoryService = factoryService;
    }
}
