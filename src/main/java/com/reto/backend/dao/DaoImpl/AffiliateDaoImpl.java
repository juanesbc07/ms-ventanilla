package com.reto.backend.dao.DaoImpl;

import com.reto.backend.dao.AffiliateDao;
import com.reto.backend.dto.AffiliateDto;
import com.reto.backend.mappers.AffiliateMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AffiliateDaoImpl implements AffiliateDao {



    @Autowired
    @Qualifier("JdbcTemplateRetoBackend")
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    private final JdbcTemplate jdbcTemplate;

    private static final String SQL_GET_AFFILIATE_BY_ID = "SELECT * FROM AFFILIATES a WHERE ID = :ID";

    private static final String SQL_GET_LIST_AFFILIATE = "SELECT * FROM AFFILIATES a ";

    private static final String SQL_CREATE_AFFILIATE ="INSERT INTO AFFILIATES (ID, NAME, AGE, MAIL) VALUES (?,?,?,?)";

    private static final String SQL_DELETE_AFFILIATE = "DELETE FROM AFFILIATES a WHERE ID = ?";

    private static final String SQL_UPDATE_AFFILIATE = "UPDATE AFFILIATES a SET NAME = ?, AGE = ?, MAIL = ? WHERE ID = ?";

    public AffiliateDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public AffiliateDto getAffiliateById(int idAffiliate) {
        return namedParameterJdbcTemplate.query(SQL_GET_AFFILIATE_BY_ID,
                new MapSqlParameterSource("ID", idAffiliate), rs -> {
                    AffiliateDto affiliateDto = new AffiliateDto();
                    if (rs.next()){
                        affiliateDto.setId(rs.getInt("ID"));
                        affiliateDto.setName(rs.getString("NAME"));
                        affiliateDto.setAge(rs.getInt("AGE"));
                        affiliateDto.setMail(rs.getString("MAIL"));
                    }
                    return affiliateDto;
                });
    }

    @Override
    public List<AffiliateDto> getListAffiliate() {

        return namedParameterJdbcTemplate.query(SQL_GET_LIST_AFFILIATE, new AffiliateMapper());

    }

    @Override
    public void createAffiliate(AffiliateDto affiliateDto) {
        jdbcTemplate.update(SQL_CREATE_AFFILIATE, affiliateDto.getId(), affiliateDto.getName(), affiliateDto.getAge(), affiliateDto.getMail());
    }

    @Override
    public void deleteAffiliate(int idAffiliate) {
        jdbcTemplate.update(SQL_DELETE_AFFILIATE, idAffiliate);
    }

    @Override
    public void updateAffiliate(AffiliateDto affiliateDto) {
        jdbcTemplate.update(SQL_UPDATE_AFFILIATE, affiliateDto.getName(), affiliateDto.getAge(), affiliateDto.getMail(), affiliateDto.getId());
    }

}
