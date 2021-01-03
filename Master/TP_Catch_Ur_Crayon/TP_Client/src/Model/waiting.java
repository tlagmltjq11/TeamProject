package Model;
public class waiting {
	private int room_num;		
	private int select;			
	
	public waiting() {
		room_num = 0;
		select = 0;
	}

	public int getRoom_num() {
		return room_num;
	}

	public void addRoom_Num() {
		room_num += 1;
	}

	public int getSelect() {
		return select;
	}
	
	public void setSelect(int select) {
		this.select = select;
	}
}
