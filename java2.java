import java.io.*;
class Student implements Serializable {
    private static final long serialVersionUID = 1L; 
    private int studentID;
    private String name;
    private double grade;
    public Student(int studentID, String name, double grade) {
        this.studentID = studentID;
        this.name = name;
        this.grade = grade;
    }
    @Override
    public String toString() {
        return "Student ID: " + studentID + ", Name: " + name + ", Grade: " + grade;
    }
}
public class SerializationExample {
    public static void main(String[] args) {
        Student student = new Student(101, "Alice", 9.5);
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("student.ser"))) {
            oos.writeObject(student);
            System.out.println("Student object serialized successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        }
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("student.ser"))) {
            Student deserializedStudent = (Student) ois.readObject();
            System.out.println("Deserialized Student:");
            System.out.println(deserializedStudent);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
