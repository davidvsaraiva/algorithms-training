# Algorithm Practice Repository

This repository contains small programs and algorithms that I am practicing as part of my journey to improve problem-solving and programming skills. Each program is self-contained and explores different algorithmic techniques, such as backtracking, sorting, and more.

---

## 📂 Project Structure

The repository is organized into packages based on the type of algorithm or problem being addressed. For example:
- **Backtracking** algorithms 
- **Dynamic programming** algorithms
- **other categories**: Additional categories will be added as more algorithms are included

---

## 📌 Current Programs

### 1. **Lego Blocks Permutations (Backtracking)**

**Location**: `backtracking/LegoBlocksPermutationsBacktracking.java`

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

### 3. **Paths in Matrix (Dynamic Programming)**

**Location:** `dynamic_programming/PathsInMatrix.java`

#### **Description**
Counts the number of ways to go from the **top-left** to the **bottom-right** of a grid where:
- `0` represents a free cell.
- `1` represents a wall (blocked).
- Movement is allowed **only right or down**.
- If the start or end cell is blocked, the result is `0`.

Problem statement:  <a href="https://www.udemy.com/course/dynamic-programming-x/learn/quiz/5350326#overview">Udemy - Paths In Matrix</a>

#### **How It Works**
- Uses a **Dynamic Programming (DP)** table to accumulate the number of valid paths to each cell.
- Each cell’s value is computed as the sum of the number of ways from the cell **above** and the cell **to the left**.
- Out-of-bounds conditions are treated as zero.

#### **Input and Output**
- **Input:** A 2D integer matrix (`int[][]`) containing `0`s and `1`s.
- **Output:** A `int` value representing the total number of valid paths.

#### **Example**
**Input**
```plaintext
matrix = [
  [0, 0, 1, 0, 1],
  [0, 0, 0, 0, 1],
  [0, 0, 1, 0, 0],
  [1, 0, 0, 0, 0]
]
```
Output
```
7
```

### 4. **Coin Change (Dynamic Programming)**

**Location:** `dynamic_programming/CoinChange.java`

#### **Description**
Given an amount and the denominations of coins available, determine how many ways change can be made for amount. 
There is a limitless supply of each coin type.

Problem statement:  <a href="https://www.hackerrank.com/challenges/coin-change/problem">Hackerrank - Coin change</a>

#### **How It Works**
- It builds a 2D DP table dp[i][j] where each cell stores the number of ways to make sum j using the first i coin types.
- For each coin type i and target sum j, it adds the ways without using this coin (dp[i-1][j]) and, if possible, the ways including at least one of this coin (dp[i][j - coinValue]).
- The answer is then the value in the last row and column, which represents using all coin types to form the total n.

#### **Input and Output**
- **Input:** n - as the amount to reach; c - list of coins
- **Output:** A `int` value representing the total number of ways change can be made for amount

#### **Example**
**Input**
```plaintext
 n = 3
 c = [8,3,1,2]
```
Output
```
3
```

### 5. **Bigger is Greater (Backtracking)**

**Location:** `backtracking/BiggerIsGreater.java`

#### **Description**
Lexicographical order is often known as alphabetical order when dealing with strings. A string is greater than another string if it comes later in a lexicographically sorted list.
Given a word, create a new word by swapping some or all of its characters. This new word must meet two criteria:
- It must be greater than the original word
- It must be the smallest word that meets the first condition

Problem statement:  <a href="https://www.hackerrank.com/challenges/bigger-is-greater/problem">Hackerrank - Bigger Is Greater</a>

#### **How It Works**
- Uses a depth-first search to generate all permutations of the input string by picking characters from remainder and building newWord.
- At each complete permutation, checks whether it is lexicographically greater than the original string and updates best with the smallest valid candidate.
- After exploring all permutations, returns the best next-greater permutation or "no answer" if none exists.

#### **Input and Output**
- **Input:** w - as the initial word
- **Output:** string value representing the least big word according to Lexicographical order or "no answer" if no valid permutation

#### **Example**
**Input**
```plaintext
abcd
```
Output
```
abdc
```
