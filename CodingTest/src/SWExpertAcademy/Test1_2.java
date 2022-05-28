package SWExpertAcademy;

public class Test1_2 {
	public static void main(String[] args) {
		int[] su = {45,80,68,19,34,55,27,60,27,18};
		float sum=0;
		for(int i=0; i<su.length; i++) {
			sum+=su[i];
		}
		float avg = sum/su.length;
		int nearest=0;
		for(int i=0; i<su.length; i++) {
			nearest = (Math.abs(avg-su[i]) < Math.abs(avg-nearest))? su[i] : nearest;
		}
		System.out.println(avg + " "+ nearest);
	}
}
