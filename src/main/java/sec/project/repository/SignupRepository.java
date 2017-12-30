package sec.project.repository;

import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;
import sec.project.domain.Signup;

@Repository
public class SignupRepository {
    
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void init(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }
    
    public void save(Signup signup) {
        this.jdbcTemplate.execute("INSERT INTO SIGNUP (username, address) VALUES ('" + signup.getName() + "', '" + signup.getAddress() + "');");
    }
    
    public void delete(int signupId) {
        this.jdbcTemplate.execute("DELETE FROM SIGNUP WHERE id = " + signupId);
    }
    
    public Signup findById(int signupId) {        
        SqlRowSet rowSet = this.jdbcTemplate.queryForRowSet("SELECT * FROM Signup WHERE id = " + signupId + ";");
        
        while(rowSet.next()) {
            return new Signup(rowSet.getInt("id"), rowSet.getString("username"), rowSet.getString("address"));
        }
        
        return null;
    }
    
    public List<Signup> getAll() {
        List<Signup> signups = new ArrayList<>();
        
        SqlRowSet rowSet = this.jdbcTemplate.queryForRowSet("SELECT * FROM Signup;");
        
        while(rowSet.next()) {
            signups.add(new Signup(rowSet.getInt("id"), rowSet.getString("username"), rowSet.getString("address")));
        }
        
        return signups;
    }
    
}
