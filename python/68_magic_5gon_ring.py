from itertools import permutations # built-in library for generating permutations of iterable with unique values

def magic_5gon_ring() -> str:
    
    max_str = "0"
    for ring in permutations(range(1, 11)):
        if not is_valid_ring(ring):
            continue
        digit_str = get_digit_string(ring)
        max_str = digit_str if int(digit_str) > int(max_str) else max_str
            
    return str(max_str)
    
def is_valid_ring(ring: list) -> bool:
    inner = ring[:5]
    outer = ring[5:]
    
    # valid strings start from the group of three with the numerically lowest external node
    if outer[0] != min(outer):
        return False
    
    # digit string must have 16 digits
    if len(get_digit_string(ring)) != 16:
        return False
        
    # each group of three must have the same sum
    if len(set(outer[i] + inner[i] + inner[(i + 1) % 5] for i in range(0, 5))) != 1:
        return False

    return True
    
def get_digit_string(ring: list) -> str:
    inner = ring[:5]
    outer = ring[5:]
    
    # [a, b, c, d, e, f, g, h, i, j]
    # inner: [a, b, c, d, e]
    # outer: [f, g, h, i, j]
    # string: fabgbchcdidejea
    
    digit_str = ""
    for i in range(0, 5):
        digit_str += str(outer[i]) + str(inner[i]) + str(inner[(i + 1) % 5])
    return digit_str
    
if __name__ == "__main__":
    print(magic_5gon_ring())