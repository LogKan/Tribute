
public class TimeToSecound {

	public static void main(String[] args) {
		System.out.println(""+timeToSecond(24,0,0));

	}
	
	public static int timeToSecond(int h, int m, int s){
		int second = (h*60*60)+(m*60)+s;
		return second;
	}

}
