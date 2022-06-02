from math import *


# err_type = abs | rel | fx
def newton(f, df, x0, tol, n, err_type):
    x = x0
    fx = f(x)
    dfx = df(x)
    actual_iterations = 0
    table = []

    error = float("inf")

    table.append(actual_iterations)
    table.append(x)
    table.append(fx)
    table.append(dfx)
    table.append("")
    table.append("")
    table.append("newline")

    if err_type == "fx":
        error = abs(fx)

    while fx != 0 and error > tol and dfx != 0 and actual_iterations < n:
        xn = x - (fx / dfx)
        fx = f(xn)
        dfx = df(xn)

        abs_err = abs(xn - x)
        rel_err = abs_err / abs(xn)

        if err_type == "fx":
            error = abs(fx)
        elif err_type == "rel":
            error = rel_err
        else:
            error = abs_err

        x = xn
        actual_iterations = actual_iterations + 1

        table.append(actual_iterations)
        table.append(x)
        table.append(fx)
        table.append(dfx)
        table.append(abs_err)
        table.append(rel_err)
        table.append("newline")

    if fx == 0:
        table.append("nan")
        return x, table
    elif error < tol:
        return x, table
    else:
        table.append("nan")
        return None, table
