# Letter frequencies (Optimization assignment)
Original repo description:  
> Simple program used to illustrate performance problems. You should be able to optimize this program to run about twice as fast.

## Assignment description
See [assignment-03.pdf](assignment-03.pdf).

## Contents
- [src/main](src/main) holds the code.
  - [Main.java](src/main/java/Main.java) holds the original implementation.
  - [Program.java](src/main/java/Program.java) is our optimized implementation.
- [Documentation](Documentation) holds the LaTeX documentation.

## Solution

### Task 1.1

Profiling with the Java Flight Recorder in IntelliJ gives us the following indication of the programs shortcommings:
![image](https://user-images.githubusercontent.com/35559774/114553882-66c95580-9c66-11eb-818f-96100b62d707.png)  

Two areas that we should be able to look at are:  
- The InputStreamReader
- The HashMap

### Task 1.2
Initial run of original program, using Sestoft Mark5 (with runningTime < 10)
```Java
-------------------------------------------
Mean              Sdev               Count
-------------------------------------------
45161160,0 ns +/- 9633302,98          2
37220422,5 ns +/- 349034,17           4
37097426,3 ns +/- 237128,88           8
37167326,9 ns +/- 257313,56           16
37140620,9 ns +/- 194416,43           32
37137303,8 ns +/- 167730,54           64
37195579,7 ns +/- 120079,00           128
37262370,4 ns +/- 84030,46            256
34186746,0 ns +/- 1958071,61          512
-------------------------------------------
```
Wrapping a `BufferedReader` around the `FileReader` and nothing else, gives the following optimazation. See [this](https://stackoverflow.com/a/26871923) stackoverflow thread for more info regarding FileReader and BufferedReader.   
```Java
-------------------------------------------
Mean              Sdev               Count
-------------------------------------------
26688810,0 ns +/- 8156130,62          2
21170010,0 ns +/- 1636441,34          4
20378076,3 ns +/- 165036,89           8
20086596,9 ns +/- 70131,53            16
20113604,4 ns +/- 95585,47            32
20121626,1 ns +/- 132419,65           64
20107895,8 ns +/- 106333,91           128
20220584,5 ns +/- 145384,37           256
20213537,6 ns +/- 40180,77            512
-------------------------------------------
```
The use of a `BufferedReader` alone have increased the program mean runtime by 40,87%.   
  
### Task 1.3
```diff
- todo short text about how we completed this
```
