package www.silver.hom;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String[][] tdata={
				{"서울","대전","부산","천안","대구"},
				{"새마을","무궁화","새마을","무궁화","새마을"},
				{"0910","0850","1000","1200","0945"},
				{"1010","1012","1520","1350","1300"}
				};		
		String sword="천안";		
		
		System.out.println(tdata[0]); // {"서울","대전","부산","천안","대구"}
		System.out.println(tdata[1]);  // {"새마을","무궁화","새마을","무궁화","새마을"}
		
		System.out.println(tdata[0].length);
		for(int i=0; i< tdata[0].length; i++) {
			String nowcity = tdata[0][i];
			if(sword.equals(nowcity)) {
				System.out.println(tdata[0][i]);  //지역명
				System.out.println(tdata[1][i]);  //기차명
				System.out.println(tdata[2][i]);  //출발시간
				System.out.println(tdata[3][i]);  //도착시간
			}
			
		}

	}

}
