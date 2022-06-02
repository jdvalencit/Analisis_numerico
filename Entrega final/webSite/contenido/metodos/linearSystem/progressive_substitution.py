import numpy as np


def progressive_substitution(ab):
    size = ab.shape[0]
    assert ab.shape[1] == size + 1

    solutions = np.zeros(size, dtype=np.float64)
    solutions[0] = ab[0][size] / ab[0][0]

    for i in range(1, size):
        accum = 0
        for p in range(0, i):
            accum += ab[i][p] * solutions[p]

        solutions[i] = (ab[i][size] - accum) / ab[i][i]
    return solutions

