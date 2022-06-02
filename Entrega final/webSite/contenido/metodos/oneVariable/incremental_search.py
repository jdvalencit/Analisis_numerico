from math import *


def incremental_search(f, xinit, dx, n):
    x0 = xinit
    fx0 = f(x0)

    if fx0 == 0:
        return (x0, x0)
    else:
        actual_iterations = 1
        x1 = x0 + dx
        fx1 = f(x1)

        while actual_iterations < n:
            x0 = x1
            x1 = x0 + dx

            fx0 = fx1
            fx1 = f(x1)

            if fx1 == 0:
                return (x1, x1)
            elif fx0 * fx1 < 0:
                return (x0, x1)

            actual_iterations = actual_iterations + 1

        return None
