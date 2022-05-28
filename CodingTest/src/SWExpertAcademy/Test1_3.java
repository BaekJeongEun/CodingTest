package SWExpertAcademy;

public class Test1_3 {

	public static void main(String[] args) {
		int arr[] = new int [10];
		String str = "53290539955364534323455987827332679340558347453272569584";
		
		for(int i=0; i<str.length(); i++) {
			
			arr[Integer.parseInt(str.substring(i, i+1))]++;
		}
		for(int i=0; i<arr.length; i++) {
			System.out.println(i+" : "+arr[i]);
		}
	}

}
