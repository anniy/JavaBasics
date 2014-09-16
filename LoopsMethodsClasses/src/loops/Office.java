package loops;

public class Office implements Comparable<Office> {
	String town ;
	float totalIncomes;
	
	public Office(String town , float totalIncomes) {
		this.town  = town;
		this.totalIncomes = totalIncomes;
	}
	public String ToStrig() {
		return town + " Total -> " + totalIncomes;
	}
	
	public String getTown () {
		return town ;
	}
	
	public void setTotalIncomes(float totalIncomes) {
		this.totalIncomes = totalIncomes;
	}
	
	public float getTotalIncomes() {
		return totalIncomes;
	}
	
	@Override
	public int compareTo(Office o) {
		return this.town.compareTo(o.getTown());
	}
	
}
