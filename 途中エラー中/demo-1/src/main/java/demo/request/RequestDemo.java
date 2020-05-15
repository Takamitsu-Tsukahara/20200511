package demo.request;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;


@Data
public class RequestDemo {

	private Integer id;

	@DateTimeFormat(pattern = "yyyy/MM/dd")
	private Date datadb;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDatadb() {
		return datadb;
	}

	public void setDatadb(Date datadb) {
		this.datadb = datadb;
	}

}
