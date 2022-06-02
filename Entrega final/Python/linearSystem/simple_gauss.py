import numpy as np
from contenido.metodos.utility import to_aug

def simple_gauss(a, b):
    ab = to_aug(a, b)
    assert a.shape[0] == a.shape[1]

    size = a.shape[0]

    # Stages
    for i in range(0, size - 1):
        # Compute multiplier for row in stage.
        for j in range(i + 1, size):
            multiplier = ab[j][i] / ab[i][i]
            for k in range(i, size + 1):
                ab[j][k] = ab[j][k] - (multiplier * ab[i][k])

    return ab