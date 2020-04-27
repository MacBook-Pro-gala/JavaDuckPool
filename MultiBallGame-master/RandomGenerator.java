import java.util.Random;

public class RandomGenerator {
	int seed;
	Random r ;
	public RandomGenerator(int seed) {
	 this.seed = seed;		
	 r = new Random(this.seed);
	}
	
	public int getRandom() {
		int num = r.nextInt(this.seed);
		//double d = Math.random();
		//int i = (int)(d*this.seed);
		return num==0?10:num;
		//return i;
	}
	public int getRandomspeed() {
		double d = Math.random();
		if (d <= 0.5) {
			int i = (int) (d * this.seed) + 3;
			return i;
		}
		else {
			int i = -((int) (d * this.seed) + 3);
			return i;
		}
	}
	
}
