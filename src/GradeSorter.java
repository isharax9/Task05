/**
 * A utility class providing advanced sorting capabilities for Student collections.
 * Implements Merge Sort for initial ordering and an optimized Insertion strategy
 * for real-time updates.
 * 
 * Key Features:
 * - Stable sorting algorithm (preserves relative order for equal marks)
 * - Guaranteed O(N log N) time complexity
 * - O(N) space complexity for auxiliary arrays
 * - Adaptive O(N) update mechanism for dynamic mark changes
 * 
 * @author H.M.Ishara Lakshitha Bandara
 * @version 1.0
 * @since 2025-11-25
 */
public class GradeSorter {

    /**
     * Sorts an array of Student objects in DESCENDING order of marks.
     * Uses the Merge Sort algorithm to guarantee O(N log N) complexity and Stability.
     * 
     * Algorithm: Divide and Conquer
     * - Divide: Split array into two halves
     * - Conquer: Recursively sort both halves
     * - Combine: Merge sorted halves in descending order
     * 
     * Time Complexity: O(N log N) in all cases (best, average, worst)
     * Space Complexity: O(N) for temporary arrays
     * 
     * @param students The array of Student objects to be sorted.
     */
    public static void mergeSort(Student[] students) {
        // Base case: A list of 0 or 1 elements is already sorted.
        if (students == null || students.length <= 1) {
            return;
        }

        // Divide: Calculate the midpoint to split the array
        int mid = students.length / 2;

        // Create temporary sub-arrays
        Student[] left = new Student[mid];
        Student[] right = new Student[students.length - mid];

        // Populate sub-arrays
        System.arraycopy(students, 0, left, 0, mid);
        System.arraycopy(students, mid, right, 0, students.length - mid);

        // Conquer: Recursively sort both sub-arrays
        mergeSort(left);
        mergeSort(right);

        // Combine: Merge the sorted sub-arrays back into the main array
        merge(students, left, right);
    }

    /**
     * Merges two sorted sub-arrays into a destination array in Descending Order.
     * This method is the core of the Merge Sort algorithm and implements the
     * STABILITY guarantee by preferring left elements on equality.
     * 
     * Stability Implementation:
     * - When left[i].marks == right[j].marks, we choose left[i]
     * - This preserves the original relative order of equal elements
     * 
     * @param result The destination array.
     * @param left   The sorted left sub-array.
     * @param right  The sorted right sub-array.
     */
    private static void merge(Student[] result, Student[] left, Student[] right) {
        int i = 0; // Pointer for left array
        int j = 0; // Pointer for right array
        int k = 0; // Pointer for result array

        // Merge elements in descending order
        while (i < left.length && j < right.length) {
            // STABILITY CRITICAL SECTION:
            // We check if the left value is Greater Than or EQUAL To right value.
            // By picking 'left' on equality, we preserve the original order
            // of students with the same marks.
            if (left[i].getMarks() >= right[j].getMarks()) {
                result[k++] = left[i++];
            } else {
                result[k++] = right[j++];
            }
        }

        // Copy remaining elements from Left (if any)
        while (i < left.length) {
            result[k++] = left[i++];
        }

        // Copy remaining elements from Right (if any)
        while (j < right.length) {
            result[k++] = right[j++];
        }
    }

    /**
     * Efficiently updates a student's mark and maintains the leaderboard order.
     * This method demonstrates an ADAPTIVE sorting strategy inspired by Timsort.
     * 
     * Algorithm:
     * 1. Linear search to find the student (O(N))
     * 2. Update the marks value
     * 3. "Bubble" the student to correct position:
     *    - If marks increased: shift UP (toward index 0)
     *    - If marks decreased: shift DOWN (toward index length-1)
     * 
     * Complexity Analysis:
     * - Search: O(N) (Linear scan to find student)
     * - Shift: O(N) (Shifting elements to new position)
     * - Total: O(N)
     * 
     * This is significantly faster than re-running mergeSort (O(N log N))
     * for a single update.
     * 
     * Optimization Note:
     * In a production system, a HashMap<Name, Index> would make the search O(1),
     * reducing total complexity to O(N) in the worst case, but typically much less.
     * 
     * @param students    The sorted array of students.
     * @param studentName The name of the student to update.
     * @param newMarks    The new marks to assign.
     */
    public static void updateStudentMark(Student[] students, String studentName, int newMarks) {
        int index = -1;

        // 1. Find the student (Linear Search)
        // In a production system, a HashMap<Name, Integer> would make this O(1)
        for (int i = 0; i < students.length; i++) {
            if (students[i].getName().equals(studentName)) {
                index = i;
                break;
            }
        }

        if (index == -1) {
            System.out.println("Error: Student '" + studentName + "' not found.");
            return;
        }

        // 2. Update the mark
        int oldMarks = students[index].getMarks();
        students[index].setMarks(newMarks);
        System.out.println("\n[UPDATE] " + studentName + ": " + oldMarks + " → " + newMarks);

        // 3. Re-position the student (Adaptive Sort Logic)
        // If marks increased, bubble UP (towards index 0)
        while (index > 0 && students[index].getMarks() > students[index - 1].getMarks()) {
            swap(students, index, index - 1);
            index--;
        }

        // If marks decreased, bubble DOWN (towards index length-1)
        while (index < students.length - 1 && students[index].getMarks() < students[index + 1].getMarks()) {
            swap(students, index, index + 1);
            index++;
        }
    }

    /**
     * Helper method to swap two elements in an array.
     * 
     * @param arr Array containing the elements.
     * @param i   Index of first element.
     * @param j   Index of second element.
     */
    private static void swap(Student[] arr, int i, int j) {
        Student temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}