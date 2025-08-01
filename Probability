/*** You're playing Battleship on a grid of cells with RR rows and CC columns. There are 0
0 or more battleships on the grid, each occupying a single distinct cell. The cell in the iith row from the top and j 
jth column from the left either contains a battleship (Gi,j = 1G i,j=1) or doesn't (Gi,j =0 G i,j =0).
You're going to fire a single shot at a random cell in the grid. You'll choose this cell uniformly at random from the 
R * C possible cells. You're interested in the probability that the cell hit by your shot contains a battleship.
Your task is to implement the function getHitProbability(R, C, G) which returns this probability.
Note: Your return value must have an absolute or relative error of at most 
10−6
10 −6  to be considered correct.
Constraints
1 ≤ R, C ≤ 100
1≤R,C≤100
0 ≤ Gi , j ≤ 1 0≤G i,j ≤1
*** /

public class Main
{
	public static void main(String[] args) {
		int R = 2;
		int C = 2;
		int [][]G = {{1,1}, {1,1}};
		getHitProbability(R,C,G);

	}

	public static void getHitProbability(int R, int C, int[][] G) {
		int hits = 0 ;
		for (int[] row : G) {
			for (int column : row) {
				if(column == 1) {
					hits++;
				}
			}
		}
		System.out.println("Result: " + (double)hits / (R*C));
	}
}
