class Graph
{
	private static double[][] matrix1 =
	{
		{0.0, 5.0, 0.0, 0.0, 0.0, 0.0},
		{5.0, 0.0, 5.0, 5.0, 0.0, 0.0},
		{0.0, 5.0, 0.0, 5.0, 0.0, 0.0},
		{0.0, 5.0, 5.0, 0.0, 0.0, 0.0},
		{0.0, 0.0, 0.0, 0.0, 5.0, 0.0},
		{0.0, 0.0, 0.0, 0.0, 0.0, 5.0},
	};

	private static double[][] matrix2 =
	{
		{0.0, 5.0, 0.0, 0.0, 0.0, 0.0},
		{0.0, 0.0, 5.0, 5.0, 0.0, 0.0},
		{0.0, 5.0, 0.0, 5.0, 0.0, 0.0},
		{0.0, 5.0, 5.0, 0.0, 0.0, 0.0},
		{0.0, 0.0, 0.0, 0.0, 5.0, 0.0},
		{0.0, 0.0, 0.0, 0.0, 0.0, 5.0},
	};

	private static boolean isSymmetric(double[][] matrix)
	{
		assert(matrix!=null);
		assert(matrix[0]!=null);
		assert(matrix.length==matrix[0].length);

		for(int spalte=0; spalte<matrix.length; spalte++){
			for(int zeile=0; zeile<=spalte; zeile++){
				if(matrix[zeile][spalte] != matrix[spalte][zeile]){
					return false;
				}
			}
		}
		return true;
	}

	private static boolean isTriviallyWeighted(double[][] matrix)
	{
		assert(matrix!=null);
		assert(matrix[0]!=null);
		assert(matrix.length==matrix[0].length);
		
		double tmp = 0;
		
		outerloop:
		for(int spalte=0; spalte<matrix.length; spalte++){
			for(int zeile=0; zeile<matrix[0].length; zeile++){
				if(matrix[zeile][spalte] != 0.0){
					tmp = matrix[zeile][spalte];
					break outerloop;
				}
			}
		}

		for(int spalte=0; spalte<matrix.length; spalte++){
			for(int zeile=0; zeile<=spalte; zeile++){
				if(matrix[zeile][spalte] != tmp && matrix[zeile][spalte] != 0.0){
					return false;
				}
				if(matrix[spalte][zeile] != tmp && matrix[spalte][zeile] != 0.0){
					return false;
				}
			}
		}
		return true;
	}

	public static void main(String[] args)
	{
		System.out.println("isSymmetric: " + isSymmetric(matrix1) + ", " + isSymmetric(matrix2));
		System.out.println("isTriviallyWeighted: " + isTriviallyWeighted(matrix1) + ", " + isTriviallyWeighted(matrix2));
	}
}

