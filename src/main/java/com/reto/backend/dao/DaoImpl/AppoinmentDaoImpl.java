package com.reto.backend.dao.DaoImpl;

import com.reto.backend.dao.AppoinmentDao;
import com.reto.backend.dto.AppoinmentDto;
import com.reto.backend.dto.TestDto;
import com.reto.backend.mappers.AppoinmentMapper;
import com.reto.backend.mappers.TestMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.List;

@Repository
public class AppoinmentDaoImpl implements AppoinmentDao {

    @Autowired
    @Qualifier("JdbcTemplateRetoBackend")
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    private final JdbcTemplate jdbcTemplate;

    public AppoinmentDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private static final String SQL_GET_APPOINMENT_BY_ID = "SELECT * FROM APPOINMENTS a WHERE ID = :ID";

    private static final String SQL_GET_LIST_APPOINMENTS = "SELECT * FROM APPOINMENTS";

    private static final String SQL_CREATE_APPOINMENT = "INSERT INTO APPOINMENTS (ID,ID_TEST, ID_AFFILIATE) VALUES (?, ?, ?)";

    private static final String SQL_DELETE_APPOINMENT = "DELETE FROM APPOINMENTS a WHERE ID = :ID";

    private static final String SQL_UPDATE_APPOINMENT = "UPDATE APPOINMENTS SET ID_TEST = ?, ID_AFFILIATE = ? WHERE ID = ?";

    private static final String SQL_GET_LIST_APPOINMENTS_BY_AFFILIATE = "SELECT * FROM APPOINMENTS WHERE ID_AFFILIATE = ?";

    private static final String SQL_GET_LIST_APPOINMENTS_BY_DATE = "SELECT * FROM APPOINMENTS a WHERE DATE1 BETWEEN TO_DATE(?, 'DD-MM-YYYY') AND TO_DATE(?,'DD-MM-YYYY')";

    @Override
    public AppoinmentDto getAppoinmentById(int idAppoinment) {
        return namedParameterJdbcTemplate.query(SQL_GET_APPOINMENT_BY_ID,
                new MapSqlParameterSource("ID", idAppoinment), rs -> {
                    AppoinmentDto appoinmentDto = new AppoinmentDto();
                    if (rs.next()){
                        appoinmentDto.setId(rs.getInt("ID"));
                        appoinmentDto.setHour(rs.getTime("DATE1"));
                        appoinmentDto.setDate(rs.getDate("DATE1"));
                        appoinmentDto.setIdTest(rs.getInt("ID_TEST"));
                        appoinmentDto.setIdAffiliate(rs.getInt("ID_AFFILIATE"));
                    }
                    return appoinmentDto;
                });
    }

    @Override
    public List<AppoinmentDto> getListAppoinments() {
        return namedParameterJdbcTemplate.query(SQL_GET_LIST_APPOINMENTS, new AppoinmentMapper());
    }

    @Override
    public void createAppoinments(AppoinmentDto appoinmentDto) {
        jdbcTemplate.update(SQL_CREATE_APPOINMENT, appoinmentDto.getId(), appoinmentDto.getIdTest(), appoinmentDto.getIdAffiliate());

    }

    @Override
    public void deleteAppoinment(int idAppoinment) {
        jdbcTemplate.update(SQL_DELETE_APPOINMENT, idAppoinment);

    }

    @Override
    public void updateAppoinment(AppoinmentDto appoinmentDto) {
        jdbcTemplate.update(SQL_UPDATE_APPOINMENT, appoinmentDto.getIdTest(), appoinmentDto.getIdAffiliate(), appoinmentDto.getId());
    }

    @Override
    public List<AppoinmentDto> getListAppoinmentsByAffiliate(int idAffiliate) {

        return jdbcTemplate.query(SQL_GET_LIST_APPOINMENTS_BY_AFFILIATE,
                (rs, rowNum) -> new AppoinmentDto(rs.getInt("id"),
                                                  rs.getTime("date1"),
                                                  rs.getDate("date1"),
                                                  rs.getInt("id_test"),
                                                  rs.getInt("id_affiliate")),idAffiliate);

    }

    @Override
    public List<AppoinmentDto> getListAppoinmentsByDate(String date, String nextDay) {


        return jdbcTemplate.query(SQL_GET_LIST_APPOINMENTS_BY_DATE,
                (rs, rowNum) -> new AppoinmentDto(rs.getInt("id"),
                        rs.getTime("date1"),
                        rs.getDate("date1"),
                        rs.getInt("id_test"),
                        rs.getInt("id_affiliate")),date,nextDay);
    }


}
