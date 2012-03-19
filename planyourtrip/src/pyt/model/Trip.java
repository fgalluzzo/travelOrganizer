package pyt.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class Trip {
	
	@Id
	@SequenceGenerator(name="trip_seq",sequenceName="trip_seq")
	@GeneratedValue(generator="trip_seq",strategy=GenerationType.SEQUENCE)
	private Long id;
	private String name;
	@ManyToMany(fetch=FetchType.LAZY)
	private List<State> places;
	@OneToOne
	private Plan plan;
	@ManyToOne
	private User traveler;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<State> getPlaces() {
		return places;
	}

	public void setPlaces(List<State> places) {
		this.places = places;
	}

	public Plan getPlan() {
		return plan;
	}

	public void setPlan(Plan plan) {
		this.plan = plan;
	}

	public User getTraveler() {
		return traveler;
	}

	public void setTraveler(User traveler) {
		this.traveler = traveler;
	}
}
