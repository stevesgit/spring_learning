package org.jdbc_template;

import org.bean.customer;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.annotation.Resource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class CustomerDaoImpl implements CustomerDao {

    @Resource(name = "jdbcTemplate")
    private JdbcTemplate jt;

    @Override
    public void save(customer u) {
        String sql = "insert into user values(null,?,1,'杭州', '1994-08-25')";
        jt.update(sql, u.getName());

    }

    @Override
    public void delete(Integer id) {
        String sql = "delete from user where id =  ?";
        jt.update(sql, id);
    }

    @Override
    public void update(customer u) {
        String sql = "update  user set name = ? where id =  ? ";
        jt.update(sql, u.getName(), u.getId());
    }

    @Override
    public customer getById(Integer id) {
        String sql = "select * from user  where id = ?";
        return jt.queryForObject(sql, new RowMapper<customer>() {
            @Override
            public customer mapRow(ResultSet resultSet, int i) throws SQLException {
                customer c = new customer();
                c.setId(resultSet.getInt("id"));
                c.setBirthday(resultSet.getString("birthday"));
                c.setName(resultSet.getString("name"));
                c.setSex(resultSet.getInt("sex"));
                c.setAddress(resultSet.getString("address"));
                return c;
            }
        }, id);
    }

    @Override
    public int getTotalCount() {
        String sql = "select count(*) from user  ";
        Integer count = jt.queryForObject(sql, Integer.class);
        return count;

    }

    @Override
    public List<customer> getAll() {
        String sql = "select  * from user ";
        List<customer> list = jt.query(sql, new RowMapper<customer>() {
            @Override
            public customer mapRow(ResultSet resultSet, int i) throws SQLException {
                customer c = new customer();
                c.setAddress(resultSet.getString("address"));
                c.setBirthday(resultSet.getString("birthday"));
                c.setName(resultSet.getString("name"));
                c.setId(resultSet.getInt("id"));
                c.setSex(resultSet.getInt("sex"));
                return c;
            }
        });
        return list;

    }

    public JdbcTemplate getJt() {
        return jt;
    }

    public void setJt(JdbcTemplate jt) {
        this.jt = jt;
    }

}
