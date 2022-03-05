// NJIT ID 31588410
public class Main {
	private static final int boardDim = 8;
	private  int[][] visited;

	//public static int[] i = { 2, 1, -1, -2, -2, -1, 1, 2, 2 };
	//public static int[] j = { 1, 2, 2, 1, -1, -2, -2, -1, 1 };
	public Main() {
		visited = new int[boardDim][boardDim];
	}

	public boolean limits(int x, int y) {
		if (x >= 0 && x < boardDim && y >= 0 && y < boardDim && visited[x][y] == -1) {
			return true;
		}
		return false;

	}
	
	public void printMethod()
    {
        for (int x = 0; x < boardDim; x++) {
            for (int y = 0; y < boardDim; y++)
                System.out.print(visited[x][y] + " ");
            System.out.println();
        }
    }
	public boolean knightTour(int x, int y, int there, int moveX[], int moveY[]) {
        
		
		 int newX = 0;
	     int newY = 0;
	     
	     if (there == boardDim*boardDim ) {
				return true;
			}
		
        //visited[x][y] = there;
 
        
       // if (there = boardDim*boardDim)
        //{
        	//
        	//
        	//
        	//
        	//
        	//
        	//
        	//
        	
           // printMethod(visited);
            
            //visited[x][y] = 0;
           // return;
       //}
 
        for (int i = 0; i < moveX.length; i++)
        {
           
            newX = x + moveX[i];
            newY = y + moveY[i];
 
           
            if (limits(newX, newY)) {
                visited[newX][newY] = there;
                
                if (knightTour(newX, newY, there+1, moveX, moveY)) {
                	return true; // looks ahead to the next valid square with recursive call
				} else {
					visited[newX][newY] = -1; // already been visited
				
                }
            }
            
        }
 
        return false;
       
    }
	
	
	public boolean work() {
		for (int k = 0; k < boardDim; k++) {
			for (int j = 0; j < boardDim; j++) {
				visited[k][j] = -1;
			}
		}
		
		visited[0][0] = 0;
		int moveX[] = { 2, 1, -1, -2, -2, -1, 1, 2 }; 
		int moveY[] = { 1, 2, 2, 1, -1, -2, -2, -1 };
		
		if (!knightTour(0, 0, 1, moveX, moveY)) {
			System.out.println("No solution exists");
			return false; 
		} else {
			printMethod();
		}
		return true;

	}
	
	
	public static void main(String[] args)
    {
        
        //int[][] visited = new int[boardDim][boardDim];
        //int there = 1;
		Main KnightTour = new Main();
      
        KnightTour.work();
        
    }
	
}