# CS367 Competency Exam — Starter Project

Self-contained. You need a JDK (`javac`/`java`, version 11+).
Follow the exam handout; this file just describes what is here.

## Layout

```
src/Stats.java        class under test (median is unimplemented)
test/StatsTest.java   tests
lib/tinytest.jar      the external dependency (assertion library)
AnalyzerRun.java      two static checkers over labeled methods (Part 2)
```

## Parts

- Part 1: compile and run `StatsTest`, then implement `Stats.median` so all
  tests pass. See the handout for what to submit.
- Part 2: compile and run `AnalyzerRun.java`, count TP/FP/TN/FN for each tool,
  and compare them; see the handout.
- Part 3: written logic questions; see the handout.
