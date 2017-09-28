import java.lang.reflect.*;
class reflect1{
	public static void main(String[] args) throws Exception{
		Class<?> clz = Class.forName("Employee");
		
		Constructor<?> c = clz.getConstructor(String.class,int.class);
		
		Object obj = c.newInstance("andy",23);

		Method m = clz.getDeclaredMethod("sayHello");
		m.invoke(obj);

		m = clz.getDeclaredMethod("getID");
		m.setAccessible(true);
		String id = (String)m.invoke(obj);
		System.out.println(id);

		Field[] field = clz.getDeclaredFields();
		for(int i=0;i<field.length;i++){
			// 
			int mo = field[i].getModifiers();
			String priv = Modifier.toString(mo);
			// 
			Class<?> type = field[i].getType();
			System.out.println(priv+" "+type.getName()+" "+field[i].getName()+";");
		}
	}
}
