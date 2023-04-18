package cz.stiga.ukol.persistence.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ZboziDto {

    private Long id;
    private String ean;
    private Integer pocet;
    private BigDecimal cenaCelkem;
    private LocalDateTime datumCas;

}
