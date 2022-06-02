import numpy as np


def regressive_substitution(ab, labels=None):
    size = ab.shape[0]
    assert ab.shape[1] == size + 1

    solutions = np.zeros(size, dtype=np.float64)
    solutions[size - 1] = ab[size - 1][size] / ab[size - 1][size - 1]

    # Loop backwards
    for i in range(size - 2, -1, -1):
        accum = 0
        for p in range(i + 1, size):
            accum += ab[i][p] * solutions[p]
        solutions[i] = (ab[i][size] - accum) / ab[i][i]

    # Update the labels and assign its values
    labeled_xs = np.zeros(size)
    if labels is not None:
        for i, v in enumerate(labels):
            labeled_xs[labels[i]] = solutions[i]
        solutions = labeled_xs

    return solutions

