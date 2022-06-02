import numpy as np
from sympy import simplify
from sympy.parsing.sympy_parser import (
    parse_expr,
    standard_transformations,
    implicit_multiplication,
)


def divided_differences(points):
    size = len(points)
    table = np.zeros((size, size + 1), dtype=np.float64)

    for i, p in enumerate(points):
        table[i][0] = points[i][0]
        table[i][1] = points[i][1]

    temp = [table[0][1]]
    rows = table.shape[0]

    c = 0
    for j in range(2, size + 1):
        for i in range(j - 1, rows):
            numerator = table[i - 1][j - 1] - table[i][j - 1]
            denominator = table[i - (1 + c)][j - (2 + c)] - table[i][j - (2 + c)]
            result = numerator / denominator
            table[i][j] = result
            if j == i + 1:
                temp.append(result)

        c += 1

    polinomy = generate_polinomy(points, temp)
    simplified_polinomy = simplify_polinomy(polinomy)

    return {"tabla": table, "pol": polinomy, "spol": simplified_polinomy}


def generate_polinomy(points, bs):
    size = len(bs)
    polinomy = ""
    for i in range(0, size):
        multiply = ""
        for j in range(0, i):
            xi = points[j][0]
            multiply += f"(x - {xi})"

        if i == size - 1:
            polinomy += f"({bs[i]}{multiply})"
        elif i == 0:
            polinomy += f"{bs[i]} + "
        else:
            polinomy += f"({bs[i]}{multiply}) + "
    return polinomy


def simplify_polinomy(poly):
    expr = parse_expr(
        poly, transformations=standard_transformations + (implicit_multiplication,)
    )
    return "{}".format(simplify(expr))
