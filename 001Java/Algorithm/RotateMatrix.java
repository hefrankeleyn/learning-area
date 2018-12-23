public class RotateMatrix{
	public static void main(String[] args){
		/*int[][] matrix = {
			            {1,2,3},
						{4,5,6},
						{7,8,9}
					   };*/
		int[][] matrix = {
			            {1,5,9 ,13},
						{2,6,10,14},
						{3,7,11,15},
						{4,8,12,16}
					   };
		RotateMatrix rM = new RotateMatrix();
		rM.print2DArray(matrix);
		rM.solution(matrix);
		//System.out.println("*****************");
		//rM.print2DArray(matrix);
	}
	
	private void print2DArray(int[][] matrix){
		for(int i=0; i<matrix.length; i++){
			for(int j=0;j<matrix[i].length; j++){
				System.out.print(matrix[i][j]+",");
			}
			System.out.println();
		}
	}
	private void printArray(int[] arr){
		for(int i=0;i<arr.length;i++){
			System.out.print(arr[i]+",");
		}
		System.out.println();
	}
	public void solution(int[][] matrix){
		int matrixLength = matrix.length;
		for(int i=matrixLength,xI=0,yI=0,c=0; i>0; i-=2,xI++,yI++,c++){
			int x=xI,y=yI;
			int x1=xI,y1=yI+i-1;
			if(i==1){
				//System.out.print("("+x+","+y+"),");
				//System.out.println(matrix[x][y]+",");
				break;
			}
			/* 3*3: 00->30,01->20,02->00,
			        12->01,22->02,21->12,
					20->22,sA[l-1],sA[l-2]
			*/
			for(int round=0; round<(i-1)*3; round++){
				System.out.print("("+x+","+y+"),");
				//System.out.print(matrix[x][y]+",");
				System.out.println("("+x1+","+y1+"),");
				//System.out.println(matrix[x1][y1]+",");
				//System.out.println("******************");
				//print2DArray(matrix);
				matrix[x][y]=matrix[x][y]^matrix[x1][y1];
				matrix[x1][y1]=matrix[x][y]^matrix[x1][y1];
				matrix[x][y]=matrix[x][y]^matrix[x1][y1];
				System.out.println("******************");
				print2DArray(matrix);
				//System.out.print("("+x+","+y+"),");
				//System.out.print(matrix[x][y]+",");
				//System.out.print("("+x1+","+y1+"),");
				//System.out.println(matrix[x1][y1]+",");
				
				if (x==xI && y==yI+i-2){
					x = xI+i-1;
					y = yI;
				}else if(x==xI && y<yI+i-1){
					y++;
				}else if(x==xI+1 && y==yI){
					x = xI+i-1;
					y = yI+i-1;
				}else if (x>xI+1 && y==yI){
					x--;
				}else if(x==xI+i-2 && y==yI+1){
					x = xI;
					y = yI+i-1;
				}else if(x==xI+i-1 && y>yI){
					y--;
				}else if (x==xI+i-1 && y==yI+i-2){
					x = xI;
					y = yI;
				}else if (x<xI+i-1 && y==yI+i-1){
					x++;
				}
				
				
				if(x1==xI+i-2 && y1==yI+i-1){
					x1 = xI;
					y1 = yI;
				}else if (x1<xI+i-2 && y1==yI+i-1){
					x1++;
				}else if (x1==xI && y1==yI+i-2){
					x1 = xI+i-1;
					y1 = yI;
				}else if (x1==xI && y1<yI+i-2){
					y1++;
				}else if (x1==xI+1 && y1==yI){
					x1=xI+i-1;
					y1=yI+i-1;
				}else if (x1>xI+1 && y1==yI){
					x1--;
				}else if (x1==xI+i-1 && y1==yI+1){
					x1=xI;
					y1=yI+i-1;
				}else if(x1==xI+i-1 && y1>yI+1){
					y1--;
				}
				
				
				
				
				
				else if (x1==xI && y1==yI+i-2){
					x1 = xI+i-1;
					y1 = yI;
				}else if (x1>xI+1 && y1==yI){
					x1--;
				}else if(x1==xI+1 && y1==yI){
					x1 = xI+i-1;
					y1 = yI+i-1;
				}else if(x1==xI+i-1 && y1>yI){
					y1--;
				}else if(x1==xI+i-2 && y1==yI+1){
					x1 = xI;
					y1 = yI+i-1;
				}else if(x1==xI && y1<yI+i-1){
					y1++;
				}
				
			}
		}
	}
	
	
}