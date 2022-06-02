from contenido.metodos.linearSystem.progressive_substitution import progressive_substitution
from contenido.metodos.linearSystem.regressive_substitution import regressive_substitution
from contenido.metodos.utility import to_aug
import numpy as np

def crout(a, b):
    n = a.shape[0]
    lower_tri = np.identity(n, dtype=np.float64)
    upper_tri = np.identity(n, dtype=np.float64)
 
    for k in range(0, n):
        sum0 = 0

        for p in range(0, k):
            sum0 += lower_tri[k][p] * upper_tri[p][k]
        lower_tri[k][k] = a[k][k] - sum0
 
        for i in range(k + 1, n):
            sum1 = 0
            for p in range(0, k):
                sum1 += lower_tri[i][p] * upper_tri[p][k]
            lower_tri[i][k] = a[i][k] - sum1
 
        for j in range(k + 1, n):
            sum2 = 0
            for p in range(0, k):
                sum2 += lower_tri[k][p] * upper_tri[p][j]
            upper_tri[k][j] = (a[k][j] - sum2) / lower_tri[k][k]

    z = progressive_substitution(to_aug(lower_tri, b))
    return regressive_substitution(to_aug(upper_tri, z))