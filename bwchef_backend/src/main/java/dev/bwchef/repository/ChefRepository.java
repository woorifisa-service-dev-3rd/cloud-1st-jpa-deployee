package dev.bwchef.repository;

import dev.bwchef.model.Chef;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ChefRepository  {

    // jpa의 entitymanager를 자동으로 주입받음 -> 엔티티 crud 작업을 수행
    @PersistenceContext
    private EntityManager entityManager;

    // 데이터베이스 작업이 시작될때 트랜잭션이 열리고, 메소드가 완료되면 트랜잭션 커밋!
    // 예외 발생시 트랜잭션 커밋
    @Transactional
    public List<Chef> findAll(){
        return entityManager.createQuery("SELECT c FROM Chef c", Chef.class).getResultList();
    }

    @Transactional
    public Chef save(Chef chef){
        entityManager.persist(chef);
        return chef;
    }

    @Transactional
    public Chef update(Chef chef){
        return entityManager.merge(chef);
    }

    @Transactional
    public void delete(Long id){
        Chef chef = entityManager.find(Chef.class, id);
        if(chef != null){
            entityManager.remove(chef);
        }
    }
}
