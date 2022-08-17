package fr.lusseau.claude.application.dao;

import fr.lusseau.claude.infrastructure.dao.exception.DaoException;
import fr.lusseau.claude.infrastructure.dto.ArticleDTO;

import java.util.List;

/**
 * @author Claude Lusseau
 * @project site_perso
 * @package fr.lusseau.claude.application.dao
 * @date 12/08/2022
 */
public interface IArticleDao<T extends ArticleDTO> {

    Long createArticle(T article) throws DaoException;

    Long edit(T article) throws DaoException;

    Boolean remove(T article) throws DaoException;

    T findArticle(Long id) throws DaoException;

    List<T> findAllArticles() throws DaoException;
}
