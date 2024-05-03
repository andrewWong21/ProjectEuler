def anagramic_squares(anagram_lists: list) -> int:
    
    max_word_length = max([len(anagram_list[0]) for anagram_list in anagram_lists])
    squares = set()
    
    i: int = 1
    while True:
        if len(str(i*i)) > max_word_length:
            break
        squares.add(i*i)
        i += 1
    
    max_square: int = 1
    for anagram_list in anagram_lists:
        for i in range(len(anagram_list) - 1):
            for j in range(i + 1, len(anagram_list)):
                word1 = anagram_list[0]
                word2 = anagram_list[1]
                max_square = max(
                    max_square, 
                    max_square_mapping(
                        word1, 
                        word2, 
                        {sq for sq in squares if len(str(sq)) == len(word1)}
                    )
                )
    
    return max_square

def max_square_mapping(word1: str, word2: str, squares: set) -> int:
    for sq in squares:
        mapping = {}
        sq_str = str(sq)
        
        # map characters of word1 to digits
        is_valid_mapping = True
        for i in range(len(word1)):
        
            # if square cannot correspond to letter mapping for word1, continue
            if word1[i] in mapping and sq_str[i] != mapping[word1[i]]:
                is_valid_mapping = False
                break
            else:
                mapping[word1[i]] = sq_str[i]
                # different letters may not map to the same digit
                if len(set(mapping.keys())) != len(set(mapping.values())):
                    is_valid_mapping = False
                    break
                
        if not is_valid_mapping:
            continue
            
        sq2_str = ""
        for c in word2:
            sq2_str += mapping[c]
        if int(sq2_str) in squares:
            return max(sq, int(sq2_str))
        
    return -1

if __name__ == "__main__":
    words = []
    f = open("98_words.txt", 'r')
    words = f.read().replace("\"", "").strip().split(",")
    f.close()
    
    # group words into lists by their used letters
    anagram_dict = {}
    for word in words:
        letters = "".join(sorted(word))
        if letters not in anagram_dict:
            anagram_dict[letters] = []
        anagram_dict[letters].append(word)
    
    # filter anagram lists to those with at least two words
    anagram_lists = [v for v in anagram_dict.values() if len(v) >= 2]

    print(anagramic_squares(anagram_lists))
