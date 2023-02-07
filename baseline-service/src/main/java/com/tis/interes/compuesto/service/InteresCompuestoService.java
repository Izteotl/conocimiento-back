package com.tis.interes.compuesto.service;

import com.tis.interes.compuesto.dto.RequestInteresDTO;
import com.tis.interes.compuesto.dto.ResponseInteresDTO;

import java.util.List;

public interface InteresCompuestoService {

    public ResponseInteresDTO calcular(RequestInteresDTO requestInteresDTO);
}
