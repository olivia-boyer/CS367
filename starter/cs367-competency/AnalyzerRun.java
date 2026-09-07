/**
 * AnalyzerRun -- compare two static null-pointer checkers over labeled methods.
 *
 * Two tools, A and B, each inspect the same set of methods and issue a verdict:
 *     WARN  the tool thinks the method can dereference null
 *     OK    the tool thinks the method is safe
 *
 * Ground truth (whether the method really has a null-dereference bug) is known
 * because these are labeled benchmark cases. For each method this prints the
 * method name, the truth, and each tool's verdict.
 *
 * A "positive" is a tool raising a WARN.
 *
 * Compile and run:
 *     javac AnalyzerRun.java
 *     java AnalyzerRun
 */
public class AnalyzerRun {

    public static void main(String[] args) {
        // {method, actuallyBuggy, toolA verdict, toolB verdict}
        String[][] cases = {
            {"parseHeader",   "true",  "WARN", "WARN"},
            {"openSocket",    "false", "WARN", "OK"},
            {"readLine",      "false", "WARN", "OK"},
            {"flushBuffer",   "true",  "WARN", "OK"},
            {"copyBytes",     "true",  "WARN", "WARN"},
            {"closeStream",   "false", "WARN", "OK"},
            {"decodeFrame",   "false", "OK",   "OK"},
            {"resizeArray",   "true",  "WARN", "WARN"},
            {"lookupUser",    "true",  "WARN", "OK"},
            {"validateToken", "false", "WARN", "OK"},
            {"hashPassword",  "false", "OK",   "OK"},
            {"mergeChunks",   "true",  "WARN", "WARN"},
        };

        System.out.printf("%-16s%-16s%-10s%-10s%n",
                "method", "actually_buggy", "toolA", "toolB");
        System.out.println("------------------------------------------------------");
        for (String[] c : cases) {
            System.out.printf("%-16s%-16s%-10s%-10s%n", c[0], c[1], c[2], c[3]);
        }
    }
}
