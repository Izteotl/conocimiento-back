package com.tis.interes.compuesto.service;

import com.tis.interes.compuesto.dto.Registro;
import com.tis.interes.compuesto.dto.RequestInteresDTO;
import com.tis.interes.compuesto.dto.ResponseInteresDTO;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
@Service
public class InteresCompuestoServiceImpl implements InteresCompuestoService{

    public ResponseInteresDTO calcular(RequestInteresDTO requestInteresDTO){
        ResponseInteresDTO responseInteresDTO = new ResponseInteresDTO();
        List<Registro> registros = new ArrayList<>();
        RequestInteresDTO actual = requestInteresDTO;
        BigDecimal aportacionesAnuales = BigDecimal.ZERO;
        BigDecimal invesionInicial = requestInteresDTO.getInversionInicial();
        for(int i=0; i< requestInteresDTO.getAnosDeInversion(); i++){
            BigDecimal siA = actual.getInversionInicial().add(actual.getAportacionAnual());
            BigDecimal red = actual.getRendimientoInversion().divide(new BigDecimal(100));
            BigDecimal rendimiento = (siA.multiply(red));
            BigDecimal saldoFina = actual.getInversionInicial().add(actual.getAportacionAnual()).add(rendimiento);

            Registro response = new Registro();
            response.setAno(i+1);
            response.setSaldoInicial(actual.getInversionInicial().setScale(0, RoundingMode.UP));
            response.setAportacion(actual.getAportacionAnual().setScale(0, RoundingMode.UP));
            response.setRendimiento(rendimiento.setScale(0, RoundingMode.UP));
            response.setSaldoFinal(saldoFina.setScale(0, RoundingMode.UP));


            aportacionesAnuales = aportacionesAnuales.add(actual.getAportacionAnual()).setScale(0,RoundingMode.UP);

            registros.add(response);
            actual.setInversionInicial(response.getSaldoFinal());
            BigDecimal nuevaAportacion = actual.getIncrementoAnual().divide(new BigDecimal(100)).multiply(actual.getAportacionAnual()).setScale(0,RoundingMode.UP);
            actual.setAportacionAnual(response.getAportacion().add(nuevaAportacion));
        }
        BigDecimal saldoFinal = registros.get(registros.size()-1).getSaldoFinal();
        BigDecimal inicialAportaciones = invesionInicial.add(aportacionesAnuales);
        responseInteresDTO.setRegistros(registros);
        responseInteresDTO.setGananciaInversion(saldoFinal.subtract(inicialAportaciones).setScale(0,RoundingMode.UP));
        responseInteresDTO.setMontoFinal(saldoFinal);
        return responseInteresDTO;
    }
}
