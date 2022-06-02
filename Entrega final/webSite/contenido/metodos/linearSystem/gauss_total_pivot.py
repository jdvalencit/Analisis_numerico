from contenido.metodos.linearSystem import total_pivot
from contenido.metodos.utility import to_aug


def gauss_total_pivot(a, b):
    ab = to_aug(a, b)
    assert a.shape[0] == a.shape[1]

    size = a.shape[0]
    labels = list(range(0, size))

    # Stages
    for k in range(0, size - 1):
        total_pivot.total_pivot(ab, k, labels)
        # Compute multiplier for row in stage.
        for i in range(k + 1, size):
            multiplier = ab[i][k] / ab[k][k]
            for j in range(k, size + 1):
                ab[i][j] = ab[i][j] - (multiplier * ab[k][j])

    return ab, labels
