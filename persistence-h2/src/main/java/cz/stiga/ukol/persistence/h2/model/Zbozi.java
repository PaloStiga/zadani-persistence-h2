package cz.stiga.ukol.persistence.h2.model;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "ZBOZI")
@Data
public class Zbozi {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_ZBOZI")
    @SequenceGenerator(name = "SEQ_ZBOZI", sequenceName = "SEQ_ZBOZI", allocationSize = 1)
    private Long id;

    private String ean;

    private Integer pocet;

    @Column(name = "CENA_CELKEM")
    private BigDecimal cenaCelkem;

    @Column(name = "DATUM_CAS")
    private LocalDateTime datumCas;

}
