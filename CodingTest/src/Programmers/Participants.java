package Programmers;

import java.util.Arrays;

public class Participants {

	public static void main(String[] args) {
		String[] participant= {"mislav", "stanko", "mislav", "ana"};
		String[] completion= {"stanko", "ana", "mislav"};
		Arrays.sort(participant);
		Arrays.sort(completion);
		int i=0;
		for(i=0; i<completion.length; i++)
			if(!participant[i].equals(completion[i]))
				break;
		System.out.println(participant[i]);
	}

}
