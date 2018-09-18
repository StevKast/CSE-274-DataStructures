import java.util.Arrays;

//Steven Kast
//CSE 274, Norm Krumpe

//Everything works here.

public class Board {
	private Character[][] data;
	private Boolean isDone;
	private int movesSoFar;
//	char[] chars = "XO-".toCharArray();
//    int len = 8;
	
	//Constructs a new board object
	public Board(){
		data = new Character[][]{
            { '-', '-', '-'},
            { '-', '-', '-'},
            { '-', '-', '-'}
        };
        isDone = false;
        movesSoFar = 0;
        
	}
	
	//Adds a move to board given a location (0-8) and what player played.
	public boolean move(int loc, char player){
		if(loc < 3){
			data[0][loc] = player;
			movesSoFar ++;
			return true;
		}else if(loc >= 3 && loc < 6){
			data[1][loc % 3] = player;
			movesSoFar ++;
			return true;
		}else if(loc < 9){
			data[2][loc % 3] = player;
			movesSoFar ++;
			return true;
		}
		return false;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.deepHashCode(data);
		result = prime * result + ((isDone == null) ? 0 : isDone.hashCode());
		result = prime * result + movesSoFar;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Board other = (Board) obj;
		if (!Arrays.deepEquals(data, other.data))
			return false;
		if (isDone == null) {
			if (other.isDone != null)
				return false;
		} else if (!isDone.equals(other.isDone))
			return false;
		if (movesSoFar != other.movesSoFar)
			return false;
		return true;
	}

	//Sets the board array based on a string given.
	public void setBoard(String state){
		if(state.length() != 9){
			System.out.println("Invaild string at setBoard, must be length 9");
			return;
		}
		
		for(int i = 0; i < 3; i++){
			for(int j = 0; j < 3; j++){
				data[i][j] = state.charAt(0);
				if(state.charAt(0) != '-'){
					movesSoFar++;
				}
				state = state.substring(1);
			}
		}
	}

	@Override
	public String toString() {
		String ret = "";
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                ret += data[i][j];
            }
        }
        return  ret;
	}

	public Character[][] getData() {
		return data;
	}
	
	

}
