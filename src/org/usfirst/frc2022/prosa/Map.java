import java.util.Arrays;

public class Map {
	public static void main(String[] args) {
		Map map = new Map(10,10);
		System.out.println(map.toString());
	}
	
	/**
	 * @param args
	 */
	float[][] values;
	final int rows;
	final int cols;

	public Map(int rows, int cols) {
		super();
		this.rows = rows;
		this.cols = cols;
		values = new float[rows][cols];
		Reset();
	}



	@Override
	public String toString() {
		String string = "";
		for (int row = 0; row < rows; row++) {
			for (int col = 0; col < cols; col++) {
				string += values[row][col] + "\t";
			}
			string += "\n";
		}
		return string;
	}



	public float[][] getValues() {
		return values;
	}


/**
 * Make the sum of the values of the map = 1 by scaling them by 1/sum.
 */
	public void Normalize() {
		Scale(1f / Sum());
	}

	/**
	 * 
	 * @return The sum of all the values.
	 */
	public float Sum() {
		float sum = 0;
		for (int row = 0; row < rows; row++) {
			for (int col = 0; col < cols; col++) {
				sum += values[row][col];
			}
		}
		return sum;
	}

	public void Reset() {
		for (int row = 0; row < rows; row++) {
			for (int col = 0; col < cols; col++) {
				values[row][col] = 1;
			}
		}
		Normalize();
	}
	
	public void Scale(float scaler) {
		for (int row = 0; row < rows; row++) {
			for (int col = 0; col < cols; col++) {
				values[row][col] *= scaler;
			}
		}
	}

	public void Sense(float[][] pMap) {
		for (int row = 0; row < rows; row++) {
			for (int col = 0; col < cols; col++) {
				values[row][col] *= pMap[row][col];
			}
		}
		Normalize();
	}
	
	public void Move(int x,int y,float pGood,float pOver, float pUnder){
		
	}

}
