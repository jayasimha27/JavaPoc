/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.spring.jdbc.template;

import com.example.spring.si.object.Employee;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author jjagadee
 */
public class CustomerDao {

    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void createTable() {
        String createQuery = "create table customer(id varchar(255) primary key, name varchar(255), email varchar(255))";
        jdbcTemplate.execute(createQuery);
    }

    public int saveEmployee(Customer e) {
        String query = "insert into customer values('" + e.getCutomerId() + "'  ,'" + e.getName() + "'  ,'" + e.getEmail() + "'  )";
        return jdbcTemplate.update(query);
    }

    public int updateEmployee(Customer e) {
        String query = "update customer set id ='" + e.getCutomerId() + "',name='" + e.getName() + "' where email='" + e.getEmail() + "'";
        return jdbcTemplate.update(query);
    }

    public int deleteEmployee(Customer e) {
        String query = "delete from customer where id='" + e.getCutomerId() + "' ";
        return jdbcTemplate.update(query);
    }

    public Boolean saveCustomereByPreparedStatement(final Customer e) {
        String query = "insert into customer values(?,?,?)";
        return jdbcTemplate.execute(query, new PreparedStatementCallback<Boolean>() {
            @Override
            public Boolean doInPreparedStatement(PreparedStatement ps)
                    throws SQLException, DataAccessException {

                ps.setString(1, e.getCutomerId());
                ps.setString(2, e.getName());
                ps.setString(3, e.getEmail());

                return ps.execute();

            }
        });

    }

    public List<Customer> getAllCustomers() {
        return jdbcTemplate.query("select * from customer", new ResultSetExtractor<List<Customer>>() {
            @Override
            public List<Customer> extractData(ResultSet rs) throws SQLException,
                    DataAccessException {

                List<Customer> list = new ArrayList<Customer>();
                while (rs.next()) {
                    Customer e = new Customer();
                    e.setCutomerId(rs.getString(1));
                    e.setName(rs.getString(2));
                    e.setEmail(rs.getString(3));
                    list.add(e);
                }
                return list;
            }
        });

    }

    public List<Customer> getAllCustomersRowMapper() {
        return jdbcTemplate.query("select * from customer", new RowMapper<Customer>() {
            @Override
            public Customer mapRow(ResultSet rs, int rownumber) throws SQLException {
                Customer e = new Customer();
                e.setCutomerId(rs.getString(1));
                e.setName(rs.getString(2));
                e.setEmail(rs.getString(3));
                return e;
            }
        });
    }
}
