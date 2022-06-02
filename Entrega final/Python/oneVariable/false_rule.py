from math import *


def false_rule(f, xlo, xup, tol,n, err_type):
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
        xm = xlo - ((fxlo * (xup - xlo)) / (fxup - fxlo))
        fxm = f(xm)
        i = 1

        error = float("inf")

        table.append(i)
        table.append(xlo)
        table.append(xup)
        table.append(xm)
        table.append(fxm)
        table.append("")
        table.append("")
        table.append("newline")

        if err_type == "fx":
            error = abs(fxm)

        while error >= tol and fxm != 0:
            if fxlo * fxm < 0:
                xup = xm
                fxup = fxm
            elif fxm * fxup < 0:
                xlo = xm
                fxlo = fxm

            xtemp = xm
            xm = xlo - ((fxlo * (xup - xlo)) / (fxup - fxlo))
            fxm = f(xm)
            abs_err = abs(xm - xtemp)
            rel_err = abs_err / abs(xm)

            if err_type == "fx":
                error = abs(fxm)
            elif err_type == "rel":
                error = rel_err
            else:
                error = abs_err

            i = i + 1

            table.append(i)
            table.append(xlo)
            table.append(xup)
            table.append(xm)
            table.append(fxm)
            table.append(abs_err)
            table.append(rel_err)
            table.append("newline")

        if fxm == 0:
            table.append("nan")
            return xm, table
        elif error < tol:
            return xm, table
    else:
        table.append("nan")
        return None, table
