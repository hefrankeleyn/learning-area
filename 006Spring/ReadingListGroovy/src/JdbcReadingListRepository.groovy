import java.sql.ResultSet
@Repository
class JdbcReadingListRepository implements ReadingListRepository{


    @Autowired
    JdbcTemplate jdbc;
    @Override
    List<Book> findByReader(String reader) {
        /*jdbc.quey("select id, reader, isbn, title, author, description from Book where reader=?",
                {rs, row-> new Book(id: rs.getLong(1),
                                    reader: rs.getString(2),
                                    isbn: rs.getString(3),
                                    title: rs.getString(4),
                                    author: rs.getString(5),
                                    description: rs.getString(6)
                )} as RowMapper, reader)*/

        jdbc.query("select id, reader, isbn, title, author, description from Book where reader=?", new RowMapper<Book>(){
            Book mapRow(ResultSet rs, int rowNum){
                new Book(id: rs.getLong(1),
                        reader: rs.getString(2),
                        isbn: rs.getString(3),
                        title: rs.getString(4),
                        author: rs.getString(5),
                        description: rs.getString(6))
            }
        }, reader)

    }

    @Override
    void save(Book book) {
        jdbc.update("insert into Book (reader, isbn, title, author, description) values(?, ?, ?, ?, ?)",
                    book.reader,
                    book.isbn,
                    book.title,
                    book.author,
                    book.description)
    }
}
