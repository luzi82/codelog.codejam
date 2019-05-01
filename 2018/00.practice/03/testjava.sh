#!/bin/bash

set -e

javac -Xlint:unchecked Solution.java
cat input.txt | java Solution

cat input.txt | java Solution > tmp.txt
diff tmp.txt output.txt

echo ====

cat input0.txt | java Solution
cat input0.txt | java Solution > tmp.txt
diff tmp.txt output0.txt
