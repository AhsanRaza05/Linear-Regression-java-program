import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.nio.file.Path;

class Main{
	
	BigDecimal X[];
	BigDecimal Y[];
	
	Main() throws IOException{
		
		readFile();
		
		System.out.println("\nX.Y");
		product(X,Y);
		
		System.out.println("\n\nX Square");
		product(X);
		
		System.out.println("\n\nY Square");
		product(Y);
		
		
	}
	
		void readFile() throws IOException {

		String x;
		String y[][] = new String[2][];
		//File f = new File("/Program/Data.txt");//
		//File f = new File(FileSystems.getDefault().getPath("Data.txt"));
		File f = new File(Path.of("").toAbsolutePath().toString() + "/Data.txt");
		f.createNewFile();

		BufferedReader rd = new BufferedReader(new FileReader(f));

		/*
		 * uLlLf[0] = rd.readLine(); uLlLf[1] = rd.readLine(); uLlLf[2] = rd.readLine();
		 */

		for (int i = 0; i < 2; i++) {

			x = rd.readLine();
			// System.out.println(x);

			if (x.contains(","))
				if (x.contains(", "))
					y[i] = x.split(", ");
				else
					y[i] = x.split(",");

			else if (x.contains(" "))
				y[i] = x.split(" ");

			else {
				System.out.println("Please enter data in valid format.");
				System.exit(0);
			}
		}

		if (y[0].length != y[1].length ) {
			System.out.println("No. of X and Y should be same.");
			System.exit(0);
		}

		X = new BigDecimal[y[0].length];
		Y = new BigDecimal[y[1].length];
		
		for(int i = 0; i < X.length; i++){
			
			X[i] = new BigDecimal(y[0][i]);
			Y[i] = new BigDecimal (y[1][i]);	
		}
		
		System.out.println("Boundaries");
		for (int i = 0; i < X.length; i++)
			System.out.println(X[i] + "-" + Y[i]);
		//Frequency = new Integer[y[2].length];

		//for (Integer i = 0; i < y[2].length; i++)
			//Frequency[i] = Integer.parseInt(y[2][i]);

		y = null;

		rd.close();
	}
	
	BigDecimal Sum(BigDecimal ar[]){
		
		BigDecimal sum = new BigDecimal("0");

		for(int i = 0; i < ar.length; i++){
			
			sum = sum.add(ar[i]);
		}
		
		return sum;
	} 
	
	BigDecimal []product(BigDecimal ar1[],BigDecimal ar2[]){
		
		BigDecimal pro[] = new BigDecimal[ar1.length];

		for(int i = 0; i < ar1.length; i++){
			
			pro[i] = ar1[i].multiply(ar2[i]);
			
			System.out.print(pro[i] + " ");
		}
		System.out.print(Sum(pro) + " ");
		return pro;
	}
	
	BigDecimal []product(BigDecimal ar[]){
		
		return (product(ar,ar));
	}
	public static void main(String args[])throws IOException{
		
		new Main();
	}
	
}