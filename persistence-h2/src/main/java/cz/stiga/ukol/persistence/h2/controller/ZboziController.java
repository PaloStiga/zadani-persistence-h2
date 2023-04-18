package cz.stiga.ukol.persistence.h2.controller;

import cz.stiga.ukol.persistence.dto.ZboziDto;
import cz.stiga.ukol.persistence.h2.mapper.ZboziMapper;
import cz.stiga.ukol.persistence.h2.model.Zbozi;
import cz.stiga.ukol.persistence.h2.repository.ZboziRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/ukol/persistence/h2/zbozi")
public class ZboziController {

    @Autowired
    ZboziRepository zboziRepository;

    @Operation(summary = "nový záznam pro entitu Zbozi")
    @PostMapping("/create")
    public ZboziDto create(@RequestBody ZboziDto zboziDto) {
        Zbozi newZbozi = ZboziMapper.INSTANCE.toEntity(zboziDto);
        Zbozi zbozi = zboziRepository.save(newZbozi);
        return ZboziMapper.INSTANCE.toDto(zbozi);
    }

    @Operation(summary = "vrátí všechny položky zboží")
    @ApiResponse(responseCode = "200", description = "List všech ZboziDto", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ZboziDto.class)))
    @GetMapping("/findAll")
    public List<ZboziDto> findAll() {
        return ZboziMapper.INSTANCE.toDtos(zboziRepository.findAll());
    }

    @Operation(summary = "vrátí všechny položky nákupu zboží dle EAN mezi uvedenými datumy (včetně)")
    @ApiResponse(responseCode = "200", description = "List vyhovujúcich ZboziDto", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ZboziDto.class)))
    @GetMapping("/findZboziByEanAndDate/{ean}")
    public List<ZboziDto> findZboziByEanAndDate(@PathVariable String ean,
                                                @RequestParam("datumOd") @DateTimeFormat(pattern = "d.M.yyyy") LocalDate datumOd,
                                                @RequestParam("datumDo") @DateTimeFormat(pattern = "d.M.yyyy") LocalDate datumDo) {
        List<ZboziDto> zboziDtoList = new ArrayList<>();
        LocalDateTime datumOdTime = datumOd.atStartOfDay();
        LocalDateTime datumDoTime = datumDo.atTime(LocalTime.MAX);
        List<Zbozi> zbozi = zboziRepository.findByEanAndDatumCasAfterAndDatumCasBefore(ean, datumOdTime, datumDoTime);
        if(zbozi.isEmpty()) {
            return zboziDtoList;
        }
        return ZboziMapper.INSTANCE.toDtos(zbozi);
    }

}