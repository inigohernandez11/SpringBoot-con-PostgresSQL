package es.profile.postgre.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
@Data
public class UsuarioDto implements Serializable {

    private Integer id;

    private String username;


    private Date birthdate;

    private Integer tlf;
}
