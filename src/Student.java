/**
 * Represents a Student within the educational reporting system.
 * This class is designed to be immutable regarding identity (Name) but mutable
 * regarding state (Marks), reflecting the reality of grade updates.
 * 
 * @author H.M.Ishara Lakshitha Bandara
 * @version 1.0
 * @since 2025-11-25
 */
class Student {
    private final String name;
    private int marks;

    /**
     * Constructs a new Student.
     * 
     * @param name  The unique identifier/name of the student.
     * @param marks The score obtained (0-100).
     */
    public Student(String name, int marks) {
        this.name = name;
        this.marks = marks;
    }

    /**
     * Gets the student's name.
     * 
     * @return The name of the student.
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the student's marks.
     * 
     * @return The marks of the student.
     */
    public int getMarks() {
        return marks;
    }

    /**
     * Updates the student's marks.
     * 
     * @param marks The new score to assign.
     */
    public void setMarks(int marks) {
        this.marks = marks;
    }

    /**
     * Returns a formatted string representation of the student.
     * Format: "Name          : Marks"
     * 
     * @return Formatted output for alignment in leaderboard.
     */
    @Override
    public String toString() {
        // Formatted output for alignment in leaderboard
        return String.format("%-15s : %3d", name, marks);
    }
}