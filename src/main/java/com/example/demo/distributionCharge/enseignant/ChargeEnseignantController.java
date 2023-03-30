package com.example.demo.distributionCharge.enseignant;

import com.example.demo.entities.Enseignant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("api/isimm/distributionCharge/enseignant")

public class ChargeEnseignantController {

    private final ChargeEnseignantServices enseignantService;

    @Autowired
    public ChargeEnseignantController(ChargeEnseignantServices enseignantService){
        this.enseignantService=enseignantService;
    }

 
}
