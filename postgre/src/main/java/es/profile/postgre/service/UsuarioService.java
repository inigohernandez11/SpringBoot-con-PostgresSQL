package es.profile.postgre.service;

import es.profile.postgre.dto.UsuarioCreateDto;
import es.profile.postgre.dto.UsuarioDto;
import es.profile.postgre.repository.models.UsuarioRepository;

import java.util.List;

public interface UsuarioService {

    List<UsuarioDto> findAll();
    UsuarioDto insert(UsuarioCreateDto usuario);
    UsuarioDto getById(Integer id);
    UsuarioDto deleteById(Integer id);
}
