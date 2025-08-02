package com.car.crud.gestionCarros.controlador;

import com.car.crud.gestionCarros.entidades.Auto;
import com.car.crud.gestionCarros.entidades.Usuario;
import com.car.crud.gestionCarros.servicio.AutoServicio;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("api/auto")
public class AutoControlador {
    private final AutoServicio autoServicio;

    public AutoControlador(AutoServicio autoServicio) {
        this.autoServicio = autoServicio;
    }


    //creacion de endpoints


    //http:localhost:8080/api/auto/agregar
    @PostMapping("/agregar")
    public Auto save(@RequestBody Auto auto) {
        return autoServicio.save(auto);}


    //http://localhost:8080/api/auto/listar
    @GetMapping("/listar")
    public List<Auto> findAll() {return autoServicio.findAll();}

    //http://localhost:8080/api/auto/listar/autos/idUsuario
    @GetMapping("/listar/autos/{idUsuario}")
    public List<Auto> findByUsuario(@PathVariable String idUsuario) {return autoServicio.findByUsuario(idUsuario);}

    //http://localhost:8080/api/autos/buscar/idAuto
    @GetMapping("/buscar/{placa}")
    public Auto findByPlaca(@PathVariable String placa) {
        return autoServicio.findById(placa);
    }

    @PatchMapping("/actualizar")
    public  Auto update(@RequestBody Auto auto) {

        Auto autoActualizar = autoServicio.findById(auto.getPlaca());

        autoActualizar.setMarca(auto.getMarca());
        autoActualizar.setModelo(auto.getModelo());
        autoActualizar.setAno(auto.getAno());
        autoActualizar.setColor(auto.getColor());

        return autoServicio.save(autoActualizar);
    }

    //http://localhost:8080/api/autos/eliminar/placa
    @DeleteMapping("/eliminar/{placa}")
    public void eliminar(@PathVariable String placa) {
        autoServicio.deleteById(placa);
    }
}
