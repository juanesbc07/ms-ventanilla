package com.reto.backend.dao.DaoImpl;

import com.reto.backend.dao.TestDao;
import com.reto.backend.dto.TestDto;
import com.reto.backend.mappers.TestMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TestDaoImpl implements TestDao {

    @Autowired
    @Qualifier("JdbcTemplateRetoBackend")
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    private final JdbcTemplate jdbcTemplate;

    private static final String SQL_GET_TEST_BY_ID = "SELECT * FROM TESTS t WHERE ID = :ID";
    private static final String SQL_GET_LIST_TEST = "SELECT * FROM TESTS t ";
    private static final String SQL_CREATE_TEST = "INSERT INTO TESTS (ID, NAME, DESCRIPTION) VALUES (?,?,?)";
    private static final String SQL_DELETE_TEST = "DELETE FROM TESTS t WHERE id = ?";
    private static final String SQL_UPDATE_TEST = "UPDATE TESTS SET NAME = ?, DESCRIPTION = ? WHERE ID = ?";


    public TestDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }




    @Override
    public TestDto getTestById(int idTest) {
        return namedParameterJdbcTemplate.query(SQL_GET_TEST_BY_ID,
                new MapSqlParameterSource("ID", idTest), rs -> {
            TestDto testDto = new TestDto();
            if (rs.next()){
                testDto.setId(rs.getInt("ID"));
                testDto.setName(rs.getString("NAME"));
                testDto.setDescription(rs.getString("DESCRIPTION"));
            }
            return testDto;
                });
    }

    @Override
    public List<TestDto> getListTest() {
            return namedParameterJdbcTemplate.query(SQL_GET_LIST_TEST, new TestMapper());
    }

    @Override
    public void createTest(TestDto testDto) {
        jdbcTemplate.update(SQL_CREATE_TEST, testDto.getId(), testDto.getName(), testDto.getDescription());
    }

    @Override
    public void deleteTest(int idTest) {
        jdbcTemplate.update(SQL_DELETE_TEST, idTest);
    }

    @Override
    public void updateTest(TestDto testDto) { jdbcTemplate.update(SQL_UPDATE_TEST, testDto.getName(), testDto.getDescription(), testDto.getId()); }
}

