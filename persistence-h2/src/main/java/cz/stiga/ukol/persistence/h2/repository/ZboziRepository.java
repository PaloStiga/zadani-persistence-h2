package cz.stiga.ukol.persistence.h2.repository;

import cz.stiga.ukol.persistence.h2.model.Zbozi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ZboziRepository extends JpaRepository<Zbozi, Long> {
    List<Zbozi> findByEanAndDatumCasAfterAndDatumCasBefore(String ean, LocalDateTime datumOd, LocalDateTime datumDo);

}
