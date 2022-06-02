import numpy as np


def jacobi(a, b, init, tol, n, err_type="abs"):
    table = []
    assert a.shape[0] == a.shape[1]
    assert a.shape[0] == len(b)
    assert len(init) == len(b)

    error = float("inf")

    xn = init
    i = 0

    table.append(i)
    table.append(xn)
    table.append("")
    table.append("")
    table.append("newline")

    while error > tol and i < n:
        x, abs_err, rel_err = next_iter(a, b, xn)
        xn = x

        if err_type == "rel":
            error = rel_err
        else:
            error = abs_err

        i += 1

        table.append(i)
        table.append(xn)
        table.append(abs_err)
        table.append(rel_err)
        table.append("newline")
    return xn, table


def next_iter(a, b, prev_x):
    size = a.shape[0]
    x = np.zeros(size, dtype=np.float64)

    for i in range(0, size):
        d = a[i][i]
        accum = 0
        for j in range(0, size):
            if j != i:
                accum += a[i][j] * prev_x[j]
        x[i] = (b[i] - accum) / d

    errs = abs(x - prev_x)
    abs_err = max(errs)
    rel_err = max(errs / abs(x))

    return x, abs_err, rel_err
