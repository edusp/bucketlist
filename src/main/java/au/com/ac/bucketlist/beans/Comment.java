package au.com.ac.bucketlist.beans;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Comment {

	private long id;
	private String commentDescription;
	private Calendar comentDate;

	@Id
	@GeneratedValue
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Column(name = "coment_escription", length = 200)
	public String getCommentDescription() {
		return commentDescription;
	}

	public void setCommentDescription(String commentDescription) {
		this.commentDescription = commentDescription;
	}

	@Column(name = "coment_date")
	@Temporal(TemporalType.DATE)
	public Calendar getComentDate() {
		return comentDate;
	}

	public void setComentDate(Calendar comentDate) {
		this.comentDate = comentDate;
	}

}
