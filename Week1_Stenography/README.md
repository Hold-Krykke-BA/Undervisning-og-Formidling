# Week 1 Assignment

* Link to description [1.5 Homework Assignment](https://datsoftlyngby.github.io/soft2021spring/UFO/week-05/#1-introduction-to-exploration-and-presentation)
  * [Solution](https://github.com/Hold-Krykke-BA/Undervisning-og-Formidling/blob/main/Week1_Stenography/steno.py)
  
## List of all search queries and list of all visited pages
* [History Camilla](https://github.com/Hold-Krykke-BA/Undervisning-og-Formidling/blob/main/Week1_Stenography/chrome_history_camilla.json)
* [History Rúni](chrome_history_runi.csv)

## List of the 3 biggest stumbling blocks
* **Properly understanding (reading) the assignment and how to tackle it** 
  * Spending more time on figuring out potential solutions than understanding the actual issue (and the hints given) caused time spent on unrelated / unsuccesful implementations. As an example, Rúni had more than 250 lines of code from different solutions using several frameworks and whatnot. Shortly after reading the assignment properly it became easier to narrow down the search inquiries and ultimately led to the solution.

* **Domain knowledge** 
  * We have not worked much in this field (image analysis) and spent much time on investigating bits, bytes, little-endian, least significant bit, image analysis, coding languages, frameworks and stupid google solutions.
  
* **Not utilizing partnership** 
  * It took just short of three hours to find the first word of the solution. In this time we did not discuss findings much more than choice of coding language and assignment interpretation.

## Brief log as explained in the slides
### Rúni  

- **Datetime stamp:** 
  - 12:00
- **Problem being working on:**
  - Initial investigation on Steganography / best approach
- **When you were last in contact with your team-mates:**
  - 1 minute ago
- **When you expect to be done with this micro-task:**
  - 30-40 minutes
- **How long did it take to do:**
  - 45 minutes
- **What misunderstandings arose:**
  - Spent far longer trying out different methods than actual investigation.
- **Which micro-experiments were done:**
  - byte reading from image, base64 encoding/decoding, openCV framework.
- **Which false leads were taken:**
  - all - no results so far. Still need to understand the basics.
---
- **Datetime stamp:**
  - 12:45
- **Problem being working on:**
  - solution
- **What is currently your frustration:**
  - interpreting task hints such as conversion & blue values. Converting back and forth, reading (x,y) values, etc.
- **When you were last in contact with your team-mates:**
  - 12
- **URL of example or idea you are trying out:**
  - https://www.boiteaklou.fr/Steganography-Least-Significant-Bit.html
- **When you expect to be done with this micro-task:**
  - Unknown.
- **How long did it take to do:**
  - Still in progress.
---
- **Datetime stamp:**
  - 13:30
- **Problem being working on:**
  - solution
- **What is currently your frustration:** 
  - Same
- **When you were last in contact with your team-mates:**
  - 12
- **URL of example or idea you are trying out:**
  - (Same) https://www.boiteaklou.fr/Steganography-Least-Significant-Bit.html
- **When you expect to be done with this micro-task:**
  - Unknown.
- **How long did it take to do:**
  - Still in progress. 
---
- **Datetime stamp:**
  - 14:45
- **Problem being working on:**
  - Solution
- **What is currently your frustration:**
  - Found a solution without understanding it. Result is returned backwards. Cannot alter parameters to return proper order without missing the proper byte order.
- **When you were last in contact with your team-mates:**
  - 13.30
- **URL of example or idea you are trying out:** 
  - (Same) https://www.boiteaklou.fr/Steganography-Least-Significant-Bit.html
- **When you expect to be done with this micro-task:**
  - Unknown. Hard to grasp.
- **How long did it take to do:**
  - Started this specific task 12:45. Had a 45 minute break. ~1½ hour.
- **What misunderstandings arose:** 
  - Bits, bytes, base64, ascii, rgba - which are needed, and how to convert between them.
- **Which micro-experiments were done:**
  - Knowing that the message should be found in the blue part of the first width row I changed my traversing and thought process. I kept hitting the same results until I reversed from end to start. (I thought I already looked at the correct the LSB)
- **Which false leads were taken:** 
  - Looking at the height of the image before width. Stupid solutions from google, too.
---
- **Datetime stamp:**
  - 15.11
- **Problem being working on:**
  - Where to reverse?
- **What is currently your frustration:**
  - Understanding the code I stitched together. Traversing bytes and bits, it is seemingly random where I chose to reverse the reading order, in order to get the result either backwards or “frontwards”.
- **When you were last in contact with your team-mates:**
  - 15.00
- **URL of example or idea you are trying out:**
  - (Same) https://www.boiteaklou.fr/Steganography-Least-Significant-Bit.html
- **When you expect to be done with this micro-task:** 
  - Unknown. I have to go now, but will have to continue by close reading the code and cleaning it up. Currently ~20 lines.
---
- **Datetime stamp:**
  - (two days later) 16.30
- **Problem being working on:**
  - Cleaning up. Camilla finished the traversal. I assumed after leaving that I had the first and only word of the puzzle. Turns out it's a whole sentence.
- **What is currently your frustration:**
  - Understanding the code fully.
- **When you were last in contact with your team-mates:**
  - Just now
- **URL of example or idea you are trying out:**
  - (Same) https://www.boiteaklou.fr/Steganography-Least-Significant-Bit.html
- **When you expect to be done with this micro-task:** 
  - Unknown. Cleaning up is going well. Documenting and doing a final push, then studying the solution for 100% understanding.

### Camilla
* **Datetime stamp**
  * 07-02-2021 10.30
* **Problem being working on**
  * Start of assignment, find out in broad terms how to solve the assignment
* **What is currently your frustration**
  * Not knowing how to solve the assignment or what language to use
* **When you were last in contact with your team-mates**
  * Yesterday, we agreed to start today
* **When you expect to be done with this micro-task**
  * Within an hour
* **How long did it take to do**
  * 35 minutes
* **Which false leads were taken**
  * Ended up reading about how to hide messages in images in python at first
---
* **Datetime stamp**
  * 07-02-2021 11.10
* **Problem being working on**
  * Start programming in javascript to see if i can make it work
* **What is currently your frustration**
  * Understanding the different guides and tutorials
* **When you were last in contact with your team-mates**
  * Yesterday, we agreed to start today
* **When you expect to be done with this micro-task**
  * Within an hour
* **How long did it take to do**
  * 60 min
---
* **Datetime stamp**
  * 07-02-2021 12.15
* **Problem being working on**
  * Scrapping a javascript solution, starting over looking at python
* **When you were last in contact with your team-mates**
  * 12.00, we decided to each look for a solution since we can’t pair program.
* **When you expect to be done with this micro-task**
  * Within an hour
---
* **Datetime stamp**
  * 07-02-2021 13.15
* **Problem being working on**
  * Solving environments in python
* **When you were last in contact with your team-mates**
  * 12.00, we decided to each make a solution since we can’t pair program and both want to make a solution.
* **When you expect to be done with this micro-task**
  * No clue
* **How long did it take to do**
  * 60 minutes
---
* **Datetime stamp**
  * 07-02-2021 14.30
* **Problem being working on**
  * Starting programming in python, following different tutorials
* **What is currently your frustration**
  * Not entirely sure about how to approach the assignment in python
* **When you were last in contact with your team-mates**
  * 12.00
* **When you expect to be done with this micro-task**
  * Don’t know
* **How long did it take to do**
  * Taking a break after 60 minutes
* **Which false leads were taken**
  * Many, no working results so far
---
* **Datetime stamp**
  * 07-02-2021 17.15
* **Problem being working on**
  * Continuing on trying to find a solution
* **What is currently your frustration**
  * Most guides are very specific and don't fit this specific assignment and I’m having a hard time trying to change them to make them fit. 
* **When you were last in contact with your team-mates**
  * 15.00
* **When you expect to be done with this micro-task**
  * Don’t know
* **How long did it take to do**
  * 35 minutes
* **Which false leads were taken**
  * Many, no working results so far
---
* **Datetime stamp**
  * 07-02-2021 17.50
* **Problem being working on**
  * Talked with Rúni who found a [tutorial](https://www.boiteaklou.fr/Steganography-Least-Significant-Bit.html) he made some progress on, I’m going to try that to
* **What is currently your frustration**
  * N/A
* **When you were last in contact with your team-mates**
  * Right now
* **When you expect to be done with this micro-task**
  * Don’t know
* **How long did it take to do**
  * 20 minutes
* **Which false leads were taken**
  * None, the assignment is done
---
