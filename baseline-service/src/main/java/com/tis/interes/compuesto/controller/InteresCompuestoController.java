package com.tis.interes.compuesto.controller;

import com.tis.interes.compuesto.dto.RequestInteresDTO;
import com.tis.interes.compuesto.dto.ResponseInteresDTO;
import com.tis.interes.compuesto.service.InteresCompuestoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/interes")
@CrossOrigin(origins = "http://localhost:4200")
public class InteresCompuestoController {

    @Autowired
    private InteresCompuestoService interesCompuestoService;

    @PostMapping
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public ResponseInteresDTO calculaInteres(@RequestBody RequestInteresDTO requestInteresDTO){
        return interesCompuestoService.calcular(requestInteresDTO);
    }
}
