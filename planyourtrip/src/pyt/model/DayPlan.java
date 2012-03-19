package pyt.model;

import java.util.Calendar;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class DayPlan {

	@Id
	@SequenceGenerator(name="dayplan_seq",sequenceName="dayplan_seq")
	@GeneratedValue(generator="dayplan_seq",strategy=GenerationType.AUTO)
	private Long id;
	@ManyToOne
	private Place place;
	private Calendar date;
	@ManyToMany(fetch=FetchType.LAZY)
	private List<Attraction> attractions;

	public Place getPlace() {
		return place;
	}

	public void setPlace(Place place) {
		this.place = place;
	}

	public List<Attraction> getAttractions() {
		return attractions;
	}

	public void setAttractions(List<Attraction> attractions) {
		this.attractions = attractions;
	}

	public Calendar getDate() {
		return date;
	}

	public void setDate(Calendar date) {
		this.date = date;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
