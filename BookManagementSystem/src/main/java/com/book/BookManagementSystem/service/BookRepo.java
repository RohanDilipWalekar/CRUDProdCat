package com.book.BookManagementSystem.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.book.BookManagementSystem.model.BookDesc;

@Repository
public class BookRepo {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public List<BookDesc> getAllBooks() {
		// TODO Auto-generated method stub
		String query = "select *from booktab";
		List<BookDesc> list = jdbcTemplate.query(query, new RowMapper<BookDesc>() {

			@Override
			public BookDesc mapRow(ResultSet rs, int rowNum) throws SQLException {
				BookDesc book = new BookDesc();

				book.setBId(rs.getInt(1));
				book.setBName(rs.getString(2));
				book.setBAuthor(rs.getString(3));
				book.setBPublish(rs.getString(4));
				book.setBPrice(rs.getInt(5));
				return book;
			}
		});

		return list.size() > 0 ? list : null;
	}

	public void addBook(BookDesc book) {
		String query = "INSERT INTO booktab (BName, BAuthor, BPublisher, BPrice) VALUES (?, ?, ?, ?)";

		// Execute the update (insert) query
		jdbcTemplate.update(query, book.getBName(), book.getBAuthor(), book.getBPublish(), book.getBPrice());
	}

	public void deleteBookById(int BId) {
		String sql = "delete from booktab WHERE BId = ?";
		jdbcTemplate.update(sql, BId);
	}

	 public void updateBookById(int BId, String bAuthor, String BPublisher, int BPrice) {
	        String sql = "UPDATE booktab SET bAuthor = ?, BPublisher = ?, BPrice = ? WHERE BId = ?";
	        jdbcTemplate.update(sql, bAuthor, BPublisher, BPrice, BId);
	    }

}
