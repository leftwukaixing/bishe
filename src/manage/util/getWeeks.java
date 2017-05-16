package manage.util;

import java.util.ArrayList;
import java.util.List;

public class getWeeks {
	private List<Integer> ll = new ArrayList<Integer>();

	public List<Integer> getLl() {
		return ll;
	}

	public void setLl(List<Integer> ll) {
		this.ll = ll;
	}
	
	public void getWeek(String str){
		int begin = 0 , end = 0 , n1;
		n1 = str.indexOf("-");
		if(n1 == -1){
			end = Integer.parseInt(str.substring(0,str.length()));
			begin = Integer.parseInt(str.substring(0,str.length()));;
		}else{
			begin = Integer.parseInt(str.substring(0, n1));
			if(str.contains("单") || str.contains("双")){
				end = Integer.parseInt(str.substring(n1+1,str.length()-1));
			}else{
				end = Integer.parseInt(str.substring(n1+1,str.length()));
			}
		}
		
		if(str.contains("单")){
			for(int i = begin ; i <= end ; i++){
				if(i % 2 == 1)
				ll.add(i);
			}
		}
		else if(str.contains("双")){
			for(int i = begin ; i <= end ; i++){
				if(i % 2 == 0)
				ll.add(i);
			}
		}else{
			for(int i = begin ; i <= end ; i++){
				ll.add(i);
			}
		}
	}
	
	public static void main(String [] args){
		getWeeks obj = new getWeeks();
		obj.getWeek("5");
		for(Integer i : obj.getLl()){
			System.out.println(i);
		}
	}
}
