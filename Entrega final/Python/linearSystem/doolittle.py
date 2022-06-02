import numpy as np
from contenido.metodos.linearSystem import progressive_substitution, regressive_substitution
from contenido.metodos.utility import to_aug


def dolittle_fac(a, b):
    size = a.shape[0]
    lower_tri = np.identity(size, dtype=np.float64)
    upper_tri = np.identity(size, dtype=np.float64)

    for k in range(0, size):
        first_sum = 0
        # Compute lower_tri[k][k]
        for p in range(0, k):
            first_sum += lower_tri[k][p] * upper_tri[p][k]
        upper_tri[k][k] = a[k][k] - first_sum

        # Compute lower_tri[i][k]
        for i in range(k + 1, size):
            second_sum = 0
            for p in range(0, k):
                second_sum += lower_tri[i][p] * upper_tri[p][k]
            lower_tri[i][k] = (a[i][k] - second_sum) / upper_tri[k][k]

        # Compute upper_tri[k][j]
        for j in range(k + 1, size):
            third_sum = 0
            for p in range(0, k):
                third_sum += lower_tri[k][p] * upper_tri[p][j]
            upper_tri[k][j] = a[k][j] - third_sum

    z = progressive_substitution.progressive_substitution(to_aug(lower_tri, b))
    return regressive_substitution.regressive_substitution(to_aug(upper_tri, z))
