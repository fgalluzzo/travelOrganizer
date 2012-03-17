package pyt.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Plan {
	@Id
	@GeneratedValue
	private Long id;
	@OneToMany(fetch=FetchType.LAZY)
	private List<DayPlan> daysPlans;
	

	public List<DayPlan> getDaysPlans() {
		return daysPlans;
	}

	public void setDaysPlans(List<DayPlan> daysPlans) {
		this.daysPlans = daysPlans;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
