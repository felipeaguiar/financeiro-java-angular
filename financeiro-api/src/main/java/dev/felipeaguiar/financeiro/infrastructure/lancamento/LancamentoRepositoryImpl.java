package dev.felipeaguiar.financeiro.infrastructure.lancamento;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import dev.felipeaguiar.financeiro.domain.lancamento.Categoria_;
import dev.felipeaguiar.financeiro.domain.lancamento.Lancamento;
import dev.felipeaguiar.financeiro.domain.lancamento.LancamentoRepositoryCustom;
import dev.felipeaguiar.financeiro.domain.lancamento.LancamentoResumo;
import dev.felipeaguiar.financeiro.domain.lancamento.Lancamento_;
import dev.felipeaguiar.financeiro.domain.lancamento.filter.LancamentoFilter;
import dev.felipeaguiar.financeiro.domain.pessoa.Pessoa_;

@Component
public class LancamentoRepositoryImpl implements LancamentoRepositoryCustom {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<Lancamento> filtrar(LancamentoFilter filter, Pageable pageable) {

		CriteriaBuilder builder = entityManager.getCriteriaBuilder();

		CriteriaQuery<Lancamento> criteria = builder.createQuery(Lancamento.class);
		Root<Lancamento> root = criteria.from(Lancamento.class);

		Predicate[] predicates = getPredicates(filter, builder, root);

		criteria.select(root);

		if (predicates.length > 0) {
			criteria.where(predicates);
		}

		TypedQuery<Lancamento> query = entityManager.createQuery(criteria);

		int page = pageable.getPageNumber();
		int size = pageable.getPageSize();
		int offset = page * size;

		query.setFirstResult(offset);
		query.setMaxResults(size);

		return query.getResultList();
	}

	@Override
	public List<LancamentoResumo> resumir(LancamentoFilter filter, Pageable pageable) {

		CriteriaBuilder builder = entityManager.getCriteriaBuilder();

		CriteriaQuery<LancamentoResumo> criteria = builder.createQuery(LancamentoResumo.class);
		Root<Lancamento> root = criteria.from(Lancamento.class);

		Predicate[] predicates = getPredicates(filter, builder, root);

		criteria.select(builder.construct(LancamentoResumo.class,
			root.get(Lancamento_.id),
			root.get(Lancamento_.descricao),
			root.get(Lancamento_.dataVencimento),
			root.get(Lancamento_.dataPagamento),
			root.get(Lancamento_.valor),
			root.get(Lancamento_.categoria).get(Categoria_.nome),
			root.get(Lancamento_.pessoa).get(Pessoa_.nome),
			root.get(Lancamento_.tipo)));

		if (predicates.length > 0) {
			criteria.where(predicates);
		}

		TypedQuery<LancamentoResumo> query = entityManager.createQuery(criteria);

		int page = pageable.getPageNumber();
		int size = pageable.getPageSize();
		int offset = page * size;

		query.setFirstResult(offset);
		query.setMaxResults(size);

		return query.getResultList();
	}

	@Override
	public Long count(LancamentoFilter filter) {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Long> criteria = builder.createQuery(Long.class);
		Root<Lancamento> root = criteria.from(Lancamento.class);

		Predicate[] predicates = getPredicates(filter, builder, root);

		criteria.select(builder.count(root));

		if (predicates.length > 0) {
			criteria.where(predicates);
		}

		return entityManager.createQuery(criteria).getSingleResult();
	}

	private Predicate[] getPredicates(LancamentoFilter filter, CriteriaBuilder builder, Root<Lancamento> root) {
		List<Predicate> predicates = new ArrayList<>();

		if (StringUtils.isNotEmpty(filter.getDescricao())) {
			Predicate descricao = builder.like(builder.lower(root.get(Lancamento_.descricao)), "%" + filter.getDescricao().toLowerCase() + "%");
			predicates.add(descricao);
		}

		if (filter.getDataVencimentoDe() != null) {
			Predicate vencimento = builder.greaterThanOrEqualTo(root.get(Lancamento_.dataVencimento), filter.getDataVencimentoDe());
			predicates.add(vencimento);
		}

		if (filter.getDataVencimentoAte() != null) {
			Predicate vencimento = builder.lessThanOrEqualTo(root.get(Lancamento_.dataVencimento), filter.getDataVencimentoAte());
			predicates.add(vencimento);
		}

		return predicates.toArray(new Predicate[predicates.size()]);
	}

}
