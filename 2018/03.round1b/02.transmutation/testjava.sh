#!/bin/bash

set -e

javac Solution.java
cat input.txt | java Solution
cat input0.txt | java Solution
