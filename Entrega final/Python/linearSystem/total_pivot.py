# This procedure mutates the input matrix and the column labels.
def total_pivot(ab, k, labels):
    largest = abs(ab[k][k])
    largest_row = k
    largest_column = k

    size = ab.shape[0]
    # i itera filas, j columnas
    for i in range(k, size):
        for j in range(k, size):
            current = abs(ab[i][j])
            if current > largest:
                largest = current
                largest_row = i
                largest_column = j
    if largest == 0:
        raise Exception("Equation system does not have unique solution.")
    else:
        if largest_row != k:
            ab[[k, largest_row]] = ab[[largest_row, k]]
        if largest_column != k:
            ab[:, [k, largest_column]] = ab[:, [largest_column, k]]
            labels[k], labels[largest_column] = labels[largest_column], labels[k]
