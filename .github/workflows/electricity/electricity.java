import java.io.Serializable;

public class electricity  implements Serializable{
    private static final long serialVersionUID = 1L;
	int code, unit;
    electricity(int c, int u){
        code = c;
		unit = u;
    }
	public double calc(){
		double amt = 0;
		if(unit <= 100) amt = amt + (unit*2.5);
		else amt = amt + (unit*3);
		return amt;
	}
}