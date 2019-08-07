package org.techsys.test.dao;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.techsys.test.model.UserVo;
import javax.annotation.Resource;

@Repository
public class UserDAO {

    @Resource
    private JdbcTemplate jdbcTemplate;

    public UserVo findById(String name){
        String querySQL = "select id,name,gender from SM_USER where name=?";
        RowMapper<UserVo> rowMapper = new BeanPropertyRowMapper(UserVo.class);
        UserVo vo = jdbcTemplate.queryForObject(querySQL, new Object[] { name }, rowMapper);
        return vo;
    }
}
