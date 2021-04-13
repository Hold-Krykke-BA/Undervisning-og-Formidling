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
_______
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
The use of a `BufferedReader` alone have increased the program mean runtime by **40,87%**. Looking at the Profile produced by the Java Flight Recorder in IntelliJ after this change, confirms that this was an actual issue with the original code:  
![image](https://user-images.githubusercontent.com/35559774/114554280-d3445480-9c66-11eb-8d1c-bec0e273a117.png)  
Going from the `InputStreamReader` (`FileReader` alone) with 41.3% in the Profile, to 11.1% for the `BufferedReader` is a noticeable change.  
_______
  
After modifying the methods `tallyChars()` and `print_tally()` we have gotten an **42,37%** optimazation. 
```Java
-------------------------------------------
Mean              Sdev               Count
-------------------------------------------
24734475,0 ns +/- 6057492,36          2
20550197,5 ns +/- 1135309,37          4
19897790,0 ns +/- 169372,90           8
19688542,5 ns +/- 71463,82            16
20048747,5 ns +/- 322151,07           32
19751591,6 ns +/- 133747,31           64
19704611,6 ns +/- 73574,46            128
19760670,4 ns +/- 108017,90           256
19701593,6 ns +/- 47694,74            512
-------------------------------------------
```  
   
![image](https://user-images.githubusercontent.com/35559774/114597817-7dd16d00-9c91-11eb-881b-50c99b65f90d.png)  
  
_______
  
After changing from `BufferedReader` to this lambda expression `Files.lines(Paths.get(fileName)).forEach(line -> tallyChars_optimized(line, freq))` from `java.nio.file.Files` the runtime decreased further. But as of now we are unsure why this is the case, as most people deem `java.nio` and `java.io` equal. We have also tried to increase the buffer in the `BufferedReader` to be able to contain the whole file, but that did nothing for the runtime. As of this change the runtime is now **51,06%** faster than the initial runtime of the program. 
```Java
-------------------------------------------
Mean              Sdev               Count
-------------------------------------------
22515290,0 ns +/- 7673839,43          2
17604875,0 ns +/- 1064155,01          4
16822411,3 ns +/- 209192,50           8
16691758,8 ns +/- 115971,66           16
16571550,6 ns +/- 102956,38           32
16596552,0 ns +/- 92303,35            64
16584048,4 ns +/- 49308,56            128
16599184,4 ns +/- 45268,89            256
16731495,5 ns +/- 57025,00            512
-------------------------------------------
```  
![image](https://user-images.githubusercontent.com/35559774/114608585-208fe880-9c9e-11eb-9533-45159b6b6bed.png)  
### Task 1.3
```diff
- todo short text about how we completed this
```
