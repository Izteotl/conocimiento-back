package com.tis.interes.compuesto.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class RequestInteresDTO {
    private BigDecimal inversionInicial;
    private BigDecimal aportacionAnual;
    private BigDecimal incrementoAnual;
    private Integer anosDeInversion;
    private BigDecimal rendimientoInversion;
}
