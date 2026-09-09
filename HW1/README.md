Coverage:
1. There are four total cases: the customer is >= 65, the customer's age < 18, the customer's age is between 18 and 65, and the customer is both under 18 and above 65.

2. The TestBuyTicket test-suite with the additions (senior, minor, non-member) does achieve 100% edge coverage. There appear to be 6 possible paths, of which my tests cover 4, so there is 66% path coverage.

3. To achieve 100% path coverage, we would need a non-member senior test and a non-member minor test.

4. A programs has the number of paths as there are possible ways to traverse the branches. As the number of branches in a program increases, so does the number of paths.

5. With a loop, there would be an edge directed back to a previous node. With recursion there would be another sub-cfg starting at the recursive node. Both would create a potentially infinite number of paths regardless of the presence of other branches. If the program reliably terminates, it still increases the number of paths in the program significantly.

6. statements are grouped such that collections of statements with not branches are grouped together, while branching statemnts are separated by edges.

Reflection:

Test Suite Quality
a. Having high coverage (in all forms of coverage), and testing many different input possibilities are helpful. A knowledge of the code and certain key aspects of it also come into play, such as looking at inputs with relations to constants in the code. 

b. We've already looked at automattically measuring coverag wiith jacoco. Coverage helps with making sure that each part of the code is tested for some input, but it can't account for how non-branching lines behave with different inputs. I don't think it's feasible to be able to automatically measure the test-suite's quality of input for finding bugs. Some automatic measuring could be done by measuring number of times each line/branch was tested with different variable values. Though this doesn't really have a clear standard, and in the case of BuyTicket, there was only one input (100) that would cause teh divide by zero error.

c. To create the most ineffective test suite I would just do one test to see if the code runs in a basic case on one path and hope for the best on the rest of them. If it's a large inneffectice test suite though, just trying random input values without any branch variation or looking at the code to look for suspicious sections.

d. I decided I had written sufficient tests once I ran out of ideas for tests to write that weren't just the same as earlier with slightly different numbers. Coverage target would have made for a more structured stopping point, and it would have guided me in where to make more tests when I was unsure of what to add.

Writing Test Suites
a. The most challenging aspect was coming up with meaningful inputs that would make for robust tests.

b. It was a bit easier since I knew the code and its expected behavior, as well as all the cases I had programmed different behavior for, so I knew to test them. However, this might make edge case testing weaker in more complicated code since if I didn't think of the case when writing the code, it probably won't come to mind when writing tests. However, for StringToInteger, since I didn't have information on how the program was supposed to behave with, for example, a number that's too large, my tests were based on how I expected the code to behave as-written rather than a standard, which, if extended to a different case, could lead to tests that reinforce bugs rather than catch them.

c. I mostly wrote the code before testing. The one exception is that I believe I wrote my tests for formatting as a Date before the tests for whether a date was valid so that I knew the strings were being parsed correctly before evaluating the secondary method. With parseDate being a fairly small program, I don't know that much would have changed in this instance. In more complex programs, writing tests first might encourage me to check that internal methods work before writing larger ones and plan out the overall structure of the code more in advance.

d. For the string parsing programs, I would use assertEquals when I expected the method to successfully return something and compare that output to the expected behavior based on the assignment instructions and my expectations for how the program logic would work. Then, I would use assertThrows on invalid inputs that I expected to fail to check that the program would recognize them as invalid. For the coverage exercise, the process was similar, but there wasn't cause to use assertThrows.

AI Written tests
I used Gemini for this. For the Ticket source file, the generated test suite had full branch coverage. This was the most minimal test with 3 "standard function tests" and 2 tests specifically targeting the bugs noted in the comments. The tests all compiled with no issue. It seems that the comments in the source code guided Gemini to test those specific bugs. For StringToInteger, it also created a robust test suite with full coverage, and it caught a bug that I missed. Embarrassing for me.  For ParseDate, the Gemini tests got the highest possible branch coverage with missing branches being infeasible ones, for example the case for (c < '0' && c > '0'). It did many tests. I ended up doing two separate test suites for Date.java and ParseDate.java and combining them into one file because I forgot to include Date.java in the original instruction to create tests. Overall, very high coverage test suites. It looks like the model is trained to aim for coverage in creating tests. It's likely also trained to recognize patterns of common errors in code. 


