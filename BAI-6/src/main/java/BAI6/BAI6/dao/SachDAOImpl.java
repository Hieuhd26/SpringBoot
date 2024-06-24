package BAI6.BAI6.dao;

import BAI6.BAI6.entity.Sach;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public class SachDAOImpl implements SachDAO{
    private EntityManager entityManager;
    @Autowired
    public SachDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void saveSach(Sach sach) {
            entityManager.persist(sach);
    }

    @Override
    public Sach getSachById(int id) {
        return entityManager.find(Sach.class,id);
    }

    @Override
    public List<Sach> getAll() {
        String jpql = "select s from Sach s ";
        return entityManager.createQuery(jpql, Sach.class).getResultList();

    }

    @Override
    public List<Sach> getSachByTitle(String title) {
        String jpql = "select s  from Sach s where s.title= :t";
        TypedQuery<Sach> query = entityManager.createQuery(jpql, Sach.class);
        query.setParameter("t", title);
        return query.getResultList();
    }

    @Override
    public Sach updateSach(Sach sach) {
      return entityManager.merge(sach);
    }

    @Override
    public void deleteById(int id) {
        Sach sach = entityManager.find(Sach.class,id);
        entityManager.remove(sach);
    }

    @Override
    public void deleteByTitle(String title) {
        String jpql = "DELETE FROM Sach s WHERE s.title = :title";
        Query query = entityManager.createQuery(jpql);
        query.setParameter("title", title);
        query.executeUpdate();
    }


}
