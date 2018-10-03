package br.com.yansi.models;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import br.com.yansi.enums.BookType;

@Embeddable
public class Price {

	@Column(scale = 2)
	private BigDecimal value;
	private BookType bookTipe;
	
	
	public BigDecimal getValue() {
		return value;
	}
	public void setValue(BigDecimal value) {
		this.value = value;
	}
	public BookType getBookTipe() {
		return bookTipe;
	}
	public void setBookTipe(BookType bookTipe) {
		this.bookTipe = bookTipe;
	}
	
	
}
