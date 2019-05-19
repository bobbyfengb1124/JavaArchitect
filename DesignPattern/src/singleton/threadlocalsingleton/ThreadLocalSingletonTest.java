package singleton.threadlocalsingleton;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


public class ThreadLocalSingletonTest {

//	public static void main(String[] args) {
//
//		for(int i=0;i<10;i++) {
//			Thread test=new Thread(new Runnable() {
//				
//				@Override
//				public void run() {
//				
//					System.out.println("Im in "+ Thread.currentThread().getName());
//					
//					System.out.println("thread local"
//							+ ""+
//							ThreadLocalSingleton.getInstance()
//				);
//					
//				}
//			});
//			
//			test.start();
//			
//		}
//		
//	}

    public static void main(String[] args) {

//		Class clazz = ThreadLocalSingleton.class;
//		try {
//			Constructor constructor = clazz.getDeclaredConstructor(null);
//			constructor.setAccessible(true);
//			System.out.println("1111");
//			Object hungrySingleton1 = constructor.newInstance();
////			new HungrySingleton();
//			System.out.println("use relection method to get object is:"+hungrySingleton1);
//			Object hungrySingleton2 = ThreadLocalSingleton.getInstance();
//			System.out.println("use HungrySingleton method to get object is:"+hungrySingleton2);
//			System.out.println(hungrySingleton1==hungrySingleton2);
//		} catch (NoSuchMethodException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (SecurityException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (InstantiationException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IllegalAccessException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IllegalArgumentException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (InvocationTargetException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}


        try {
            ThreadLocalSingleton instance1 = null;

            ThreadLocalSingleton.getInstance();
            ThreadLocalSingleton instance2 = ThreadLocalSingleton.getInstance();

            FileOutputStream fos = new FileOutputStream("ThreadLocalSingleton.obj");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(instance2);
            oos.flush();
            oos.close();

            FileInputStream fis = new FileInputStream("ThreadLocalSingleton.obj");
            ObjectInputStream ois = new ObjectInputStream(fis);
            instance1 = (ThreadLocalSingleton) ois.readObject();
            ois.close();

            System.out.println(instance1);
            System.out.println(instance2);
            System.out.println(instance1 == instance2);

        } catch (Exception e) {
            e.printStackTrace();
        }


    }

}
