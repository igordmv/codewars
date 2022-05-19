def dbl_linear(n):
    u = [1]
    dict = {}
    for pos in range(0, n * 4):
        y = 2 * u[pos] + 1
        z = 3 * u[pos] + 1
        if y not in dict.keys():
            dict[y] = 1
            u.append(y)
        if z not in dict.keys():
            dict[z] = 1
            u.append(z)
    u.sort()
    return u[n]

   