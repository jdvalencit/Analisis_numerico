from math import *


# err_type = abs | rel | fx
def secant(f, interval, tol, n, err_type):
    x0 = interval[0]
    x1 = interval[1]
    assert x1 > x0
    table = []

    fx0 = f(x0)
    actual_iterations = 0

    if fx0 == 0:
        return x0
    else:
        error = float("inf")

        fx1 = f(x1)

        table.append(actual_iterations)
        table.append(x0)
        table.append(x1)
        table.append(fx0)
        table.append(fx1)
        table.append("")
        table.append("")
        table.append("newline")

        if err_type == "fx":
            error = abs(fx1)

        denominator = fx1 - fx0
        actual_iterations = actual_iterations + 1
        while error > tol and fx1 != 0 and denominator != 0 and actual_iterations < n:
            x2 = x1 - ((fx1 * (x1 - x0)) / denominator)
            abs_err = abs(x2 - x1)
            rel_err = abs_err / abs(x2)

            if err_type == "rel":
                error = rel_err
            else:
                error = abs_err

            x0 = x1
            fx0 = fx1
            x1 = x2
            fx1 = f(x1)

            if err_type == "fx":
                error = abs(fx1)

            denominator = fx1 - fx0
            actual_iterations = actual_iterations + 1

            table.append(actual_iterations)
            table.append(x0)
            table.append(x1)
            table.append(fx0)
            table.append(fx1)
            table.append(abs_err)
            table.append(rel_err)
            table.append("newline")

    if fx1 == 0:
        table.append("nan")
        return x1, table
    elif error < tol:
        return x1, table
    else:
        table.append("nan")
        return None, table
