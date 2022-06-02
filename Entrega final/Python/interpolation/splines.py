from collections import namedtuple
import numpy as np
from contenido.metodos.linearSystem import gauss_partial_pivot, regressive_substitution

Si = namedtuple("Si", "ai bi xi")


def linear_splines(points):
    sorted_points = sorted(points)
    equations = []
    intervals = []
    for p0, p1 in zip(sorted_points, sorted_points[1:]):
        x0, f0 = p0
        x1, f1 = p1
        b = (f1 - f0) / (x1 - x0)
        intervals.append((x0, x1))
        equations.append(Si(f0, b, x0))

    result = []
    for i, (equations, intv) in enumerate(zip(equations, intervals)):
        s = f"s{i} = {equations.ai} + {equations.bi}(x - {equations.xi}), [{intv[0]},{intv[1]}]"
        result.append(s)

    return result


def quadratic_splines(points):
    sorted_points = sorted(points)
    interval_amount = len(sorted_points) - 1
    size = (interval_amount * 2) - 1
    hs = []
    zs = np.zeros(size, dtype=np.float64)
    system = np.zeros((size, size), dtype=np.float64)
    intervals = []

    col_shift = 0
    for i, (p0, p1) in enumerate(zip(sorted_points, sorted_points[1:])):
        x0, f0 = p0
        x1, f1 = p1
        intervals.append((x0, x1))
        h = x1 - x0

        system[i][col_shift] = h
        if i == 0:
            col_shift += 1
        else:
            system[i][col_shift + 1] = np.power(h, 2)
            col_shift += 2

        hs.append(h)
        zs[i] = f1 - f0

    col_shift = 0
    for i in range(interval_amount, size):
        system[i][col_shift] = 1
        if i == interval_amount:
            system[i][col_shift + 1] = -1
            col_shift += 1
        else:
            system[i][col_shift + 1] = 2 * hs[i - interval_amount]
            system[i][col_shift + 2] = -1
            col_shift += 2

    ab = gauss_partial_pivot.gauss_partial_pivot(system, zs)
    results = regressive_substitution.regressive_substitution(ab)

    i = 0
    k = 0
    size = len(results)
    equations = []

    while True:
        if k >= size:
            break

        ai = points[i][1]
        bi = results[k]
        ci = None
        xi = points[i][0]
        intv = intervals[i]
        if i == 0:
            ci = 0
            k += 1
        else:
            ci = results[k + 1]
            k += 2

        if ci == 0:
            equations.append(f"s{i} = {ai} + {bi}(x - {xi}), [{intv[0]},{intv[1]}]")
        else:
            equations.append(
                f"s{i} = {ai} + {bi}(x - {xi}) + {ci}(x - {xi})^2, [{intv[0]},{intv[1]}]"
            )
        i += 1

    return equations
