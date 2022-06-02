from math import *


def bisection(f, xlo, xup, tol, n, err_type):
    fxlo = f(xlo)
    fxup = f(xup)
    table = []
    if fxlo == 0:
        table.append("nan")
        return xlo, table
    elif fxup == 0:
        table.append("nan")
        return xup, table
    elif fxlo * fxup < 0:
        xm = (xlo + xup) / 2
        fxm = f(xm)
        actual_iterations = 1
        error = float("inf")

        table.append(actual_iterations)
        table.append(xlo)
        table.append(xup)
        table.append(xm)
        table.append(fxm)
        table.append("")
        table.append("")
        table.append("newline")
        if err_type == "fx":
            error = abs(fxm)

        while error >= tol and fxm != 0 and actual_iterations < n:
            if fxlo * fxm < 0:
                xup = xm
                fxup = fxm
            elif fxm * fxup < 0:
                xlo = xm
                fxlo = fxm

            xtemp = xm
            xm = (xlo + xup) / 2
            fxm = f(xm)
            abs_err = abs(xm - xtemp)
            rel_err = abs_err / abs(xm)

            if err_type == "fx":
                error = abs(fxm)
            elif err_type == "rel":
                error = rel_err
            else:
                error = abs_err

            actual_iterations = actual_iterations + 1

            table.append(actual_iterations)
            table.append(xlo)
            table.append(xup)
            table.append(xm)
            table.append(fxm)
            table.append(abs_err)
            table.append(rel_err)
            table.append("newline")

        if fxm == 0 or error < tol:
            return xm, table
        else:
            table.append("Max iterations reached")
            return None, table
    else:
        return None, table
