package br.com.pebas.pebasdelivery.repository.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class PessoaTempleteService {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public boolean checkExistenceCPF(String cpf){
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT COUNT(*) FROM PESSOA P WHERE ");
        sql.append("REPLACE(REPLACE(P.CPF,'.',''),'-','') = ");
        sql.append("REPLACE(REPLACE('");
        sql.append(cpf);
        sql.append("','.',''),'-','') ");
        return jdbcTemplate.queryForObject(sql.toString(), Integer.class) > 0;
    }

}
