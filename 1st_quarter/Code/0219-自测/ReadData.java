
import java.io.*;

public class ReadData{
	public static void main(String[] args) throws IOException{
		readData();
	}

	private static void readData() throws IOException{
		DataInputStream in = null;
		double total = 0.0;
		try{
			in = new DataInputStream(new BufferedInputStream(new FileInputStream("shoppingcart.data")));
			double price;
			int unit;
			String desc;
			try{
				while(true){
					price = in.readDouble();
					unit  = in.readInt();
					desc  = in.readUTF();
					total += unit*price;
				}
			}catch(EOFException e){
			
			}
			System.out.format("TOTALprice:$%.2f%n",total);
		}finally{
			in.close();
		}
	}
}
