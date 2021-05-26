package kfh.nobel.prize.application.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "nobel_prizes")
public class Prizes {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@JsonIgnore
	private long id;
	private String year;
	private String category;
	private String overallMotivation;
	@Column(nullable = false, updatable = false)
	@UpdateTimestamp()
	private Date updatedDate;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "prizeId")
	private List<Laureate> laureates;

	public Prizes() {}

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}

	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}

	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	public List<Laureate> getLaureates() {
		return laureates;
	}
	public void setLaureates(List<Laureate> laureates) {
		this.laureates = laureates;
	}

	public String getOverallMotivation() { return overallMotivation; }

	public void setOverallMotivation(String overallMotivation) { this.overallMotivation = overallMotivation; }

	@Override
	public String toString() {
		return "Prizes{" +
				"id=" + id +
				", year='" + year + '\'' +
				", category='" + category + '\'' +
				", overallMotivation='" + overallMotivation + '\'' +
				", laureates=" + laureates +
				'}';
	}
}
