import numpy as np


def to_aug(a, b):
    return np.column_stack((a, b))


def create_matrix(lss):
    return np.array(lss).astype(np.float64)


def create_vector(vec):
    return np.array(vec).astype(np.float64)
