#!/bin/bash

set -e

javac Solution.java
cat input.txt | java Solution

cat input.txt | java Solution > tmp.txt
diff tmp.txt output.txt
