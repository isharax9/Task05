# Task 5: Student Leaderboard Management System

[![MIT License](https://img.shields.io/badge/License-MIT-green.svg)](https://choosealicense.com/licenses/mit/)
[![Java](https://img.shields.io/badge/Java-11+-orange.svg)](https://www.oracle.com/java/)
[![Status](https://img.shields.io/badge/Status-Complete-success.svg)](https://github.com/isharax9/Task05)

## 📚 Project Overview

A sophisticated **Student Leaderboard Management System** implementing stable sorting algorithms with dynamic update capabilities. This project demonstrates advanced data structures and algorithms concepts, specifically focusing on **Merge Sort** for efficient sorting and **adaptive insertion** for real-time mark updates.

### 🎯 Key Features

- ✅ **Stable Merge Sort Implementation** - O(N log N) time complexity
- ✅ **Dynamic Mark Updates** - O(N) adaptive repositioning
- ✅ **Stability Guarantee** - Preserves relative order for equal marks
- ✅ **Production-Ready Code** - Comprehensive documentation and error handling
- ✅ **Professional Output** - Formatted leaderboard with ranking badges

---

## 🛠️ Technologies Used

- **Language:** Java (JDK 11+)
- **Algorithm:** Stable Merge Sort (Divide and Conquer)
- **Update Strategy:** Adaptive Insertion (inspired by Timsort)
- **Documentation:** Comprehensive Javadoc comments

---

## 📁 Project Structure

```
Task05/
│
├── src/
│   ├── Student.java              # Student entity class
│   ├── GradeSorter.java          # Merge Sort and update logic
│   └── LeaderboardSystem.java    # Main driver with test scenarios
│
├── LICENSE                    # MIT License
└── README.md                  # Project documentation
```

---

## 🚀 Getting Started

### Prerequisites

- Java Development Kit (JDK) 11 or higher
- Any Java IDE (IntelliJ IDEA, Eclipse, VS Code) or command line

### Installation

1. **Clone the repository**
   ```bash
   git clone https://github.com/isharax9/Task05.git
   cd Task05
   ```

2. **Compile the Java files**
   ```bash
   javac src/*.java
   ```

3. **Run the program**
   ```bash
   java -cp src LeaderboardSystem
   ```

---

## 💻 Usage Example

The system automatically executes comprehensive test scenarios demonstrating:

1. **Initial Sorting** - Unsorted student list → Descending order
2. **Mark Improvement** - Student moves up in ranking
3. **Mark Correction** - Student moves down in ranking
4. **Minor Adjustments** - Moderate rank changes
5. **Stability Testing** - Handling equal marks

---

## 📊 Algorithm Analysis

### Merge Sort (Initial Sorting)

| Complexity      | Value            | Description                              |
|-----------------|------------------|------------------------------------------|
| **Time (Best)** | O(N log N)       | Already sorted data                      |
| **Time (Avg)**  | O(N log N)       | Randomly distributed marks               |
| **Time (Worst)**| O(N log N)       | Reverse sorted data                      |
| **Space**       | O(N)             | Temporary arrays for merging             |
| **Stability**   | ✅ Stable        | Preserves relative order                 |

### Adaptive Update (Mark Changes)

| Operation       | Complexity       | Description                              |
|-----------------|------------------|------------------------------------------|
| **Search**      | O(N)             | Linear scan to find student              |
| **Reposition**  | O(N)             | Bubble to correct position               |
| **Total**       | O(N)             | Significantly faster than re-sorting     |

**Performance Comparison:**
- Re-sorting with Merge Sort: ~10,000 operations (for 1,000 students)
- Adaptive Update: ~500 operations (average case)
- **Speed Improvement: ~20x faster for single updates**

---

## 🖥️ Sample Output

```
############################################################
#                                                          #
#       STUDENT LEADERBOARD MANAGEMENT SYSTEM              #
#              Sorting with Dynamic Updates                #
#                                                          #
#        Author: H.M.Ishara Lakshitha Bandara             #
#               Task 5: DSA Assignment                     #
#                                                          #
############################################################

============================================================
PHASE 1: INITIAL DATA (Unsorted)
============================================================

------------------------------------------------------------
| Rank |      Name       | Marks |          Position          |
------------------------------------------------------------
|    1 | Ayesha          |    75 |    1st Place               |
|    2 | Thilina         |    82 |    2nd Place               |
|    3 | Nimasha         |    68 |    3rd Place               |
|    4 | Sahan           |    90 |    4th Place               |
|    5 | Dilki           |    78 |    5th Place               |
|    6 | Kamal           |    85 |    6th Place               |
|    7 | Rashmi          |    72 |    7th Place               |
|    8 | Dinesh          |    88 |    8th Place               |
------------------------------------------------------------

============================================================
PHASE 2: APPLYING MERGE SORT (Descending Order)
============================================================
Algorithm: Stable Merge Sort
Time Complexity: O(N log N)
Space Complexity: O(N)
Execution Time: 245.3 microseconds

------------------------------------------------------------
| Rank |      Name       | Marks |          Position          |
------------------------------------------------------------
|    1 | Sahan           |    90 | 🥇 1st Place (Gold Medal)   |
|    2 | Dinesh          |    88 | 🥈 2nd Place (Silver Medal) |
|    3 | Kamal           |    85 | 🥉 3rd Place (Bronze Medal) |
|    4 | Thilina         |    82 |    4th Place               |
|    5 | Dilki           |    78 |    5th Place               |
|    6 | Ayesha          |    75 |    6th Place               |
|    7 | Rashmi          |    72 |    7th Place               |
|    8 | Nimasha         |    68 |    8th Place               |
------------------------------------------------------------

============================================================
PHASE 3: DYNAMIC UPDATE - Mark Improvement
============================================================
Scenario: Ayesha's marks are updated from 75 to 95.
Expected: Ayesha should move from Rank 6 to Rank 1.

[UPDATE] Ayesha: 75 → 95
Update Time: 12.7 microseconds

------------------------------------------------------------
| Rank |      Name       | Marks |          Position          |
------------------------------------------------------------
|    1 | Ayesha          |    95 | 🥇 1st Place (Gold Medal)   |
|    2 | Sahan           |    90 | 🥈 2nd Place (Silver Medal) |
|    3 | Dinesh          |    88 | 🥉 3rd Place (Bronze Medal) |
|    4 | Kamal           |    85 |    4th Place               |
|    5 | Thilina         |    82 |    5th Place               |
|    6 | Dilki           |    78 |    6th Place               |
|    7 | Rashmi          |    72 |    7th Place               |
|    8 | Nimasha         |    68 |    8th Place               |
------------------------------------------------------------

============================================================
PHASE 4: DYNAMIC UPDATE - Mark Correction
============================================================
Scenario: Sahan's marks are corrected from 90 to 60.
Expected: Sahan should drop from Rank 3 to Rank 8.

[UPDATE] Sahan: 90 → 60
Update Time: 8.4 microseconds

------------------------------------------------------------
| Rank |      Name       | Marks |          Position          |
------------------------------------------------------------
|    1 | Ayesha          |    95 | 🥇 1st Place (Gold Medal)   |
|    2 | Dinesh          |    88 | 🥈 2nd Place (Silver Medal) |
|    3 | Kamal           |    85 | 🥉 3rd Place (Bronze Medal) |
|    4 | Thilina         |    82 |    4th Place               |
|    5 | Dilki           |    78 |    5th Place               |
|    6 | Rashmi          |    72 |    6th Place               |
|    7 | Nimasha         |    68 |    7th Place               |
|    8 | Sahan           |    60 |    8th Place               |
------------------------------------------------------------

============================================================
EXECUTION SUMMARY
============================================================
✓ Stable Merge Sort: O(N log N) complexity achieved
✓ Adaptive Updates: O(N) complexity for mark changes
✓ Stability Guarantee: Preserved relative order for equal marks
✓ All test scenarios executed successfully
============================================================

System developed by H.M.Ishara Lakshitha Bandara
Licensed under MIT License
############################################################
```

---

## 📝 Implementation Details

### 1. Student Entity (`Student.java`)
- **Immutable Identity:** Name field is final
- **Mutable State:** Marks can be updated
- **Formatted Output:** Aligned string representation

### 2. Grade Sorter (`GradeSorter.java`)

#### Merge Sort Implementation
```java
public static void mergeSort(Student[] students)
```
- **Divide:** Split array recursively at midpoint
- **Conquer:** Sort both halves recursively
- **Combine:** Merge in descending order with stability guarantee

**Stability Critical Section:**
```java
if (left[i].getMarks() >= right[j].getMarks()) {
    result[k++] = left[i++];  // Prefer left on equality
}
```

#### Adaptive Update
```java
public static void updateStudentMark(Student[] students, String name, int newMarks)
```
- **Search:** O(N) linear search for student
- **Update:** Modify marks value
- **Reposition:** "Bubble" to correct position
  - UP if marks increased
  - DOWN if marks decreased

### 3. Leaderboard System (`LeaderboardSystem.java`)
- Comprehensive test scenarios
- Performance metrics (execution time)
- Professional formatting with medals
- Summary statistics

---

## 🥇 Why Merge Sort?

| Feature           | Merge Sort | Quick Sort | Heap Sort |
|-------------------|------------|------------|-----------|
| **Stable**        | ✅ Yes     | ❌ No      | ❌ No      |
| **Time (Worst)**  | O(N log N) | O(N²)      | O(N log N)|
| **Space**         | O(N)       | O(log N)   | O(1)      |
| **Predictable**   | ✅ Yes     | ❌ No      | ✅ Yes     |

**Conclusion:** Merge Sort is ideal for educational systems requiring:
- Stable sorting (preserving secondary order)
- Guaranteed performance (no worst-case degradation)
- Predictable behavior for critical systems

---

## ⚙️ Future Enhancements

- [ ] HashMap integration for O(1) student lookup
- [ ] Multi-criteria sorting (marks, attendance, name)
- [ ] File I/O for persistent data storage
- [ ] GUI interface with JavaFX
- [ ] Batch update operations
- [ ] Performance benchmarking tools
- [ ] Export to CSV/PDF reports

---

## 📚 References

This implementation is based on comprehensive research documented in the project's technical report:

1. **Sorting Algorithms** - [Wikipedia](https://en.wikipedia.org/wiki/Sorting_algorithm)
2. **Stable Sorting** - [GeeksforGeeks](https://www.geeksforgeeks.org/stable-and-unstable-sorting-algorithms/)
3. **Merge Sort** - Algorithm design principles
4. **Timsort** - Inspiration for adaptive updates

---

## 👨‍💻 Author

**H.M.Ishara Lakshitha Bandara**
- GitHub: [@isharax9](https://github.com/isharax9)
- Portfolio: [isharax9.me](https://isharax9.me)
- LinkedIn: [Ishara Bandara](https://linkedin.com/in/isharax9)

---

## 📜 License

This project is licensed under the **MIT License** - see the [LICENSE](LICENSE) file for details.

```
Copyright (c) 2025 H.M.Ishara Lakshitha Bandara

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.
```

---

## 🚀 Acknowledgments

- DSA course instructors for comprehensive algorithm education
- Research papers on stable sorting algorithms
- Java community for excellent documentation
- Open-source contributors for algorithmic insights

---

<div align="center">

**⭐ If you found this project helpful, please consider giving it a star! ⭐**

**Made with ❤️ for Data Structures & Algorithms**

</div>