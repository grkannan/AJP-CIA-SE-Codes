public class electricity implements java.io.Serializable{
	int code, unit;
	electricity(int c, int u){
		code = c;
		unit = u;
	}
	public double calc(){
		double amt = 0;
		if (unit <=100) amt = amt+(unit*2.0);
		else amt = amt+(unit*3.0);
		return amt;
	}
}
