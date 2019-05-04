@Grab("h2")

import java.sql.ResultSet

class ContactDao {

    @Autowired
    JdbcTemplate jdbcTemplate;
    String SELECT_ALL = "select id, firstName, lastName, phoneNumber, emailAddress from contacts order by lastName"

    String SAVE_ONE = "insert into contacts (firstName, lastName, phoneNumber, emailAddress) " +
            "values (?, ?, ?, ?)"

    List<Contact> findAll(){
        jdbcTemplate.query(SELECT_ALL, new RowMapper<Contact>(){
            Contact mapRow(ResultSet rs, int rowNum){
                new Contact(id: rs.getLong(1), firstName: rs.getString(2),
                lastName: rs.getString(3), phoneNumber: rs.getString(4),
                emailAddress: rs.getString(5))
            }
        })
    }

    void save(Contact contact){
        jdbcTemplate.update(SAVE_ONE, contact.firstName, contact.lastName, contact.phoneNumber, contact.emailAddress)
    }
}
