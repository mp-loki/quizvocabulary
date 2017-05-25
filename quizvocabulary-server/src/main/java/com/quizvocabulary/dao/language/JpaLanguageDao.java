package com.quizvocabulary.dao.language;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.quizvocabulary.dao.AbstractJpaDao;
import com.quizvocabulary.dao.model.LanguageEntity;
import com.quizvocabulary.dao.util.DaoUtil;
import com.quizvocabulary.data.model.Language;

@Component
public class JpaLanguageDao extends AbstractJpaDao<LanguageEntity, Language, String> implements LanguageDao {

	@Autowired
	private LanguageRepository languageRepository;
	@Override
	protected CrudRepository<LanguageEntity, String> getCrudRepository() {
		return languageRepository;
	}

	@Override
	protected Class<LanguageEntity> getEntityClass() {
		return LanguageEntity.class;
	}

	@Override
	public Language findByCode(String code) {
		return DaoUtil.toDto(languageRepository.findByCode(code));
	}

	@Override
	public Language findByName(String name) {
		return DaoUtil.toDto(languageRepository.findByName(name));
	}

}
