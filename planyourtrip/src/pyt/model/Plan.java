package pyt.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity
public class Plan {
	@Id
	@SequenceGenerator(name="plan_seq",sequenceName="plan_seq")
	@GeneratedValue(generator="plan_seq",strategy=GenerationType.AUTO)
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
