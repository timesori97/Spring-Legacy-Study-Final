package www.silver.hom;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String[][] tdata={
				{"����","����","�λ�","õ��","�뱸"},
				{"������","����ȭ","������","����ȭ","������"},
				{"0910","0850","1000","1200","0945"},
				{"1010","1012","1520","1350","1300"}
				};		
		String sword="õ��";		
		
		System.out.println(tdata[0]); // {"����","����","�λ�","õ��","�뱸"}
		System.out.println(tdata[1]);  // {"������","����ȭ","������","����ȭ","������"}
		
		System.out.println(tdata[0].length);
		for(int i=0; i< tdata[0].length; i++) {
			String nowcity = tdata[0][i];
			if(sword.equals(nowcity)) {
				System.out.println(tdata[0][i]);  //������
				System.out.println(tdata[1][i]);  //������
				System.out.println(tdata[2][i]);  //��߽ð�
				System.out.println(tdata[3][i]);  //�����ð�
			}
			
		}

	}

}
