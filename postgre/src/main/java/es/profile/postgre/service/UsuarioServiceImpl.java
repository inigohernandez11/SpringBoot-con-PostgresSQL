package es.profile.postgre.service;

import es.profile.postgre.dto.UsuarioCreateDto;
import es.profile.postgre.dto.UsuarioDto;
import es.profile.postgre.mapper.ObjectMapper;
import es.profile.postgre.repository.models.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UsuarioServiceImpl implements UsuarioService {

    private final es.profile.postgre.repository.UsuarioRepository usuarioRepository;
    private final ObjectMapper mapper;
    @Override
    public List<UsuarioDto> findAll(){
        return mapper.map(usuarioRepository.findAll(),UsuarioDto.class);
    }
    @Transactional
    @Override
    public UsuarioDto insert(UsuarioCreateDto usuario) {
        return mapper.map(usuarioRepository.save(mapper.map(usuario, UsuarioRepository.class)), UsuarioDto.class);
    }

    @Override
    public UsuarioDto getById(Integer id){
        return usuarioRepository.findById(id)
                .map(value -> mapper.map(value, UsuarioDto.class))
                .orElse(null);
    }
    @Transactional
    @Override
    public UsuarioDto deleteById(Integer id){
        Optional<UsuarioRepository> usuario = usuarioRepository.findById(id);
        usuarioRepository.deleteById(id);
        return usuario.map(value -> mapper.map(value,UsuarioDto.class))
                .orElse(null);
    }


}
