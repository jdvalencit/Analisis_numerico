def partial_pivot(ab, k):
    largest = abs(ab[k][k])
    largest_row = k
    size = ab.shape[0]

    for r in range(k + 1, size):
        current = abs(ab[r][k])
        if current > largest:
            largest = current
            largest_row = r
    if largest == 0:
        raise Exception("Equation system does not have unique solution.")
    else:
        if largest_row != k:
            ab[[k, largest_row]] = ab[[largest_row, k]]