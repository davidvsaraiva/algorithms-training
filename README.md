# Algorithm Practice Repository

This repository contains small programs and algorithms that I am practicing as part of my journey to improve problem-solving and programming skills. Each program is self-contained and explores different algorithmic techniques, such as backtracking, sorting, and more.

---

## 📂 Project Structure

The repository is organized into packages based on the type of algorithm or problem being addressed. For example:
- **Backtracking**
- **Dynamic programming**
- **Simulation**
- **Two Pointers / Searching**
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

### 6. **Bigger is Greater (Next Lexicographical Permutation)**

**Location:** `combinatorics/permutations/BiggerIsGreaterNextLexicographicalPermutation.java`

#### **Description**
Same description (example and input/output) as problem 5.

Problem statement:  <a href="https://www.hackerrank.com/challenges/bigger-is-greater/problem">Hackerrank - Bigger Is Greater</a>

#### **How It Works**
* The Next Lexicographical Permutation algorithm:
* - finds the next permutation in dictionary order by identifying a pivot index,
* - swapping it with the smallest larger element in the suffix,
* - then reversing the suffix to make the result minimal but still larger

### 7. **House Robber (Dynamic programming)**

**Location:** `dynamic_programming/HouseRobber.java`

#### **Description**
House robber (problem)
* Given an array of integers arr where arr[i] represents the amount of money in the house i, you are asked to find the
* maximum amount of money that a robber can steal knowing that he can't steal two adjacent houses because the security
* systems would automatically call the police

Problem statement:  <a href="https://www.udemy.com/course/dynamic-programming-x/learn/quiz/5345756#overview">Udemy - House Robber</a>

#### **How It Works**
- The algorithm keeps track of only two values: the best total you can get up to the previous house (prev1) and the one before that (prev2).
- For each house, it decides whether it's better to rob it (value + prev2) or skip it (prev1).
- It updates these two values as it moves through the array, and the final answer is the last computed maximum.

#### **Input and Output**
- **Input:** arr - initial array with the houses value
- **Output:** int - maximum money robber can steal

#### **Example**
**Input**
```plaintext
arr = [2, 10, 3, 6, 8, 1, 7]
```
Output
```
25
```

### 8. **The Bomberman Game (Simulation)**

**Location:** `simulation/Bomberman.java`

#### **Description**
Bomberman lives in a rectangular grid. Each cell in the grid either contains a bomb or nothing at all.

Each bomb can be planted in any cell of the grid but once planted, it will detonate after exactly 3 seconds. Once a bomb detonates, it's destroyed — along with anything in its four neighboring cells. This means that if a bomb detonates in cell , any valid cells  and  are cleared. If there is a bomb in a neighboring cell, the neighboring bomb is destroyed without detonating, so there's no chain reaction.

Bomberman is immune to bombs, so he can move freely throughout the grid. Here's what he does:
1. Initially, Bomberman arbitrarily plants bombs in some of the cells, the initial state.
2. After one second, Bomberman does nothing.
3. After one more second, Bomberman plants bombs in all cells without bombs, thus filling the whole grid with bombs. No bombs detonate at this point.
4. After one more second, any bombs planted exactly three seconds ago will detonate. Here, Bomberman stands back and observes.
5. Bomberman then repeats steps 3 and 4 indefinitely.

Note that during every second Bomberman plants bombs, the bombs are planted simultaneously (i.e., at the exact same moment), and any bombs planted at the same time will detonate at the same time.

Problem statement: <a href="https://www.hackerrank.com/challenges/bomber-man/problem">Hackerrank- The Bomberman Game</a>
#### **How It Works**
- The rules of the system define a deterministic evolution: from any grid state, the next state is fully determined, so the algorithm simulates only the meaningful steps instead of every second.
- Each generated state is converted to a compact key and stored in a map to record when it first appeared, while a list maintains all states in time order.
- When a newly produced state already exists in the map, the process has entered a repeat loop; from this point forward, the states follow a fixed cycle.
- For large n, instead of simulating further, the algorithm computes the equivalent time inside the cycle using modular arithmetic and return the precomputed state at that effective position.


- The current solution detects when a cycle repeats and stops calculating new grids. However, this is not the most optimal solution - actually there are only 3 distinct grids that ever matter:
1. "Initial grid" (t = 1)"
2. "Grid at t = 3"
3. "Grid at t = 5"

When solving this, I haven't realized this pattern and I have built the cycle detection code.

#### **Input and Output**
- **Input:** n - int - number of seconds to simulate; grid - List of Strings with the initial state
- **Output:** grid - state of the grid at n seconds

#### **Example**
**Input**
```plaintext
n = 3
grid = ['.......', '...O...', '....O..','.......', 'OO.....', 'OO.....']
```
Output
```
grid = ['OOO.OOO', 'OO...OO', 'OOO...O', '..OO.OO', '...OOOO', '...OOOO']
```

### 9. **Climbing the leaderboard (Two pointers / searching)**

**Location**: `javascript/two_pointers_searching/ClimbingLeaderboard.js`

#### **Description**
An arcade game player wants to climb to the top of the leaderboard and track their ranking. The game uses Dense
Ranking, so its leaderboard works like this:
- The player with the highest score is ranked number 1 on the leaderboard.
- Players who have equal scores receive the same ranking number, and the next player(s) receive the immediately
  following ranking number.

The goal is to return an array with  the player's rank after each new score 

Problem statement: <a href="https://www.hackerrank.com/challenges/climbing-the-leaderboard/problem">Hackerrank - Climbing the Leaderboard</a>
#### **How It Works**
- The algorithm first removes duplicate scores from the ranked list to reflect dense ranking correctly.
- It then starts from the lowest rank and, for each player score, moves a pointer upward through the leaderboard while the player’s score is greater than or equal to the current ranked score.
- Because the pointer only moves in one direction and never resets, the solution runs in linear time O(n + m).

#### **Input and Output**
- **Input**:
    - variable ranked[i] the leaderboard scores in decreasing order.
    - variable player[j] the game scores.
- **Output**: an array with the player's rank after each new score

#### **Example**
```plaintext
ranked = [100, 90, 90, 80]
player = [70, 80, 105]

Return [4,3,1]
```