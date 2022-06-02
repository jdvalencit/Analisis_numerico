import numpy as np
from contenido.metodos.linearSystem import progressive_substitution, regressive_substitution
from contenido.metodos.utility import to_aug


def lu_gauss(a, b):
    assert a.shape[0] == a.shape[1]
    assert a.shape[0] == b.shape[0]

    size = a.shape[0]
    lower_tri = np.identity(size, dtype=np.float64)

    # Stages
    for k in range(0, size - 1):
        # Compute multiplier for row in stage.
        for i in range(k + 1, size):
            multiplier = a[i][k] / a[k][k]
            for j in range(k, size):
                a[i][j] = a[i][j] - (multiplier * a[k][j])
                if i > j:
                    lower_tri[i][j] = multiplier
    z = progressive_substitution.progressive_substitution(to_aug(lower_tri, b))
    return regressive_substitution.regressive_substitution(to_aug(a, z))
