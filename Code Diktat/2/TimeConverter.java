import java.lang.Math;
public class TimeConverter {
	
	private int second;
	// Contoh Overload
	public TimeConverter(){	
	}
	// Contoh Overload
	public TimeConverter(int second){
		this.second=second;
	}
	// Contoh method getter
	public int getSecond(){
		return this.second;
	}
	// Contoh method setter
	public void setSecond(int second){
		this.second=Math.abs(second);
	}
	
	public String showTime(){
		int x = this.getSecond();
		int temp=0;
		int y=3600;
		String s = "";
		for(int i=0;i<3;i++){
			if(i<2){
				temp=Math.round(x/y);
				x=x%y;
				y=y/60;
				if(temp<10){
					s= s+"0"+temp+":";
				}
				else if(temp>=10){
					s= s+temp+":";
				}
			}
			else if(i==2){
				if(x<10){
					s= s+"0"+x;
				}
				else if(x>=10){
					s= s+x;
				}
			}
		}
		s="Converted time : "+s;
		return s;
	}
}	