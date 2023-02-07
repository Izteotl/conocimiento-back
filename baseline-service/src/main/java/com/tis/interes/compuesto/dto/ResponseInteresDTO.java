package com.tis.interes.compuesto.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseInteresDTO {

    private BigDecimal gananciaInversion;
    private BigDecimal montoFinal;
    private List<Registro> registros;

}
