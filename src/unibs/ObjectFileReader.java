package unibs;

import java.io.*;

public class ObjectFileReader {

    private static final String ERROR_READ_FILE = "Error: there was a problem while reading the file";
    private static final String ERROR_WRITE_FILE = "Error: there was a problem while saving the file";
    private static final String ERROR_CLOSE_FILE = "Error: there was a problem while closing the file";

    private ObjectFileReader(){

    }

    /**
     * read an object from a file
     * @param file
     * @return the object read
     */
    public static Object readObject(File file) {

        Object object = null;
        ObjectInputStream objectInputStream = null;

        try {
            objectInputStream =  new ObjectInputStream(new BufferedInputStream(new FileInputStream(file)));
            object = objectInputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println(ERROR_READ_FILE);
            e.printStackTrace();
        } finally {
            try{
                objectInputStream.close();
            } catch (IOException e) {
                System.out.println(ERROR_CLOSE_FILE);
                e.printStackTrace();
            }
        }
        return object;
    }

    public static void writeObject(File file, Object object) {
        ObjectOutputStream objectOutputStream = null;
        try {
            objectOutputStream = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(file)));
            objectOutputStream.writeObject(object);
        } catch (IOException e) {
            System.out.println(ERROR_WRITE_FILE);
            e.printStackTrace();
        } finally {
            try {
                objectOutputStream.close();
            } catch (IOException e) {
                System.out.println(ERROR_CLOSE_FILE);
                e.printStackTrace();
            }
        }
    }



}
