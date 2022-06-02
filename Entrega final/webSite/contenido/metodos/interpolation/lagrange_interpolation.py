import sympy as sym
import numpy as np

x = sym.Symbol("x")


def lagrange(puntos):

    size = np.size(puntos, 0)
    producto = 0
    arreglo_x = [i[0] for i in puntos]
    arreglo_y = [i[1] for i in puntos]

    for k in range(size):
        l = 1
        for i in range(size):
            if i != k:
                l = l * ((x - arreglo_x[i]) / (arreglo_x[k] - arreglo_x[i]))
        producto = producto + l * (arreglo_y[k])
    producto = sym.simplify(sym.expand(producto))

    return producto
