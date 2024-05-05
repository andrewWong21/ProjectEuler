from math import sqrt

def arranged_probability(total: int) -> int:
    # B = number of blue discs
    # r = number of red discs
    # probability of taking two blue discs is 1/2
    # ((B) / (B + r)) * ((B - 1) / (B + r - 1)) = 1/2
    # 2B^2 - 2B = (B + r) * (B + r - 1)
    # 2B^2 - 2B = B^2 + Br - B + Br + r^2 - r
    # B^2 - 2B = 2Br - B + r^2 - r
    # B^2 - B - 2Br - r^2 + r = 0
    # B^2 + (-2r - 1)B - r^2 + r = 0
    
    # a = 1, b = -2r - 1, c = -r^2 + r
    # B = (-b +/- sqrt(b^2 - 4ac))/2a
    # B = (2r + 1 +/- sqrt((-2r - 1)^2 - 4(1)(-r^2 + r))) / 2
    # B = (2r + 1 +/- sqrt(4r^2 + 4r + 1 + 4r^2 - 4r)) / 2
    # B = (2r + 1 +/- sqrt(8r^2 + 1)) / 2
    # B must be positive, so drop solution (2r - ...)/2 since sqrt(8r^2 + 1) > 2r + 1
    
    # B = r + (sqrt(8r^2 + 1) + 1)/2
    # B must be an integer, so sqrt(8r^2 + 1) must be an odd integer x
    # x^2 - 8r^2 = 1, fundamental solution (x_f, r_f) is (3, 1) -> 9 - 8 = 1
    x_f, r_f = 3, 1
    x, r = x_f, r_f
    
    while True:
        discrim_sqrt = sqrt(8 * r ** 2 + 1)
        if int(discrim_sqrt) == discrim_sqrt and discrim_sqrt % 2 == 1:
            b = r + (int(discrim_sqrt) + 1) // 2
            # print(b, r, b + r)
            # print("\t", str(b) + "/" + str(b + r), str(b - 1) + "/" + str(b + r - 1))
            if b + r > total:
                return b
        
        # using Brahmagupta's identity 
        # x_k = x_1*x_(k-1) + n*y_1*y_(k-1)
        # y_k = y_1*x_(k-1) + x_1*y_(k-1)
        # to generate next solution for the equation x^2 - 8r^2 = 1
        x_1 = x_f * x + 8 * r_f * r
        r_1 = r_f * x + x_f * r
        x, r = x_1, r_1

if __name__ == "__main__":
    print(arranged_probability(1_000_000_000_000))
