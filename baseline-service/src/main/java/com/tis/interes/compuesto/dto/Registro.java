package com.tis.interes.compuesto.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Registro {
    private Integer ano;
    private BigDecimal saldoInicial;
    private BigDecimal aportacion;
    private BigDecimal rendimiento;
    private BigDecimal saldoFinal;
}
