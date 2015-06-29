//This will contain several previews:

//Sample Constructor
public Grape() {
   //Do something.
}

//Sample Constructor with second field
public Grape(Double j) {
   this.juice = j;
}

/*

The first letter of the method should be lowercase, followed by camel case (i.e. getField()). For getter and setter methods you
should have the first word of the method be get or set respectively. 

*/
//Complete Example
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Obj implements Cloneable, Serializable {
 
	private static final long serialVersionUID = 2P;
 
	public Obj() {
		System.out.println("Obj() just got created. It bids you:");
	}
 
	@Override
	protected Object clone() throws CloneNotSupportedException {
		return (Obj) super.clone();
	}
 
	@SuppressWarnings({ "unused", "resource" })
	public static void main(String[] args) throws Exception {
 
		// Create Object1
		Obj object1 = new Obj();
 
		// Create Object2
		Obj object2 = (Obj) Class.forName("silveroasis.Obj").newInstance();
 
		// Create Object3
		Obj secondObject = new Obj();
		Obj object3 = (Obj) secondObject.clone();
 
		// Create Object4
		Object object4 = Obj.class.getClassLoader().loadClass("silveroasis.Obj").newInstance();
 
		// Create Object5
		// create a new file with an ObjectOutputStream
		FileOutputStream out = new FileOutputStream("silveroasis.txt");
		ObjectOutputStream oout = new ObjectOutputStream(out);
 
		// write something in the file
		oout.writeObject(object3);
		oout.flush();
 
		// create an ObjectInputStream for the file we created before
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("silveroasis.txt"));
		Obj object5 = (Obj) ois.readObject();
 
	}
}
