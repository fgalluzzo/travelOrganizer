package pyt.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class State extends Place {
	
	@ManyToOne
	private Country country;
	
	@OneToMany(mappedBy="state",fetch=FetchType.LAZY)
	private List<City> cities;
	

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		country.getStates().add(this);
		this.country = country;
	}

	public List<City> getCities() {
		return cities;
	}

	public void setCities(List<City> cities) {
		this.cities = cities;
	}
}
