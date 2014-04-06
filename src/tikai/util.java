package tikai;

public class util {
	final double[] dxs = {Math.cos(Math.PI * 1/6), Math.cos(Math.PI * 1/2), Math.cos(Math.PI * 7/10), Math.cos(Math.PI * 9/10), Math.cos(Math.PI * 11/10), Math.cos(Math.PI *13/10), Math.cos(Math.PI *3/2), Math.cos(Math.PI *11/6)};
	final double[] dys = {Math.sin(Math.PI * 1/6), Math.sin(Math.PI * 1/2), Math.sin(Math.PI * 7/10), Math.sin(Math.PI * 9/10), Math.sin(Math.PI * 11/10), Math.sin(Math.PI *13/10), Math.sin(Math.PI *3/2), Math.sin(Math.PI *11/6)};
	
	
	
	int[] kmeans(double[][] coords, int[] weights, int rounds) {
		int[] res = new int[weights.length];
		double[][] centers = new double[weights.length][2];
		
		return res;
	}
}
