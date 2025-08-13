package fact.it.tab_service.repository;

import fact.it.tab_service.model.Tab;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public interface TabRepository extends JpaRepository<Tab, Long> {
}
