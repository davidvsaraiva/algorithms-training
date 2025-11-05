# Algorithm Practice Repository

This repository contains small programs and algorithms that I am practicing as part of my journey to improve problem-solving and programming skills. Each program is self-contained and explores different algorithmic techniques, such as recursion, backtracking, sorting, and more.

---

## 📂 Project Structure

The repository is organized into packages based on the type of algorithm or problem being addressed. For example:
- **recursion**: Programs that solve problems using recursion, including backtracking algorithms.
    - **Backtracking** algorithms (e.g., Lego Blocks Permutations) are included as part of this package.
- **other categories**: Additional categories will be added as more algorithms are included

---

## 📌 Current Programs

### 1. **Lego Blocks Permutations (Backtracking)**

**Location**: `recursion/LegoBlocksPermutationsBacktracking.java`

#### **Description**
This program generates all possible permutations of blocks with dimensions `1`, `2`, `3`, and `4` to form a line of a given length (`n`). The program uses **backtracking** to efficiently explore and generate the solutions.

#### **How It Works**
- The user inputs the desired line length (`n`).
- The program recursively explores all possible combinations of blocks that sum up to `n` while ensuring no invalid combinations are generated.
- The results are printed as a list of permutations.

#### **Input and Output**
- **Input**: An integer representing the line length.
- **Output**: A list of permutations where each permutation is a valid combination of block dimensions that sum to the input length.

#### **Example**
```plaintext
Enter the dimension of the line: 4
You entered: 4
[1, 1, 1, 1]
[1, 1, 2]
[1, 2, 1]
[1, 3]
[2, 1, 1]
[2, 2]
[3, 1]
[4]
```

## 2. Fibonacci Modified (Dynamic Programming / BigInteger)

**Location:** `dynamic_programming/FibonacciModified.java`

### Description

Computes the n-th term of the **Modified Fibonacci** sequence defined by  
T_{i+2} = T_{i+1}^2 + T_i, given integers t1, t2, and n.  
Because values grow extremely fast, the implementation uses `java.math.BigInteger`.

- Problem statement: <a href="https://www.hackerrank.com/challenges/fibonacci-modified/problem">HackerRank – Fibonacci Modified</a>

### How It Works

- Keep the last two terms and iterate from term 3 up to n.  
- For each step, compute `curr = beforePrev + prev^2`, then advance the window.  
- **Time:** O(n) iterations (each step does one square and one add).  
  - Big-integer arithmetic cost grows with the number’s digits.  
- **Extra space:** O(1) (besides the integers themselves).

### Input and Output

- **Input:** three integers `t1 t2 n` (per HackerRank prompt).  
- **Output:** the value of `T_n` as a decimal string.

### Example

Input
```
0 1 5
```

Output
```
5
```