package pyt.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class City  extends Place{
	
	@ManyToOne
	private State state;
	
	@OneToMany(mappedBy="city",fetch=FetchType.LAZY)
	private List<Attraction> attractions;
	
	public State getState() {
		return state;
	}
	public void setState(State state) {
		this.state = state;
	}
	public List<Attraction> getAttractions() {
		return attractions;
	}
	public void setAttractions(List<Attraction> attractions) {
		this.attractions = attractions;
	}
}
