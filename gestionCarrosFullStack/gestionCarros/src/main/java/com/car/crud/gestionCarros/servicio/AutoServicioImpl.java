package com.car.crud.gestionCarros.servicio;

import com.car.crud.gestionCarros.entidades.Auto;
import com.car.crud.gestionCarros.entidades.Usuario;
import com.car.crud.gestionCarros.repositorio.AutoRepositorio;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AutoServicioImpl implements AutoServicio {

    private final AutoRepositorio autoRepositorio;

    /**
     * Metodo contructor
     * @param autoRepositorio
     */
    public AutoServicioImpl(AutoRepositorio autoRepositorio) {
        this.autoRepositorio = autoRepositorio;
    }

    /**
     * Metodo para guardar un auto
     * @param auto
     * @return
     */
    @Override
    public Auto save(Auto auto) {
        System.out.println("Iniciando autos"+auto.getAno());
        Usuario usuario = auto.getUsuario();
        return autoRepositorio.save(auto);
    }

    /**
     * Metodo que me permite listar todos los autos creados
     * @return
     */
    @Override
    public List<Auto> findAll() {
        return autoRepositorio.findAll();
    }


    /**
     * Metodo para retornar un auto dado su identificador
     * @param id
     * @return
     */
    public Auto findById(String id) {
        Auto auto = autoRepositorio.findById(id).orElseThrow(
                () -> new RuntimeException("No se encontro el auto.")
        );

        return auto;
    }

    /**
     * Metodo para lisatr todos los autos d eun usaurio
     * @param idUsuario
     * @return una lista con todos los autos de un usuario
     */
    @Override
    public List<Auto> findByUsuario(String idUsuario) {
        return autoRepositorio.findByUsuario_id(idUsuario);
    }

    /**
     * Metodo par aleiminar un auto
     * @param id
     */
    @Override
    public  void deleteById(String id) {
        autoRepositorio.deleteById(id);
    }

    /**
     * Metodo para actualizar un auto
     * @param auto
     * @return
     */
    public Auto update(Auto auto) {
        return autoRepositorio.save(auto);
    }


}
