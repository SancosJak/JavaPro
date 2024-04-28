package de.ait.demouser.repository;

import de.ait.demouser.models.User;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@RequiredArgsConstructor
@Repository
public class UserRepositoryJdbcImpl implements UserRepository {
    private final DataSource dataSource;
    private final JdbcTemplate jdbcTemplate;

    //language=SQL
    private static final String SQL_SELECT_BY_ID = "select * from account where id = ?";
    private static final String SQL_SELECT_ALL = "select * from account";
    private static final String SQL_DELETE_BY_ID = "DELETE FROM account WHERE id = ?";


    private static final RowMapper<User>USER_ROW_MAPPER = (row, rowNum) -> {
        Long id = row.getLong("id");
        String firstName = row.getString("first_name");
        String lastName = row.getString("last_name");
        String email = row.getString("email");
        String password = row.getString("password");

        return User.builder()
                .id(id)
                .firstName(firstName)
                .lastName(lastName)
                .email(email)
                .password(password)
                .build();
    };


    @Override
    public User findById(Long id) {
        return jdbcTemplate.queryForObject(SQL_SELECT_BY_ID, USER_ROW_MAPPER,id);
    }

    @Override
    public List<User> findAll() {
        return jdbcTemplate.query(SQL_SELECT_ALL,USER_ROW_MAPPER);
    }

    @Override
    public void save(User model) {
        SimpleJdbcInsert jdbcInsert = new SimpleJdbcInsert(dataSource)
                .usingGeneratedKeyColumns("id");
        jdbcInsert.withTableName("account");
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("first_name", model.getFirstName());
        parameters.put("last_name", model.getLastName());
        parameters.put("email", model.getEmail());
        parameters.put("password", model.getPassword());

        //jdbcInsert.execute(parameters);
        long generatedID = jdbcInsert.executeAndReturnKey(parameters).longValue();
        model.setId(generatedID);
    }

    @Override
    public void delete(User model) {
        jdbcTemplate.update(SQL_DELETE_BY_ID, model.getId());
    }
}
