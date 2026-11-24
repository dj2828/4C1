#!/usr/bin/env python3
# NOTE: it is recommended to use this even if you don't understand the following code.

import sys

sys.stdin = open('input.txt', 'r')
sys.stdout = open('output.txt', 'w')

# input data
T = int(input().strip()) # dopo quanto ti annoi
N = int(input().strip()) # numero di pause
A, B = map(list, zip(*[map(int, input().strip().split()) for _ in range(N)])) # pause
M = int(input().strip()) # numero di pause per hano
X, Y = map(list, zip(*[map(int, input().strip().split()) for _ in range(M)])) # pause

# insert your code here

totale = 0
j = 0

for i in range(N):
    inizio_pazienza = A[i]

    while inizio_pazienza <= B[i]:
        while j < M and Y[j] < inizio_pazienza:
            j += 1

        if j == M or X[j] > min(B[i], inizio_pazienza + T):
            break

        if X[j] <= inizio_pazienza:
            fine = min(B[i], Y[j])
            totale += fine - inizio_pazienza + 1
            inizio_pazienza = fine + 1

        elif inizio_pazienza <= X[j]:
            fine = min(B[i], Y[j])
            totale += fine - X[j] + 1
            inizio_pazienza = fine + 1

print(totale)