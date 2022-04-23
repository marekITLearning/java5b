package sk.itlearning.java5.webservicejpa;

import java.util.List;

import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

@Stateful
public class ZakaznikService {

	@PersistenceContext(unitName = "APP_DB")
	private EntityManager em;

	public List<Zakaznik> getAll() {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Zakaznik> q = cb.createQuery(Zakaznik.class);
		Root<Zakaznik> root = q.from(Zakaznik.class);
		q.select(root);
		return em.createQuery(q).getResultList();
	}

}
